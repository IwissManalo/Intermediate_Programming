import java.util.Scanner;

public class LabAct1 
{
	static String def = "\u001B[0m";  //default color
	static String cbg = "\033[46m"; //cyan BG
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) 
	{
		run();
	}
	static void run()
	{
		//runCount starts at 0
		int runCount = 0;
		
		while(runCount<=5)
		{
																		
            System.out.print("Input first name (should not exceed 30 characters): ");
            String fName = sc.nextLine();
            
	            if (fName.length() > 30)
	            {
 	            	System.out.println("Oh noe!☹ Please refer to the instructions");
	            	throw new IllegalArgumentException("The program only accepts less than 30 characters");   
	            }

            System.out.print("Input last name: ");
            String lName = sc.nextLine().toLowerCase();
            
	            if (!lName.matches("[a-zA-Z]+"))
	            {
 	            	System.out.println("Oh noe!☹ Please refer to the instructions");
	            	throw new IllegalArgumentException("The program doesn't accept any special characters");   
	            }

            System.out.print("Input middle name: ");
            String mName = sc.nextLine();
            
	            if (mName.contains(" "))
	            {
 	            	System.out.println("Oh noe!☹ Please refer to the instructions");
	            	throw new IllegalArgumentException("The program doesn't accept white spaces");   
	            }
            
            System.out.print("Choose a random number between 0-1000: ");
            String sNum = sc.nextLine();
            int iNum = Integer.parseInt(sNum);
            
        		 if (iNum < 0 || iNum > 1000) {
  	            	System.out.println("Oh noe!☹ Please refer to the instructions");
                    throw new IllegalArgumentException("The program doesn't accept a negative value or an out of range number");
                 }

                 if (sNum.matches("[a-zA-Z]+")) {
 	            	System.out.println("Oh noe!☹ Please refer to the instructions");
                    throw new IllegalArgumentException("The program doesn't accept any letters");
                 }
            
           //new arguments
           if (fName.length() == lName.length()) 
           {
    	   	   int[] lastN = new int[lName.length()];
	    	   	for (int i = 0; i < lName.length(); i++) 
	            {
	                char c = lName.charAt(i);
	
	                if (c >= 'a' && c <= 'z') {
	             	   lastN[i] = (c - 'a' + 1);
	                }
	            }
		       
		       if (isPalindrome(lastN))
		       {
	               int[] midN = new int[mName.length()];
	               for (int i = 0; i < mName.length(); i++) 
	               {
	                   char c = mName.charAt(i);

	                   if (c >= 'a' && c <= 'z') {
	                	   midN[i] = (c - 'a' + 1);
	                   }
	               }
	               int[][] outerArray = new int[2][];
	               outerArray[0] = lastN;
	               outerArray[1] = midN;
	
	               System.out.println("outer array = [");
	               for (int i = 0; i < outerArray.length; i++) 
	               {
	                   System.out.print("a" + (i + 1) + " = ");
	                   for (int a = 0; a < outerArray[i].length; a++) 
	                   {
	                       System.out.print(outerArray[i][a] + " ");
	                   }
	                   System.out.println(" ");

	               }
                   System.out.println("]");
                   System.out.println(cbg + "\n♥️ALTHEA IRISH MANALO♥️" + def);
                   break;
		       }
           }
           else
           {
        	   runCount++;
               System.out.println("The first name and last name doesn't have the same length"+ cbg +
            		   				"\nRerun count: " + runCount + def);
           }
		}
		
	  if (runCount == 6) 
	  {
            System.out.println("The program has exceeded the maximum rerun count.");
      }
	}
	
	private static boolean isPalindrome(int[] intArray) 
	{
	    int p = intArray.length;
	    for (int i = 0; i < p / 2; i++) 
	    {
	        if (intArray[i] != intArray[p - i - 1]) 
	        {
	        	System.out.println(cbg + "Please make the last name palidrome" + def);
	            return false;
	        }
	    }
	    return true;
	}
}
