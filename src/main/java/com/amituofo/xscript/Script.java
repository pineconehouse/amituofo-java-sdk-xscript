package com.amituofo.xscript;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.common.util.StringUtils;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;
import com.amituofo.xscript.keyworld.lang.Function;

public abstract class Script {

	// private List<Element> subElements = null;

	private final Map<String, Var<?>> scriptVars = new HashMap<String, Var<?>>();
	private final Map<String, String> attributes = new HashMap<String, String>();

	private Script[] subscripts = null;

	private final String name;
	private final Script parent;
	// private final Element e;

	public Script() {
		name = null;
		// e = null;
		parent = null;
	}

	public Script(String name) {
		this.name = name;
		this.parent = null;
	}

	public Script(Element e, Script parent) throws ScriptException {
		this.parent = parent;
		// this.subElements = e.getChildren();
		// this.e = e;

		// if (this.subElements.size() == 0) {
		// this.subElements = null;
		// }

		Attribute attr = e.getAttribute("name");
		if (attr != null) {
			this.name = attr.getValue();
		} else {
			this.name = null;
		}

		List<Attribute> attributes = e.getAttributes();
		for (Attribute attr1 : attributes) {
			addAttributeDefine(attr1.getName(), attr1.getValue());
		}

		parseScriptAttribute();

		initScript(e, parent);

		parseSubScript(e, parent);
	}

	protected abstract void parseScriptAttribute() throws ScriptException;

	protected abstract void initScript(Element e, Script parent) throws ScriptException;

	public void addAttributeDefine(String name, String defineValue) {
		attributes.put(name, defineValue);
	}

	public String[] getAttributes() {
		return attributes.keySet().toArray(new String[attributes.size()]);
	}

	protected String lookupAttributeDefineValue(String attrName) throws ScriptException {
		String varValue = attributes.get(attrName);
		if (StringUtils.isEmpty(varValue)) {
			// throw new ScriptException("Unable to find var [" + attrName + "].");
			return null;
		} else {
			return varValue;
		}
	}

	protected Object lookupAttributeDynamicValue(String attrName) throws ScriptException {
		String varValue = attributes.get(attrName);
		if (StringUtils.isEmpty(varValue)) {
			throw new ScriptException("Unable to find attribute [" + attrName + "].");
		} else {
			return this.replaceReferenceVarObj(varValue);
		}
	}

	protected Object lookupAttributeDynamicValue(String attrName, Object defaultValue) throws ScriptException {
		String varValue = attributes.get(attrName);
		if (StringUtils.isEmpty(varValue)) {
			return defaultValue;
		}

		return this.replaceReferenceVarObj(varValue);
	}

	protected String lookupAttributeDynamicStringValue(String attrName) throws ScriptException {
		String varValue = attributes.get(attrName);
		if (StringUtils.isEmpty(varValue)) {
			throw new ScriptException("Unable to find attribute [" + attrName + "].");
		} else {
			return this.replaceReferenceVarString(varValue);
		}
	}

	protected String lookupAttributeDynamicStringValue(String attrName, String defaultValue) throws ScriptException {
		String varValue = attributes.get(attrName);
		if (StringUtils.isEmpty(varValue)) {
			return defaultValue;
		} else {
			return this.replaceReferenceVarString(varValue);
		}
	}

	protected boolean lookupAttributeDynamicBooleanValue(String attrName, boolean defaultValue) throws ScriptException {
		String varValue = attributes.get(attrName);
		if (StringUtils.isEmpty(varValue)) {
			return defaultValue;
		} else {
			String value = this.replaceReferenceVarString(varValue);
			try {
				boolean ret = Boolean.parseBoolean(value);
				return ret;
			} catch (Exception e) {
				return defaultValue;
			}
		}
	}

	protected int lookupAttributeDynamicIntValue(String attrName, int defaultValue) throws ScriptException {
		String varValue = attributes.get(attrName);
		if (StringUtils.isEmpty(varValue)) {
			return defaultValue;
		} else {
			String value = this.replaceReferenceVarString(varValue);
			try {
				int ret = Integer.parseInt(value);
				return ret;
			} catch (Exception e) {
				return defaultValue;
			}
		}
	}

