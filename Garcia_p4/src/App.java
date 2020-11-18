import java.util.*;

class App{

    private static TaskList Arr = new TaskList();


    public static void main(String args[]){
        menu();
    }


    private static void menu(){
        int Choice;
        System.out.println("Main Menu\n---------\n");
        System.out.println("1) create a new list\n2) load an existing list\n3) quit\n");

        try{
            Scanner in = new Scanner(System.in);
            Choice = in.nextInt();
            switch (Choice)
            {
                case 1: System.out.println("new task list has been created\n");  Arr.List_menu(Choice, in); menu();break;
                case 2:  Arr.LoadList(in);break;
                case 3: System.out.println("Closing application"); break;
                default: System.out.println("Error please choose a correct option from 1-3"); menu();break;
            }


        }catch(InputMismatchException e){
            System.out.println("Please enter a valid menu option.");
            menu();
        }


    }




}
