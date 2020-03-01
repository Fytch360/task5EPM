package TimurPizzaApp.entity;


public class Pizza {
    private String name;
    private String[] ingredients;
    private String type;
    private int amount;

    public Pizza() {
        setName("");
        setType("");
        setAmount(0);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public float getPrice(String[] ingredients, int i) {
        float result = 0.0f;
        if(ingredients[i].equals("Tomato paste")) {
            result = 1.00f;
        } else if(ingredients[i].equals("Cheese")) {
            result = 1.00f;
        } else if(ingredients[i].equals("Salami")) {
            result = 1.50f;
        } else if(ingredients[i].equals("Bacon")) {
            result = 1.20f;
        } else if(ingredients[i].equals("Garlic")) {
            result = 0.30f;
        } else if(ingredients[i].equals("Corn")) {
            result = 0.70f;
        } else if(ingredients[i].equals("Pepper")) {
            result = 0.60f;
        } else if(ingredients[i].equals("Olives")) {
            result = 0.50f;
        }
        return result;
    }
}