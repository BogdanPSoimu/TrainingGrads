package Pizza;

/**
 * Created by bsoimu on 7/30/2016.
 */
public class DeluxePizza extends Pizza {

    @Override
    public void generatePizza() {
        type = PizzaType.DELUXE;
        price = 20.00;
    }
}
