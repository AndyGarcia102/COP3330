public class Pyramid extends Shape3D{
    public String name;
    public double area;
    public double volume;

    public Pyramid(double l, double w, double h){
        this.name = "pyramid";
        this.area = l*w + l*(Math.sqrt(Math.pow((w/2),2) + (h*h))) + w*(Math.sqrt(((l*l)/4)+(h*h))) ;
        this.volume = (l*w*h)/3;
    }

    public String getName(){
        return name;
    }

    public double getArea(){
        return area;
    }

    public double getVolume(){
        return volume;
    }
}
