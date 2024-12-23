public class Car extends Transport {
    private boolean New;
    private float price;
    private boolean go;

    public Car(String color, float speed, float V, float weight, float price, boolean New, boolean go) {
        super(color, speed, V, weight);
        this.price = price;
        this.New = New;
        this.go = go;
    }
    public void setValue(String color, float speed, float V, float weight, float price, boolean New, boolean go) {
        super.setValue(color, speed, weight, V);
        this.price = price;
        this.New = New;
        this.go = go;
    }
    @Override
    protected String getValue() {
        System.out.println(super.getValue());
        return getNew();
    }
    protected String getValue1() {
        return getNew1();
    }
    public void setNew(boolean neww) {
        New = neww;
    }
    public String getNew() {
        if (New && price > 1000)
            return "Машина новая";
        else
            return "Машина Б/у";
    }
    public String getNew1(){
        if (go)
            return "Машина готова к поездке"+"\n";
        else
            return "Машина не готова к поездке"+"\n";
    }
        }
