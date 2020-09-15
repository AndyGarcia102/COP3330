import java.util.*;

public class Decrypter{

    public String decrypt(String num){
        String decrypt = ReturnInt(num);
        return decrypt;
    }

    public String ReturnInt(String num){

        String value = num;
        int valueNum = Integer.valueOf(value);
        int individualNum, decryptArr[] = new int[4];
        int encrypted [] = new int [4];
        String d = null;

        if(valueNum > 9999){
            System.out.println("Error cannot decrypt this number");
        }else{

            //System.out.print("-> decrypt \""+value+"\"");

            //Takes each number in an array converted from a string
            for(int i = 0; i < 4; i++ ) {
                individualNum = (valueNum % 10);
                valueNum = valueNum/10;
                decryptArr[i] = individualNum;

                encrypted[i] = change(decryptArr[i]);
                //System.out.println(encrypted[i]);
            }
            //Function changes the position of the numbers to proper order
            d = swap(encrypted);
        }
        return d;
    }

    //Function that undoes the effects of encryption function
    public int change(int n){
        int decryption;

        decryption = (n+3)%10;

        return decryption;
    }

    //Function that takes the values from one array and changes them to decrypt the text
    public String swap(int[] arr )
    {
        int[] array = new int[4];

        array[0] = arr[1];
        array[1] = arr[0];
        array[2] = arr[3];
        array[3] = arr[2];

        String convertString = Arrays.toString(array);
        convertString = convertString.replaceAll("\\p{P}","");
        convertString = convertString.replaceAll("\\s", "");
        //System.out.print("\" to \""+convertString+"\"");
        return convertString;
    }
}
