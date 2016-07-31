package Pizza;

/**
 * Created by bsoimu on 7/30/2016.
 */
public class HamAndMushroomPizza extends Pizza {

    @Override
    public void generatePizza() {
        type = PizzaType.HAMANDMUSHROOM;
        price = 10.99;
    }
}
