package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Vector;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import net.sf.memoranda.*;
import net.sf.memoranda.date.CalendarDate;
import nu.xom.Document;
import nu.xom.Element;

public class TaskImplTest {
	
	private TaskImpl test1;
	private TaskImpl test2;
	private TaskImpl test3;
	private Vector test2Vector;

	@Before
	public void setUpOnce() throws Exception {
		ProjectManager.createProject("test", new CalendarDate(1,1,2016), new CalendarDate(31,12,2016));
		Project test = ProjectManager.getProject("test");
		TaskListImpl testList = new TaskListImpl(new Document(new Element("document")), test);
		testList.createTask(new CalendarDate(10,2,2016), new CalendarDate(28,2,2016), "this is a test1", Task.PRIORITY_HIGH, Task.ACTIVE, "this is a description1.", null);
		testList.createTask(new CalendarDate(10,2,2016), new CalendarDate(28,2,2016), "this is a test2", Task.PRIORITY_HIGH, Task.ACTIVE, "this is a description2.", null);
		testList.createTask(new CalendarDate(10,2,2016), new CalendarDate(28,2,2016), "this is a test3", Task.PRIORITY_HIGH, Task.ACTIVE, "this is a description3.", null);
		Collection testContent = testList.getAllSubTasks(null);
		Object[] testArrContent = testContent.toArray();
		test1 = (TaskImpl) testArrContent[0];
		test2 = (TaskImpl) testArrContent[1];
		test3 = (TaskImpl) testArrContent[2];
		
		test2.addDependsFrom(test1);	
		test2Vector = new Vector();
		test2Vector.addElement(test1);
		
	}

	@After
	public void tearDown() throws Exception {
	}

	//Not testing Getter//Setter methods, therefore starting with getdependsfrom
	//testDepends from tests add and get depends from by ensuring that the value of the method added in the
	///setup matches the value. also tests null case.
	@Test
	public void testDependsFrom() {
		assertTrue(test1.getDependsFrom().equals(new Vector()));
		assertEquals(test2.getDependsFrom().toString(), test2Vector.toString());
	}

	@Test
	public void testRemoveDependsFrom() {
		test2.removeDependsFrom(test1);
		assertTrue(test2.getDependsFrom().equals(new Vector()));
	}

	@Test
	public void testHasSubTasks() {
		test1.hasSubTasks(test2.getID());
	}

}
