package com.org.invoiceGeneratorAPI.entity;

import lombok.Data;

@Data
public class Item implements java.io.Serializable
{
private String name;
private int qty;
private double amount;
private String description;
}