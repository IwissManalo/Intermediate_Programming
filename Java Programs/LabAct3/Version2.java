package IntermediateProgramming;
import java.util.*;

public class LabAct3
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Integer> sigSet1 = new ArrayList<Integer>();
    static ArrayList<Integer> sigSet2 = new ArrayList<Integer>();
    public static void main(String[] args)
    {
        ArrayList<Integer> integers = new ArrayList<>(16);

        while (integers.size() < 16)
        {
            System.out.print("Enter " + integers.size() + " value: ");
            int input = sc.nextInt();
            integers.add(input);
        }

        System.out.println("\033[1;34m" + "\nUser's Series of Numbers:" + "\033[0m");
        System.out.print("[");

        for (int value : integers)
        {
            System.out.print(value + ", ");
        }
        System.out.println("]");

        //Separate lists
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();

        //Dividers
        for (int i = 0; i < integers.size() / 2; i++)
        {   one.add(integers.get(i));   }
        for (int i = integers.size() / 2; i < integers.size(); i++)
        {   two.add(integers.get(i));   }

        //List to Array
        Integer[] set1 = one.toArray(new Integer[0]);
        Integer[] set2 = two.toArray(new Integer[0]);
        significanceDetector(set1, set2);

        //Saves all sig digits to a new collection
        ArrayList<Integer> newCollection1 = new ArrayList<>();
        ArrayList<Integer> newCollection2 = new ArrayList<>();
        for (Integer num : set1)
        {
            String numStr = String.valueOf(num);
            String strippedNumStr = numStr.replaceAll("^0+|0+$", "");
            int numSignificantDigits = strippedNumStr.length();
            if (numSignificantDigits > 0 && !newCollection1.contains(num))
            {   newCollection1.add(num);    }
        }

        for (Integer num : set2)
        {
            String numStr = String.valueOf(num);
            String strippedNumStr = numStr.replaceAll("^0+|0+$", "");
            int numSignificantDigits = strippedNumStr.length();
            if (numSignificantDigits > 0 && !newCollection2.contains(num))
            {   newCollection2.add(num);    }
        }

        System.out.println("\033[1;34m" + "\nIntegers with significant digits in the first half of the list: " + sigSet1 + "\033[0m");
        System.out.print(newCollection1 + " ");

        System.out.println("\033[1;34m" + "\nIntegers with significant digits in the second half of the list: " + sigSet2 + "\033[0m");
        System.out.print(newCollection2 + " ");

        //Intersecting Detection
        boolean isIntersecting = false;
        System.out.print("\033[1;34m" + "\nIntersecting Digits: ");

        Set<Integer> intersectingDigits = new HashSet<>();
        for (int num : sigSet1)
        {
            if (sigSet2.contains(num))
            {
                intersectingDigits.add(num);
                isIntersecting = true;
            }
        }

        System.out.print(intersectingDigits + "\033[0m");

        //TRUE
        if (isIntersecting)
        {
            System.out.print("\033[1;34m" + "\n\nEntering Intersecting Conditions..." + "\033[0m");
            Intersect();
        }
        else
        {
            System.out.print("\033[1;34m" + "\n\nEntering Non-Intersecting Conditions..." + "\033[0m");
            notIntersect();
        }

        System.out.print("\033[1;34m" + "\n\n🏋️‍♀️ALTHEA IRISH MANALO🏋️‍♀️" + "\033[0m");
    }

    static void significanceDetector(Integer[] set1, Integer[] set2)
    {
        // Print out the integers in the first half of the list with significant digits
        System.out.println("\033[1;34m" + "\nFirst half of the list with significant digits:" + "\033[0m");
        for (int num : set1)
        {
            String numStr = String.valueOf(num);
            String strippedNumStr = numStr.replaceAll("^0+|0+$", "");
            int sigDigits = strippedNumStr.length();
            if (sigDigits > 0)
            {
                System.out.println(num + " has " + sigDigits + " significant digit(s)");
                sigSet1.add(sigDigits);
            }
        }
        System.out.println("\033[1;34m" + "\nSecond half of the list with significant digits:" + "\033[0m");
        for (int num : set2)
        {
            String numStr = String.valueOf(num);
            String strippedNumStr = numStr.replaceAll("^0+|0+$", "");
            int sigDigits = strippedNumStr.length();
            {
                System.out.println(num + " has " + sigDigits + " significant digit(s)");
                sigSet2.add(sigDigits);
            }
        }


    }
    static void Intersect()
    {
        //My reversed name
        String reversedName = "olanamhsiriaehtla";
        int [] adjacent = new int[reversedName.length()];
        System.out.println("\nMy reversed name: " + "olanaM hsirI eahtlA" + '\n');

        for (int i = 0; i < reversedName.length(); i++)
        {
            char c = reversedName.charAt(i);
            int placeNumber = (int) c - 96;
            adjacent[i] = placeNumber;
            System.out.print(adjacent[i] + ", ");
        }

        //Adjacent Checker
        int sameValue = 0;
        for (int i = 0; i < adjacent.length - 1; i++)
        {
            if (adjacent[i] == adjacent[i+1])
            {
                sameValue++;
            }
        }
        System.out.println("\033[1;34m" + "\nNumber of adjacent elements of the same value: " + sameValue + "\033[0m");
    }
    static void notIntersect()
    {
        //My full name
        String fullName = "altheairishmanalo";
        int [] values = new int[fullName.length()];
        System.out.println("\nMy full name: " + "Althea Irish Manalo" + "\033[1;34m" + "\n\nAlphabetical Placement" + "\033[0m");

        for (int i = 0; i < fullName.length(); i++)
        {
            char c = fullName.charAt(i);
            int placeNumber = (int) c - 96;
            values[i] = placeNumber;
            System.out.print(values[i] + ", ");
        }
        System.out.println("\033[1;34m" + "\n\nBinary values:" + "\033[0m");
        //Binary Values
        for (int value : values)
        {
            System.out.print(Integer.toBinaryString(value) + ' ');
        }

        //Octal Values
        System.out.println("\033[1;34m" + "\nOctal values:" + "\033[0m");
        for (int value : values)
        {
            System.out.print(Integer.toOctalString(value) + ' ');
        }

        //Hexadecimal Values
        System.out.println("\033[1;34m" + "\nHexadecimal values:" + "\033[0m");
        for (int value : values)
        {
            System.out.print(Integer.toHexString(value) + ' ');
        }
    }
}