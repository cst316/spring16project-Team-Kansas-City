package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import net.sf.memoranda.*;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.ProjectManager;

public class HistoryTest {
    ProjectManager manager = new ProjectManager();
    Project testProject = manager.createProject("test", new CalendarDate(1,1,2016), new CalendarDate(31,12,2016));
    CalendarDate testDate = new CalendarDate(1,1,2016);
    HistoryItem testHistoryItem = new HistoryItem(testDate, testProject);
    HistoryItem testHistoryItem2 = new HistoryItem(testDate, testProject);
    HistoryItem testHistoryItem3 = new HistoryItem(new CalendarDate(1,2,2016), testProject);

    
    @Test
    public void testGetDate() {
        assertEquals(testHistoryItem.getDate(), testDate);
    }
    
    @Test
    public void testGetProject() {
        assertEquals(testHistoryItem.getProject(), testProject);
    }
    
    @Test
    public void testEquals() {
        assertTrue(testHistoryItem.equals(testHistoryItem2));
        assertFalse(testHistoryItem.equals(testHistoryItem3));
    }
    
    @Test
    public void testAdd() {
        History.add(testHistoryItem);
        History.add(testHistoryItem2);
        History.add(testHistoryItem3);
        assertEquals(History.getList().size(), 3);
    }

}
