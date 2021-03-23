package com.amituofo.xscript.keyworld.io;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class Print extends ExecutableScript {

	public Print(Element e, Script parent) throws ScriptException {
		super(e, parent);

		// parseSub();
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		String print = super.lookupAttributeDynamicStringValue("value");
		System.out.println(print);

		return ExeResult.FINISHED;
	}

	@Override
	protected void head(Object... param) throws ScriptException {
		// value = replaceRelVar(value);
	}

	@Override
	protected void foot() throws ScriptException {
		// TODO Auto-generated method stub

	}

	@Override
	protected void parseScriptAttribute() throws ScriptException {
//		Attribute attr = e.getAttribute("value");
//		if (attr == null) {
//			throw new ScriptException("Value attribute not found!");
//		}
//
//		value = attr.getValue();
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}

}
