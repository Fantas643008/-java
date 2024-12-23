
public abstract class Animal {

    private String name;
    private String color;
    private float speed;
    private String view;

    public Animal (String name , String color, float speed ){
        this.name = name;
        this.color = color;
        this.speed = speed;
        System.out.println(" Животное создано:" );
//        System.out.println(getValue());
    }
    public abstract void mooveObject(float speed);

    protected void setValue (String name, String color, float speed, String view){
        this.name = name;
        this.color = color;
        this.speed = speed;
        this.view = view;
    }
    protected String getValue (){
        String info = " Вид животного: " + view + "\n" + " Имя животного: "  + name +"\n" +" Цвет животного: " + color + "\n" +" Скорость животного: " + speed;
        return info;

    }

    class Heart{
        private boolean isReady;
        private int age;

        public void setValues (boolean isReady,int age){
            this.isReady=isReady;
            this.age=age;
        }
        public void isReady(boolean isReady){
            this.isReady=isReady;
        }

        public void info(){
            if(isReady)
                System.out.println(" Сердце бьется" + "\n" );
            else
                System.out.println(" Сердце не бьется , оно качало кровь " + age + "лет" + "\n");
        }


    }



    }

