package com.example.pagination.model;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class HeaderResponseBean implements Serializable {

    /**
     * Generate by eclipse
     */
    private static final long serialVersionUID = 2367978280736122674L;
    @JsonAlias({"reqID", "reqId"})
    private String reqID;
    private String reqDtm;
    private String txnRefID;
    private String service;
    @JsonAlias({"statusCd", "statusCode"})
    private String statusCd;
    private String statusDesc;

    private ErrorDisplayBean errorDisplay;

    public HeaderResponseBean() {
        this.statusCd = "0000";
        this.statusDesc = "SUCCESS";
        this.errorDisplay = new ErrorDisplayBean();
    }

    public HeaderResponseBean(String statusCd, String statusDesc) {
        this.statusCd = statusCd;
        this.statusDesc = statusDesc;
    }

    public ErrorDisplayBean getErrorDisplay() {
        return errorDisplay;
    }

    public void setErrorDisplay(ErrorDisplayBean errorDisplay) {
        this.errorDisplay = errorDisplay;
    }

    public String getReqID() {
        return reqID;
    }

    public void setReqID(String reqID) {
        this.reqID = reqID;
    }

    public String getReqDtm() {
        return reqDtm;
    }

    public void setReqDtm(String reqDtm) {
        this.reqDtm = reqDtm;
    }

    public String getTxnRefID() {
        return txnRefID;
    }

    public void setTxnRefID(String txnRefID) {
        this.txnRefID = txnRefID;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getStatusCd() {
        return statusCd;
    }

    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    public String getStatusDesc() {
        return statusDesc;
    }

    public void setStatusDesc(String statusDesc) {
        this.statusDesc = statusDesc;
    }

    @Override
    public String toString() {
        return "HeaderResponseBean{" +
                "reqID='" + reqID + '\'' +
                ", reqDtm='" + reqDtm + '\'' +
                ", txnRefID='" + txnRefID + '\'' +
                ", service='" + service + '\'' +
                ", statusCd='" + statusCd + '\'' +
                ", statusDesc='" + statusDesc + '\'' +
                '}';
    }
}
