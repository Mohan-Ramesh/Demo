package jSonHandling;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Runner {
	public static void main(String[] args) throws IOException, ParseException {
		/*
		
		JSONTOXLFILE object = new JSONTOXLFILE();
		object.writer();
		object.xlWriter();*/
		
		
		
		Jsonexample oJsonexample = new Jsonexample();
		oJsonexample.writeJson();
	}

}
