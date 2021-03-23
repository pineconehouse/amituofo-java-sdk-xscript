package com.amituofo.xscript.keyworld.db;

import java.sql.Connection;

import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class ExecProc extends ExecutableScript {
	private Connection connection;
	private String proc = "";

	public ExecProc(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected ExeResult body(Object... param) {
		System.out.println("exec" + proc);
		
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
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void parseScriptAttribute() throws ScriptException {
		// TODO Auto-generated method stub
		
	}

}
