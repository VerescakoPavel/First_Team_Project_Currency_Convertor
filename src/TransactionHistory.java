/*
import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class TransactionHistory implements iTransactionHistory, CurrencyCalculator {
    private final List<TransactionRecord> history;
    private final String filePath;
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    public TransactionHistory(String filePath) {
        this.filePath = filePath;
        history = new ArrayList<>();
        loadHistory();
    }

    @Override
    public void addTransaction(double amount, String fromCurrency, String toCurrency, double result) {
        LocalDateTime dateTime = LocalDateTime.now();
        TransactionRecord record = new TransactionRecord(dateTime, amount, fromCurrency, toCurrency, result);
        history.add(record);
        saveHistory();
    }

    @Override
    public List<TransactionRecord> getTransactionHistory() {
        return history;
    }

    @Override
    public double exchangeCurrency(int fromCurrencyIndex, int toCurrencyIndex, double amount) {
        return 0;
    }

    @Override
    public double convertCurrency(double amount, float rateFrom, float rateTo) {
        return amount * (rateTo / rateFrom);
    }

    @Override
    public List<String> getSupportedCurrencies() {
        return null;
    }

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

                bw.newLine();
            }
            System.out.println("\n" +
                    "The history of exchanges is saved to the file:" + filePath);
        } catch (IOException e) {
            System.out.println("Error when saving exchange history:" + e.getMessage());
        }
    }

    private void loadHistory() {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                LocalDateTime dateTime = LocalDateTime.parse(parts[0], formatter);
                double amount = Double.parseDouble(parts[1]);
                String fromCurrency = parts[2];
                String toCurrency = parts[3];
                double result = Double.parseDouble(parts[4]);
                history.add(new TransactionRecord(dateTime, amount, fromCurrency, toCurrency, result));
            }
        } catch (IOException e) {
            System.out.println("Error when reading exchange history:" + e.getMessage());
        }
    }
}*/
