import java.util.Currency;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyExchangeMenu {

    private static Map<String, Curr> currencies = new HashMap<>();

    static {
        currencies.put("USD", new Curr("USD", 1.0f));
        currencies.put("EUR", new Curr("EUR", 0.92f));
        currencies.put("GBP", new Curr("GBP", 0.78f));
    }

    public static void exchangeMenu() {
        Scanner scanner = new Scanner(System.in);

        String inputCurrencyToSell = printMenuGetInput("sell");
        String inputCurrencyToBuy = printMenuGetInput("buy");
        double amountInput = readCheckAmount();

        Curr currencyToSell = currencies.get(inputCurrencyToSell);
        Curr currencyToBuy = currencies.get(inputCurrencyToBuy);

        if (currencyToSell != null && currencyToBuy != null) {
            CurrencyCalculator calculator = new CurrencyCalculator();

            double result = calculator.toConvert(amountInput, currencyToSell.getRate(), currencyToBuy.getRate());
            String convertedAmount = String.format("%.2f", result);
            System.out.println(amountInput + currencyToSell.getName() + " -> " + convertedAmount + currencyToBuy.getName());
            System.out.println("_____________________________________________________");
            System.out.println();
        } else
            System.out.println("Invalid input");
    }

    public static String printMenuGetInput(String actionSellOrBuy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Pls choose currency you want to " + actionSellOrBuy + " (Text only)");
        System.out.println("Available currencies : ");
        for (String key : currencies.keySet()) {
            System.out.println(key);
        }
        System.out.println();

        String result;
        while (true) {
            result = scanner.nextLine().toUpperCase();
            if (currencies.containsKey(result))
                break;
            else
                System.out.println("Invalid input. Pls enter 3 letters code only");
        }
        return result;
    }

    public static double readCheckAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pls Enter amount: ");
        double amount = scanner.nextDouble();

        return ((amount > 0) ? amount : readCheckAmount());

    }
}
