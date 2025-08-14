package com.org.invoiceGeneratorAPI.service;

import org.springframework.stereotype.Service;
import com.org.invoiceGeneratorAPI.repository.InvoiceRepository;
import com.org.invoiceGeneratorAPI.entity.Invoice;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class InvoiceService 
{

private final InvoiceRepository invoiceRepository;

@Autowired
public InvoiceService(InvoiceRepository invoiceRepository)
{
this.invoiceRepository=invoiceRepository;
}

public Invoice saveInvoice(Invoice invoice)
{
System.out.println(invoice);
return invoiceRepository.save(invoice);
}

public void deleteAllInvoices()
{
invoiceRepository.deleteAll();
}

public List<Invoice> fetchInvoicesByEmailId(String emailId)
{
return invoiceRepository.findByEmailId(emailId);
}

public void removeInvoice(String invoiceId)
{
if(invoiceRepository.existsById(invoiceId))
{
invoiceRepository.deleteById(invoiceId);
}
else{
throw new RuntimeException("Invalid Invoice Id :"+invoiceId);
}
}


}