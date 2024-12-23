public class Truck extends Transport {
    private boolean isLoaded;
    private boolean New;

    public Truck(String color, float speed, float V, float weight , boolean isLoaded, boolean New) {
        super(color, speed,V,weight);
        this.isLoaded=isLoaded;
        this.New = New;
    }
    public void setValue (String color , float speed, float V, float weight, boolean New, boolean isLoaded){
        super.setValue(color, speed, V, weight);
        this.New=New;
        this.isLoaded=isLoaded;
    }
    @Override
    protected String getValue() {
        System.out.println(super.getValue());
        return getLoaded();
    }
    protected String getValue1() {
        return getLoaded1();
    }
    public void setLoaded(boolean loaded) {
         isLoaded = loaded;
     }
    public String getLoaded() {
        if (isLoaded)
            return "Грузовик Загружен";
        else
            return "Грузовик не загружен";
    }
    public String getLoaded1(){
        if (New)
            return "Грузовик Новый"+"\n";
        else
            return "Грузовик Б/У"+"\n";
    }
}