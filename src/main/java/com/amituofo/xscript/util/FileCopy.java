package com.amituofo.xscript.util;

/*
 * FileCopy.java	
 *
 * Copyright 2007 Cristina Roura Claver cristina.roura@gmail.com
 *
 * This file is part of LHMC.
 *
 * LHMC is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 *
 * LHMC is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import com.amituofo.common.util.StreamUtils;

//import jcifs.smb.SmbFile;
//import jcifs.smb.SmbFileInputStream;
//import jcifs.smb.SmbFileOutputStream;

/**
 * FileCopy is a threaded class that manages the copy of files from remote filesystem (SmbFile) to local filesystem (File) and vice versa.
 * Also manages to copy from remote to remote filesystem or local to local filesystem.
 * 
 * @author Cristina Roura Claver
 * @version 0.01 20 Jun 2007
 */
public class FileCopy extends Thread {

	Object srcFile;
	Object destFile;
	private COPY_TYPE copyType;

	private static enum COPY_TYPE {
		FILE_TO_FILE, FILE_TO_SMBFILE, SMBFILE_TO_FILE, SMBFILE_TO_SMBFILE;
	}

	/**
	 * Constructor that creates the input and output stream from source file and destination file.
	 * 
	 * @param srcFile
	 *            the source file.
	 * @param destFile
	 *            the destination file.
	 */
	public FileCopy(File srcFile, File destFile) {
		copyType = COPY_TYPE.FILE_TO_FILE;

		this.srcFile = srcFile;
		this.destFile = destFile;
	}

	/**
	 * Constructor that creates the input and output stream from source file and destination smbfile.
	 * 
	 * @param srcFile
	 *            the source file.
	 * @param destFile
	 *            the destination smbfile.
	 * @see SmbFile
	 */
//	public FileCopy(File srcFile, SmbFile destFile) {
//		copyType = COPY_TYPE.FILE_TO_SMBFILE;
//
//		this.srcFile = srcFile;
//		this.destFile = destFile;
//	}

	/**
	 * Constructor that creates the source and destination smbfile.
	 * 
	 * @param srcFile
	 *            the source smbfile.
	 * @param destFile
	 *            the destination smbfile.
	 * @see SmbFile
	 */
//	public FileCopy(SmbFile srcFile, SmbFile destFile) {
//		copyType = COPY_TYPE.SMBFILE_TO_SMBFILE;
//
//		this.srcFile = srcFile;
//		this.destFile = destFile;
//	}

	/**
	 * Constructor that creates the input and output stream from source smbfile and destination file.
	 * 
	 * @param srcFile
	 *            the source smbfile.
	 * @param destFile
	 *            the destination file.
	 * @see SmbFile
	 */
//	public FileCopy(SmbFile srcFile, File destFile) {
//		copyType = COPY_TYPE.SMBFILE_TO_FILE;
//
//		this.srcFile = srcFile;
//		this.destFile = destFile;
//	}

	/**
	 * Executes the copy of the files.
	 */
	public void run() {
		try {
			copy();
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}

	public void copy() throws IOException {
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			switch (copyType) {
			case FILE_TO_FILE:
				inStream = new FileInputStream((File) srcFile);
				outStream = new FileOutputStream((File) destFile);
				copyStreams(inStream, outStream);
				break;

//			case FILE_TO_SMBFILE:
//				inStream = new FileInputStream((File) srcFile);
//				outStream = new SmbFileOutputStream((SmbFile) destFile);
//				copyStreams(inStream, outStream);
//				break;
//
//			case SMBFILE_TO_FILE:
//				inStream = new SmbFileInputStream((SmbFile) srcFile);
//				outStream = new FileOutputStream((File) destFile);
//				copyStreams(inStream, outStream);
//				break;
//
//			case SMBFILE_TO_SMBFILE:
//				/* if the copy is beetween smbfiles, we can use the method from smbfile copyTo */
//				((SmbFile) srcFile).copyTo((SmbFile) destFile);
//				break;

			}
		} finally {
			try {
				if (inStream != null) {
					inStream.close();
					inStream = null;
				}
			} catch (Throwable e) {
			}

			try {
				if (outStream != null) {
					outStream.flush();
					outStream.close();
					outStream = null;
				}
			} catch (Throwable e) {
			}
		}
	}

	/**
	 * Makes the copy of an inputstream to an outputstream.
	 * 
	 * @param in
	 *            the inputstream.
	 * @param out
	 *            the outputstream.
	 * @throws IOException
	 */
	private void copyStreams(InputStream in, OutputStream out) throws IOException {
		byte[] buffer = new byte[StreamUtils.DEFAULT_BUFFER_SIZE];
		int bytesRead;
		while ((bytesRead = in.read(buffer)) >= 0) {
			out.write(buffer, 0, bytesRead);
		}
	}

	public static void main(String[] s) throws IOException {
		FileCopy copy = new FileCopy(new File("C:\\TEMP\\_786290767_.png"), new File("\\\\10.167.38.50\\ETLTempFolder\\xx.png"));
		copy.copy();
	}
}