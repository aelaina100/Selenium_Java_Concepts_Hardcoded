package SeleniumExamplesPkg.Selenium_Concepts_Hardcoded;
import org.testng.annotations.Test;

public class Added17FormattingNamingConventionsDebugging {
	
	@Test
	public void  Added17FormattingNamingConventionsDebuggingTest()
	
	//The areas of    1-Formatting    2-Naming conventions  3-Debugging
	{
		
	// 1- Formatting:=========>    CNTRL + SHIFT + F  simultaneously.
		
		
   // 2-  CamelCase naming Convention in defining Class, Method,Variable, & Package names:=======>
		 
		  // A- Classes and Interfaces: Their names should be nouns
		      // Try to keep your class names simple and descriptive. Use whole words-avoid acronyms and abbreviations, 
		     // (unless the abbreviation is much more widely used than the long form, such as URL or HTML).
		    // Start with an uppercase letter, and capitalize the first letter of each subsequent concatenated word. For example:
		          /*
		public class MyClass {
		    // class body
		}

		public interface MyInterface {
		    // interface body
		}
         */
		
		 // B- Methods: Start with a lowercase letter, and capitalize the first letter of each subsequent concatenated word. For example:
		  /*
		public void myMethod() {
		    // method body
		}

		public int calculateTotalAmount() {
		    // method body
		} */

		
		//  C- Variables: Start with a lowercase letter, and capitalize the first letter of each subsequent concatenated word. For example:
		/*
		 * int myVariable;
           String firstName;

		 */
		
		// D- Constants: Use all uppercase letters with words separated by underscores (_). For example:
		
		  /* public static final int MAX_VALUE = 100;
             public static final String DEFAULT_NAME = "John";  */

		// E- Packages: Use lowercase letters for package names. For example:
           
		   // package com.example.myproject;

		
		
 //3- Debugging the code: means, executing step by step and observing the results.l
		/*
		 * Start fresh by: Window ==> Perspective ==> Reset perpective.
		 * Especially when encountering the issue of being unable to view the debug section.
		 * 
		 * Set Toggle break point = To debug/ view my execution step by step FROM this point
		 * and ONWARDS.
		 * Then, Run ==> Debug As.
		 * Script will stop executing AT the toggle break point.
		 * 
		 * Now, clicking on 'Step Over' will execute ONLY the line at the toggle info, showing
		 * all of it's debug info in debug section. Execution stops here.
		 * 
		 * This is to diagnose on which line the script is failing & why it's failing.
		 * 
		 * Clicking again on 'Step over' will execute ONLY the next line below the toggle break 
		 * point, showing in debug window showing all of it's debug info in debug section. Execution 
		 * stops here.
		 * 
		 * and so on & on
		 * 
		 * Also, if you know the line at which the script fails, without being able to know why,
		 * then debugging with the 'Step over' conveys to you the root cause of the problem.
		 * 
		 * Now, let's say that debugging helped me understand the error & correct my code. Then,
		 * click on Run ==>'Resume' in order to exist the debug mode & execute in normal fashion
		 * all of the rest of the method/test case. Unless, you have a 2nd toggle break point
		 * at which the normal fashion execution will stop there where  Run ==>'Resume' will
		 * exist the debug mode & execute in normal fashion ll of the rest of the method/test case
		 * unless etc. etc.
		 * 
		 * Now, 'Step Into' is to step inside a method.
		 */
		
	}
	

}
