package Pizza;

/**
 * Created by bsoimu on 7/30/2016.
 */
public class ProsciuttoPizza extends Pizza {

    @Override
    public void generatePizza() {
        type = PizzaType.PROSCIUTTO;
        price = 14.66;
    }
}
