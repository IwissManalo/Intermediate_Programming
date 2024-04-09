package Testers;
import java.util.ArrayList;
//non-user input by ALTHEA IRISH MANALO
public class TestingBlock03
{
    public static void main(String[] args)
    {
        int[] numbers = {6, 2, 5, 7, 0, 0, 8, 9, 4, 1, 3, 1, 0, 0, 0, 0};
        ArrayList<Integer> one = new ArrayList<>();
        ArrayList<Integer> two = new ArrayList<>();

        for (int i = 0; i < numbers.length / 2; i++) one.add(numbers[i]);
        for (int i = numbers.length / 2; i < numbers.length; i++) two.add(numbers[i]);

        System.out.println(
                "First half:" + one +
                "\nSecond half:" + two +
                "\033[1;34m" + "\n\nSince these are preset lists, the significant digits are also been set" + "\033[0m" +
                "\n\nSignificant Digits in 1st Half: 8" +
                "\nSignificant Digits in 2nd Half: 4\n");

        //Saves all sig digits to a new collection
        ArrayList<Integer> newCollection1 = new ArrayList<>();
        ArrayList<Integer> newCollection2 = new ArrayList<>();

        newCol(newCollection1, newCollection2);
        System.out.println( "\033[1;34m" + "New Collections 1 and 2: \n" + newCollection1 + "\n" + newCollection2 + "\033[0m");

       //Intersecting Detection
        boolean isIntersecting = false;
        System.out.print("\033[1;34m" + "\nIntersecting Digits: [");
        for (int num : newCollection1)
        {
            if (newCollection2.contains(num))
            {
                System.out.print(num + ",");
                isIntersecting = true;
            }
        }
        System.out.print("]" + "\033[0m");

        if (isIntersecting) //TRUE
        {
            System.out.print("\033[1;34m" + "Entering Intersecting Conditions..." + "\033[0m");
            Intersect();
        }
        else //notIntersecting FALSE
            System.out.print("\033[1;34m" + "\nEntering Non-Intersecting Conditions..." + "\033[0m");
        notIntersect();

    }

    static void newCol (ArrayList<Integer> newCollection1, ArrayList<Integer> newCollection2)
    {
        newCollection1.add(6); newCollection1.add(2); newCollection1.add(5); newCollection1.add(7); newCollection1.add(0); newCollection1.add(0);  newCollection1.add(8); newCollection1.add(9);
        newCollection2.add(4); newCollection2.add(1); newCollection2.add(3); newCollection2.add(1);
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
