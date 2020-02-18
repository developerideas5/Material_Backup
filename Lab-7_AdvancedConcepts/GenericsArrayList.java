import java.util.ArrayList;
import java.util.Iterator;

/**
 * A simple example demonstrating generics. 
 * 
 * @author RPL <>[]{}
 */
public class GenericsArrayList {

	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<String>();
		names.add("lisa");
		names.add("bart");
		names.add("homer");		
		//names.add( 5 );		// compiler gives error, wrong type
		
		for ( String name : names ) {
			System.out.println( name );
		}
	}
}
