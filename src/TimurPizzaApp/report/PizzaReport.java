package TimurPizzaApp.report;

import TimurPizzaApp.entity.Pizza;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class PizzaReport {
    private static final float INITIAL_VAL = 0.0f;
    private static final float PIZZA_BASE_CALZONE = 1.50f;
    private static final float PIZZA_BASE_COMMON = 1.00f;

    public String report(Pizza[] pizza, int orderId, int clientId) {
        String time = new SimpleDateFormat("dd.MM.yyyy  HH:mm:ss").format(Calendar.getInstance().getTime());
        String result = "\n\n********************************\n";
        result += "Заказ: " + orderId + "\n";
        result += "Клиент: " + clientId + "\n";
        result += time + "\n";

        // for() => each pizza
        float overall = INITIAL_VAL;
        for (int i = 0; i < pizza.length; i++) {
            result += "Название: " + pizza[i].getName() + "\n";
            result += "--------------------------------\n";

            float sum = INITIAL_VAL;
            if (pizza[i].getType().equals("Calzone")) {
                String part1 = String.format("%-21s", "Pizza Base (Calzone) ");
                String part2 = String.format("%13s", String.format("%.2f", PIZZA_BASE_CALZONE).replace('.', ',') + " €\n");
                result += part1 + part2;
                sum += PIZZA_BASE_CALZONE;
            } else {
                String part1 = String.format("%-21s", "Pizza Base ");
                String part2 = String.format("%13s", String.format("%.2f", PIZZA_BASE_COMMON).replace('.', ',') + " €\n");
                result += part1 + part2;
                sum += PIZZA_BASE_COMMON;
            }

            // for() => each ingredient with a price
            for (int j = 0; j < pizza[i].getIngredients().length; j++) {
                String part1 = String.format("%-21s", pizza[i].getIngredients()[j] + " ");
                String part2 = String.format("%13s", String.format("%.2f", pizza[i].getPrice(pizza[i].getIngredients(), j)).replace('.', ',') + " €\n");
                result += part1 + part2;
                sum += pizza[i].getPrice(pizza[i].getIngredients(), j);
            }

            result += "--------------------------------\n";
            String part1 = String.format("%-21s", "Всего: ");
            String part2 = String.format("%13s", String.format("%.2f", sum).replace('.', ',') + " €\n");
            result += part1 + part2;
            part1 = String.format("%-21s", "Кол-во: ");
            part2 = String.format("%13s", pizza[i].getAmount() + "\n");
            result += part1 + part2;
            result += "--------------------------------\n";
            overall += sum * pizza[i].getAmount();
        }
        String part1 = String.format("%-21s", "Общая сумма: ");
        String part2 = String.format("%13s", String.format("%.2f", overall).replace('.', ',') + " €\n");
        result += part1 + part2;
        result += "********************************\n\n";
        return result;
    }
}