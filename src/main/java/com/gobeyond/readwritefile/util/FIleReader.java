package com.gobeyond.readwritefile.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FIleReader {

	public List<String> readFile(String fileName) {

		Path path = Paths.get(fileName);
		List<String> outPut = new ArrayList<String>();

		try {
			List<String> list = Files.readAllLines(path);
			list.forEach(line -> {

				String[] str = line.split(",");

				Double price = 0.0;
				if (str[2].length() > 0)
					price = Double.parseDouble(str[2]);

				if (price > 5000.00) {

					outPut.add(line);
				}
			}

			);
		} catch (IOException e) {

			e.printStackTrace();

		}
		return outPut;
	}

}
