import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class ContactItemTest {
    ContactItem contact;

    String validFname ="Test Title";
    String validLname ="Test Project";
    String validPhone = "561-555-5555";
    String validEmail = "andy@knights.ucf.edu";

    String empty = "";

    @Test
    public void creationFailsWithAllBlankValues(){
        try{
            contact = new ContactItem(empty,empty,empty,empty);
        }catch(NullPointerException I){
            System.out.println("Failed All Items NULL");
        }
    }

    @Test
    public void creationSucceedsWithBlankEmail(){
        try{
            contact = new ContactItem(validFname,validLname,validPhone,empty);
        }catch(NullPointerException I){
            System.out.println("Failed blank emil");
        }
    }

    @Test
    public void creationSucceedsWithBlankFirstName(){
        try{
            contact = new ContactItem(empty,validLname,validPhone,validEmail);
        }catch(NullPointerException I){
            System.out.println("Failed black name");
        }
    }

    @Test
    public void creationSucceedsWithBlankLastName(){
        try{
            contact = new ContactItem(empty,empty,validPhone,validEmail);
        }catch(NullPointerException I){
            System.out.println("Failed blank name");
        }
    }

    @Test
    public void creationSucceedsWithBlankPhone(){
        try{
            contact = new ContactItem(empty,empty,empty,validEmail);
        }catch(NullPointerException I){
            System.out.println("Failed incorrect phone");
        }
    }

    @Test
    public void creationSucceedsWithNonBlankValues(){
        try{
            contact = new ContactItem(validFname,validLname,validPhone,validEmail);
        }catch(NullPointerException I){
            System.out.println("Failed All Items NULL");
        }
    }

    @Test
    public void editingFailsWithAllBlankValues(){
        try{
            contact = new ContactItem(validFname,validLname,validPhone,validEmail);
            contact = new ContactItem(empty,empty,empty,empty);
        }catch(NullPointerException I){
            System.out.println("Failed All Items NULL");
        }

    }

    @Test
    public void editingSucceedsWithBlankEmail(){
        try{
            contact = new ContactItem(validFname,validLname,validPhone,validEmail);
            contact = new ContactItem(validFname,validLname,validPhone,empty);
        }catch(NullPointerException I){
            System.out.println("Failed Empty email");
        }
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        try{
            contact = new ContactItem(validFname,validLname,validPhone,validEmail);
            contact = new ContactItem(empty,validLname,validPhone,empty);
        }catch(NullPointerException I){
            System.out.println("Failed Empty First name");
        }
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        try{
            contact = new ContactItem(validFname,validLname,validPhone,validEmail);
            contact = new ContactItem(validFname,empty,validPhone,empty);
        }catch(NullPointerException I){
            System.out.println("Failed Empty Last name");
        }
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        try{
            contact = new ContactItem(validFname,validLname,validPhone,validEmail);
            contact = new ContactItem(validFname,validLname,empty,empty);
        }catch(NullPointerException I){
            System.out.println("Failed Empty Phone");
        }
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        try{
            contact = new ContactItem(validFname,validLname,validPhone,validEmail);
            contact = new ContactItem(validFname,validLname,validPhone,validEmail);
        }catch(NullPointerException I){
            System.out.println("Failed Data not correct");
        }
    }

    @Test
    public void testToString(){
        contact = new ContactItem(validFname,validLname,validPhone,validEmail);
        assertEquals(validFname, contact.getFname());
        assertEquals(validLname, contact.getLname());
        assertEquals(validPhone, contact.getPhone());
        assertEquals(validEmail, contact.getEmail());
    }

}
