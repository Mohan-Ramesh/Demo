package exe18522;

import java.io.IOException;

import org.json.simple.parser.ParseException;

public class Runner {

	public static void main(String[] args) throws IOException, ParseException {
		TopperFinder oTopperFinder = new TopperFinder();
		oTopperFinder.jsonWriter();
		oTopperFinder.jsonReader();

}
}