package com.amituofo.xscript;

import java.util.HashMap;
import java.util.Map;

import org.jdom.Element;

import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.keyworld.fs.Copy;
import com.amituofo.xscript.keyworld.fs.MkDir;
import com.amituofo.xscript.keyworld.fs.Rename;
import com.amituofo.xscript.keyworld.fs.RmDir;
import com.amituofo.xscript.keyworld.io.Print;
import com.amituofo.xscript.keyworld.lang.Break;
import com.amituofo.xscript.keyworld.lang.Call;
import com.amituofo.xscript.keyworld.lang.Continue;
import com.amituofo.xscript.keyworld.lang.DoIf;
import com.amituofo.xscript.keyworld.lang.DoIfNot;
import com.amituofo.xscript.keyworld.lang.DoWhile;
import com.amituofo.xscript.keyworld.lang.Exec;
import com.amituofo.xscript.keyworld.lang.Exit;
import com.amituofo.xscript.keyworld.lang.Function;
import com.amituofo.xscript.keyworld.lang.Return;
import com.amituofo.xscript.keyworld.lang.Set;
import com.amituofo.xscript.keyworld.lang.Sleep;
import com.amituofo.xscript.keyworld.lang.Threading;
import com.amituofo.xscript.keyworld.lang.VarDouble;
import com.amituofo.xscript.keyworld.lang.VarInt;
import com.amituofo.xscript.keyworld.lang.VarObject;
import com.amituofo.xscript.keyworld.lang.VarString;
import com.amituofo.xscript.keyworld.lang.VarSystemProperty;
import com.amituofo.xscript.keyworld.utils.Calc;
import com.amituofo.xscript.keyworld.utils.ConfigurateLog4j2;

public class ScriptKeyword {
	private final static Map<String, Class<? extends Script>> basicKeywordMap = new HashMap<String, Class<? extends Script>>();
	private final static Map<String, Class<? extends Script>> customeKeywordMap = new HashMap<String, Class<? extends Script>>();

	static {
		basicKeywordMap.put("var-int", VarInt.class);
		basicKeywordMap.put("var-string", VarString.class);
		basicKeywordMap.put("var-double", VarDouble.class);
		basicKeywordMap.put("var-object", VarObject.class);
		basicKeywordMap.put("var-system-property", VarSystemProperty.class);
		basicKeywordMap.put("var", VarObject.class);
		basicKeywordMap.put("print", Print.class);
		basicKeywordMap.put("function", Function.class);
		basicKeywordMap.put("calc", Calc.class);
		basicKeywordMap.put("exec", Exec.class);
		basicKeywordMap.put("call", Call.class);
		basicKeywordMap.put("set", Set.class);
		basicKeywordMap.put("do-if", DoIf.class);
		basicKeywordMap.put("do-ifnot", DoIfNot.class);
		basicKeywordMap.put("do-while", DoWhile.class);
		basicKeywordMap.put("sleep", Sleep.class);
		basicKeywordMap.put("threading", Threading.class);
		basicKeywordMap.put("exit", Exit.class);
		basicKeywordMap.put("return", Return.class);
		basicKeywordMap.put("break", Break.class);
		basicKeywordMap.put("continue", Continue.class);
		// keywordMap.put("", .class);
		// keywordMap.put("", .class);
		// keywordMap.put("", .class);
		// keywordMap.put("", .class);
		basicKeywordMap.put("copy", Copy.class);
		basicKeywordMap.put("mkdir", MkDir.class);
		basicKeywordMap.put("rmdir", RmDir.class);
		basicKeywordMap.put("rename", Rename.class);

		basicKeywordMap.put("configurate-log4j2", ConfigurateLog4j2.class);
	}

	public static Script newInstance(String keyword, Element element, Script parent) throws ScriptException {
		Script inst = null;
		Class<? extends Script> cls = basicKeywordMap.get(keyword.toLowerCase());
		if (cls != null) {
			try {
				inst = cls.getConstructor(Element.class, Script.class).newInstance(element, parent);
			} catch (Exception e1) {
				throw new ScriptException("Failed to create script [" + keyword + "]", e1);
			}

			return inst;
		}

		cls = customeKeywordMap.get(keyword.toLowerCase());
		if (cls != null) {
			try {
				inst = cls.getConstructor(Element.class, Script.class).newInstance(element, parent);
			} catch (Exception e1) {
				throw new ScriptException("Failed to create script [" + keyword + "]", e1);
			}

			return inst;
		}

		throw new ScriptException("Unknow script [" + keyword + "]");
	}

	public static void register(String keyword, Class<? extends Script> newsccls) throws ScriptException {
		Class<? extends Script> cls = basicKeywordMap.get(keyword.toLowerCase());
		if (cls != null) {
			basicKeywordMap.remove(keyword.toLowerCase());
			// throw new ScriptException("Keyword "+keyword+" already exist in basic keyword list.");
		}

		customeKeywordMap.put(keyword.toLowerCase(), newsccls);
	}
}
