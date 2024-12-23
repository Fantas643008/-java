    public class Cat extends Animal implements ILight{

    public Heart heart = new Heart();
    protected boolean homeless;
    protected int age;
    private boolean isOn;


    public Cat (String name, String color, Float speed , boolean homeless, int age){
        super(name,color,speed);
        this.homeless = homeless;
        this.age = age;

    }

    public void setValue (String name, String color, float speed,boolean homeless, int age, String view) {
        super.setValue(name, color, speed,view);
        this.homeless = homeless;
        this.age = age;
    }

        @Override
        public void mooveObject(float speed) {
            System.out.println(" Объект двигается со скорость: "+ speed);
        }

        @Override
      protected String getValue (){
        System.out.println(super.getValue());
        return setLoaded();
    }
        protected String getValue1 (){
            return setLoaded1();
    }
    public String setLoaded(){
        if (homeless)
            return " Животное домашнее";
        else
            return " Животное бездомное";
    }
    public String setLoaded1(){
        if (age>5)
            return " Животное взрослое";
        else
            return " Животное молодое";
    }

        @Override
        public void setLight(boolean set) {
            isOn=set;
        }

        @Override
        public void blinkLight() {
            System.out.println("Мы моргаем фарами");
        }
    }
