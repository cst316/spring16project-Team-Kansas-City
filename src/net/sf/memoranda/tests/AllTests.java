package net.sf.memoranda.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ ProjectTests.class, CalenderDateTest.class, EventTest.class, HistoryTest.class, NoteTest.class, 
		ResourceTest.class, TaskTests.class })
public class AllTests {

}
