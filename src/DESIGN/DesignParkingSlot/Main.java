package DESIGN.DesignParkingSlot;

public class Main {

    public static void main(String[] args) {
        ParkingSystem park = new ParkingSystem(10 , 5 , 3);
        System.out.println(park.addCar(2));

    }
}

class ParkingSystem {

    int big;
    int medium;
    int small;

    public ParkingSystem(int big, int medium, int small) {
        this.big = big;
        this.medium = medium;
        this.small = small;
    }

    public String addCar(int carType) {
        if (carType == 1 &&  big-- > 0) {
            return "slot available for big car";
        }
        if (carType == 2 &&  medium-- > 0) {
            return "slot available for medium car";
        }
        if (carType == 3 &&  small-- > 0) {
            return "slot available for small car";
        }
        return "slot is not invalid".toString();
    }
}