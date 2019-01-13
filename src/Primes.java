import java.io.*;
import java.util.Scanner;

public class Primes {

    /**
     * Counts the amount of prime numbers there are between 1-10000.
     * @param fname The name of the file that the input will come from.
     * @return The number of prime numbers there are in the file, between 1-10000.
     * @throws IOException
     */
    public static int count(String fname) throws IOException{
        File infile = new File(fname);
        Scanner input = new Scanner(infile);
        int i = 0;
        while (input.hasNext()) {
            i++;
            input.next();
        }
        input.close();
        return i;
    }

    /**
     * Uses binary search to search through an array to see if a certain prime exists from 1-10000.
     * @param array An array of prime numbers.
     * @param value The value that is to be searched for.
     * @return The index of the number that was searched for. Returns -1 if not found.
     */
    public static int binarySearch(int[] array, int value) {
        int low = 0, high = array.length - 1, mid = 0;

        while(low <= high) {
            mid = (high + low) / 2;

            if (array[mid] ==  value) {
                return mid;
            }
            else if (array[mid] > value) {
                high = mid -1;
            }
            else {
                low = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String [] Args) throws IOException {
        File infile = new File("primes.txt");
        Scanner input = new Scanner(infile);
        input.useDelimiter(", ");

        Scanner userIn = new Scanner(System.in);
        String userInput = "";

        int[] primes = new int[count("primes.txt")];

        for (int i = 0; i < primes.length; i++) {
            primes[i] = input.nextInt(); //Delimiter is set to ", " so nextInt() works.
        }

        System.out.println("Welcome!");

        do {
            System.out.print("\nEnter a number from 1 to 10,000 or 'x' to exit: ");
            userInput = userIn.nextLine();
            if(userInput.equalsIgnoreCase("x"))
                break;
            else if(binarySearch(primes, Integer.parseInt(userInput)) != -1) {
                System.out.print(userInput + " is prime!\n");
            }else
                System.out.print(userInput + " is composite.\n");
        } while(!userInput.equalsIgnoreCase("x"));
        System.out.println("\nGoodbye!");
    }
}