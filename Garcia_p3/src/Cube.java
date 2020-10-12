public class Cube extends Shape3D{
    public String name;
    public double area;
    public double volume;

    public Cube(double size){
        this.name = "cube";
        this.area = size*size;
        this.volume = area*size;
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        area *= 6;
        return area;
    }

    public double getVolume(){
        return volume;
    }
}
