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

		System.out.println(path);
		List<String> list = new ArrayList<>();

		try {
			list = Files.readAllLines(path);

			System.out.println(list.toString());

		} catch (IOException e) {

			e.printStackTrace();

		}
		return list;
	}

}
