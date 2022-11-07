package com.example.transaction.service.notification;

import java.util.concurrent.ExecutionException;


public interface NotificationService {

    void sendEmail(NotificationEvent notificationEvent) throws ExecutionException, InterruptedException;

}
