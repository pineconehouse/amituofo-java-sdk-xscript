package com.amituofo.xscript.keyworld.utils;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class VarList extends Var<List> {

	public VarList(Element e, Script parent) throws ScriptException {
		super(e, parent);
		// TODO Auto-generated constructor stub
	}
//	public VarList(Element e, Script parent) throws ScriptException {
//		super(e, parent);
//		
//		this.value = new ArrayList<Object>();
//	}
//
//	public VarList(String name, List value) throws ScriptException {
//		super(name, value);
//		
//		this.value = value;
//	}
//
//	@Override
//	public void parseValue(String val) {
////		this.value = val;
//	}
//
//	public void add(Object o) {
//		value.add(o);	
//	}
//	
////	public void remove(Object o) {
////		value.remove(o);	
////	}
//
//	public void remove(int index) {
//		value.remove(index);	
//	}
//
//	public Object get(int index) {
//		return value.get(index);	
//	}
//
//	public int size() {
//		return value.size();	
//	}

	@Override
	protected List parseValue(String defineValue) throws ScriptException {
		// TODO Auto-generated method stub
		return null;
	}
}
