import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> infectedByDay = new ArrayList<Integer>();
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int target = Integer.parseInt(input.nextLine());
        int infected = Integer.parseInt(input.nextLine());
        int rFactor = Integer.parseInt(input.nextLine());

        int totalInfected = 0;
        int index = 0;

        while (totalInfected <= target) {
            infectedByDay.add(infected);
            infected = infected*rFactor;
            totalInfected = totalInfected + infectedByDay.get(index);
            index ++;
        }
        System.out.println(infectedByDay.size()-1);
    }
}