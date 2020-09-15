import java.util.*;

public class Encrypter{

    public String encrypt(String num){
        String encryption = ReturnInt(num);
        return encryption;
    }

    public String ReturnInt(String num){

        String value = num;
        int valueNum = Integer.valueOf(value);
        int individualNum, encryptArr[] = new int[4];
        int encrypted [] = new int [4];
        String e = null;

        //If the value is over 5 digits the code will terminate
        if(valueNum > 9999){
            //System.out.println("Error cannot encrypt this number");
        }else{

            //System.out.print("-> encrypts \""+value+"\"");

            //Loop that takes each digit and moves them into an array
            for(int i = 0; i < 4; i++ ) {
                individualNum = (valueNum % 10);
                valueNum = valueNum/10;
                encryptArr[i] = individualNum;

                encrypted[i] = change(encryptArr[i]);
                //System.out.println(encrypted[i]);
            }
            //Changes number position in the array
            e = swap(encrypted);


        }
        return e;
    }

    //Changes the number to the encryption method
    public int change(int n){
        int encryption;

        encryption = (n+7)%10;

        return encryption;
    }

    //Swaps the position of the number to the desired encryption pattern
    public String swap(int[] arr )
    {
        int[] array = new int[4];

        array[0] = arr[1];
        array[1] = arr[0];
        array[2] = arr[3];
        array[3] = arr[2];

        //Converts an int array into a string and removes all formatting
        String convertString = Arrays.toString(array);
        convertString = convertString.replaceAll("\\p{P}","");
        convertString = convertString.replaceAll("\\s", "");
        //System.out.print("\" to \""+convertString+"\"");

        return convertString;
    }


}
