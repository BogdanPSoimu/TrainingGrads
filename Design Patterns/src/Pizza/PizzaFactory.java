package Pizza;

/**
 * Created by bsoimu on 7/30/2016.
 */
public class PizzaFactory {

    public static Pizza getPizza(PizzaType pizzaType) {
        switch (pizzaType) {
            case DELUXE:
                return new DeluxePizza();
            case HAMANDMUSHROOM:
                return new HamAndMushroomPizza();
            case PROSCIUTTO:
                return new ProsciuttoPizza();
            default:
                return null;
        }
    }
}
