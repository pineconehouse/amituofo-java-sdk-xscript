package com.amituofo.xscript;

import java.io.File;
import java.io.IOException;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.lang.Function;

public class ScriptEntry extends ReturnableScript {

	private Function main = null;

	public ScriptEntry(Element e) throws ScriptException {
		super(e, null);
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		if (main == null) {
			throw new ScriptException("Main function not found!");
		}

		return main.exec();
	}

	@Override
	protected void head(Object... param) throws ScriptException {
		this.main = lookupFunction("main");
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
