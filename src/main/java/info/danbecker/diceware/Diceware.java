package info.danbecker.diceware;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.security.SecureRandom;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

import rx.Observable;
import rx.functions.Action1;

/**
 * RxJava-HelloWorld
 * <p>
 * Demonstrate reactive Java via simple example
 * 
 * @author <a href="mailto://dan@danbecker.info>Dan Becker</a>
 */
public class Diceware {
	
	// options
	public static boolean strictMode = false; // uses dice method, not computer shortCuts
    public static int numWords = 6;
	public static String dictionaryName = "";
	
	public static void main(String[] args) throws Exception {
		hello( args );
	}

	public static void hello(String... names) {
	    Observable.from(names).subscribe(new Action1<String>() {

	        @Override
	        public void call(String s) {
	            System.out.println("Hello " + s + "!");
	        }

	    });
	}
	
	/** Command line options for this application. */
	public static void parseGatherOptions( String [] args ) throws ParseException {
		// Parse the command line arguments
		Options options = new Options();
		options.addOption( "h", "help", false, "print the command line options." );
		options.addOption( "n", "numWords", true, "uses this many words in the pass-phrase." );
		options.addOption( "e", "specialCharEntropy", true, "uses special characters in NONE, ONE, ALL words." );
		options.addOption( "s", "strictMode", false, "avoids computer random short cuts, uses diceware dice simulation." );
		options.addOption( "d", "dictionary", true, "dictionary STD (standard), D8K (8k list), OTHER (name provided)." );
		options.addOption( "r", "dictionaryName", true, "dictionary name" );

		CommandLineParser cliParser = new DefaultParser();
		CommandLine line = cliParser.parse( options, args );
		
	    // Gather command line arguments for execution
	    if( line.hasOption( "help" ) ) {
	    	HelpFormatter formatter = new HelpFormatter();
	    	formatter.printHelp( "java -jar diceware.jar <options> info.danbecker.diceware.Diceware", options );
	    	System.exit( 0 );
	    }
	    if( line.hasOption( "numWords" ) ) {
	    	numWords = Integer.parseInt( line.getOptionValue( "numWords" ) );
	    }	  		
	    
	    if( line.hasOption( "strictMode" ) ) {
	    	strictMode = true;	
	    }	  		
//	    if( line.hasOption( "specialCharEntropy" ) ) {
//	    	specialCharEntropy = WordOption.valueOf( line.getOptionValue( "specialCharEntropy" ) );
//	    }	  		
//	    if( line.hasOption( "dictionaryName" ) ) {
//	    	dictionaryName = line.getOptionValue( "dictionaryName" );
//	    }	  		
//	    if( line.hasOption( "dictionary" ) ) {
//	    	dictionary = DictionaryOption.valueOf( line.getOptionValue( "dictionary" ) );
//	    	
//	    	switch (dictionary) {
//    			case STD: dictionaryName = DICT_STD_NAME;
//    			case D8K: dictionaryName = DICT_D8K_NAME;
//    			case OTHER: // do nothing, use provided name
//	    	}
//	    }	  		
	}
	
}
