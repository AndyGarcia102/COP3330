public class Triangle extends Shape2D{

    public String name;
    public double area;

    public Triangle(double b, double h){
        this.name = "triangle";
        this.area = (b*h)/2;
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return area;
    }

}
