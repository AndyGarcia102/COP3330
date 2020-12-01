import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ContactItem {
    public String Fname;
    public String Lname;
    public String PhoneNumber;
    public String Email;

    public ContactItem(String first, String last, String number, String mail){
        this.SetContact(first,last,number,mail);
    }

    public void SetContact(String F, String L, String P, String E)
    {
        if(F.trim().equals("") && L.trim().equals("") && P.trim().equals("") && E.trim().equals(""))
            throw new NullPointerException("All Data is NULL ");

        if(!isValid(E))
            throw new InputMismatchException("Not a valid Email ");

        if(!isValidPhone(P))
            throw new InputMismatchException("Not a valid Phone number ");

        this.Fname = F.trim();
        this.Lname = L.trim();
        this.PhoneNumber = P.trim();
        this.Email = E.trim();
    }

    public static boolean isValid(String email) {
        String Validation = "^[a-zA-Z0-9_+&*-]+(?:\\."+
                "[a-zA-Z0-9_+&*-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]{2,7}$";

        Pattern pat = Pattern.compile(Validation);
        if (email == null || email.trim().equals("") )
            return true;
        return pat.matcher(email).matches();
    }

    public static boolean isValidPhone(String phone){
        Pattern pattern = Pattern.compile("^(\\d{3}[-]?){2}\\d{4}$");
        Matcher matcher = pattern.matcher(phone);

        if(phone.trim().equals(""))
            return true;
        return matcher.matches();
    }

    public String getFname() {
        return this.Fname;
    }

    public String getPhone(){
        return this.PhoneNumber;
    }

    public String getLname() {
        return this.Lname;
    }

    public String getEmail(){
        return this.Email;
    }

}