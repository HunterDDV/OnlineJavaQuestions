
import java.util.Arrays;

/**
 *
 * @author Denzil Vorster
 * @version 1.0, May 9, 2018
 */
public class Vetting {

    private String teachName;
    private int[][] arRates;
    private int total[] = new int[5];

    public Vetting() {
    }

    public Vetting(String teachName, int arRates[][]) {
        this.teachName = teachName;
        this.arRates = arRates;
    }

    void processRates() {
        getTotal();
        getMax();
        getMin();
        getFrequency();
    }

    void getTotal() {
        int counter = 0;

        for (int i = 0; i < 5; i++) {
            counter = 0;
            for (int j = 0; j < arRates.length; j++) {
                counter = counter + arRates[j][i];
            }
            total[i] = counter;
        }
    }

    int getMax() {
        int max = total[0];

        for (int i = 0; i < total.length; i++) {
            if (total[i] > max) {
                max = total[i];
            }
        }

        return max;
    }

    int getMin() {
        int min = total[0];

        for (int i = 0; i < total.length; i++) {
            if (total[i] < min) {
                min = total[i];
            }
        }

        return min;
    }

    void getFrequency() {
        int[]arFrequency = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        for (int[] rate : arRates) {
            for (int j = 0; j < rate.length; j++) {
                switch (rate[j]) {
                    case 0:
                        arFrequency[0]++;
                        break;
                    case 1:
                        arFrequency[1]++;
                        break;
                    case 2:
                        arFrequency[2]++;
                        break;
                    case 3:
                        arFrequency[3]++;
                        break;
                    case 4:
                        arFrequency[4]++;
                        break;
                    case 5:
                        arFrequency[5]++;
                        break;
                    case 6:
                        arFrequency[6]++;
                        break;
                    case 7:
                        arFrequency[7]++;
                        break;
                    case 8:
                        arFrequency[8]++;
                        break;
                    case 9:
                        arFrequency[9]++;
                        break;
                    case 10:
                        arFrequency[10]++;
                        break;
                }
            }
        }
        
        System.out.println("\nOverall rate distribution:");
        
        for (int i = 0; i < arFrequency.length; i++) {
            System.out.print(i + ": ");
            
            for (int j = 0; j < arFrequency[i]; j++) {
                System.out.print("*");
            }
            
            System.out.println();
        }
        
        System.out.println();
    }
    
    void outputRates(int max, int min){
        System.out.println("The rates are:\n");
        System.out.println("            " + "Assessment 1 " + "Assessment 2 " + "Assessment 3 " + "Assessment 4 " + "Assessment 5");
        
        for (int i = 0; i < arRates.length; i++) {
            System.out.print("Student " + (i + 1));
            
            for (int j = 0; j < arRates[i].length; j++) {
                System.out.print("          " + arRates[i][j]);
            }
            
            System.out.println();
            
        }

        System.out.println(Arrays.toString(total) + "\n");
        System.out.println("The last number in the total array is " + total[4]);
        System.out.println("Good job on a high score of " + max);
        System.out.println("You could improve on the score of " + min);
    }
    
}
