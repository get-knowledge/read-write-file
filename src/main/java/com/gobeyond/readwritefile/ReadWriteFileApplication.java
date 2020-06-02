package com.gobeyond.readwritefile;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gobeyond.readwritefile.util.FIleReader;
import com.gobeyond.readwritefile.util.FileWriter;

@SpringBootApplication
public class ReadWriteFileApplication implements CommandLineRunner {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public ReadWriteFileApplication(FileWriter fileW, FIleReader fileR) {
		this.fileW = fileW;
		this.fileR = fileR;
	}

	private FileWriter fileW;
	private FIleReader fileR;

	public static void main(String[] args) {
		SpringApplication.run(ReadWriteFileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		String fileName = "input.txt";

		List<String> response = new ArrayList<String>();

		try {

			response = fileR.readFile(fileName);
			fileW.writeFile(response);

		} catch (Exception e) {
			LOGGER.error("IOException", e);
		}

	}

}
