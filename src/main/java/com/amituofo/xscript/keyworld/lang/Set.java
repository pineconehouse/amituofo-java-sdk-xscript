package com.amituofo.xscript.keyworld.lang;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class Set extends ExecutableScript {
	// protected List<Var> varlist = new ArrayList<Var>();
	// protected Map<String, String> varValMap = new HashMap<String, String>();
	private String[] attributes;

	public Set(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		for (String varname : attributes) {
			String newVal = super.lookupAttributeDynamicStringValue(varname);
			Var var = super.lookupVar(varname);

			if (var == null) {
				throw new ScriptException("variable [" + varname + "] not found!");
			} else {
				var.parseAndSetValue(newVal);
			}
			// System.out.println(varname+"="+var.getValue());
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
		Var var = null;
		// Attribute attr = e.getAttribute("name");
		// if (attr != null) {
		// var = this.lookupVar(attr.getValue());
		// if (var == null) {
		// throw new ScriptException("Var " + attr.getValue() + " not found!");
		// }
		// varlist.add(var);
		//
		// attr = e.getAttribute("value");
		// if (attr == null) {
		// throw new ScriptException("Value attribute not found!");
		// }
		// varValMap.put(var.getName(), attr.getValue());
		// }
		//
		// // -----------------------------------------------------------------
		//
		// List<Attribute> attrSets = e.getAttributes();
		// for (Attribute attrSet : attrSets) {
		// if (!attrSet.getName().equalsIgnoreCase("name") && !attrSet.getName().equalsIgnoreCase("value")) {
		// var = this.lookupVar(attrSet.getName());
		// if (var == null) {
		// throw new ScriptException("Var " + attrSet.getName() + " not found!");
		// }
		//
		// varlist.add(var);
		// varValMap.put(attrSet.getName(), attrSet.getValue());
		// }
		// }

		attributes = super.getAttributes();
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}
}
