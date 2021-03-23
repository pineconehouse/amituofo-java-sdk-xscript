package com.amituofo.xscript.keyworld.lang;

import java.math.BigDecimal;

import org.jdom.Element;

import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class VarDouble extends Var<Double> {
	public VarDouble(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected Double parseValue(String val) {
		try {
			return Double.valueOf(val);
		} catch (NumberFormatException e) {
			return null;
		}

	}
}
