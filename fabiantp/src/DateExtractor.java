import java.io.File;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * Reference implementation for the class "Web Search - Information Extraction"
 * at Telecom ParisTech, Paris, France in Spring 2011
 *
 * @author Fabian M. Suchanek
 *
 * Extracts the first date from a page.
 */

public class DateExtractor extends Extractor {
	
	/** Extracts the first date from a page*/
	@Override
	public Triple extract(Page page) {
		
		 final  String DATE_PATTERN ="([A-Z][a-z]+) ([1-9]|[12][0-9]|3[01]), ([0-9][0-9][0-9][0-9])";
		
		 String a="";
		 String b="";
		 String c="";
		 
		 Triple triple=new Triple(a, b , c);
		 triple.subject=page.title;
		
		 triple.predicate="hasDate";
		Pattern pattern=Pattern.compile(DATE_PATTERN);
		Matcher matcher=pattern.matcher(page.content);
		while(matcher.find()) {
			//triple.subject=page.title;
			//triple.predicate="hasDate";
			triple.object=matcher.group(); 
			return triple;
			//holds the N-th group of the match
		  // matcher.group() holds the entire match
		}
		
		
		
		
	    return null;
	}
	
	public static void main(String[] args) throws IOException {
	
			  for(Triple triple : new DateExtractor().run(new File("text"))) { 
			    System.out.println(triple); 
			  } 
			  // For example: new DateExtractor().run(new File(args[0])));
			
	}
}














