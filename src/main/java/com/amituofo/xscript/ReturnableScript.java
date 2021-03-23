package com.amituofo.xscript;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public abstract class ReturnableScript<RESULT_CLASS extends Object> extends ExecutableScript {
	protected Var<RESULT_CLASS> result;

	public ReturnableScript() throws ScriptException {
	}

	public ReturnableScript(Element e, Script parent) throws ScriptException {
		super(e, parent);
		
		Attribute attr = e.getAttribute("result");
		if (attr != null) {
			String varName = attr.getValue().replace("$", "");
			result = this.lookupVar(varName);

			if (result == null) {
				result = new Var<RESULT_CLASS>(varName, null);
				this.getParent().addVar(result);
				// throw new ScriptException("Result var not found!");
			}
		}
	}

	@Override
	protected void parseSubScript(Element e, Script parent) throws ScriptException {
		super.parseSubScript(e, parent);
	}

	public RESULT_CLASS getResult() {
		if (result != null) {
			return result.getValue();
		}
		return null;
	}

	public void setResult(RESULT_CLASS value) {
		if (result != null) {
			result.setValue(value);
		} else {
			
		}
	}
}
