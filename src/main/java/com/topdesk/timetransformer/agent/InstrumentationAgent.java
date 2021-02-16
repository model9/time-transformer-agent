package com.topdesk.timetransformer.agent;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class InstrumentationAgent {
	/**
	 * JVM hook to statically load the javaagent at startup.
	 *
	 * After the Java Virtual Machine (JVM) has initialized, the premain method
	 * will be called. Then the real application main method will be called.
	 *
	 * @param agentArgs arguments passed to this agent
	 * @param instrumentation the {@link Instrumentation} instance passed by the JVM
	 * @throws UnmodifiableClassException 
	 */
	public static void premain(@SuppressWarnings("unused") String agentArgs, Instrumentation instrumentation) throws UnmodifiableClassException {
		instrumentation.addTransformer(new TimeInstrumentationTransformer(), false);
	}
}
