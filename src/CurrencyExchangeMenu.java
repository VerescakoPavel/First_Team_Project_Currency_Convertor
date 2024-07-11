
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyExchangeMenu {
    private static final Map<String, Currency> currencies = new HashMap<>();
    private final CurrencyCalculator calculator;
    static {
        currencies.put("USD", new Currency("USD", 1.0f));
        currencies.put("EUR", new Currency("EUR", 0.92f));
        currencies.put("GBP", new Currency("GBP", 0.78f));
        currencies.put("RUB", new Currency("RUB", 76f));
    }

    public CurrencyExchangeMenu() {
        calculator = new CurrencyCalculator();
    }

    public void exchangeMenu(TransactionHistory transactionHistory) {

        Scanner scanner = new Scanner(System.in);

        String inputCurrencyToSell = printMenuGetInput("sell");
        String inputCurrencyToBuy = printMenuGetInput("buy");
        double amountInput = readCheckAmount();

        Currency currencyToSell = currencies.get(inputCurrencyToSell);
        Currency currencyToBuy = currencies.get(inputCurrencyToBuy);

        if (currencyToSell != null && currencyToBuy != null) {

            double result = calculator.convertedResult(amountInput, currencyToSell.getRate(), currencyToBuy.getRate());
            String convertedAmount = String.format("%.2f", result); //
            System.out.println(amountInput + currencyToSell.getName() + " -> " + convertedAmount + currencyToBuy.getName());


            transactionHistory.addTransaction(amountInput, currencyToSell.getName(), currencyToBuy.getName(), result);

            System.out.println("_____________________________________________________");
            System.out.println();
        } else {
            System.out.println("Invalid input");
        }
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
            if (currencies.containsKey(result)) {
                break;
            } else {
                System.out.println("Invalid input. Pls enter 3 letters code only");
            }
        }
        return result;
    }

    public static double readCheckAmount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pls Enter amount: ");
        double amount = scanner.nextDouble();

        return (amount > 0) ? amount : readCheckAmount();
    }
}