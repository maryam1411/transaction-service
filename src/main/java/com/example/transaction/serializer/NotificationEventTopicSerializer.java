package com.example.transaction.serializer;

import java.util.Map;

public interface NotificationEventTopicSerializer extends Cloneable {
    void configure(Map<String, ?> var1, boolean var2);

    byte[] serialize(String var1, byte[] notificationEvent);

    void close();
}
