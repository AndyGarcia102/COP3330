import java.io.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.*;


public class TaskList {

    public ArrayList<TaskItem> tasks;

    public TaskList(){
        tasks = new ArrayList<>();
    }

    public void List_menu(int c, Scanner in){
        try {
            while (c != 8) {
                System.out.println("List Operation Menu\n" +
                        "---------");
                System.out.println("1) view the list\n" +
                        "2) add an item\n" +
                        "3) edit an item\n" +
                        "4) remove an item\n" +
                        "5) mark an item as completed\n" +
                        "6) unmark an item as completed\n" +
                        "7) save the current list\n" +
                        "8) quit to the main menu\n");

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
                    System.out.print("Task title: ");
                    in.nextLine();
                    String title = in.nextLine();
                    System.out.print("Task description: ");
                    String des = in.nextLine();
                    System.out.print("Task due date: ");
                    LocalDate date = LocalDate.parse(in.nextLine());
                    this.tasks.add(new TaskItem(title, des, date));
                    break;

                case 3:
                    Print();
                    System.out.print("Which task will you edit? ");
                    int remove = in.nextInt();
                    System.out.print("Enter a new title for task "+remove+": ");
                    in.nextLine();
                    String newTitle = in.nextLine();
                    System.out.print("Enter a new description for task "+remove+": ");
                    String newDes = in.nextLine();
                    System.out.print("Enter a new task due date (YYYY-MM-DD) for task "+remove+": ");
                    LocalDate newDate = LocalDate.parse(in.nextLine());

                    if(newTitle.trim().equals("") || newTitle == null){
                        throw new NullPointerException("Warning: title must be at least 1 character long; task not created");
                    }

                    tasks.get(remove).title = newTitle; tasks.get(remove).des = newDes; tasks.get(remove).Date = newDate;

                    break;

                case 4:
                    Print();
                    System.out.print("Which task will you remove? ");
                    remove = in.nextInt();
                    tasks.remove(remove);
                    break;

                case 5:
                    PrintUncomp();
                    System.out.print("\nWhich task will you mark as completed? ");
                    int markcomplete = in.nextInt();
                    tasks.get(markcomplete).finished();
                    break;

                case 6:
                    PrintCompleted();
                    System.out.print("\nWhich task will you unmark as completed? ");
                    int unmarkcomplete = in.nextInt();
                    tasks.get(unmarkcomplete).unfinished();
                    break;

                case 7:
                    System.out.print("Enter the filename to load: ");
                    in.next();
                    String Filename = System.getProperty("user.dir")+"\\src\\"+in.nextLine();
                    //SaveList(Filename);
                    break;

                case 8: System.out.println("Exit to menu"); break;

                default:
                    System.out.println("Enter a valid choice please.");
            }
            System.out.print("\n");
        }catch(DateTimeParseException F){
            System.out.println("WARNING: invalid due date; task not created\n");
            List_menu(c,in);
        }catch(NullPointerException H){
            System.out.println("WARNING: title must be at least 1 character long; task not created\n");
            List_menu(c,in);
        }catch(IndexOutOfBoundsException I){
            System.out.println("WARNING: out of bound call please enter correct value\n");
            List_menu(c,in);
        }catch(DateTimeException E){
            System.out.println("Cannot chose an old date");
            List_menu(c,in);
        }
    }

    public void addTask(String title, String project, LocalDate dueDate) {
        this.tasks.add(new TaskItem(title,project,dueDate));
    }

    private void Print(){
        System.out.println("Current Tasks\n" +
                "-------------\n");
        for(int i = 0; i< tasks.size();i++){
            if(tasks.get(i).isComp() == true){
                System.out.print(i+") ");
                System.out.print("***["+tasks.get(i).getDate()+"] "+tasks.get(i).getTitle()+": "+tasks.get(i).getDes());
                System.out.print("\n");
            }else{
                System.out.print(i+") ");
                System.out.print("["+tasks.get(i).getDate()+"] "+tasks.get(i).getTitle()+": "+tasks.get(i).getDes());
                System.out.print("\n");
            }

        }
    }

    private void PrintUncomp() {
        System.out.println("Uncompleted Tasks\n" +
                "-------------\n");
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isComp() == false) {
                System.out.print(i + ") ");
                System.out.print("[" + tasks.get(i).getDate() + "] " + tasks.get(i).getTitle() + ": " + tasks.get(i).getDes());
                System.out.print("\n");
            }
        }
    }

    private void PrintCompleted(){
        System.out.println("Completed Tasks\n" +
                "-------------\n");
        for (int i = 0; i < tasks.size(); i++) {
            if (tasks.get(i).isComp() == true) {
                System.out.print(i + ") ");
                System.out.print("[" + tasks.get(i).getDate() + "] " + tasks.get(i).getTitle() + ": " + tasks.get(i).getDes());
                System.out.print("\n");
            }
        }
    }

    public void LoadList(Scanner in){
        String FileName;
        System.out.print("Enter name of file to load: ");
        in.next();
        FileName = (System.getProperty("user.dir")+"\\src\\"+in.nextLine());
        try {
            FileInputStream readData = new FileInputStream(FileName);
            ObjectInputStream readObj = new ObjectInputStream(readData);

            tasks = (ArrayList<TaskItem>) readObj.readObject();

            readData.close();
            readObj.close();

        }catch (FileNotFoundException e){
            //e.printStackTrace();
            System.out.println("Could not find and open file.");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


    public void SaveList(String Filename){

        try (Formatter outfile = new Formatter(Filename)){
            File outfp = new File(Filename);
            outfp.createNewFile();



            System.out.println("\nFile saved!\n");
        }catch (IOException e){
            e.printStackTrace();
        }
    }


}
