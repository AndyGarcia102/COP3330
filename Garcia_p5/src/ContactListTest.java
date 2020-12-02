import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

public class ContactListTest{
    String validFname = "C";
    String validLname = "Hollander";
    String validPhone = "561-555-5555";
    String validEmail = "ucf@gmail.com";
    String empty = "";
    public ContactList List = new ContactList();

    @Test
    public void addingItemsIncreasesSize(){
        assertEquals(List.contact.size(),0);
        List.addContact(validFname,validLname,validPhone,validEmail);
        assertEquals(List.contact.size(),1);
    }

    @Test
    public void editingItemsFailsWithAllBlankValues(){
        try{
            List.addContact(validFname,validLname,validPhone,validEmail);
            List.edit(empty,empty,empty,empty,0);
        }catch (NullPointerException H){
            System.out.println("Cannot edit empty");
        }
    }

    @Test
    public void editingItemsFailsWithInvalidIndex(){
        try{
            List.addContact(validFname,validLname,validPhone,validEmail);
            List.edit(empty,validLname,validPhone,validEmail,7);
        }catch (IndexOutOfBoundsException I){
            System.out.println("Cannot edit empty");
        }
    }

    @Test
    public void editingSucceedsWithBlankFirstName(){
        try{
            List.addContact(validFname,validLname,validPhone,validEmail);
            List.edit(empty,validLname,validPhone,validEmail,0);
            assertEquals(List.contact.get(0).Fname,"");
        }catch (NullPointerException H){
            System.out.println("Cannot edit empty");
        }
    }

    @Test
    public void editingSucceedsWithBlankLastName(){
        try{
            List.addContact(validFname,validLname,validPhone,validEmail);
            List.edit(validFname,empty,validPhone,validEmail,0);
            assertEquals(List.contact.get(0).Lname,"");
        }catch (NullPointerException H){
            System.out.println("Cannot edit empty");
        }
    }

    @Test
    public void editingSucceedsWithBlankPhone(){
        try{
            List.addContact(validFname,validLname,validPhone,validEmail);
            List.edit(validFname,empty,empty,validEmail,0);
            assertEquals(List.contact.get(0).PhoneNumber,"");
        }catch (NullPointerException H){
            System.out.println("Cannot edit empty");
        }
    }

    @Test
    public void editingSucceedsWithNonBlankValues(){
        try{
            List.addContact(validFname,validLname,validPhone,validEmail);
            List.edit("pog","log","555-555-5555","andy@ucf.com",0);
            assertEquals(List.contact.get(0).PhoneNumber,"555-555-5555");
            assertEquals(List.contact.get(0).Fname,"pog");
            assertEquals(List.contact.get(0).Lname, "log");
            assertEquals(List.contact.get(0).Email, "andy@ucf.com");
        }catch (NullPointerException H){
            System.out.println("Cannot edit empty");
        }
    }

    @Test
    public void newListIsEmpty(){
        assertEquals(List.contact.size(),0);
    }

    @Test
    public void removingItemsDecreasesSize(){
        List.addContact(validFname,validLname,validPhone,validEmail);
        List.addContact(validFname,empty,validPhone,validEmail);
        assertEquals(List.contact.size(),2);
        List.contact.remove(0);
        assertEquals(List.contact.size(),1);
    }

    @Test
    public void removingItemsFailsWithInvalidIndex(){
        List.addContact(validFname,validLname,validPhone,validEmail);
        List.addContact(validFname,empty,validPhone,validEmail);
        assertEquals(List.contact.size(),2);
        List.toRemove(0);
        assertEquals(List.contact.size(),1);
    }

    @Test
    public void savedContactListCanBeLoaded(){

    }
}
