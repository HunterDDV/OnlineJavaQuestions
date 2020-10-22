package thyshys;

import java.util.Scanner;

/**
 *
 * @author Denzil Vorster
 */
public class ThysHys {

    public static void main(String[] args) {
        int[] temperature = new int[10];
        int temp = 0;
        int total = 0;
        int average = 0;
        int counter = 1;
        Scanner scan = new Scanner(System.in);

        for(int i = 0; i < temperature.length; i ++){
            System.out.print("Enter the temperature for day " + counter + ":");
            temp = scan.nextInt();
            temperature[i] = temp;
            total = total + temp;
            counter ++;
        }
        counter = 0;
        
        average = total / (temperature.length);
        System.out.println("The average temperature is: " + average);        
        
        System.out.println("");
        
        System.out.println("Checking when temperature was higher than average");
        
        for (int i = 0; i < temperature.length; i ++) {
            if (temperature[i] == average) {
                System.out.println("On day " + counter + ": the temperature was average.");
                counter ++;
            }
            else if(temperature[i] > average){
                System.out.println("On day " + counter + ": the temperature was higher than the average.");
                counter ++;
            }
            else if(temperature[i] < average){
                System.out.println("On day " + counter + ": the temperature was lower than the average.");
                counter ++;
            }
        }
        counter = 0;
    }
}
