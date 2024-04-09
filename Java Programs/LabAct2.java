import java.util.*;

public class LabAct2 
{
	static Scanner sc = new Scanner(System.in);
	static int strength = 0;
	
	public static void main (String [] args)
	{
		String input;
		
		do 
		{
			do 
			{
				System.out.print("*Note that the program doesn't accept any whitespaces*\n" + "Input an alphanumeric value: ");
				input = sc.nextLine();
				
				if (input.contains(" "))
				System.out.print("Oh noe! Please refer to the instructions\n\n");
			}
			//loops the user's input if it contains whitespace
			while (input.contains(" "));

			//checks if strength is less than or over 100
	        if (valueStrength(input) < 100) 
	        {
		        System.out.println("Value: " + strength);

	            int length = input.length();
	            String firstHalf = input.substring(0, length / 2);
	            String secondHalf = input.substring(length / 2);
	
	            ArrayList<Character> list1 = new ArrayList<>();
	            ArrayList<Character> list2 = new ArrayList<>();
	            for (char c : firstHalf.toCharArray()) 
	            {
	                list1.add(c);
	            }
	            for (char c : secondHalf.toCharArray()) 
	            {
	                list2.add(c);
	            }
	
	            ArrayList<Character> duplicateValues = new ArrayList<>();
	            for (int i = 0; i < list1.size(); i++) 
	            {
	                for (int j = 0; j < list2.size(); j++) {
	                    if (list1.get(i).equals(list2.get(j))) 
	                    {
	                        duplicateValues.add(list1.get(i));
	                        list1.remove(i);
	                        list2.remove(j);
	                        i--;
	                        break;
	                    }
	                }
	            }
	
	            ArrayList<Character> mergedList = new ArrayList<>();
	            mergedList.addAll(list1);
	            mergedList.addAll(list2);
	
	            boolean containsNumber = false;
	            for (char c : mergedList) 
	            {
	                if (Character.isDigit(c)) 
	                {
	                    containsNumber = true;
	                    break;
	                }
	            }
	
	            if (containsNumber) 
	            {
	                System.out.println("The 1st half alphanumeric values are: " + list1);
	            } 
	            else 
	            {
	                System.out.println("The 2nd half alphanumeric values are: " + list2);
	            }
		        System.out.println("💗ALTHEA IRISH MANALO💗");

	        }
	        else 
	        	System.out.println("The value strength is over 100");
		}
		while (strength > 100);
	}
	
		//value strength calculator
	 	private static int valueStrength(String input) 
	    {
	 		//input to character array
	 		char[] c = input.toCharArray();
	 		//int strength = 0;
	 		
	 		int length = c.length;

        	if(!isEven(length))
        	{
        		length = length -2;
        	}
        	else 
        		length = length -1;
        	
        	for (int i = 0; i < length; i++) 
        	{
	            if (Character.isUpperCase(c[i]) && (Character.isLowerCase(c[i+1])))//upper + lower
	            { 
	            	strength += 5;
	            }
	            if (Character.isLowerCase(c[i]) && (Character.isUpperCase(c[i+1])))// lower + upper
	            { 
	            	strength += 4;
	            }
	            if (Character.isDigit(c[i]) && (Character.isLowerCase(c[i+1]))) //number + lower
	            {
	                strength += 2;
	            }
	            if (Character.isLowerCase(c[i]) && (Character.isDigit(c[i+1]))) //lower + number
	            {
	                strength += 1;
	            }
	            if (Character.isUpperCase(c[i]) && (Character.isDigit(c[i+1]))) //upper + number
	            {
	            	strength += 1;
	            }
	            if (Character.isDigit(c[i]) && (Character.isUpperCase(c[i+1]))) //number + upper
	            {
	            	strength += 2;
	            }
	            if (Character.isUpperCase(c[i]) && (Character.isUpperCase(c[i+1]))) //upper + upper
	            {
	            	strength += 3;
	            }
	            if (Character.isLowerCase(c[i]) && (Character.isLowerCase(c[i+1]))) //lower + lower
	            {
	            	strength += 3;
	            }
	            
        	}
        	//strength counter
	        return strength;
	    }
	 	
	 	static boolean isEven(int length)
	 	{
	 		return length % 2 == 0;
	 	}	 
}
