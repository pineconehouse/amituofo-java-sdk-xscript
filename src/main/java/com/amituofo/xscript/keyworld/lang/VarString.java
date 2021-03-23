package com.amituofo.xscript.keyworld.lang;

import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class VarString extends Var<String> {
	public VarString(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected String parseValue(String defineValue) throws ScriptException {
		String val;
		if (!this.isReferenceVar(defineValue)) {
			val = defineValue;
		} else {
			val = (String) this.lookupAttributeDynamicStringValue("value");
		}

		return val;
	}

//	@Override
//	protected ExeResult body(Object... param) throws ScriptException {
//		 super.body();
//	}
	
	
}
