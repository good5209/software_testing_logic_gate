package logicGate;

import junit.framework.TestCase;
import logicGate.AndGate;
import logicGate.GateException;
import logicGate.Wire;

public class AndGateTest extends TestCase {

	public void testAndGate() {
		try {
			new AndGate(null, null, null);
			assertFalse(true);
		} catch (GateException e) {
			assertFalse(false);
		}
		
		try {
			new AndGate(new Wire(), null, null);
			assertFalse(true);
		} catch (GateException e) {
			assertFalse(false);
		}
		
		try {
			new AndGate(null, new Wire(), null);
			assertFalse(true);
		} catch (GateException e) {
			assertFalse(false);
		}
		
		try {
			new AndGate(null, null, new Wire());
			assertFalse(true);
		} catch (GateException e) {
			assertFalse(false);
		}
		
		try {
			new AndGate(new Wire(), new Wire(), null);
			assertFalse(true);
		} catch (GateException e) {
			assertFalse(false);
		}
		
		try {
			Wire wire = new Wire();
			new AndGate(wire, new Wire(), wire);
			assertFalse(true);
		} catch (GateException e) {
			assertFalse(false);
		}
		
		try {
			Wire wire = new Wire();
			new AndGate(new Wire(), wire, wire);
			assertFalse(true);
		} catch (GateException e) {
			assertFalse(false);
		}
		
		try {
			Wire wire = new Wire();
			new AndGate(wire, wire, new Wire());
			new AndGate(new Wire(), new Wire(), new Wire());
		} catch (GateException e) {
			assertTrue(false);
		}
	}
	
	public void testOutputSignal() {
		Wire inputWire1 = new Wire();
		Wire inputWire2 = new Wire();
		Wire outputWire = new Wire();
		try {
			AndGate gate = new AndGate(inputWire1, inputWire2, outputWire);
			
			inputWire1.setSignal(false);
			inputWire2.setSignal(false);
			assertEquals(false, gate.getOutputSignal());
			
			inputWire1.setSignal(true);
			inputWire2.setSignal(false);
			assertEquals(false, gate.getOutputSignal());
			
			inputWire1.setSignal(false);
			inputWire2.setSignal(true);
			assertEquals(false, gate.getOutputSignal());
			
			inputWire1.setSignal(true);
			inputWire2.setSignal(true);
			assertEquals(true, gate.getOutputSignal());
		} catch (GateException e) {
			assertTrue(false);
		}
	}
	
	public void testWireSignal() {
		Wire inputWire1 = new Wire();
		Wire inputWire2 = new Wire();
		Wire outputWire = new Wire();
		try {
			new AndGate(inputWire1, inputWire2, outputWire);
		} catch (GateException e) {
			assertTrue(false);
		}
		
		inputWire1.setSignal(false);
		inputWire2.setSignal(false);
		assertEquals(false, outputWire.getSignal());
		
		inputWire1.setSignal(true);
		inputWire2.setSignal(false);
		assertEquals(false, outputWire.getSignal());
		
		inputWire1.setSignal(false);
		inputWire2.setSignal(true);
		assertEquals(false, outputWire.getSignal());
		
		inputWire1.setSignal(true);
		inputWire2.setSignal(true);
		assertEquals(true, outputWire.getSignal());
	}
}
