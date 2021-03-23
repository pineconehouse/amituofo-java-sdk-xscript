package com.amituofo.xscript.keyworld.utils;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ReturnableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class Get extends ReturnableScript {

	private String index;

	public Get(Element e, Script parent) throws ScriptException {
		super(e, parent);

		//TODO
	}

	@Override
	protected void head(Object... param) throws ScriptException {
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void foot() throws ScriptException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void parseScriptAttribute() throws ScriptException {

//		Attribute attr = e.getAttribute("index");
//		if (attr == null) {
//			throw new ScriptException("Get index attribute not found!");
//		}
//		
//		index = attr.getValue();
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub
		
	}
}
