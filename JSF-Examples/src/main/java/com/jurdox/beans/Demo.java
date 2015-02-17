package com.jurdox.beans;

import java.io.IOException;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

public class Demo {

	public void downloadFile() throws IOException {
		String content = "obsah suboru";
		FacesContext fc = FacesContext.getCurrentInstance();
		ExternalContext ec = fc.getExternalContext();

		ec.responseReset();
		ec.setResponseContentType("application/zip");
		ec.setResponseHeader("Content-Disposition", "attachment; filename=file.zip");
		OutputStream output = ec.getResponseOutputStream();
		ZipOutputStream zos = new ZipOutputStream(output);
		ZipEntry entry = new ZipEntry("file.csv");

		zos.putNextEntry(entry);
		zos.write(content.getBytes());
		zos.closeEntry();
		zos.close();		
		
		fc.responseComplete();
	}

	public void onSomeEvent(ActionEvent event) {
		try {
			downloadFile();
		} catch (Exception e) {
		}
	}

}