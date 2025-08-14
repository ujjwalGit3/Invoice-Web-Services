package com.org.invoiceGeneratorAPI.entity;

import lombok.Data;

@Data
public class InvoiceDetails implements java.io.Serializable
{
private String number;
private String date;
private String dueDate;
}