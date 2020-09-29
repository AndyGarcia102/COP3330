import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BodyMassIndexTest {

    @Test
    public void testBodyMassIndex1(){
        BodyMassIndex BMI1 = new BodyMassIndex(65,90);

        double exactBMI = BMI1.Mass();
        String weight = BMI1.cat();

        assertEquals(15,exactBMI);
        assertEquals("you are Underweight",weight);
    }


    @Test
    public void testBodyMassIndex2(){
        BodyMassIndex BMI2 = new BodyMassIndex(65,126);

        double exactBMI = BMI2.Mass();
        String weight = BMI2.cat();

        assertEquals(21,exactBMI);
        assertEquals("you are Normal weight",weight);
    }


    @Test
    public void testBodyMassIndex3(){
        BodyMassIndex BMI3 = new BodyMassIndex(74,227);

        double exactBMI = BMI3.Mass();
        String weight = BMI3.cat();

        assertEquals(29.1,exactBMI);
        assertEquals("you are Overweight", weight);
    }


    @Test
    public void testBodyMassIndex4(){
        BodyMassIndex BMI3 = new BodyMassIndex(75,300);

        double exactBMI = BMI3.Mass();
        String weight = BMI3.cat();

        assertEquals(37.5,exactBMI);
        assertEquals("you are Obese", weight);

    }

}