	protected double lookupAttributeDynamicDoubleValue(String attrName, double defaultValue) throws ScriptException {
		String varValue = attributes.get(attrName);
		if (StringUtils.isEmpty(varValue)) {
			return defaultValue;
		} else {
			String value = this.replaceReferenceVarString(varValue);
			try {
				double ret = Double.parseDouble(value);
				return ret;
			} catch (Exception e) {
				return defaultValue;
			}
		}
	}
	
	protected long lookupAttributeDynamicLongValue(String attrName, long defaultValue) throws ScriptException {
		String varValue = attributes.get(attrName);
		if (StringUtils.isEmpty(varValue)) {
			return defaultValue;
		} else {
			String value = this.replaceReferenceVarString(varValue);
			try {
				long ret = Long.parseLong(value);
				return ret;
			} catch (Exception e) {
				return defaultValue;
			}
		}
	}

	protected void parseSubScript(Element e, Script parent) throws ScriptException {
		List<Element> subElements = e.getChildren();
		if (subElements == null || subElements.size() == 0) {
			return;
		}

		List<Script> subscripts1 = new ArrayList<Script>();
		for (Element element : subElements) {
			Script inst = ScriptKeyword.newInstance(element.getName(), element, this);
			if (inst instanceof Var) {
				Var<?> var = (Var<?>) inst;
				scriptVars.put(var.getName(), var);
			}

			subscripts1.add(inst);
		}

		if (subscripts1.size() > 0) {
			this.subscripts = new Script[subscripts1.size()];
			for (int i = 0; i < subscripts.length; i++) {
				subscripts[i] = subscripts1.get(i);
			}
		}
	}

	protected Object lookupVarValue(String varName) throws ScriptException {
		Var var = lookupVar(varName);
		if (var == null) {
			throw new ScriptException("Var " + varName + " not found!");
		}

		return var.getValue();
	}

	protected Var lookupVar(String varName) throws ScriptException {
		Var var = lookupVar(this, varName);
		if (var == null) {
			var = Global.globalVars.get(varName);
		}

		return var;
	}

	private Var lookupVar(Script sc, String varName) throws ScriptException {
		Var var = sc.scriptVars.get(varName);
		if (var == null && sc.parent != null) {
			return lookupVar(sc.parent, varName);
		}

		return var;
	}

	protected boolean isReferenceVar(String paramName) {

		if (paramName != null && paramName.length() > 0) {
			return paramName.indexOf("${") != -1;
		}

		return false;
	}

	protected String replaceReferenceVarString(String value) throws ScriptException {
		if (value != null && value.length() > 0) {
			String tempVal = value;
			int start = -1;
			int end = -1;

			start = tempVal.indexOf("${");
			while (start != -1) {
				end = tempVal.indexOf("}", start + 1);
				if (end != -1) {
					String varName = tempVal.substring(start + 2, end);

					Object repwith = lookupVarValue(varName);
					if (repwith == null) {
						repwith = "null";
						throw new ScriptException("var ${" + varName + "} not found.");
					}
					tempVal = tempVal.replace("${" + varName + "}", repwith.toString());
				}

				start = tempVal.indexOf("${");
			}
			return tempVal;
		}

		return value;
	}

	protected Object replaceReferenceVarObj(String value) throws ScriptException {
		if (value != null && value.length() > 0) {
			String tempVal = value.trim();
			int start = -1;
			int end = -1;

			start = tempVal.indexOf("${");
			if (start != -1 && start == 0) {
				end = tempVal.indexOf("}", start + 1);
				if (end != -1) {
					String varName = tempVal.substring(start + 2, end);

					Object repwith = lookupVarValue(varName);
					return repwith;
				}
			}
			return tempVal;
		}

		return value;
	}

	protected Function lookupFunction(String name) {// , Var[] parameters) {
		Script isParentNull = this.parent;
		Script root = this;
		while (isParentNull != null) {
			root = isParentNull;
			isParentNull = isParentNull.parent;
		}

		if (root.subscripts != null) {
			for (Script script : root.subscripts) {
				if (script instanceof Function) {
					Function fun = (Function) script;
					if (name.equalsIgnoreCase(fun.getName())) {
						// if (parameters != null) {
						// if (parameters.length == fun.getParameters().length) {
						// return fun;
						// }
						// } else {
						return fun;
						// }
					}
				}
			}
		}

		return null;
	}

	protected void addVar(Var var) {
		scriptVars.put(var.getName(), var);
	}

	protected Script getParent() {
		return parent;
	}

	public Script[] getSubscripts() {
		return subscripts;
	}

	public String getName() {
		return name;
	}
}
