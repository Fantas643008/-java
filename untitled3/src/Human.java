public class Human {

    protected String name;
    protected int age;
    protected short height;

    public void human (String name,int age,short height) {
       this.name = name;
       this.age = age;
       this.height = height;
//        System.out.println(" Человек создан " +"\n" + getValue());

    }
    public void setValue (String name, int age, short height){
        this.name = name;
        this.age = age;
        this.height = height;
    }
    public String getValue (){
        String result =" Имя: " +name +"\n"+" Лет: "+ age+"\n" + " Рост: " + height;
        return result;
    }

}
