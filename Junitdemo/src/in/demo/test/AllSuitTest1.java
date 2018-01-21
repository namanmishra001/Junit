package in.demo.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class AllSuitTest1 {
	public static void main(String[] args) {
		Result result = JUnitCore.runClasses(AllTests.class);
		
		System.out.println("Failure......");
		for (Failure failure :result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("total failure---->"+result.getFailureCount());
		System.out.println("Total Test---->"+result.getRunCount());
		System.out.println("Total Ignores--->"+result.getIgnoreCount());
	}

}
