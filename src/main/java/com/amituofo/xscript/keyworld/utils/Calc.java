package com.amituofo.xscript.keyworld.utils;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ReturnableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.util.Expression;

public class Calc extends ReturnableScript {
	// private final static StringCaculate caculate = new StringCaculate();
	private String exp = "";

	public Calc(Element e, Script parent) throws ScriptException {
		super(e, parent);

		// parseSub();
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		String newexp = replaceReferenceVarString(exp);

		Expression builder = new Expression(newexp);
		double rest;
		try {
			rest = builder.eval().doubleValue();
		} catch (Exception e) {
			throw new ScriptException(e);
		}

		setResult(rest);

		return ExeResult.FINISHED;
	}

	@Override
	protected void head(Object... param) throws ScriptException {
	}

	@Override
	protected void foot() throws ScriptException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void parseScriptAttribute() throws ScriptException {
//		Attribute attr = e.getAttribute("exp");
//		if (attr == null) {
//			throw new ScriptException("Exp attribute not found!");
//		}
//
//		exp = attr.getValue();
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}

}
