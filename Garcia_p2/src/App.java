import java.util.*;
import java.text.DecimalFormat;


public class App {

    public static void main(String[] args) {
        ArrayList<BodyMassIndex> bmiData = new ArrayList<BodyMassIndex>();

        while (moreInput()) {

            double height = getUserHeight();
            double weight = getUserWeight();

            BodyMassIndex bmi = new BodyMassIndex(height, weight);
            bmiData.add(bmi);

            displayBmiInfo(bmi);
        }

        displayBmiStatistics(bmiData);
    }

    //This method answers with a boolean expression
    public static boolean moreInput(){
        System.out.println("Would you like to calculate your BMI? (Y/N)");
        Scanner scan = new Scanner(System.in);
        String answer = scan.next();

        if("Y".equals(answer) || ("y".equals(answer))) {
            return true;
        }
            return false;

    }


    //Method ask for user input for height
    public static double getUserHeight(){
        System.out.println("Enter user Height(In inches): ");
        Scanner scan = new Scanner(System.in);
        double height = scan.nextDouble();

        if(height <= 0){
            System.out.println("Please enter a Correct value");
            getUserHeight();
        }

        return height;
    }


    //Method as for user input for weight
    public static double getUserWeight(){
        System.out.println("Enter user Weight(In lbs): ");
        Scanner scan = new Scanner(System.in);
        double weight = scan.nextDouble();

        if(weight <= 0){
            System.out.println("Please enter a Correct value");
            getUserWeight();
        }

        return weight;
    }

    //Display the information from BodyMass class
    public static void displayBmiInfo(BodyMassIndex bmi){

        System.out.println("your BMI is "+ (bmi.BMI));
        System.out.println(bmi.category);

    }


    //Takes the BMI from every case and calculates the average BMI average
    public static void displayBmiStatistics(ArrayList<BodyMassIndex> bmiData){
        double average = 0;

        //System.out.println(bmiData.size());
        for(int i = 0; i< bmiData.size();i++){

            average += (bmiData.get(i).Mass());
        }

        if(average == 0){
            System.out.println("");
        }else {
            average = average / bmiData.size();
            DecimalFormat formatAvg = new DecimalFormat("#.0");
            System.out.println("The average BMI is: " + formatAvg.format(average));
        }

    }

}
