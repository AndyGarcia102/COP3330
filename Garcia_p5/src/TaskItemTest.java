import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;
import org.junit.Before;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;


public class TaskItemTest {
    String validTitle = "First";
    String validDes = "List of items to buy";
    LocalDate validDate = LocalDate.parse("2020-12-12");
    TaskItem item;



    @Before
    public void setUp() throws Exception {
        try {
            item = new TaskItem(validTitle, validDes, validDate);
        } catch (Exception e) {
            System.out.println("There are few errors in the testing of Task class");
            System.out.println("Following message could be helpful to identify the cause:");
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void constructorFailsWithInvalidDueDate(){

    }

    @Test
    public void constructorFailsWithInvalidTitle(){
        try {
            item.setTitle("");
        } catch (NullPointerException e) {
            System.out.println("Failed task");
        }
    }

    @Test
    public void constructorSucceedsWithValidDueDate(){
        assertEquals(validDate,item.getDate());
    }

    @Test
    public void constructorSucceedsWithValidTitle(){
        assertEquals(validTitle,item.getTitle());
    }

    @Test
    public void editingDescriptionSucceedsWithExpectedValue(){
        item = new TaskItem("Second","empty", validDate);
        assertEquals(item.des,"empty");
    }

    @Test
    public void editingDueDateFailsWithInvalidDateFormat(){

        try{
            item = new TaskItem(validTitle,validDes,LocalDate.parse("2020-31-12"));
        }catch (DateTimeParseException l){
            System.out.println("Failure");
        }
    }

    @Test
    public void editingDueDateFailsWithInvalidYYYMMDD(){
        try{
            item = new TaskItem(validTitle,validDes,LocalDate.parse("2020-31-12"));
        }catch (DateTimeParseException l){
            System.out.println("Failure");
        }
    }

    @Test
    public void editingDueDateSucceedsWithExpectedValue(){
        try{
            item = new TaskItem(validTitle,validDes,validDate);
        }catch (DateTimeParseException l){
            System.out.println("Failure");
        }
    }

    @Test
    public void editingTitleFailsWithEmptyString(){
        try{
            item = new TaskItem("",validDes,validDate);

        }catch(NullPointerException f){
            System.out.println("Empty String");
        }
    }

    @Test
    public void editingTitleSucceedsWithExpectedValue(){
        try{
            item = new TaskItem("New Name",validDes,validDate);

        }catch(NullPointerException f){
            System.out.println("Empty String");
        }
    }
}
