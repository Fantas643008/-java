
public class Main {
    public static void main(String[] args) {

        Car Toyota = new Car("Черный",240,2.5f,2000f, 2000,true,true);
        Toyota.setValue("Голубой",340,3.5f,2500f, 20000,true,true);
        System.out.println(Toyota.getValue()+"\n" + Toyota.getValue1());

        Truck truck = new Truck("Белый", 120,4.5f,5000, true,true);
        truck.setValue("Черный", 150,8.5f,9000, true,false);
        System.out.println(truck.getValue()+"\n"+truck.getValue1());



    }
}