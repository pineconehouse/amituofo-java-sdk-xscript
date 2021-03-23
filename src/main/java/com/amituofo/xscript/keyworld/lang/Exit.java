package com.amituofo.xscript.keyworld.lang;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class Exit extends ExecutableScript {

//	private String status;

	public Exit(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
//		String newstatus = replaceReferenceVarString(status);
//		System.exit(Integer.parseInt(newstatus));
		System.exit(0);

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
//		Attribute attr = e.getAttribute("status");
//		if (attr == null) {
//			throw new ScriptException("Status attribute not found!");
//		}
//
//		status = attr.getValue();
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}

}
