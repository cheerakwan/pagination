package com.example.pagination.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name ="HISTORY_STATEMENT")
public class HistoryStatement{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int runningId;
    private BigDecimal amount;
    private String walletId;
    private String merchantName;
    private String merchantId;
    private String transactionId;
    private String payerId;
    private String payerName;
    private String walletType;
    private Date processDate;
}

