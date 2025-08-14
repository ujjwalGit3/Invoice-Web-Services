package com.org.invoiceGeneratorAPI.entity;

import lombok.Data;

@Data
public class Account implements java.io.Serializable
{
private String name;
private String number;
private String ifscCode;
}