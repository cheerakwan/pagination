package com.example.pagination.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class HeaderRequestBean implements Serializable {

    /**
     * Generate by eclipse
     */
    private static final long serialVersionUID = 3577183254367503164L;

    @ApiModelProperty(example = "20012001",
            required = true,
            allowEmptyValue = false,
            value = "for identity client")
    private String reqID;

    @ApiModelProperty(example = "GP",
            required = true,
            allowEmptyValue = false,
            value = "for identity client")
    private String reqChannel;

    @ApiModelProperty(example = "2018-05-01 21:10:07.232",
            required = true,
            allowEmptyValue = false,
            value = "datetime while execute transaction")
    private String reqDtm;

    @ApiModelProperty(example = "non.t",
            required = true,
            allowEmptyValue = false,
            value = "for identity client")
    private String reqBy;

    @ApiModelProperty(example = "some service",
            required = true,
            allowEmptyValue = false,
            value = "for identity webservice")
    private String service;

    @ApiModelProperty(example = "111",
            required = false,
            allowEmptyValue = true)
    private String txnRefID;

    @ApiModelProperty(example = "192.168.0.1",
            required = true,
            allowEmptyValue = false,
            value = "for identity client")
    private String ip;

    @ApiModelProperty(example = "ios or android",
            required = false,
            allowEmptyValue = true,
            value = "for identity client os")
    private String clientOS;
    @ApiModelProperty(example = "1.1.x",
            required = false,
            allowEmptyValue = true,
            value = "for identity client version")
    private String appVersion;


}