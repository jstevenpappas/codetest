package com.codetest.domain;

import java.io.File;

public class PersonRecordDataSource {

	/**
	 * Domain object used to abstract user from 
	 * implementation details of source data
	 */
	private File csvFile;  // comma-separated file
	private File ssvFile;  // space-separated file
	private File psvFile;  // pipe-separated file
	
	public File getCsvFile() {
		return csvFile;
	}
	public void setCsvFile(File csvFile) {
		this.csvFile = csvFile;
	}
	public File getSsvFile() {
		return ssvFile;
	}
	public void setSsvFile(File ssvFile) {
		this.ssvFile = ssvFile;
	}
	public File getPsvFile() {
		return psvFile;
	}
	public void setPsvFile(File psvFile) {
		this.psvFile = psvFile;
	}
	
}
