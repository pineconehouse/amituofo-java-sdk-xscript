package com.amituofo.xscript;

import java.util.ArrayList;
import java.util.List;

import org.jdom.Element;

import com.amituofo.common.kit.thread.Interrupter;
import com.amituofo.xscript.ex.ScriptException;

public abstract class ExecutableScript extends Script {
	private ExecutableScript[] executableScripts;
	private Interrupter scriptInterrupter = new Interrupter();

	public ExecutableScript() throws ScriptException {
	}

	public ExecutableScript(String name) {
		super(name);
	}

	public ExecutableScript(Element e, Script parent) throws ScriptException {
		super(e, parent);
	}

	protected abstract void head(Object... param) throws ScriptException;

	protected abstract ExeResult body(Object... param) throws ScriptException;

	protected abstract void foot() throws ScriptException;

	public ExeResult exec(Object... param) throws ScriptException {
		head(param);

		ExeResult result = body(param);

		foot();

		return result;
	}

	public void shutdown() {
		scriptInterrupter.setInterrupted(true);
		if (executableScripts != null) {
			for (Script script : executableScripts) {
				if (script instanceof ExecutableScript) {
					try {
						((ExecutableScript) script).shutdown();
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

	public boolean isInterrupted() {
		return scriptInterrupter.isInterrupted();
	}
	// protected abstract void stopExec() throws ScriptException;

	@Override
	protected void parseSubScript(Element e, Script parent) throws ScriptException {
		super.parseSubScript(e, parent);

		Script[] scripts = super.getSubscripts();
		if (super.getSubscripts() != null) {
			List<ExecutableScript> executableScript1 = new ArrayList<ExecutableScript>();
			for (Script script : scripts) {
				if (script instanceof ExecutableScript) {
					executableScript1.add((ExecutableScript) script);
				}
			}

			if (executableScript1.size() > 0) {
				this.executableScripts = new ExecutableScript[executableScript1.size()];
				for (int i = 0; i < executableScripts.length; i++) {
					executableScripts[i] = executableScript1.get(i);
				}
			} else {
				this.executableScripts = null;
			}
		}
	}

	// protected ExeResult execSubscripts() throws ScriptException {
	// if (executableScripts != null) {
	// for (Script script : executableScripts) {
	// if (script instanceof ExecutableScript) {
	// ExeResult es = ((ExecutableScript) script).exec();
	//
	// if (es == ExeResult.RETURN || es == ExeResult.BREAK || es == ExeResult.CONTINUE) {
	// return es;
	// }
	// }
	// }
	// }
	//
	// return ExeResult.FINISHED;
	// }

	protected ExeResult execSubscripts(Object... param) throws ScriptException {
		if (executableScripts != null) {
			for (Script script : executableScripts) {
				if (script instanceof ExecutableScript) {
					ExeResult es = ((ExecutableScript) script).exec(param);

					if (es == ExeResult.RETURN || es == ExeResult.BREAK || es == ExeResult.CONTINUE) {
						return es;
					}
				}
			}
		}

		return ExeResult.FINISHED;
	}

}
