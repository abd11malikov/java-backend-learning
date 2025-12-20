public class Car {
    String name;
    double motorSize;

    Car(String name, double motorSize){
        this.name = name;
        this.motorSize = motorSize;
    }

    void stage(double newMotorSize){
        motorSize= newMotorSize;
        System.out.println("Motor size changed to "+ newMotorSize);
    }

    public static void main(String[] args) {
        Car car = new Car("BMW",4.4);
        car.stage(5.5);
    }
}
