import java.io.*;
import java.util.*;

public class Main {
    public static void main(String args[]) throws IOException {
        Scanner input = new Scanner(System.in);

        int small = input.nextInt();
        int medium = input.nextInt();
        int large = input.nextInt();

        int happiness = small + 2 * medium + 3 * large;

        if (happiness >= 10) {
            System.out.println("happy");
        } else {
            System.out.println("sad");
        }

        System.exit(1);

    }
}