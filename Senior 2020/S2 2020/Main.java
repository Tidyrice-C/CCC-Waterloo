import java.util.*;
import java.io.*;

public class Main {

    static ArrayList<Integer> coordinateProducts = new ArrayList<Integer>();
    static ArrayList<Integer> jumpValues = new ArrayList<Integer>();

    //for repetitions
    static ArrayList<Integer> coordinateProductsRepeat = new ArrayList<Integer>();
    static ArrayList<Integer> jumpValuesRepeat = new ArrayList<Integer>();

    static int startJumpValue;

    static int exitCoordsN;
    static int exitCoordsM;

    static void calcExit() {
        boolean canExit = false;
        int toExitJumpValue = coordinateProducts.get(coordinateProducts.size() - 1);

        int timesToExecute = jumpValues.size();

        int currentCoordinateProduct = toExitJumpValue;

        if (currentCoordinateProduct == startJumpValue) {
        System.out.println("yes");
        return; }

        for (int i = 0; i <= timesToExecute; i++) {
            int repeatCoordinateProduct = 0;
            //search jump values for the product of current coordinates
            int newIndex = jumpValues.indexOf(currentCoordinateProduct);
            int indexRepeat = jumpValuesRepeat.indexOf(currentCoordinateProduct);
            //if there is no jump value for current coords then path is broken, return
            if (newIndex == -1 && indexRepeat == -1) {
            canExit = false;
            break; }

            if (newIndex != -1) {
                currentCoordinateProduct = coordinateProducts.get(newIndex);
            } else {
                currentCoordinateProduct = coordinateProductsRepeat.get(indexRepeat);
                repeatCoordinateProduct = coordinateProductsRepeat.get(indexRepeat);
            }

            if (currentCoordinateProduct == startJumpValue || repeatCoordinateProduct == startJumpValue) {
                canExit = true;
            break;
         }
        }
         if (canExit) {
             System.out.println("yes");
         } else {
             System.out.println("no");
         }
        
    }
    
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);

        int mRows = input.nextInt();
        int nColumns = input.nextInt();

        startJumpValue = input.nextInt(); //start box is also (1,1)
        int executeTimes = mRows*nColumns - 1;

        int currentN = 2;
        int currentM = 1;

        for (int i = executeTimes; i > 0; i--) {
            int nextInt = input.nextInt();

            if (jumpValues.indexOf(nextInt) == -1) {
             jumpValues.add(nextInt);
             coordinateProducts.add(currentN * currentM);
        } else {
            jumpValuesRepeat.add(nextInt);
            coordinateProductsRepeat.add(currentN * currentM);
        }
             if (currentN == nColumns) {
                 currentN = 1;
                 currentM++;
             } else {
                 currentN++;
             }
        }
      //END OF FOR FUNCTION
        calcExit();
    }
}