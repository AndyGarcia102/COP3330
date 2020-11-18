import org.junit.Test;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import static org.junit.jupiter.api.Assertions.*;

public class TaskItemTest {



    @Test
    public void creatingTaskItemFailsWithInvalidDueDate(){
        String Date = "00-00";
        LocalDate newDate = LocalDate.parse(Date);
        assertThrows(DateTimeParseException.class,()-> new TaskItem("name","",newDate));
    }

    @Test
    public void creatingTaskItemFailsWithInvalidTitle(){
        String Date = "2020-12-10";
        LocalDate newDate = LocalDate.parse(Date);
        assertThrows(NullPointerException.class,()-> new TaskItem("","",newDate));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidDueDate(){
        String Date = "2020-12-10";
        LocalDate newDate = LocalDate.parse(Date);
        assertDoesNotThrow(DateTimeParseException.class,()-> new TaskItem("name","",newDate));
    }

    @Test
    public void creatingTaskItemSucceedsWithValidTitle(){
        String Date = "2020-12-10";
        LocalDate newDate = LocalDate.parse(Date);
        assertDoesNotThrow(NullPointerException.class,()-> new TaskItem("name","",newDate));
    }



}
