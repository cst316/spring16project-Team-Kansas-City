package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Before;
import org.junit.Test;

import net.sf.memoranda.Project;
import net.sf.memoranda.ProjectImpl;
import net.sf.memoranda.ProjectManager;
import net.sf.memoranda.date.CalendarDate;

public class ProjectTests {

	private Project test1;
	
	@Before
	public void setUpOnce() throws Exception {
		test1 = ProjectManager.createProject("test1", new CalendarDate(1,1,2016), new CalendarDate(31,12,2016));
		ProjectManager.createProject("test2", new CalendarDate(1,1,2016), new CalendarDate(31,10,2016));
		ProjectManager.createProject("test3", new CalendarDate(15,2,2016), new CalendarDate(31,8,2016));
		ProjectManager.createProject("test4", new CalendarDate(5,4,2016), new CalendarDate(31,5,2016));
	}

	@Test
	public void testProjects() {
		assertTrue(ProjectManager.getActiveProjects().size() == 3);
		
		assertTrue(ProjectManager.getAllProjects().size() == 5);
		
		ProjectManager.removeProject(test1.getID());
		
		assertTrue(ProjectManager.getAllProjects().size() == 4);
		
	}
}
