package com.amituofo.xscript.keyworld.lang;

import org.jdom.Element;

import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class VarObject extends Var<Object> {
	public VarObject(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	public VarObject(String name, Object value) throws ScriptException {
		super(name, value);
	}

	@Override
	protected Object parseValue(String val) {
		return null;
	}
}
