package com.gobeyond.readwritefile.util;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

@Component
public class FileWriters {

	private final String FILE_NAME = "output.csv";

	public void writeFile(List<List<String>> content) {

		try {

			FileWriter csvWriter = new FileWriter(FILE_NAME);

			content.stream().forEach(str -> {

				try {
					csvWriter.append(str.stream().map(Object::toString).collect(Collectors.joining(",")));
					csvWriter.append(",");
					csvWriter.append("\n");
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			});

			csvWriter.flush();
			csvWriter.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
