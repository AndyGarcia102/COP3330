import java.io.*;
import java.util.*;


public class ContactList {

    public ArrayList<ContactItem> contact;

    public ContactList(){
        contact = new ArrayList<>();
    }

    public void List_menu(int c, Scanner in){
        try {
            while (c != 6) {
                System.out.println("List Operation Menu\n" +
                        "---------");
                System.out.println("1) view the list\n" +
                        "2) add an item\n" +
                        "3) edit an item\n" +
                        "4) remove an item\n" +
                        "5) save the current list\n" +
                        "6) quit to the main menu\n");

                c = in.nextInt();
                Select_list(in, c);
            }
        }catch(InputMismatchException L){
            System.out.println("Please enter a valid list operation.");
            in.next();
            List_menu(c,in);
        }
    }

    public void Select_list(Scanner in, int c){

        try{
            switch (c)
            {
                case 1: Print(); break;
                case 2:
                    System.out.print("First Name: ");
                    in.nextLine();
                    String Fname = in.nextLine();
                    System.out.print("Last Name: ");
                    String Lname = in.nextLine();
                    System.out.print("Phone Number (xxx-xxx-xxxx): ");
                    String Phone = in.nextLine();
                    System.out.print("Email Address (x@y.z): ");
                    String Email = in.nextLine();
                    this.contact.add(new ContactItem(Fname, Lname, Phone, Email));
                    break;

                case 3:
                    Print();
                    int remove;
                    if(contact.size() > 0){
                        System.out.print("Which contact will you edit? ");
                        remove = in.nextInt();
                        if(contact.size() < remove || remove < 0) throw new IndexOutOfBoundsException("size");
                        System.out.print("Enter a new first name for contact "+remove+": ");
                        in.nextLine();
                        String newfirst = in.nextLine();
                        System.out.print("Enter a new last name for contact "+remove+": ");
                        String newlast = in.nextLine();
                        System.out.print("Enter a new phone number (xxx-xxx-xxxx) for contact "+remove+": ");
                        String newPhone = in.nextLine();
                        System.out.print("Enter a new email address (x@y.z) for contact "+remove+": ");
                        String newEmail = in.nextLine();
                        edit(newfirst,newlast,newPhone,newEmail,remove);

                    }else System.out.print("No contacts to edit");

                    break;

                case 4:
                    Print();
                    System.out.print("Which contact will you remove? ");
                    remove = in.nextInt();
                    contact.remove(remove);
                    break;

                case 5:
                    System.out.print("Enter the filename to save: ");
                    /*in.next();
                    String Filename = System.getProperty("user.dir")+"\\src\\"+in.nextLine();
                    //SaveList(Filename);*/
                    break;

                case 6:
                    System.out.println("Exit to menu");
                    for(int i = 0; i< contact.size(); i++){
                        contact.remove(i);
                    }
                    break;

                default:
                    System.out.println("Enter a valid choice please.");
            }
            System.out.print("\n");
        }catch(NullPointerException H){
            System.out.println("WARNING: There must be some information in a contact\n");
            List_menu(c,in);
        }catch(IndexOutOfBoundsException I){
            System.out.println("WARNING: out of bound call please enter correct value\n");
            List_menu(c,in);
        }catch(InputMismatchException E){
            System.out.println("WARNING: Invalid operation please try again\n");
            List_menu(c, in);
        }
    }

    public void addContact(String Fname, String Lname, String Phone, String Email) {
        this.contact.add(new ContactItem(Fname,Lname,Phone,Email));
    }

    public void toRemove(int remove){
        try{
            if(contact.size() < remove || remove < 0) throw new IndexOutOfBoundsException("size");
            contact.remove(remove);

        }catch(IndexOutOfBoundsException I) {
            System.out.println("WARNING: out of bound call please enter correct value\n");
        }
    }

    private void Print(){
        System.out.println("Current contacts\n" +
                "-------------\n");
        for(int i = 0; i< contact.size();i++){
            System.out.print(i+") ");
            System.out.print("Name: "+contact.get(i).getFname()+" "+contact.get(i).getLname()+"\n");
            System.out.print("Phone: "+contact.get(i).getPhone()+"\n");
            System.out.print("Email: "+contact.get(i).getEmail());
            System.out.print("\n");
        }

    }

    public void edit(String newfirst, String newlast, String newPhone, String newEmail, int remove){
        try{
            if(contact.size() < remove || remove < 0) throw new IndexOutOfBoundsException("size");
            if(newfirst.trim().equals("") && newlast.trim().equals("") && newPhone.trim().equals("") && newEmail.trim().equals(""))
                throw new NullPointerException("All Data is NULL ");

            if(!ContactItem.isValid(newEmail))
                throw new InputMismatchException("Not a valid Email ");

            if(!ContactItem.isValidPhone(newPhone))
                throw new InputMismatchException("Not a valid Phone number ");

            contact.get(remove).Fname = newfirst; contact.get(remove).Lname = newlast; contact.get(remove).PhoneNumber = newPhone; contact.get(remove).Email = newEmail;
        }catch(IndexOutOfBoundsException I) {
            System.out.println("WARNING: out of bound call please enter correct value\n");
        }
    }


    public void SaveList(String Filename){

    }


}