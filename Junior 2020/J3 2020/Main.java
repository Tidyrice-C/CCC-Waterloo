import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int topX = 0;
        int topY = 0;
        int botX = 10000;
        int botY = 10000;

        int executeTimes = input.nextInt();
        
        for (int i = 0; i < executeTimes; i++) {
            String line = input.next();
            String[] coords = line.split(",");

            int X = Integer.parseInt(coords[0]);
            int Y = Integer.parseInt(coords[1]);
            

            if (X > topX) {
                topX = X;
            } if (X < botX) {
                botX = X;
            }

            if (Y > topY) {
                topY = Y;
            } if (Y < botY) {
                botY = Y;
            }
        } 
        int fBotX = botX - 1;
        int fBotY = botY - 1;
        int fTopX = topX + 1;
        int fTopY = topY + 1;

        System.out.println(fBotX + "," + fBotY);
        System.out.println(fTopX + "," + fTopY);
    }
}