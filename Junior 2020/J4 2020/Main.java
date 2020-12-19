import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<String> toShift = new ArrayList<String>();

    static boolean containsCyclicShift = false;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        String baseText = input.next();
        String[] shiftTarget = input.next().split("");

        for (int i = 0; i < shiftTarget.length; i++) {
            toShift.add(shiftTarget[i]);
        }

        for (int i = 0; i < shiftTarget.length; i++) {
            String firstLetter = toShift.get(0);
            toShift.add(firstLetter);
            toShift.remove(0);
            String arrayString = toShift.toString();
            arrayString = arrayString.substring(1, arrayString.length() - 1).replaceAll(",","").replaceAll(" ","");
            
            if (baseText.contains(arrayString)) {
                containsCyclicShift = true;
                break;
            }
        }

        if (containsCyclicShift) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }

    }
}