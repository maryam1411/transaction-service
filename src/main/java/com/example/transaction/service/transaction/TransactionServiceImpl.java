package com.example.transaction.service.transaction;

import com.example.transaction.domain.Transaction;
import com.example.transaction.enums.NotificationType;
import com.example.transaction.exception.InvalidUserIdException;
import com.example.transaction.repository.TransactionRepository;
import com.example.transaction.service.account.AccountModel;
import com.example.transaction.service.account.AccountService;
import com.example.transaction.service.notification.NotificationEvent;
import com.example.transaction.service.notification.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.ExecutionException;


@Service
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final NotificationService notificationService;
    private final AccountService accountService;

    @Autowired
    public TransactionServiceImpl(TransactionRepository transactionRepository, NotificationService notificationService, AccountService accountService) {
        this.transactionRepository = transactionRepository;
        this.notificationService = notificationService;
        this.accountService = accountService;
    }

    @Override
    public void performTransaction(Transaction transaction) throws InvalidUserIdException, ExecutionException, InterruptedException {
        NotificationEvent notificationEvent = getNotificationEvent(transaction.getUserName());
        transactionRepository.save(transaction);
        notificationService.sendEmail(notificationEvent);
    }


    @Override
    public Transaction calculateBalance(String userName) {
        return transactionRepository.findByUserName(userName);
    }

    @Override
    public Optional<Transaction> getTransaction(UUID transactionId) {
        return transactionRepository.findById(transactionId);
    }

    private NotificationEvent getNotificationEvent(String userName) throws InvalidUserIdException {
        AccountModel accountModel = accountService.getAccount(userName);
        NotificationEvent notificationEvent = new NotificationEvent();
        notificationEvent.setNotificationType(NotificationType.CREDIT_TRANSACTION);
        notificationEvent.setEmail(accountModel.getEmail());
        notificationEvent.setPurpose("Credit transaction");
        return notificationEvent;
    }
}