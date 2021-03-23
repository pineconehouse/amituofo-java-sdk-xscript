package com.amituofo.xscript.keyworld;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.common.util.StringUtils;
import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public  class Var<T extends Object> extends ExecutableScript {
	private T value;
	private String defineValue;

	public Var(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	public Var(String name, T value) throws ScriptException {
		super(name);
		this.value = value;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
	
	public void parseAndSetValue(String value) throws ScriptException {
		this.value = parseValue(value);
	}

	protected T parseValue(String defineValue) throws ScriptException {
		return null;
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
//		if (this.isReferenceVar(defineValue)) {
//			this.value = (T) this.lookupAttributeDynamicValue("value");
//		}

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
	protected void initScript(Element e, Script parent) throws ScriptException {
		this.defineValue = this.lookupAttributeDefineValue("value");

		this.value = parseValue(defineValue);

//		if (!this.isReferenceVar(defineValue)) {
//			this.value = parseValue(defineValue);
//		} else {
//			this.value = (T) this.lookupAttributeDynamicValue("value");
//		}
	}

	@Override
	protected void parseScriptAttribute() throws ScriptException {

		// Attribute attr = e.getAttribute("name");
		// if (attr == null) {
		// throw new ScriptException("Var name attribute not found!");
		// }
		//
		// name = attr.getValue();
		//
		// attr = e.getAttribute("value");
		// if (attr == null) {
		// // throw new ScriptException("Value attribute not found!");
		// strValue = null;
		// } else {
		// strValue = attr.getValue();
		// if (StringUtils.isNotEmpty(strValue)) {
		// strValue = this.replaceReferenceVarString(strValue);
		// }
		// }
	}
}
