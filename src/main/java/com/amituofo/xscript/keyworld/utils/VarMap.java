package com.amituofo.xscript.keyworld.utils;

import java.util.HashMap;
import java.util.Map;

import org.jdom.Element;

import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class VarMap extends Var<Map> {

	public VarMap(Element e, Script parent) throws ScriptException {
		super(e, parent);
		// TODO Auto-generated constructor stub
	}
//	public VarMap(Element e, Script parent) throws ScriptException {
//		super(e, parent);
//		
//		this.value = new HashMap<String, Object>();
//	}
//
//	public VarMap(String name, Map value) throws ScriptException {
//		super(name, value);
//		
//		this.value = value;
//	}
//
//	@Override
//	public void parseValue(String val) {
////		this.value = val;
//	}

	@Override
	protected Map parseValue(String defineValue) throws ScriptException {
		// TODO Auto-generated method stub
		return null;
	}
}
