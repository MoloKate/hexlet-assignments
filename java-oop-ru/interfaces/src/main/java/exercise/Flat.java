package exercise;

// BEGIN
public class Flat implements Home {
    private double area;
    private double balconyArea;
    private int floor;
    public Flat (double area, double balconyArea, int floor){
        this.area =area;
        this.balconyArea = balconyArea;
        this.floor = floor;
    }

    @Override
    public int compareTo(Home another) {
        Double fullArea = area + balconyArea;
        return fullArea.compareTo(another.getArea());
    }

    @Override
    public double getArea() {
        double generalArea = area + balconyArea;
        return generalArea;
    }

    @Override
    public String toString() {
        return "Квартира площадью " + getArea() + " метров на " + floor + " этаже";
    }
}

// END
