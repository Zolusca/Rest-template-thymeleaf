package com.web_client.Entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigInteger;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vouchers {
    private Integer id;
    private String name;
    private String description;
    private BigInteger discount;
    @JsonProperty("started_at")
    private String dateStarted;
    @JsonProperty("expired_at")
    private String dateExpired;
}
