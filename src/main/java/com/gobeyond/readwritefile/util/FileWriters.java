package com.gobeyond.readwritefile.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FileWriters {

	private final String FILE_NAME = "output.csv";

	public void writeFile(List<List<String>> content) {

		try {

			FileWriter csvWriter = new FileWriter(FILE_NAME);

			try {
				csvWriter.append(content.toString());
				csvWriter.append(",");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			csvWriter.flush();
			csvWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
