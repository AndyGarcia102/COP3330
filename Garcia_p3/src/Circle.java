public class Circle extends Shape2D{
    public String name;
    public double area;

    public Circle(double r){
        this.name = "circle";
        this.area = Math.PI * (r*r);
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return area;
    }
}
