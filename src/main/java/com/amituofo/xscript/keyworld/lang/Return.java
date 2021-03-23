package com.amituofo.xscript.keyworld.lang;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ExecutableScript;
import com.amituofo.xscript.ReturnableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;

public class Return extends ExecutableScript {
	final static String KEY = "951753862497532159!2@3#4$5%6^7&8*9(0)-_=+qazxsw";
	private String value = KEY;

	public Return(Element e, Script parent) throws ScriptException {
		super(e, parent);

	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		if (!KEY.equals(value)) {
			String ret = replaceReferenceVarString(value);
			Script sc = this.getParent();
			if (sc != null) {
				((ReturnableScript) sc).setResult(ret);
			}
		}

		return ExeResult.RETURN;
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
//		Attribute attr = e.getAttribute("value");
//		if (attr != null) {
//			// throw new ScriptException("Value attribute not found!");
//			value = attr.getValue();
//		}
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}

}
