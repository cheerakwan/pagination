package com.example.pagination.controller;

import com.example.pagination.model.MessageRequestTransactionBean;
import com.example.pagination.model.MessageResponseTransactionBean;
import com.example.pagination.service.HistoryStatementServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
public class HistoryStatementController {

    private HistoryStatementServiceImpl historyStatementService;

    public HistoryStatementController(HistoryStatementServiceImpl historyStatementService) {
        this.historyStatementService = historyStatementService;
    }

    @PostMapping(path = "statement")
    public MessageResponseTransactionBean getTransactionStatement(@RequestBody MessageRequestTransactionBean request) {
        return historyStatementService.getStatementData(request);
    }

}
