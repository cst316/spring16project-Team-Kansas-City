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
	private NoteListImpl noteList;
	private NoteImpl note1;
	private NoteImpl note2;
	private NoteImpl note3;
	private Element el;
	Project test;

	@Before
	public void setUpOnce() throws Exception {
		ProjectManager.createProject("test", new CalendarDate(1,1,2016), new CalendarDate(31,12,2016));
		Project test = ProjectManager.getProject("test");
		noteList = new NoteListImpl(test);
	}

	@Before
	public void setUp() throws Exception {
		note1 = new NoteImpl(el, test);
	}
	
	@Test
	public void testGetProject() throws Exception {
		assertTrue(((Note)noteList).getProject().equals(test));
	}
	
	@Test
	public void testGetDate() throws Exception {
		assertTrue(date.equals(note1.getDate()));
	}

	@After
	public void tearDown() throws Exception { 
	}
}