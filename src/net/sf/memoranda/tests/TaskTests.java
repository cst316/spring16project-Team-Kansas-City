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
import net.sf.memoranda.ui.TaskTable;
import nu.xom.Document;
import nu.xom.Element;

public class TaskTests {
	
	private TaskListImpl testList;
	private TaskImpl test1;
	private TaskImpl test2;
	private TaskImpl test3;
	private TaskImpl test4;
	private Vector test2Vector;

	@Before
	public void setUp() throws Exception {
		ProjectManager.createProject("test", new CalendarDate(1,1,2016), new CalendarDate(31,12,2016));
		Project test = ProjectManager.getProject("test");
		testList = new TaskListImpl(new Document(new Element("document")), test);
		test1 = (TaskImpl) testList.createTask(new CalendarDate(10,2,2016), new CalendarDate(28,2,2016), "this is a test1", Task.PRIORITY_HIGH, Task.ACTIVE, "this is a description1.", null);
		test2 = (TaskImpl)testList.createTask(new CalendarDate(10,2,2016), new CalendarDate(28,2,2016), "this is a test2", Task.PRIORITY_HIGH, Task.ACTIVE, "this is a description2.", null);
		test3 = (TaskImpl)testList.createTask(new CalendarDate(10,2,2016), new CalendarDate(28,2,2016), "this is a test3", Task.PRIORITY_LOW, Task.ACTIVE, "this is a description3.", test1.getID());
		test4 = (TaskImpl)testList.createTask(new CalendarDate(10,1,2016), new CalendarDate(28,12,2016), "this is a test4", Task.PRIORITY_NORMAL, Task.ACTIVE, "this is a description4.", test1.getID());
		test2.addDependsFrom(test1);
		test2Vector = new Vector();
		test2Vector.addElement(test1);;
		
		
		
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
		assertTrue(testList.hasSubTasks(test1.getID()));
		assertTrue(!testList.hasSubTasks(test2.getID()));
		assertTrue(testList.hasParentTask(test3.getID()));
		assertTrue(!testList.hasParentTask(test2.getID()));
	}
	
	@Test
	public void testRemoveTasks() {
		testList.removeTask(test3);
		Collection testRemoved = testList.getAllSubTasks(null);
		Vector<TaskImpl> testAgainst = new Vector<TaskImpl>();
		testAgainst.addElement(test4);
		assertTrue(testList.getAllSubTasks(test1.getID()).equals(testAgainst));
		
	}
	
	@Test
	public void testStartDates(){
		assertTrue(testList.getEarliestStartDateFromSubTasks(test1).equals(test4.getStartDate()));
		assertTrue(testList.getLatestEndDateFromSubTasks(test1).equals(test4.getEndDate()));
	}
	
	@Test
	public void testPercents(){
		long[] testListPercent = testList.calculateCompletionFromSubTasks(test1);
		long[] testPercent = {0,2};
		assertTrue(testListPercent[0]==(testPercent[0]) && testListPercent[1]==(testPercent[1]));
		
	}
}
