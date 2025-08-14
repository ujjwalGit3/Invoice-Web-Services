package com.org.invoiceGeneratorAPI.dto;

import lombok.Data;

@Data
public class AuthResponse 
{
private String token;
private String message;
public AuthResponse()
{
}
public AuthResponse(String token,String message)
{
this.token=token;
this.message=message;
}
}