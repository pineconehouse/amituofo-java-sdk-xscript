/*
 * Copyright (C) 2019 Rison Han
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amituofo.xscript;

import java.io.File;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;

import com.amituofo.common.api.Builder;
import com.amituofo.common.ex.InvalidParameterException;
import com.amituofo.xscript.ex.ScriptException;

public class ScriptBuilder implements Builder<ScriptEntry, ScriptException> {

	private Element root;

	public ScriptBuilder() {
	}
	

	public ScriptBuilder withScriptBody(Element root) {
		this.root = root;

		return this;
	}

	public ScriptBuilder withScriptFile(File scriptFile) throws ScriptException {
		Document doc = null;
		SAXBuilder builder = new SAXBuilder(false);
		try {
			doc = (Document) builder.build(scriptFile);
		} catch (Exception e) {
			throw new ScriptException(e);
		}
		this.root = doc.getRootElement();

		return this;
	}

	@Override
	public ScriptEntry bulid() throws ScriptException, InvalidParameterException {
		if (root == null) {
			throw new InvalidParameterException("Unable to locate script entry!");
		}
		
		if (root.getName().equalsIgnoreCase("script")) {
			ScriptEntry sc = new ScriptEntry(root);

			return sc;
		}

		return null;
	}

}
