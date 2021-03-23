package com.amituofo.xscript.keyworld.utils;

import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;
import com.amituofo.xscript.keyworld.lang.Set;

public class Add extends Set {

	public Add(Element e, Script parent) throws ScriptException {
		super(e, parent);
		// TODO Auto-generated constructor stub
	}

//	public Add(Element e, Script parent) throws ScriptException {
//		super(e, parent);
//	}
//
//	@Override
//	protected ExeResult body(Object... param) throws ScriptException {
//		for (Var var : varlist) {
//			Object newVal = replaceReferenceVarObj(varValMap.get(var.getName()));
//			((VarList)var).add(newVal);
//		}
//
//		return ExeResult.FINISHED;
//	}
}
