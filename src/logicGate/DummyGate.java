package logicGate;

/**
 * simply redirect input signal to output wire
 */
public class DummyGate implements Gate {
	private Wire input, output;
	
	/**
	 * Dummy gate
	 * @param input input wire
	 * @param output output wire
	 * @throws GateException attach wire is invalid
	 */
	public DummyGate(Wire input, Wire output) throws GateException {
		if (input != null && output != null && input != output) {
			this.input = input;
			this.output = output;
			this.output.attachGateOutput(this);
			return;
		}
		throw new GateException("DummyGate create failure");
	}
	
	@Override
	public boolean getOutputSignal() {
		return input.getSignal();
	}
}
