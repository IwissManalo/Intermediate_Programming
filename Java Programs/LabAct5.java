package LabAct5;
import java.util.*;

public class LabAct5 extends Thread
{
    static String blue = "\033[1;34m";
    static String def = "\033[0m";
    static Scanner sc = new Scanner(System.in);
    static int favoriteNumber, leastFavoriteNumber;
    static String fullAddress;

    public static void main (String[] args)
    {
        System.out.print(blue + "Enter your favorite number: " + def);
        favoriteNumber = sc.nextInt();

        System.out.print(blue + "Enter your least favorite number: " + def);
        leastFavoriteNumber = sc.nextInt();

        System.out.print(blue + "Enter your full address: " + def);
        sc.nextLine();
        fullAddress = sc.nextLine();

        ThreadOne firstThread = new ThreadOne(favoriteNumber, leastFavoriteNumber);
        firstThread.start();

        ThreadTwo secondThread = new ThreadTwo(leastFavoriteNumber);
        secondThread.start();

        ThreadThree thirdThread = new ThreadThree(fullAddress);
        thirdThread.start();
    }

}

package LabAct5;

public class ThreadOne extends Thread
{
    private final int favoriteNumber;
    private final int leastFavoriteNumber;

    public ThreadOne(int favoriteNumber, int leastFavoriteNumber)
    {
        this.favoriteNumber = favoriteNumber;
        this.leastFavoriteNumber = leastFavoriteNumber;
    }

    @Override
    public void run()
    {
        int numDigits = String.valueOf(favoriteNumber).length(); //number of digits

        int sum = 0;
        int a = 0, b = 1;
        for (int i = 0; i < numDigits; i++) //fibonacci of digits
        {
            sum += a;
            int next = a + b;
            a = b;
            b = next;
        }
        //System.out.println("Fibonacci of Digits: " + b);

        int factorial = 1;
        for (int i = 2; i <= sum; i++) //factorial of sum
        {   factorial *= i; }
       //System.out.println("Sum of Factorial: " + factorial);

        int result;
        String stats;

        if (factorial % 2 == 0)
        {
            stats = "even"; result = favoriteNumber % factorial;
        } //even
        else
        {
            stats = "odd"; result = favoriteNumber * leastFavoriteNumber;
        } //odd

        System.out.println("The factorial is " + stats + ", Result: "+ result);
    }
}
package LabAct5;

public class ThreadTwo extends Thread
{
    private final int leastFavoriteNumber;
    public ThreadTwo(int leastFavoriteNumber)
    {   this.leastFavoriteNumber = leastFavoriteNumber; }

    @Override
    public void run()
    {
        String romanNumbers = convertToRomanNumbers(leastFavoriteNumber);
        String romanNumbersWithSpaces = romanNumbers.replaceAll("", " ").trim();
        System.out.println("Result of thread 2: " + romanNumbersWithSpaces);
    }

    private String convertToRomanNumbers(int num)
    {
        int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
        String[] numerals = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };

        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0)
        {
            while (num >= values[i])
            {
                sb.append(numerals[i]);
                num -= values[i];
            }
            i++;
        }
        return sb.toString();
    }
}
package LabAct5;
import java.util.*;
public class ThreadThree extends Thread {
private final String fullAddress;

    public ThreadThree(String fullAddress) {
        this.fullAddress = fullAddress;
    }

    @Override
    public void run() {
        // Step 1: Remove whitespaces and reverse
        String reversed = new StringBuilder(fullAddress.replaceAll("\\s", "")).reverse().toString();

        // Step 2: Remove repeating values except for the first occurrence and all numbers
        Set<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for (char c : reversed.toCharArray()) {
            if (Character.isLetter(c)) {
                char lowercase = Character.toLowerCase(c);
                if (!set.contains(lowercase)) {
                    set.add(lowercase);
                    sb.append(c);
                }
            } else if (Character.isDigit(c)) {
                sb.append(c);
            }
        }
        String filtered = sb.toString();

        // Step 3: Append the remaining letters to the alphabet
        String alphabet = "abcdefghijklmnopqrstuvwxyz";
        StringBuilder matrixBuilder = new StringBuilder(alphabet);
        for (char c : filtered.toCharArray()) {
            if (!Character.isDigit(c) && !matrixBuilder.toString().contains(String.valueOf(c))) {
                matrixBuilder.append(c);
            }
        }
        String matrixString = matrixBuilder.toString();
        char[][] matrix = new char[2][matrixString.length()];
        for (int i = 0; i < matrixString.length(); i++) {
            matrix[0][i] = alphabet.charAt(i);
            matrix[1][i] = matrixString.charAt(i);
        }

        // Step 5: Convert and display original address using matrix
        StringBuilder originalBuilder = new StringBuilder();
        for (char c : filtered.toCharArray()) {
            if (Character.isDigit(c)) {
                originalBuilder.append(c);
            } else {
                int index = matrixString.indexOf(c);
                originalBuilder.append(matrix[0][index]);
            }
        }
        String original = originalBuilder.reverse().toString();
        System.out.println("Original address: " + original);

        System.out.println("\033[1;34m" + "\n💀ALTHEA IRISH MANALO💀");
    }
}
