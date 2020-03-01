package TimurPizzaApp.valid;
import TimurPizzaApp.entity.Pizza;
import java.util.Arrays;

public class PizzaValidator {
    private static final int NAME_MIN_LENGTH = 4;
    private static final int NAME_MAX_LENGTH = 20;
    private static final int UPPER_CASE_A_ASCII = 65;
    private static final int UPPER_CASE_Z_ASCII = 90;
    private static final int LOWER_CASE_A_ASCII = 97;
    private static final int LOWER_CASE_Z_ASCII = 122;
    private static final int MIN_PIZZA_AMOUNT = 0;
    private static final int MAX_PIZZA_AMOUNT = 10;
    private static final int MAX_INGREDIENTS_AMOUNT = 7;
    public boolean checkName(String name) {
        boolean isFine = name.length() >= NAME_MIN_LENGTH && name.length() <= NAME_MAX_LENGTH;
        if(!isFine) {
            return isFine;
        }

        int i = 0;
        while(i != name.length()) {
            isFine = (int) name.charAt(i) >= UPPER_CASE_A_ASCII && (int) name.charAt(i) <= UPPER_CASE_Z_ASCII
                    || (int) name.charAt(i) >= LOWER_CASE_A_ASCII && (int) name.charAt(i) <= LOWER_CASE_Z_ASCII;
            if(!isFine) {
                break;
            }
            i++;
        }
        return isFine;
    }

    public static boolean checkAmount(int amount) {
        return amount>=MIN_PIZZA_AMOUNT && amount<=MAX_PIZZA_AMOUNT;
    }

    public static boolean checkIngredients(String ingredient, Pizza pz) {
        boolean result = true;

        // if there are already 7 ingredients
        if(pz.getIngredients().length >= MAX_INGREDIENTS_AMOUNT) {
            return false;
        }

        // checks if such ingredient exists
        if(!(ingredient.equals("Cheese") || ingredient.equals("Salami")
                || ingredient.equals("Bacon") || ingredient.equals("Garlic")
                || ingredient.equals("Corn") || ingredient.equals("Pepper")
                || ingredient.equals("Olives"))) {
            return false;
        }

        // checks if pizza already contains the ingredient
        boolean isContain = Arrays.asList(pz.getIngredients()).contains(ingredient);
        if(isContain) {
            return false;
        }
        return result;
    }
}
