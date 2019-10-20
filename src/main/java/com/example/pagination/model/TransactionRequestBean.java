package com.example.pagination.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class TransactionRequestBean implements Serializable {
	
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -8279788051686390751L;
	private String appId;
    private String uuid;
    private String apiKey;
    private String merchantId;
    private String startDate;
    private String endDate;

}
