package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.date.CalendarDate;
import net.sf.memoranda.NoteImpl;
import nu.xom.Attribute;
import nu.xom.Element;

public class NoteTest {
	
	private NoteImpl note1;
	private NoteImpl note2;
	private NoteImpl note3;
	private Project proj;
	private Element el;
	private Project proj2;
	private Element el2;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		note1 = new NoteImpl(el, proj);
		note2 = new NoteImpl(el2, proj2);
		note3 = new NoteImpl(el, proj);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void equalsTest() {
		assertTrue(note1.equals(note3));
		assertFalse(note1.equals(note2)); 
	}
}