package com.example.pagination.model;

import com.example.pagination.entity.HistoryStatement;
import lombok.Data;

import java.util.List;

@Data
public class MessageResponseTransactionBean {

	private HeaderResponseBean headerResp;
	private List<PromptPayTransaction> transactionResponse;
	private List<HistoryStatement> historyStatements;

	public MessageResponseTransactionBean() {
		headerResp = new HeaderResponseBean();
	}
}
