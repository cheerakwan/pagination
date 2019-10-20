package com.example.pagination.service;

import com.example.pagination.entity.HistoryStatement;
import com.example.pagination.model.MessageRequestTransactionBean;
import com.example.pagination.model.MessageResponseTransactionBean;
import com.example.pagination.repository.HistoryStatementRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Slf4j
@Service
public class HistoryStatementServiceImpl {

    private HistoryStatementRepository historyStatementRepository;

    public HistoryStatementServiceImpl(HistoryStatementRepository historyStatementRepository) {
        this.historyStatementRepository = historyStatementRepository;
    }


    public MessageResponseTransactionBean getStatementData(MessageRequestTransactionBean request) {
        MessageResponseTransactionBean responseBean = new MessageResponseTransactionBean();
        try {
            String merchantId = request.getTransactionRequest().getMerchantId();
            String dateRequest = request.getTransactionRequest().getEndDate();
            dateRequest = dateRequest.replaceAll("-", "").replaceAll("/", "");
            Date date = new SimpleDateFormat("yyyyMMdd").parse(dateRequest);
            Timestamp startDate = new Timestamp(getDate(date, 23, 30, 0, 001, -1).getTime());
            Timestamp endDate = new Timestamp(getDate(date, 23, 59, 59, 999, 0).getTime());

            //Pageable pageRequest = new PageRequest(1, 10);
            //Pageable pageRequest = new PageRequest(1, 5, new Sort(Sort.Direction.DESC, "processDate"));

            Page<HistoryStatement> historyStatementPage = historyStatementRepository.findAll(
                        getHistoryStatementSpec(merchantId, startDate, endDate), new PageRequest(0, 10, new Sort(Sort.Direction.DESC, "processDate")));

            //Page<HistoryStatement> historyStatements = historyStatementRepository.findAll(new PageRequest(0, 10));

            List<HistoryStatement> historyStatementsContent = historyStatementPage.getContent();
            responseBean.setHistoryStatements(historyStatementsContent);


        }catch (Exception e) {
            log.error(e.getMessage());
        }

        return responseBean;
    }

    private Specification<HistoryStatement> getHistoryStatementSpec(String merchantId, Date startDate, Date endDate) {
        return new Specification<HistoryStatement>() {
            @Override
            public Predicate toPredicate(Root<HistoryStatement> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicateList = new ArrayList<>();
                predicateList.add(criteriaBuilder.equal(root.get("merchantId"), merchantId));
                //predicateList.add(criteriaBuilder.between(root.get("processDate"), startDate, endDate));

                return criteriaBuilder.and(predicateList.toArray(new Predicate[predicateList.size()]));
            }
        };
    }

    private Date getDate(Date dateRequest, int hour, int minute, int second, int millisecond, int plusDay) throws ParseException {
        Calendar calendar = GregorianCalendar.getInstance(Locale.getDefault());
        calendar.setTime(dateRequest);
        if (plusDay != 0)
            calendar.add(Calendar.DAY_OF_MONTH, plusDay);
        calendar.set(Calendar.HOUR_OF_DAY, hour);
        calendar.set(Calendar.MINUTE, minute);
        calendar.set(Calendar.SECOND, second);
        calendar.set(Calendar.MILLISECOND, millisecond);
        Date date = calendar.getTime();
        return date;
    }

}
