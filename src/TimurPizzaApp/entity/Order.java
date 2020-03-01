package TimurPizzaApp.entity;

import TimurPizzaApp.action.PizzaAction;
import TimurPizzaApp.report.PizzaReport;

public class Order{
    int orderId;
    int clientId;
    Pizza[] pizza;

    public Order(int orderId, int clientId, int numberOfTypes){
        this.orderId = orderId;
        this.clientId = clientId;
        this.pizza = new Pizza[numberOfTypes];
        for(int i = 0; i < numberOfTypes; i++) {
            this.pizza[i] = new Pizza();
        }
    }

    public void addPizza(int pizzaID, String name, String type, int amount) {
        PizzaAction action = new PizzaAction();
        action.addNewPizza(pizza[pizzaID-1], name, type, amount, clientId, pizzaID);
    }

    public String attributes() {
        String result = "[" + orderId + ":" + clientId + ":";

        for(int i = 0; i < pizza.length; i++) {
            result += pizza[i].getName() + ":" + pizza[i].getAmount();
            if(i != pizza.length-1) {
                result += ":";
            }
        }
        result += "]";
        return result;
    }

    public void addIngredient(int pizzaID, String ingredient) {
        PizzaAction action = new PizzaAction();
        action.addNewIngredient(pizza[pizzaID-1], ingredient);
    }

    public String toString() {
        PizzaReport rp = new PizzaReport();
        return rp.report(pizza, orderId, clientId);
    }
}