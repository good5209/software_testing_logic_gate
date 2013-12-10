package logicGate;

/**
 * attached with wires, obtain and compute one or more input signal, produce one output signal
 */
interface Gate {
	/**
	 * get output wire signal
	 */
	public boolean getOutputSignal();
}
