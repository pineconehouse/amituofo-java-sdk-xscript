package com.amituofo.xscript.keyworld.lang;

import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class DoIfNot extends DoCondition {
	public DoIfNot(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		boolean isTrue = this.getExpResult();
		
		if (!isTrue) {
			return this.execSubscripts();
		}
		
		return ExeResult.FINISHED;
	}

	@Override
	protected void head(Object... param) throws ScriptException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void foot() throws ScriptException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void parseScriptAttribute() throws ScriptException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub
		
	}

}
