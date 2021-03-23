package com.amituofo.xscript.keyworld.fs;

import java.io.File;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ReturnableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class Exists extends ReturnableScript<Boolean> {
	protected String dirPath;

	public Exists(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		File dir = new File(replaceReferenceVarString(dirPath));
		this.setResult(dir.exists());

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
//		Attribute attr = e.getAttribute("dir");
//		if (attr == null) {
//			throw new ScriptException("dir attribute not found!");
//		}
//
//		dirPath = attr.getValue();
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}

}
