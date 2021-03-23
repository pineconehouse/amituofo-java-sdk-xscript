package com.amituofo.xscript.keyworld.lang;

import org.jdom.Element;

import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class VarInt extends Var<Integer> {
	
	public VarInt(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected Integer parseValue(String defineValue) {
		try {
			int i = Integer.parseInt(defineValue);
			return i;
		} catch (Exception e1) {
		}
		
		return null;
	}
}
