package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.*;
import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.ui.TaskTable;
import nu.xom.Attribute;
import nu.xom.Document;
import nu.xom.Element;

public class NoteTest {
	
	private CalendarDate date = new CalendarDate(1,1,2016);
	private CalendarDate date2 = new CalendarDate(1,2,2016);
	private NoteListImpl noteList;
	private NoteImpl note1;
	private NoteImpl note2;
	private Element el;
	Project test;

	@Before
	public void setUpOnce() throws Exception {
		ProjectManager.createProject("test", new CalendarDate(1,1,2016), new CalendarDate(31,12,2016));
		test = ProjectManager.getProject("test");
		noteList = new NoteListImpl(test);
		note1 = (NoteImpl)noteList.createNoteForDate(date);
		note2 = (NoteImpl)noteList.createNoteForDate(date2);
	}

	@Test
	public void testGetDate() throws Exception {
		assertTrue(date.equals(note1.getDate()));
		assertFalse(note1.getDate().equals(note2.getDate()));
	}

	@After
	public void tearDown() throws Exception { 
	}
}