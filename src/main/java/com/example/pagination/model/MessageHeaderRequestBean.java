package com.example.pagination.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MessageHeaderRequestBean implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5954296357019037724L;

    private HeaderRequestBean headerReq;

    public HeaderRequestBean getHeaderReq() {
        return headerReq;
    }

    public void setHeaderReq(HeaderRequestBean headerReq) {
        this.headerReq = headerReq;
    }

}
