package com.amituofo.xscript.keyworld.fs;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom.Attribute;
import org.jdom.Element;

import com.amituofo.common.util.FileUtils;
import com.amituofo.xscript.ExeResult;
import com.amituofo.xscript.ReturnableScript;
import com.amituofo.xscript.Script;
import com.amituofo.xscript.ex.ScriptException;
import com.amituofo.xscript.util.FileCopy;

public class Copy extends ReturnableScript<Boolean> {
	protected String sourcePath;
	protected String targetPath;
	private String subfolderStr = "true";

	public Copy(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	@Override
	protected ExeResult body(Object... param) throws ScriptException {
		File source = new File(replaceReferenceVarString(sourcePath));
		File target = new File(replaceReferenceVarString(targetPath));
		Boolean subfolder = Boolean.valueOf(replaceReferenceVarString(subfolderStr));

		if (source.isFile()) {
			copyFromFile(source, target);

			this.setResult(true);
		} else if (source.isDirectory()) {
			copyFromDir(source, target, "*", subfolder);

			this.setResult(true);
		} else if (source.getName().contains("*")) {
			File parSrc = source.getParentFile();
			if (parSrc.isDirectory()) {
				copyFromDir(parSrc, target, source.getName(), subfolder);
			}

			this.setResult(true);
		} else if (!source.exists()) {
			// throw new ScriptException("Source folder " + source + " does not exists");
			this.setResult(false);
		}

		return ExeResult.FINISHED;
	}

	public static void copyFromFile(File source, File target) throws ScriptException {
		if (target.isFile()) {
		} else if (target.isDirectory()) {
			target = new File(target.getPath() + File.separator + source.getName());
		}

		try {
			new FileCopy(source, target).copy();
		} catch (IOException e) {
			throw new ScriptException(e);
		}
	}

	public static void copyFromDir(File source, File target, String pattern, boolean subfolder) throws ScriptException {
		List<File> files = FileUtils.findFiles(source.getPath(), pattern, subfolder);
		if (files.size() > 0) {
			if (target.isFile()) {
				target = target.getParentFile();
			} else if (target.isDirectory()) {
			}

			int start = source.getPath().length() + File.separator.length();
			String sourceFolder = source.getName();

			for (File file : files) {
				try {
					File tarFile = new File(target.getPath() + File.separator + sourceFolder + File.separator + file.getPath().substring(start));
					if (!tarFile.getParentFile().exists()) {
						tarFile.getParentFile().mkdirs();
					}

					if (!tarFile.isDirectory()) {
						new FileCopy(file, tarFile).copy();
					}
				} catch (IOException e) {
					throw new ScriptException(e);
				}
			}
		}
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
//		Attribute attr = e.getAttribute("source");
//		if (attr == null) {
//			throw new ScriptException("Source attribute not found!");
//		}
//
//		sourcePath = attr.getValue();
//
//		attr = e.getAttribute("target");
//		if (attr == null) {
//			throw new ScriptException("Target attribute not found!");
//		}
//
//		targetPath = attr.getValue();
//
//		attr = e.getAttribute("subfolder");
//		if (attr != null) {
//			subfolderStr = attr.getValue().trim();
//			if (subfolderStr.length() == 0) {
//				subfolderStr = "true";
//			}
//		}
	}

	@Override
	protected void initScript(Element e, Script parent) throws ScriptException {
		// TODO Auto-generated method stub

	}

}
