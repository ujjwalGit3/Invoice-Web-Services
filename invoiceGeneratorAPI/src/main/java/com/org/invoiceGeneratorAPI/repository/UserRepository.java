package com.org.invoiceGeneratorAPI.repository;
import com.org.invoiceGeneratorAPI.entity.Users;

import org.springframework.data.mongodb.repository.MongoRepository;
import java.util.Optional;

public interface UserRepository extends MongoRepository<Users,String>
{
Optional<Users> findByEmailId(String emailId);
boolean existsByEmailId(String emailId);
}


