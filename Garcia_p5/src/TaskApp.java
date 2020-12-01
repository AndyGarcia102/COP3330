import java.util.*;
import java.io.FileNotFoundException;

class TaskApp{

    private static final TaskList Arr = new TaskList();

    public static void menu(){
        int Choice;
        System.out.println("\nMain Menu\n---------\n");
        System.out.println("1) create a new list\n2) load an existing list\n3) quit\n");

        try{
            Scanner in = new Scanner(System.in);
            Choice = in.nextInt();
            in.nextLine();
            switch (Choice) {
                case 1 -> {
                    System.out.println("new task list has been created\n");
                    Arr.List_menu(Choice, in);
                    menu();
                }
                case 2 -> {
                    Arr.LoadList(Choice, in);
                    menu();
                }
                case 3 -> System.out.println("Closing Task");
                default -> {
                    System.out.println("Error please choose a correct option from 1-3");
                    menu();
                }
            }


        }catch(InputMismatchException e){
          System.out.println("Please enter a valid menu option.");
          menu();
        }catch(FileNotFoundException ex){
          System.out.println("Error -0");
        }


    }




}