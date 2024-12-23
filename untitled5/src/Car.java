public class Car {

    final String model;
    String color;
    double fuelConsumtion;
    final int volume;
    int fuelLevel;

    Car(String model, String color, double fuelConsumtion, int volume, int fuelLevel) {
        this.model = model;
        this.color = color;
        this.fuelConsumtion = fuelConsumtion;
        this.volume = volume;
        this.fuelLevel = fuelLevel;
    }
    void move(int x1, int y1, int x2 , int y2) {
        double path = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
//        double newPath = Math.round(path *10.0)/10.0;
        fuelLevel = (int) (fuelLevel - path / 100 * fuelConsumtion);
        if (fuelLevel <= 0){
            System.out.println(" Автомобиль марки: " + model + " не доехал , пора заправиться.");
        fuelLevel = 0;
    }
       else
       System.out.println(" Автомобиль марки: " + model + " проехал : " + Math.round(path*10.0)/10.0 + " Км и осталось: " + fuelLevel + " литра." );
    }
    void reFuel (int  liters){
        fuelLevel += liters;
        if (fuelLevel>volume) {
            int backFuel = liters-volume;
            System.out.println(" " +  model + " Бензин льется чрез край, мы пролили : " + backFuel + " литров." );
            fuelLevel = volume;
        }
        else
            System.out.println( " " + model + " Заправились на" + " " + liters + " литров, теперь у нас: " + fuelLevel + " литров.");

    }
}
