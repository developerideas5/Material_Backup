import acm.program.ConsoleProgram;


public class CombinationsEtc extends ConsoleProgram {

	public void run() {
		listAllPermutations( "bcd" );
		//listAllSubsets( "bcd" );
		//listAllCombinations( 3, "abcde" );
	}
	
	private void listAllPermutations(String perms) {
		println( "List all permutations of " + perms );
		recPermute( "", perms );
	}

	private void recPermute(String soFar, String rest) {
	     if (rest.equals( "" )) {
	         println( soFar );
	     } else {
	         for (int i = 0; i < rest.length(); i++) {
	              String next = soFar + rest.charAt(i);

	              String remaining = rest.substring(0, i)
	                               + rest.substring(i+1);
	              recPermute(next, remaining);
	         }
	     }
	}
}
