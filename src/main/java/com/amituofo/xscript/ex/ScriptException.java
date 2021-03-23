package com.amituofo.xscript.ex;

import com.amituofo.common.ex.HSCException;

public class ScriptException extends HSCException {
	public ScriptException() {
		super();
	}

	public ScriptException(String msg) {
		super(msg);
	}

	public ScriptException(Throwable cause) {
		super(cause);
	}

	public ScriptException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
