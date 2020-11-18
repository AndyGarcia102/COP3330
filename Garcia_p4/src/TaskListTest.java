import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskListTest {

    @Test
    public void addingTaskItemsIncreasesSize(){
        String Date = "2020-12-10";
        LocalDate newDate = LocalDate.parse(Date);
        TaskList list = new TaskList();
        list.addTask("name","",newDate);
        list.tasks.size();

        assertEquals(1,list.tasks.size());
    }

    @Test
    public void completingTaskItemChangesStatus(){

    }

    @Test
    public void completingTaskItemFailsWithInvalidIndex(){

    }

    @Test
    public void editingTaskItemChangesValues(){

    }

    @Test
    public void editingTaskItemDescriptionChangesValue(){

    }
}
