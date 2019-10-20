package com.example.pagination.model;


import java.io.Serializable;

public class MessageRequestTransactionBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6513177689980977170L;
	private HeaderRequestBean headerReq;
	private TransactionRequestBean transactionRequest;
	
	public MessageRequestTransactionBean() {
		this.headerReq=new HeaderRequestBean();
		this.transactionRequest = new TransactionRequestBean();
	}
	public HeaderRequestBean getHeaderReq() {
		return headerReq;
	}
	public void setHeaderReq(HeaderRequestBean headerReq) {
		this.headerReq = headerReq;
	}
	public TransactionRequestBean getTransactionRequest() {
		return transactionRequest;
	}
	public void setTransactionRequest(TransactionRequestBean transactionRequest) {
		this.transactionRequest = transactionRequest;
	}
}
