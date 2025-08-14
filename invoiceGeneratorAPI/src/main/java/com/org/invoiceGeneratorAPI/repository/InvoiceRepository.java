package com.org.invoiceGeneratorAPI.repository;

import com.org.invoiceGeneratorAPI.entity.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.*;

public interface InvoiceRepository extends MongoRepository<Invoice,String>{

List<Invoice> findByEmailId(String emailId);
} 