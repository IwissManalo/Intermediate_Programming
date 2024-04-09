package IntermediateProgramming;
import java.util.*;

public class Draft4
{
    static String blue = "\033[1;34m";
    static String def = "\033[0m";
    static Scanner sc = new Scanner (System.in);
    static ArrayList<String> groupOfStrings = new ArrayList<>();
    static Set<String> swappedKeys = new HashSet<>();


    public static void main (String [] args) {
        System.out.print("*Note the the program only accepts input separated by space* \nInput group of strings: ");
        String[] strings = sc.nextLine().split(" ");
        Collections.addAll(groupOfStrings, strings);

        //prints out the input
        //System.out.println(groupOfStringsMap);

        //map with string key and boolean value
        Map<String, Boolean> groupOfStringsMap = new HashMap<>();

        for (String string : Draft4.groupOfStrings) {
            groupOfStringsMap.put(string, Collections.frequency(Draft4.groupOfStrings, string) >= 2);
        }

        System.out.println(blue + "\n---Key Values---\n" + def + groupOfStringsMap);

        //for third and fourth condition --- Character Key Checker
        List<String> keysList = new ArrayList<>(groupOfStringsMap.keySet());    //stores the keys from map to arraylist
        System.out.println(keysList);

        for (int i = 0; i < keysList.size() - 1; i++) {
            String firstKey = keysList.get(i);
            String secondKey = keysList.get(i + 1);

            if (!swappedKeys.contains(firstKey) && !swappedKeys.contains(secondKey))
            {
                boolean allCharactersInOtherKeys = true;

                for (int j = 0; j < firstKey.length(); j++)
                {
                    char currentChar = firstKey.charAt(j);
                    if (secondKey.indexOf(currentChar) == -1)
                    {
                        allCharactersInOtherKeys = false;
                        break;
                    }
                }

                if (allCharactersInOtherKeys)
                {
                    // swap values of firstKey and secondKey
                    Boolean temp = groupOfStringsMap.get(firstKey);
                    groupOfStringsMap.put(firstKey, groupOfStringsMap.get(secondKey));
                    groupOfStringsMap.put(secondKey, temp);

                    // add keys to swappedKeys set to track them
                    swappedKeys.add(firstKey);
                    swappedKeys.add(secondKey);
                }
            }
        }

        System.out.println(blue + "\n---Swapped Key Values---\n" + def + groupOfStringsMap);

        for (int i = 0; i < keysList.size(); i++)
        {
            for (int j = i+1; j < keysList.size(); j++)
            {
                String key1 = keysList.get(i);
                String key2 = keysList.get(j);
                if (!swappedKeys.contains(key1) && !swappedKeys.contains(key2))
                {
                    boolean shouldSwap = true;
                    for (int k = 0; k < key1.length(); k++)
                    {
                        if (!key2.contains(String.valueOf(key1.charAt(k))))
                        {
                            shouldSwap = false;
                            break;
                        }
                    }
                    if (shouldSwap)
                    {
                        String temp = String.valueOf(groupOfStringsMap.get(key1));
                        groupOfStringsMap.put(key1, groupOfStringsMap.get(key2));
                        groupOfStringsMap.put(key2, Boolean.valueOf(temp));
                        swappedKeys.add(key1);
                        swappedKeys.add(key2);
                    }
                }
            }
        }

        System.out.println(blue + "\n---Final Result---\n" + def + groupOfStringsMap);

        for (String key : groupOfStringsMap.keySet())
        {
            int fibNum1 = 0;
            int fibNum2 = 1;
            int fibNum3 = 1;
            int length = key.length();
            for (int i = 2; i < length; i++)
            {
                fibNum1 = fibNum2;
                fibNum2 = fibNum3;
                fibNum3 = fibNum1 + fibNum2;
            }
            int highestFibonacci = fibNum3;
            System.out.println("Key: " + key + ", Highest Fibonacci: " + highestFibonacci);
        }

        //last conditions
        boolean shouldRerun = false;
        for (boolean value : groupOfStringsMap.values())
        {
            if (value)
            {
                shouldRerun = true;
                break;
            }
        }
        if (shouldRerun)
        {
            System.out.println("Rerunning the program...\n");
            main(args);
        }
        else
        {
            System.out.print("\nExiting the program in...");
            for (int i = 10; i >= 1; i--)
            {
                System.out.print(i + " ");
                try
                {Thread.sleep(1000);}
                catch (InterruptedException e)
                {   e.printStackTrace();    }
            }
            System.out.println("\n💥💥💥Program terminated💥💥💥");
        }

        System.out.println(blue + "\n⚰️ALTHEA IRISH MANALO⚰️");
    }
}
