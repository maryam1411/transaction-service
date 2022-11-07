package com.example.transaction.service.notification;

import com.example.transaction.enums.NotificationType;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class NotificationEvent {

    private String purpose;
    private String email;
    private NotificationType notificationType;


}

