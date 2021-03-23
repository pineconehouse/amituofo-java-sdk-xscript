package com.amituofo.xscript.keyworld.db;

import java.sql.Connection;

import org.jdom.Element;

import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.Var;

public class VarConnection extends Var<Connection> {
	public VarConnection(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected Connection parseValue(String val) {
		return null;
	}
}
