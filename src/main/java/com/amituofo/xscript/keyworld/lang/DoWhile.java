package com.amituofo.xscript.keyworld.lang;

import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class DoWhile extends DoCondition {

	public DoWhile(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		while (this.getExpResult()) {
			ExeResult es = this.execSubscripts();
			if (es == ExeResult.BREAK) {
				return ExeResult.BREAK;
			} else if (es == ExeResult.CONTINUE) {
				continue;
			} else if (es == ExeResult.RETURN) {
				return ExeResult.RETURN;
			}
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
