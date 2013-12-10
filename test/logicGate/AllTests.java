package logicGate;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(WireTest.class);
		//suite.addTestSuite(AndGateTest.class);
		//suite.addTestSuite(OrGateTest.class);
		//suite.addTestSuite(NotGateTest.class);
		return suite;
	}
}
