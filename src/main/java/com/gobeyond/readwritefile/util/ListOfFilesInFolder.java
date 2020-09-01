package com.gobeyond.readwritefile.util;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class ListOfFilesInFolder {

	static String temp = "";

	private FileWriters fileW;
	private FIleReader fileR;

	List<String> response = new ArrayList<String>();

	public ListOfFilesInFolder(FileWriters fileW, FIleReader fileR) {
		this.fileW = fileW;
		this.fileR = fileR;
	}

	public void listFilesForFolder(final File folder) throws IOException {

		List<List<String>> outPut = new ArrayList<>();

		for (final File fileEntry : folder.listFiles()) {

			if (fileEntry.isDirectory()) {
				listFilesForFolder(fileEntry);
			} else {
				if (fileEntry.isFile()) {
					temp = fileEntry.getName();
					if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("txt")) {

						response = fileR.readFile(fileEntry.getAbsolutePath());
						outPut.add(response);
					}

				}

			}
		}

		// Write all response after read the file
		fileW.writeFile(outPut);
	}
}
