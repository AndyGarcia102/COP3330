import java.util.*;

class Main{

    //private static TaskApp TApp = new TaskApp();
    //private static ContactApp CApp = new ContactApp();

    public static void main(String[] args){
      DuelMenu();
    }

    private static void DuelMenu(){
      System.out.println("Select Your Application\n-----------------------\n");
      System.out.println("1) task list\n2) contact list\n3) quit\n");
      int Choice;

      try{
        Scanner in = new Scanner(System.in);
        Choice = in.nextInt();
          switch (Choice) {
              case 1 -> {
                  TaskApp.menu();
                  DuelMenu();
              }
              case 2 -> {
                  ContactApp.menu();
                  DuelMenu();
              }
              case 3 -> System.out.println("Closing application");
              default -> {
                  System.out.println("Error please choose a correct option from 1-3");
                  DuelMenu();
              }
          }
      }catch(InputMismatchException e){
          System.out.println("Please enter a valid Selection option.\n");
          DuelMenu();
        }


    }

}