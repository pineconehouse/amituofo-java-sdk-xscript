package com.amituofo.xscript.keyworld.lang;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ReturnableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class Call extends ReturnableScript {
	private String[] parameterNames;

	public Call(Element e, Script parent) throws ScriptException {
		super(e, parent);

		// parseSub();
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		String function = (String) this.lookupAttributeDynamicStringValue("function");

		Function fun = this.lookupFunction(function);

		Var[] paramValues = null;
		if (parameterNames != null) {
			paramValues = new Var[parameterNames.length];
			for (int i = 0; i < parameterNames.length; i++) {
				paramValues[i] = this.lookupVar(parameterNames[i]);
			}
		}

		fun.setParameterValues(paramValues);
		fun.exec();
		setResult(fun.getResult());

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
		String parametersDefine = lookupAttributeDefineValue("parameters");
		if (parametersDefine != null) {
			String[] params = parametersDefine.split(",");
			parameterNames = new String[params.length];
			for (int i = 0; i < params.length; i++) {
				String param = params[i].trim();
				if (!param.startsWith("${") || !param.endsWith("}")) {
					throw new ScriptException("Function parameter must be like ${xxx}!");
				}

				String paramName = param.substring(2, param.length() - 1);
				parameterNames[i] = paramName;
				super.addAttributeDefine(paramName, param);
				// Var var = this.lookupVar(paramNm);
				// if (var == null) {
				// throw new ScriptException("Function parameter " + paramNm + " not found!");
				// }
				// parameters[i] = var;
			}
		}
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}
}
