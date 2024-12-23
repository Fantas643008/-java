public class Woman extends Human{
    private String woman ="Женщина";
    private int workInTheKitchen;
    private boolean worked;

    public void woman (String name, int age , short height, int workInTheKitchen, boolean worded ){
        super.human(name,age,height);
        this.workInTheKitchen = workInTheKitchen;
        this.worked = worded;
//        System.out.println(" Человек создан: "+ man + "\n" + getValue());
    }
    public void setValue (String name, int age , short height,int workInTheKitchen, boolean worked){
        super.human(name,age,height);
        this.workInTheKitchen = workInTheKitchen;
        this.worked = worked;
    }
    @Override
    public String getValue(){
        if (worked)
            return " Создан человек: "+ woman + "\n" + " Имя: " + name +"\n" + " Возраст " + age + "\n"
                    + " Рост: " + height + "\n " + name + " работает на кухне: " + workInTheKitchen + " лет"+ "\n";
        else
            return " Создан человек: "+ woman + "\n" + " Имя: " + name +"\n" + " Возраст " + age + "\n"
                    + " Рост: " + height + "\n" + " Человек безработный"+"\n";

    }
}
