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
public class RecordServiceTest {

    RecordService subj;
    MockedStatic<LocalDateTime> dateTimeMocked;

    @BeforeMethod
    public void setUp() {
        subj = new RecordService();
        dateTimeMocked = Mockito.mockStatic(LocalDateTime.class, Mockito.CALLS_REAL_METHODS);
    }

    @AfterMethod
    public void tearDown() {
        dateTimeMocked.close();
    }

    @Test
    public void testCreateRecord() {

        Clock clock = Clock.fixed(Instant.parse("2014-12-22T10:15:30.00Z"), ZoneId.of("UTC"));
        LocalDateTime localDateTime = LocalDateTime.now(clock);
        when(LocalDateTime.now()).thenReturn(localDateTime);
        String dateTimeExpected = "2014-12-22T10:15:30";

        Record record = subj.createRecord();


        LocalDateTime dateTime = record.getDateTime();
        String string = dateTime.toString();
        assertEquals(string, "2014-12-22T10:15:30");
    }

    @Test
    public void testCreateRecord2() {
        LocalDateTime currentDate = LocalDateTime.of(2023, 1, 11, 1, 1, 1);
        dateTimeMocked.when(LocalDateTime::now).thenReturn(currentDate);

        Record record = subj.createRecord();

        LocalDateTime dateTime = record.getDateTime();
        String string = dateTime.toString();


        assertEquals(string, "2023-01-11T01:01:01");
    }

}