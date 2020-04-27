package com.vs.jackson.json.demo;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Driver {

	public static void main(String[] args) {
		try {
			// Create the object mapper.
			ObjectMapper mapper = new ObjectMapper();

			// Read JSON file and map/convert to Java POJO:
			// data/sample-lite.json
			Student student = mapper.readValue(new File("data/sample-full.json"), Student.class);

			// Print the Student.
			System.out.println(student);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
