package com.gobeyond.readwritefile.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FileWriter {

	private final String FILE_NAME = "output.txt";

	public void writeFile(List<String> content) {

		Path path = Paths.get(FILE_NAME);

		try {
			Files.write(path, content, StandardOpenOption.CREATE);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
