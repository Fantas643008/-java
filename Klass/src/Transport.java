
public class Transport {

    private String color;
    private float speed;
    private float V;
    private float weight;

    public Transport(String color , float speed, float V, float weight) {
        this.color = color;
        this.speed = speed;
        this.V=V;
        this.weight=weight;
        System.out.println("Транспорт создан:");
//        System.out.println(getValue());
    }
    protected void setValue(String color , float speed, float V, float weight){
        this.speed = speed;
        this.V = V;
        this.weight = weight;
        this.color = color;

    }
    protected String getValue () {
        String info = " Цвет: " + color +"\n" + " Вес: " + weight+"\n" + " Объем двигателя: " + V+" Литра"+ "\n" + " MAX Скорость: " + speed + "\n";
        return info;
        }
}
