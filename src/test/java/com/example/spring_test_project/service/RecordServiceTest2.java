package com.example.spring_test_project.service;

import static org.mockito.Mockito.when;
import static org.testng.Assert.assertEquals;

import com.example.spring_test_project.model.Record;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Clock;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * @author Aleksandr_Berestov
 */
public class RecordServiceTest2 {

    RecordService subj;

    @BeforeMethod
    public void setUp() {
        subj = new RecordService();
    }


    @Test
    public void testCreateRecord() {
        String dateTimeExpected = "2014-12-22T10:15:30";

        Record record = subj.createRecord();

        LocalDateTime dateTime = record.getDateTime();
        String string = dateTime.toString();
        assertEquals(string, "2014-12-22T10:15:30");
    }

    @Test
    public void testCreateRecord2() {
        Record record = subj.createRecord();

        LocalDateTime dateTime = record.getDateTime();
        String string = dateTime.toString();

        assertEquals(string, "2023-01-11T01:01:01");
    }

}