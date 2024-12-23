public class Woolf extends Animal {

    protected boolean whild;
    protected int age;
    public Heart heart = new Heart();

    public Woolf (String name, String color, Float speed , boolean homeless, int age){
        super(name,color,speed);
        this.whild = homeless;
        this.age = age;

    }
    public void setValue (String name, String color, float speed,boolean homeless, int age,String view) {
        super.setValue(name, color, speed,view);
        this.whild = homeless;
        this.age = age;
    }

    @Override
    public void mooveObject(float speed) {
        System.out.println("Объект двигается со скорость: "+ speed);
    }

    @Override
    protected String getValue (){
        System.out.println(super.getValue());
        return setLoaded();
    }
    protected String getValue1 (){
        return setLoaded1();}

    public String setLoaded(){
        if (!whild)
            return " Животное дикое";
        else
            return " Животное не дикое";
    }
    public String setLoaded1(){
        if (age>5)
            return " Животное взрослое";
        else
            return " Животное молодое";
    }

}