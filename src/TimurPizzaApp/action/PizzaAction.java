package TimurPizzaApp.action;
import TimurPizzaApp.entity.Pizza;
import TimurPizzaApp.valid.PizzaValidator;

public class PizzaAction {
    public void addNewIngredient(Pizza pz, String ingredient) {
        PizzaValidator isValid = new PizzaValidator();
        if(!isValid.checkIngredients(ingredient, pz)) {
            throw new IllegalArgumentException("Such ingredient cannot be added!");
        }

        String[] pizzaIngredients = pz.getIngredients();
        String[] newIngredients = new String[pizzaIngredients.length+1];
        System.arraycopy(pizzaIngredients, 0, newIngredients, 0, pizzaIngredients.length);
        newIngredients[pizzaIngredients.length] = ingredient;
        pz.setIngredients(newIngredients);
    }

    public void addNewPizza(Pizza pizza, String name, String type, int amount, int clientId, int pizzaId) {
        PizzaValidator isValid = new PizzaValidator();

        if(!isValid.checkAmount(amount)) {
            throw new IllegalArgumentException("Not TimurPizzaApp.valid amount for " + name);
        }

        if(isValid.checkName(name)) {
            pizza.setName(name);
        } else {
            pizza.setName(clientId + "_" + pizzaId);
        }

        pizza.setType(type);
        pizza.setAmount(amount);

        PizzaMargarita whatPizza = new PizzaMargarita();
        pizza.setIngredients(whatPizza.defaultIngredients(pizza.getName()));
    }
}