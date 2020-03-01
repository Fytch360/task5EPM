package TimurPizzaApp.action;

public class PizzaMargarita {
    public static String[] defaultIngredients(String name) {
        String[] setThis = new String[4];
        if(name.equals("Margarita")) {
            setThis[0] = "Tomato paste";
            setThis[1] = "Pepper";
            setThis[2] = "Garlic";
            setThis[3] = "Bacon";
        } else {
            setThis[0] = "Tomato paste";
            setThis[1] = "Cheese";
            setThis[2] = "Salami";
            setThis[3] = "Olives";
        }
        return setThis;
    }
}
