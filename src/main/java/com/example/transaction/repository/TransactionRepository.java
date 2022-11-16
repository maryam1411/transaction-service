package com.example.transaction.repository;

import com.example.transaction.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, UUID> {

    Transaction findByUserName(String userName);


}
