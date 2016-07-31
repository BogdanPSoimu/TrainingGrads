package Pizza;

/**
 * Created by bsoimu on 7/30/2016.
 */
public class PizzaDemo {

    public static void main(String[] args) {

        Pizza deluxePizza = PizzaFactory.getPizza(PizzaType.DELUXE);
        System.out.println("Deluxe Pizza: " + deluxePizza.getType() + ", Price: " + deluxePizza.getPrice());

        Pizza hamAndMushroomPizza = PizzaFactory.getPizza(PizzaType.HAMANDMUSHROOM);
        System.out.println("Ham And Mushroom Pizza: " + hamAndMushroomPizza.getType() + ", Price: " + hamAndMushroomPizza.getPrice());

        Pizza prosciuttoPizza = PizzaFactory.getPizza(PizzaType.PROSCIUTTO);
        System.out.println("Prosciutto Pizza: " + prosciuttoPizza.getType() + ", Price: " + prosciuttoPizza.getPrice());
    }
}
