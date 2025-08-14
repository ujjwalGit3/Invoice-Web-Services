package com.org.invoiceGeneratorAPI.entity;

import lombok.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

@Data
public class Company implements java.io.Serializable
{
private String name;
@JsonProperty("phoneNumber")
private String number;	
private String address;
}