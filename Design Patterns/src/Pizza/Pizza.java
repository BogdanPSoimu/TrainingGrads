package Pizza;

/**
 * Created by bsoimu on 7/30/2016.
 */
public abstract class Pizza {

    protected PizzaType type;

    protected Double price;

    public PizzaType getType() {
        return type;
    }

    public Double getPrice() { return  price; }

    public Pizza() {
        this.generatePizza();
    }

    public abstract void generatePizza();
}
