package com.org.invoiceGeneratorAPI.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Billing implements java.io.Serializable
{
private String name;
@JsonProperty("phoneNumber")	
private String phone;
private String address;
}