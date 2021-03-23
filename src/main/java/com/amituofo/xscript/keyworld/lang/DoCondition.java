package com.amituofo.xscript.keyworld.lang;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.util.Expression;

public abstract class DoCondition extends ExecutableScript {

	protected String exp;

	public DoCondition(Element e, Script parent) throws ScriptException {
		super(e, parent);

		Attribute attr = e.getAttribute("exp");
		if (attr == null) {
			throw new ScriptException("Exp attribute not found!");
		}

		exp = attr.getValue();
	}

	public boolean getExpResult() throws ScriptException {
		String newexp = replaceReferenceVarString(exp);

		Expression builder = new Expression(newexp);
		try {
			return builder.evalBoolean();
		} catch (Exception e) {
			throw new ScriptException(e);
		}
	}
}
