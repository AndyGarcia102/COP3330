import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class TaskItem {
    public String title;
    public String des;
    public LocalDate Date;
    public boolean comp;

    public TaskItem(String title, String des, LocalDate Date){
        this.setTitle(title);
        this.setDes(des);
        this.setDate(Date);
        this.comp = false;
    }


    public void setTitle(String title){

        if(title.trim().equals("")){
            throw new NullPointerException("Warning: title must be at least 1 character long; task not created");
        }
        this.title = title.trim();
    }

    public void setDate(LocalDate date) {
        if(date.compareTo(LocalDate.now())<0 ){
            throw new DateTimeException("Warning: invalid due date; task not created");
        }
        DateTimeFormatter formattedDate = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        this.Date = LocalDate.parse(date.format(formattedDate));
    }

    public void setDes(String des){
        this.des = des.trim();
    }


    public String getTitle() {
        return this.title;
    }

    public LocalDate getDate(){
        return this.Date;
    }

    public String getDes() {
        return this.des;
    }

    public boolean isComp(){
        return this.comp;
    }

    public boolean unfinished(){
        return this.comp = false;
    }

    public boolean finished(){
        return this.comp = true;
    }

}