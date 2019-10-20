package com.example.pagination.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class PromptPayTransaction implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 9103103302785819432L;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String merchantId;

    @Id
    @JsonProperty(access = Access.WRITE_ONLY)
    private String transactionId;

    //@JsonSerialize(using = MaskAccountIdSerializer.class)
    private String fromAccountId;

    //@JsonSerialize(using = MaskFullNameSerializer.class)
    private String fromAccountName;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String toAnyId;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String toAccountName;

    private BigDecimal amount;

    @Temporal(TemporalType.TIMESTAMP)
    private Date transferDate;

    @JsonProperty(access = Access.WRITE_ONLY)
    private String additionalNote;

    private String transactionType;

    private String transactionTypeDisplay;

}
