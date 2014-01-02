package logicGate;

/**
 * obtain one input signal, and produce "or" signal to output wire
 */
public class NotGate implements Gate {
	private Wire input, output;
	
	/**
	 * Not gate
	 * @param input input wire
	 * @param output output wire
	 * @throws GateException attach wire is invalid
	 */
	public NotGate(Wire input, Wire output) throws GateException {
		if (input != null && output != null && input != output) { // output cannot connect to input
			this.input = input;
			this.output = output;
			this.output.attachGateOutput(this);
			return;
		}
		throw new GateException("NotGate create failure");
	}
	
	@Override
	public boolean getOutputSignal() {
		return !input.getSignal();
	}
}
