package com.example.transaction.repository;

import com.example.transaction.domain.Transaction;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.UUID;

@Repository
public interface TransactionRepository extends MongoRepository<Transaction, UUID> {

    @Transactional
    @Query("select t from transaction t where c.userId =?1")
    Transaction getTransaction(String userId);

}
