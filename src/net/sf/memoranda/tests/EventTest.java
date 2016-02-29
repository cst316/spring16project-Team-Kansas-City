package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.EventsManager;
import net.sf.memoranda.Event;
import net.sf.memoranda.date.CalendarDate;

public class EventTest {
    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }
    
    EventsManager eventManager = new EventsManager();
    CalendarDate testDate = new CalendarDate(2016, 01, 01);
    Event testEvent = eventManager.createEvent(testDate, 12, 12, "test");
    
    @Test
    public void testGetHour() {
        assertEquals(testEvent.getHour(), 12);
    }
    
    @Test
    public void testGetMinute() {
        assertEquals(testEvent.getMinute(), 12);
    }
    
    @Test
    public void testGetText() {
        assertEquals(testEvent.getText(), "test");
    }
    
    @Test
    public void testGetStartDate() {
        //should have no start date
        assertEquals(testEvent.getStartDate(), null);
    }
    
    @Test
    public void testIsRepeatable() {
        //should not be repeatable
        assertEquals(testEvent.isRepeatable(), false);
    }
    
}
