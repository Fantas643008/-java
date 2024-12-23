public class Main {
    public static void main(String[] args) {

        Man danila = new Man();
        Man iliya = new Man();
        danila.setValue("Данила",24,(short) 188,"Риэлтор",true);
        iliya.setValue("Илья",24,(short) 178,"Накроман",true);
        Woman nastya = new Woman();
        nastya.setValue("Настя", 27,(short)161,10,true);
        System.out.println(danila.getValue());
        System.out.println(iliya.getValue());
        System.out.println(nastya.getValue());
    }
}




