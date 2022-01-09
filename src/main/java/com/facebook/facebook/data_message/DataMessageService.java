package com.facebook.facebook.data_message;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

@Service

public class DataMessageService {

    @Autowired
    DataMessageRepository dataMessageRepository;

    public DataMessage addDataMessage(DataMessage dataMessage) {
        dataMessage.setTimeCreated(new Timestamp(new Date().getTime()));
        return dataMessageRepository.save(dataMessage);
    }

    public DataMessage updateDataMessage(DataMessage dataMessage) {
        return dataMessageRepository.save(dataMessage);
    }

    public void deleteDataMessage(DataMessage dataMessage) {
        dataMessageRepository.delete(dataMessage);
    }

}
