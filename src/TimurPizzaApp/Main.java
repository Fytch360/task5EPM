package TimurPizzaApp;
import TimurPizzaApp.entity.Order;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        PrintWriter out = new PrintWriter(new FileWriter("src/TimurPizzaApp/bill.txt"));

        Order firstOrder = new Order(10001, 7717, 2);
        firstOrder.addPizza(1, "Margarita", "Calzone", 2);
        firstOrder.addPizza(2, "PepperoniOro", "Common", 3);
        firstOrder.addIngredient(1, "Corn");

        Order secondOrder = new Order(10002, 4372, 1);
        secondOrder.addPizza(1, "BasePZZ", "Common", 9);
        out.println(firstOrder);
        out.println(secondOrder);
        out.close();

    }
}
