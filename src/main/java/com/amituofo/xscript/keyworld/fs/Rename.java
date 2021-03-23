package com.amituofo.xscript.keyworld.fs;

import java.io.File;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ReturnableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class Rename extends ReturnableScript<Boolean> {
	protected String sourcePath;
	protected String targetPath;

	public Rename(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		File source = new File(replaceReferenceVarString(sourcePath));
		File target = new File(replaceReferenceVarString(targetPath));

		setResult(source.renameTo(target));

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

//		Attribute attr = e.getAttribute("source");
//		if (attr == null) {
//			throw new ScriptException("Source attribute not found!");
//		}
//
//		sourcePath = attr.getValue();
//
//		attr = e.getAttribute("target");
//		if (attr == null) {
//			throw new ScriptException("Target attribute not found!");
//		}
//
//		targetPath = attr.getValue();
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}

}
