package com.amituofo.xscript.keyworld.db;

import java.sql.Connection;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class Commit extends ExecutableScript {
	private Connection connection;
	private String sql = "";

	public Commit(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected ExeResult body(Object... param) {
		System.out.println("exec" + sql);

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
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void parseScriptAttribute() throws ScriptException {
//		Attribute attr = e.getAttribute("sql");
//		if (attr == null) {
//			throw new ScriptException("sql attribute not found!");
//		}
//		sql = attr.getValue();
//		if (isReferenceVar(sql)) {
//			sql = (String) lookupVarValue(sql);
//		}
//
//		attr = e.getAttribute("connection");
//		if (attr == null) {
//			throw new ScriptException("sql attribute not found!");
//		}
//
//		String connName = attr.getValue();
//		if (isReferenceVar(connName)) {
//			connection = (Connection) lookupVarValue(connName);
//		}
	}

}
