import java.util.*;

class ContactApp{

  private static final ContactList Arr = new ContactList();

  public static void menu(){
    int Choice;
    System.out.println("\nMain Menu\n---------\n");
    System.out.println("1) create a new list\n2) load an existing list\n3) quit\n");

    try{
      Scanner in = new Scanner(System.in);
      Choice = in.nextInt();
      switch (Choice){
        case 1: System.out.println("new task list has been created\n");  Arr.List_menu(Choice, in); menu();break;
        case 2: break;
        case 3: System.out.println("Closing contact"); break;
        default: System.out.println("Error please choose a correct option from 1-3"); menu();break;
        }

      }catch(InputMismatchException e){
            System.out.println("Please enter a valid menu option.");
            menu();
        }
    }


}