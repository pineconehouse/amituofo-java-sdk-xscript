package com.amituofo.xscript.keyworld.lang;

import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class Threading extends ExecutableScript implements Runnable {
	public Threading(Element e, Script parent) throws ScriptException {
		super(e, parent);
//		parseSub();
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		new Thread(this).start();
		
		return ExeResult.FINISHED;
	}

	public void run() {
		try {
			this.execSubscripts();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
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
