package com.org.invoiceGeneratorAPI.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;   
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import com.org.invoiceGeneratorAPI.service.InvoiceService;
import com.org.invoiceGeneratorAPI.service.MailService;
import com.org.invoiceGeneratorAPI.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;


@RestController
@RequestMapping("/api/invoices")
@CrossOrigin(origins="http://localhost:5173")
public class InvoiceController
{

private final InvoiceService invoiceService;

@Autowired
private MailService emailService;

@Autowired
public InvoiceController(InvoiceService invoiceService)
{	
this.invoiceService=invoiceService;
}

private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);

@PostMapping("/add")
public ResponseEntity<Invoice> saveInvoice(@RequestBody Invoice invoice)
{
 logger.info("Invoice received: {}", invoice);
return ResponseEntity.ok(invoiceService.saveInvoice(invoice));
}

@DeleteMapping("/deleteAllInvoices")
public String deleteAll()
{
invoiceService.deleteAllInvoices();
return "Invoices delete";
}

@GetMapping("/fetchInvoice/{emailId}")
public ResponseEntity<List<Invoice>> fetchInvoices(@PathVariable String emailId)
{
List<Invoice> invoices = invoiceService.fetchInvoicesByEmailId(emailId);
//	Log each invoice or a summary of what is being fetched
logger.info("Fetched {} invoices", invoices.size());
invoices.forEach(invoice -> logger.info("Fetched Invoice: {}", invoice));
return ResponseEntity.ok(invoices);
}

@DeleteMapping("/deleteInvoice/{id}")
public ResponseEntity<String> removeInvoice(@PathVariable String id)
{
invoiceService.removeInvoice(id);
return ResponseEntity.ok("Invoice Deleted Successfully");
}

@PostMapping(value="/mailInvoice",consumes = "multipart/form-data")
public ResponseEntity<String> sendInvoice(
@RequestPart("toEmail") String toEmail,
@RequestPart("file") MultipartFile file)
{
boolean result=emailService.sendEmail(toEmail,file);
if(result)
{
return ResponseEntity.ok("Email Sent Successfully");
}
else{
return ResponseEntity.status(500).body("Failed to Send email.");
}
}

}