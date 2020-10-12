public class Square extends Shape2D{

    public String name;
    public double area;

    public Square(double size){
        this.name = "square";
        this.area = size*size;
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return area;
    }

}
