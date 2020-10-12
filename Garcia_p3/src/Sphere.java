public class Sphere extends Shape3D{
    public String name;
    public double area;
    public double volume;

    //Get the respected values of a sphere for some reason thought (4/3) was not registering so i used 1.3
    public Sphere(double r){
        this.name = "sphere";
        this.area = 4 * Math.PI * (r*r);
        this.volume = (Math.PI*Math.pow(r,3))*(1.33333333333333333333333333);

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
