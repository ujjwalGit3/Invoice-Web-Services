package com.org.invoiceGeneratorAPI.entity;

import lombok.Data;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;


@Document(collection="Users")
@Data
public class Users implements java.io.Serializable
{
public Users()
{
}
@Id
private String id;
@Indexed(unique=true)
private String emailId;
private String password;
private String name;
private String phoneNumber;
}