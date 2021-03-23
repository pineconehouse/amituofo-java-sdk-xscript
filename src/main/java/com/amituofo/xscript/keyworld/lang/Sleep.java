package com.amituofo.xscript.keyworld.lang;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class Sleep extends ExecutableScript {
	private String ms;

	public Sleep(Element e, Script parent) throws ScriptException {
		super(e, parent);

	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		String newms = replaceReferenceVarString(ms);
		try {
			Thread.sleep(Long.parseLong(newms));
		} catch (Exception e) {
			throw new ScriptException(e);
		}

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
//		Attribute attr = e.getAttribute("ms");
//		if (attr == null) {
//			throw new ScriptException("ms attribute not found!");
//		}
//
//		ms = attr.getValue();
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub
		
	}
}
