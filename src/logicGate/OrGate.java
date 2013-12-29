package logicGate;

public class OrGate implements Gate
{
	private Wire input1, input2, output;

	/**
	 * Or gate
	 * @param input input wire
	 * @param output output wire
	 * @throws GateException attach wire is invalid
	 */
	public OrGate(Wire input1, Wire input2, Wire output) throws GateException
	{
		if(input1 != null && input2 != null && output != null && input1 != output && input2 != output)
		{
			this.input1 = input1;
			this.input2 = input2;
			this.output = output;
			this.output.attachGateOutput(this);
			return;
		}

		throw new GateException("OrGate create failure");
	}

	@Override
	public boolean getOutputSignal()
	{
		return (input1.getSignal() || input2.getSignal());
	}
}