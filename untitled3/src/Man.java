public class Man extends Human{
    private String man ="Мужчина";
    private String work;
    private boolean worked;

    public void man (String name, int age , short height, String work, boolean worded ){
        super.human(name,age,height);
        this.work = work;
        this.worked = worded;
//        System.out.println(" Человек создан: "+ man + "\n" + getValue());
    }
    public void setValue (String name, int age , short height,String work, boolean worked){
        super.human(name,age,height);
        this.work = work;
        this.worked = worked;
    }
    @Override
    public String getValue(){
        if (worked)
            return " Создан человек: "+ man + "\n" + " Имя: " + name +"\n" + " Возраст " + age + "\n" +
                    " Рост: " + height + "\n" + " Человек работает: " + work +"\n";
        else
            return " Создан человек: "+ man + "\n" + " Имя: " + name +"\n" + " Возраст " + age + "\n" +
                    " Рост: " + height + "\n" + " Человек безработный"+"\n";

    }
}
