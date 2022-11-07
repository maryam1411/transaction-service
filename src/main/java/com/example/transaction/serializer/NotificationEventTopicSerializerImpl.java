package com.example.transaction.serializer;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class NotificationEventTopicSerializerImpl implements NotificationEventTopicSerializer {


    @Override
    public void configure(Map<String, ?> var1, boolean var2) {

    }

    @Override
    public byte[] serialize(String var1, byte[] notificationEvent) {
        byte[] retVal = null;
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            retVal = objectMapper.writeValueAsString(notificationEvent).getBytes();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    @Override
    public void close() {

    }
}

