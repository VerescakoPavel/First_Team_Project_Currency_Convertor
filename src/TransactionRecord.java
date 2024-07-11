
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class TransactionRecord {
private final LocalDateTime dateTime;
    private final double amount;
    private final String fromCurrency;
    private final String toCurrency;
    private final double result;


    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");


    public TransactionRecord(LocalDateTime dateTime, double amount, String fromCurrency, String toCurrency, double result) {
        this.dateTime = dateTime;
        this.amount = amount;
        this.fromCurrency = fromCurrency;
        this.toCurrency = toCurrency;
        this.result = result;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public double getAmount() {
        return amount;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public double getResult() {
        return result;
    }

    @Override
    public String toString() {
        return String.format("%s | %.2f %s -> %.2f %s", dateTime.format(formatter), amount, fromCurrency, result, toCurrency);
    }


}
