package com.amituofo.xscript.keyworld.lang;

import org.jdom.Element;

import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class VarBoolean extends Var<Boolean> {
	public VarBoolean(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected Boolean parseValue(String defineValue) {
		if ("true".equalsIgnoreCase(defineValue)) {
			return Boolean.TRUE;
		}
		return Boolean.FALSE;
	}
}
