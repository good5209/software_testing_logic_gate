package logicGate;

/**
 * connected between gates, transmit and represent logic unit signal
 */
public class Wire {
	private boolean signal = false;
	private Gate outputGate;
	
	/**
	 * set this wire signal state
	 * @param signal signal value
	 */
	public void setSignal(boolean signal) {
		this.signal = signal;
	}
	
	/**
	 * get this wire signal state
	 * @return signal value
	 */
	public boolean getSignal() {
		if (outputGate != null) { // check wire is attach to gate
			return outputGate.getOutputSignal();
		}
		return signal;
	}

	/**
	 * attach to a gate output
	 * @param gate attach to this gate's output
	 * @throws GateException already attach to another gate
	 */
	public void attachGateOutput(Gate gate) throws GateException {
		if (outputGate == null) { // wire only can add to a gate output
			outputGate = gate;
			return;
		}
		throw new GateException("Wire try to attach more than one gate output");
	}
}
