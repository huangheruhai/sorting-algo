import java.io.File;
import java.io.IOException;
import java.util.List;

import junit.framework.TestCase;

public class BaseTests extends TestCase {
	
	protected static List<Triple> typeTriples;
	
	protected static List<Triple> dateTriples;
	
	static {
		try {
			dateTriples = new DateExtractor().run(new File("text"));
			typeTriples = new TypeExtractor().run(new File("text"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}