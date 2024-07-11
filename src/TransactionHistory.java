import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistory {
    private final List<TransactionRecord> history;
    private final String filePath;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

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
                LocalDateTime dateTime = LocalDateTime.parse(parts[0].trim(), formatter);


                String amountString = parts[1].trim().split(" ")[0];
                double amount = Double.parseDouble(amountString.replace(',', '.'));

                String fromCurrency = parts[1].trim().split(" ")[1];
                double result = Double.parseDouble(parts[1].trim().split(" ")[3].replace(',', '.'));
                String toCurrency = parts[1].trim().split(" ")[4];

                history.add(new TransactionRecord(dateTime, amount, fromCurrency, toCurrency, result));
            }
            System.out.println("Exchange history loaded successfully.");
        } catch (IOException e) {
            System.out.println("Error when reading exchange history: " + e.getMessage());
        }
    }
}