package com.org.invoiceGeneratorAPI.entity;

import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import java.time.Instant;

@Data
@Document(collection = "invoices")
public class Invoice implements java.io.Serializable
{
@Id
private String id;
private Company company;
private Billing billing;
private Account account;
@JsonProperty("invoice")
private InvoiceDetails invoiceDetails;
private String emailId;
private List<Item> items;
private String notes;
private String logo;
private double tax;

@CreatedDate
private Instant createdAt;

@LastModifiedDate
private Instant lastUpdatedAt;
              

private String thumbnailUrl;

private String template;
private String title;

}