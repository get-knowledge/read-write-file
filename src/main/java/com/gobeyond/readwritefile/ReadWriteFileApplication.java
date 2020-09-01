package com.gobeyond.readwritefile;

import java.io.File;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.gobeyond.readwritefile.util.ListOfFilesInFolder;

@SpringBootApplication
public class ReadWriteFileApplication implements CommandLineRunner {

	final Logger LOGGER = LoggerFactory.getLogger(getClass());

	public ReadWriteFileApplication(ListOfFilesInFolder listOfFilesInFolder) {
		this.listOfFilesInFolder = listOfFilesInFolder;
	}

	private ListOfFilesInFolder listOfFilesInFolder;

	public static File folder = new File("/home/dhananjay/Desktop/CollectionOfTextFiles/");

	public static void main(String[] args) {
		SpringApplication.run(ReadWriteFileApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		try {

			listOfFilesInFolder.listFilesForFolder(folder);

		} catch (Exception e) {
			LOGGER.error("IOException", e);
		}

	}

}
