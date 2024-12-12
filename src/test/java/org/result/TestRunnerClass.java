package org.result;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.runner.SuiteLevelExecution;

public class TestRunnerClass {
	public static void main(String[] args) {
		Result runClasses = JUnitCore.runClasses(SuiteLevelExecution.class);

		boolean wasSuccessful = runClasses.wasSuccessful();
		if(wasSuccessful)
		{
			System.out.println("User login and logout successful");
			System.out.println("Runcount:"+runClasses.getRunCount());
		}
		else
		{
			System.out.println("Fail count"+runClasses.getFailureCount());
		}
	}
}
