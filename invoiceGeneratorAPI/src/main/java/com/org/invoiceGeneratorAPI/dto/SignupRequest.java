package com.org.invoiceGeneratorAPI.dto;

import lombok.Data;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Data
public class SignupRequest implements java.io.Serializable
{
@Email(message="Invalid email format")
@NotBlank(message="Email Required")
private String emailId;

@NotBlank(message="Name Required")
private String name;

@NotBlank(message="Password Required")
@Size(min=6,message="Password Must be 6 characters")
private String password;

@NotBlank(message="Number Required")
private String phoneNumber;
}