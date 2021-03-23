package com.amituofo.xscript.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.StringWriter;

public class Exec {
	public static int exec(String cmd, boolean waitfor) throws IOException, InterruptedException {
		Process process = Runtime.getRuntime().exec(cmd);
		StreamReader reader = new StreamReader(process.getInputStream());
		reader.start();
		if (waitfor) {
			process.waitFor();
			return process.exitValue();
		} else {
			return 0;
		}
	}

	static class StreamReader extends Thread {
		private InputStream is;
		private StringWriter sw = new StringWriter();

		public StreamReader(InputStream is) {
			this.is = is;
		}

		public void run() {
			try {
				int c;
				while ((c = is.read()) != -1)
					sw.write(c);
			} catch (IOException e) {
			}
		}

		public String getResult() {
			return sw.toString();
		}
	}
}
