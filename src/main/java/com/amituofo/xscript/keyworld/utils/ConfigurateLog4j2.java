package com.amituofo.xscript.keyworld.utils;

import java.io.FileInputStream;

import org.apache.logging.log4j.core.LoggerContext;
import org.jdom.Element;

import com.amituofo.common.util.StringUtils;
import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class ConfigurateLog4j2 extends ExecutableScript {
	public ConfigurateLog4j2(Element e, Script parent) throws ScriptException {
		super(e, parent);

		// parseSub();
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		String configFilename = this.lookupAttributeDynamicStringValue("config-file");
		if (StringUtils.isEmpty(configFilename)) {
			return ExeResult.FINISHED;
		}

		org.apache.logging.log4j.core.config.ConfigurationSource source;
		try {
			source = new org.apache.logging.log4j.core.config.ConfigurationSource(new FileInputStream(configFilename));
			LoggerContext lc = org.apache.logging.log4j.core.config.Configurator.initialize(null, source);
		} catch (Exception e) {
			e.printStackTrace();
			throw new ScriptException("Failed when initialize log4j by configuration " + configFilename, e);
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
		// Attribute attr = e.getAttribute("cmd");
		// if (attr == null) {
		// throw new ScriptException("Cmd attribute not found!");
		// }
		//
		// cmd = attr.getValue();
		//
		// attr = e.getAttribute("param");
		// if (attr != null) {
		// param = attr.getValue();
		// }
		//
		// attr = e.getAttribute("workingDir");
		// if (attr != null) {
		// workingDir = attr.getValue().trim();
		// }
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}
}
