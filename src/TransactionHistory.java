import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistory implements iTransactionHistory {
    private final List<TransactionRecord> history;
    private final String filePath;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    private static final int DATE_INDEX = 0;
    private static final int SUM_INDEX = 0;
    private static final int SELL_CURRENCY_INDEX = 1;
    private static final int OUTCOME_INDEX = 3;
    private static final int BUY_CURRENCY_INDEX = 4;
    private static final int DISPLAY_INDEX = 1;

    public TransactionHistory(String filePath) {
        this.filePath = filePath;
        history = new ArrayList<>();
        loadHistory();
    }

    public void addTransaction(double amount, String fromCurrency, String toCurrency, double result) {
        LocalDateTime dateTime = LocalDateTime.now();
        TransactionRecord record = new TransactionRecord(dateTime, amount, fromCurrency, toCurrency, result);
        history.add(record);
        saveHistory();
    }

    public List<TransactionRecord> getTransactionHistory() {
        return history;
    }

/*    public double exchangeCurrency(int fromCurrencyIndex, int toCurrencyIndex, double amount) {

        return 0;
    }

    public double convertCurrency(double amount, float rateFrom, float rateTo) {
        return amount * (rateTo / rateFrom);
    }

    public List<String> getSupportedCurrencies() {
        return null;
    }*/

    public void printHistory() {
        if (history.isEmpty()) {
            System.out.println("Exchange history is empty.");
        } else {
            for (TransactionRecord record : history) {
                System.out.println(record);
            }
        }
    }

    private void saveHistory() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (TransactionRecord record : history) {
                bw.write(record.toString());
                bw.newLine();
            }
            System.out.println("\nThe history of exchanges is saved to the file: " + filePath);
        } catch (IOException e) {
            System.out.println("Error when saving exchange history: " + e.getMessage());
        }
    }

    private void loadHistory() {


        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                LocalDateTime dateTime = LocalDateTime.parse(parts[DATE_INDEX].trim(), formatter);


                String amountString = parts[DISPLAY_INDEX].trim().split(" ")[SUM_INDEX];
                double amount = Double.parseDouble(amountString.replace(',', '.'));

                String fromCurrency = parts[DISPLAY_INDEX].trim().split(" ")[SELL_CURRENCY_INDEX];
                double result = Double.parseDouble(parts[DISPLAY_INDEX].trim().split(" ")[OUTCOME_INDEX].replace(',', '.'));
                String toCurrency = parts[DISPLAY_INDEX].trim().split(" ")[BUY_CURRENCY_INDEX];

                history.add(new TransactionRecord(dateTime, amount, fromCurrency, toCurrency, result));
            }
            System.out.println("Exchange history loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error when reading exchange history: " + e.getMessage());
        }
    }
}