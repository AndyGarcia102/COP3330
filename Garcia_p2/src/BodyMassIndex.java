import java.lang.Math;

public class BodyMassIndex {

    public double BMI;
    public String category = null;

    //Calculate the Bmi of a person
    public BodyMassIndex(double height, double weight){
        BMI = 703 * weight / (height * height);
        BMI = Math.round(BMI*10.0)/10.0;
        BodyMassCategory(BMI);
    }

    //Using the value from BMI this function releases proper category of weight
    public void BodyMassCategory(double BMI){

        if(BMI < 18.5)
        {
            category = ("you are Underweight");
        }else if(BMI >= 18.5 && BMI <= 24.94){
            category = ("you are Normal weight");
        }else if(BMI >= 24.95 && BMI <=29.9){
            category = ("you are Overweight");
        }else if(BMI >= 30){
            category = ("you are Obese");
        }

    }


    public double Mass(){

        return BMI;
    }


    public String cat(){

        return category;
    }


}
