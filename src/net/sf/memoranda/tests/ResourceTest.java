package net.sf.memoranda.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import antlr.collections.impl.Vector;
import net.sf.memoranda.*;
import net.sf.memoranda.date.CalendarDate;

public class ResourceTest {
    ProjectManager manager = new ProjectManager();
    Project testProject = manager.createProject("test", new CalendarDate(1,1,2016), new CalendarDate(31,12,2016));

    Resource testResource = new Resource("/home/test/resource", true, true);
    ResourcesListImpl testResourceList = new ResourcesListImpl(testProject);
    
    @Test
    public void testGetPath() {
        assertEquals(testResource.getPath(), "/home/test/resource");
    }
    
    @Test
    public void testIsInetShortCut() {
        assertEquals(testResource.isInetShortcut(), true);
    }
    
    @Test
    public void testIsProjectFile() {
        assertEquals(testResource.isProjectFile(), true);
    }
    
    @Test
    public void testAddResource() {
        testResourceList.addResource("/home/test/resource");
        assertEquals(testResourceList.getResource("/home/test/resource").getPath(), testResource.getPath());
    }
    
    @Test
    public void testRemoveResource() {
        testResourceList.removeResource("/home/test/resource");
        assertEquals(testResourceList.getResource("/home/test/resource"), null);
    }
    
    @Test
    public void testGetAllCount() {
        testResourceList.addResource("/home/test/resource");
        testResourceList.addResource("/home/test/resource");
        testResourceList.addResource("/home/test/resource");
        assertEquals(testResourceList.getAllResourcesCount(), 3);
    }

}
