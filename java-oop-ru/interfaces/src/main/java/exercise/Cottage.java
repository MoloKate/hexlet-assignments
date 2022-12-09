package exercise;

// BEGIN
public class Cottage implements Home {
    private Double area;
    private int floorCount;

    public Cottage(double area, int floorCount) {
        this.area = area;
        this.floorCount = floorCount;
    }

    @Override
    public String toString() {
        return floorCount + " этажный коттедж площадью " + area.toString().replace(',' , '.')
                + " метров";
    }

    @Override
    public int compareTo(Home another) {
       return area.compareTo(another.getArea());
    }

    @Override
    public double getArea() {
        return area;
    }

}
// END
