package com.hitachivantara.test;

import java.io.File;
import java.io.IOException;

import org.jdom.JDOMException;

import com.amituofo.common.ex.InvalidParameterException;
import com.amituofo.xscript.ScriptBuilder;
import com.amituofo.xscript.ex.ScriptException;

public class ExecXscript  {

	public static void main(String[] args) throws JDOMException, IOException, ScriptException, InvalidParameterException {
		new ScriptBuilder().withScriptFile(new File("E:\\WORKSPACE1\\hitachivantara-java-sdk-xscript\\src\\test\\java\\Script(Sample2).xml")).bulid().exec();
	}

}
