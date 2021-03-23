package com.amituofo.xscript.keyworld.lang;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.common.util.StringUtils;
import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ReturnableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class Function extends ReturnableScript<Object> {
	private Var[] parameters;

	public Function(Element e, Script parent) throws ScriptException {
		super(e, parent);

		// parseSub();
	}

	@Override
	protected void parseScriptAttribute() throws ScriptException {
		String parametersDefine = lookupAttributeDefineValue("parameters");
		if (parametersDefine != null) {
			String[] params = parametersDefine.split(",");
			parameters = new VarObject[params.length];
			for (int i = 0; i < params.length; i++) {
				String param = params[i].trim();
				if (StringUtils.isNotEmpty(param)) {
					if (!param.startsWith("$")) {
						throw new ScriptException("Function parameter must be like $xxx!");
					}

					String paramName = param.substring(1);

					Var var = this.lookupVar(paramName);
					if (var == null) {
						var = new VarObject(paramName, null);
					}

					addVar(var);
					parameters[i] = var;
				}
			}
		}

		if (result == null) {
			result = new VarObject("", null);
		}
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		ExeResult es = this.execSubscripts();

		Script sc = this.getParent();
		if (sc != null) {
			((ReturnableScript) sc).setResult(this.getResult());
		}

		return es;
	}

	public void setParameterValues(Var[] values) {
		for (int i = 0; i < parameters.length; i++) {
			parameters[i].setValue(values[i].getValue());
		}
	}
	//
	// public Var[] getParameters() {
	// return parameters;
	// }

	@Override
	protected void head(Object... param) throws ScriptException {

	}

	@Override
	protected void foot() throws ScriptException {
		// TODO Auto-generated method stub

	}

}
