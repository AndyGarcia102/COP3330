import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.ArrayList;


public class TaskListTest {
    private  TaskList Arr = new TaskList();
    String validTitle = "First";
    String validDes = "List of items to buy";
    LocalDate validDate = LocalDate.parse("2020-12-12");

    @Test
    public void addingItemsIncreasesSize(){
        Arr.addTask(validTitle,validDes,validDate);
        assertEquals(Arr.tasks.size(),1);
    }

    @Test
    public void completingTaskItemChangesStatus(){
        Arr.addTask(validTitle,validDes,validDate);
        Arr.tasks.get(0).unfinished();

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){

        try{
            Arr.addTask(validTitle,validDes,validDate);
            Arr.tasks.get(11).finished();
        }catch(IndexOutOfBoundsException k){
            System.out.println("out of bounds");
        }
    }

    @Test
    public void editingItemDescriptionFailsWithInvalidIndex(){
        Arr.addTask(validTitle,validDes,validDate);
        Arr.edit("less","more",LocalDate.parse("2020-12-11"),12);
    }

    @Test
    public void editingItemDescriptionSucceedsWithExpectedValue(){
        Arr.addTask(validTitle,validDes,validDate);
        Arr.edit("less","more",LocalDate.parse("2020-12-11"),0);
        assertEquals(Arr.tasks.get(0).des,"more");
    }

    @Test
    public void editingItemDueDateSucceedsWithExpectedValue(){
        Arr.addTask(validTitle,validDes,validDate);
        Arr.edit("less","more",LocalDate.parse("2020-12-11"),0);
        assertEquals(Arr.tasks.get(0).getDate(),LocalDate.parse("2020-12-11"));
    }

    @Test
    public void editingItemTitleFailsWithEmptyString(){

        try{
            Arr.addTask(validTitle,validDes,validDate);
            Arr.edit("","more",LocalDate.parse("2020-12-11"),0);
        }catch(NullPointerException l){
            System.out.println("File with empty title");
        }
    }

    @Test
    public void editingItemTitleFailsWithInvalidIndex(){
        Arr.addTask(validTitle,validDes,validDate);
        Arr.edit("less","more",LocalDate.parse("2020-12-11"),12);
    }

    @Test
    public void editingItemTitleSucceedsWithExpectedValue(){
        Arr.addTask(validTitle,validDes,validDate);
        Arr.edit("less","more",LocalDate.parse("2020-12-11"),0);
        assertEquals(Arr.tasks.get(0).title,"less");
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidDateFormat(){

    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidIndex(){
        Arr.addTask(validTitle,validDes,validDate);
        Arr.edit("less","more",LocalDate.parse("2020-12-11"),12);
    }

    @Test
    public void editingTaskItemDueDateFailsWithInvalidYYYMMDD(){

    }
}
