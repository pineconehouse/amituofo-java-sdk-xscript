package com.amituofo.xscript.keyworld.fs;

import java.io.File;

import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class MkDir extends Exists {

	public MkDir(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		File dir = new File(replaceReferenceVarString(dirPath));

		if (!dir.exists()) {
			setResult(dir.mkdirs());
		}

		return ExeResult.FINISHED;
	}

}
