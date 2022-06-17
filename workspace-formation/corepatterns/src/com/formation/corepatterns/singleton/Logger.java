package com.formation.corepatterns.singleton;

import java.io.Serializable;

public class Logger implements Serializable, Cloneable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger log;

	private Logger() {

	}

	public static Logger log(String message) {

		synchronized (Logger.class) {
			if (log == null) {
				synchronized (Logger.class) {
					log = new Logger();
					System.out.println(message);
				}
			}
		}
		return log;

	}

	public Object readResolve() {
		return log;

	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();

	}
}
