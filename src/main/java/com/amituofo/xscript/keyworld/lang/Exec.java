package com.amituofo.xscript.keyworld.lang;

import java.io.File;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.common.util.StringUtils;
import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class Exec extends ExecutableScript {
	private String cmd = null;
//	private String cmdparam = "cmd";
	private String workingDir = null;

	public Exec(Element e, Script parent) throws ScriptException {
		super(e, parent);

		// parseSub();
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		this.cmd = this.lookupAttributeDynamicStringValue("cmd");
		if (StringUtils.isEmpty(cmd)) {
			return ExeResult.FINISHED;
		}
		try {
			if (workingDir == null || workingDir.length() == 0) {
				Runtime.getRuntime().exec(cmd);
			} else {
				Runtime.getRuntime().exec(cmd, null, new File(replaceReferenceVarString(workingDir)));
			}
		} catch (Exception e) {
			throw new ScriptException(e);
		}

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
//		Attribute attr = e.getAttribute("cmd");
//		if (attr == null) {
//			throw new ScriptException("Cmd attribute not found!");
//		}
//
//		cmd = attr.getValue();
//
//		attr = e.getAttribute("param");
//		if (attr != null) {
//			param = attr.getValue();
//		}
//
//		attr = e.getAttribute("workingDir");
//		if (attr != null) {
//			workingDir = attr.getValue().trim();
//		}
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}
}
