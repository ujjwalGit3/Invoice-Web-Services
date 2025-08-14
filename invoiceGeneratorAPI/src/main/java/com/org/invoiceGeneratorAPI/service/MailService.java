package com.org.invoiceGeneratorAPI.service;

import jakarta.mail.internet.MimeMessage;
import jakarta.mail.MessagingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.core.io.ByteArrayResource;


@Service
public class MailService 
{
@Autowired
private JavaMailSender mailSender;

public boolean sendEmail(String toMail,MultipartFile file)
{
try{
MimeMessage message=mailSender.createMimeMessage();
MimeMessageHelper helper=new MimeMessageHelper(message,true);

helper.setFrom("ujjwalchawda314@gmail.com");
helper.setTo(toMail);
helper.setSubject("Your Invoice");
helper.setText("Dear Customer,\n\n Please Find Attached Invoice.\n\nThank You !!!");

helper.addAttachment(file.getOriginalFilename(),new ByteArrayResource(file.getBytes()),"application/pdf");

mailSender.send(message);
return true;
}catch(Exception e)
{
System.out.println("Email Send Failed: " + e.getMessage());
e.printStackTrace(); // Shows full error in console
return false;
}
}
}