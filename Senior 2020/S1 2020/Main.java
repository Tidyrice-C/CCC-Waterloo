import java.io.*;
import java.util.*;

public class Main {

    static int prevTime = 0;
    static int prevDistance = 0;
    
    static HashMap<Integer, Integer> timeAndDistance = new HashMap<Integer, Integer>();

    static ArrayList<Integer> allTimes = new ArrayList<Integer>();

    static float topSpeed = 0;

    //FUNCTION
    static void calcSpeed(int time, int distance) {
        int deltaTime = time - prevTime;
        int deltaDistance = Math.abs(distance - prevDistance);

        float speed = (float)deltaDistance/deltaTime;
        if (speed > topSpeed)
        topSpeed = speed;
    }

    public static void main(String[] args) throws IOException {

        Scanner input = new Scanner(System.in);
        int executeTimes = input.nextInt();

        for (int i= executeTimes; i > 0; i--) {
            int time = input.nextInt();
            int distance = input.nextInt();

            //PUTS VALUES IN ARRAYLIST
            allTimes.add(time);
            //PUTS VALUES IN HASHMAP
            timeAndDistance.put(time, distance);
        }

        Collections.sort(allTimes);

        for (int i = 0; i < allTimes.size(); i++) {

            int distance = timeAndDistance.get(allTimes.get(i));

            if (i != 0) {
                calcSpeed(allTimes.get(i) , distance);
            }

                prevTime = allTimes.get(i);
                prevDistance = distance;
                



        }

        //float topSpeed = Collections.max(allSpeeds);

        System.out.println(topSpeed);
        System.exit(1);
    }
}
