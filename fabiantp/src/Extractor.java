import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Fabian M. Suchanek
 * 
 * Abstract super class for all Wikipedia extractors
 */

public abstract class Extractor {

	/** Returns a fact (triple) found in a page.
	 *  @param A wikipedia page.
	 *  @return A triple <subject, predicate, object> or null if no information
	 *  could be extracted.
	 **/
	public abstract Triple extract(Page page);
	
	public List<Triple> run(File wikipedia) throws IOException {
		List<Triple> triples = new ArrayList<>();
		try(Parser pages = new Parser(wikipedia)) {
			while(pages.hasNext()) {
				Triple triple = extract(pages.next());
				if (triple != null) {
					triples.add(triple);
				}
			}
		}
		return triples;
	}
}
