package logicGate;

import junit.framework.TestCase;

import logicGate.Wire;
import logicGate.GateException;

public class WireTest extends TestCase {
	public void testWire() {
		new Wire();
	}
	
	public void testGetSignal() {
		Wire wire = new Wire();
		assertEquals(false, wire.getSignal());
		try {
			Wire inputWire = new Wire();
			Wire outputWire = new Wire();
			new DummyGate(inputWire, outputWire);
			inputWire.setSignal(true);
			assertEquals(true, outputWire.getSignal());
		} catch (GateException e) {
			assertTrue(false);
		}
	}
	
	public void testSetSignal() {
		Wire w = new Wire();
		w.setSignal(true);
		assertEquals(true, w.getSignal());
		w.setSignal(false);
		assertEquals(false, w.getSignal());
	}
	
	public void testAttachGateOutput() {
		try {
			Wire wire = new Wire();
			new DummyGate(new Wire(), wire);
			new DummyGate(new Wire(), wire);
		} catch (GateException e) {
			assertFalse(false);
		}
		
		try {
			Wire wire = new Wire();
			new DummyGate(new Wire(), wire);
			new DummyGate(wire, new Wire());
		} catch (GateException e) {
			assertTrue(false);
		}
		
		try {
			Wire wire = new Wire();
			new DummyGate(wire, new Wire());
			new DummyGate(wire, new Wire());
		} catch (GateException e) {
			assertTrue(false);
		}
		
		try {
			new DummyGate(new Wire(), new Wire());
		} catch (GateException e) {
			assertTrue(false);
		}
	}
}
