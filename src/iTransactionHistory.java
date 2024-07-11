
import java.util.List;

public interface iTransactionHistory {
    void addTransaction(double amount, String fromCurrency, String toCurrency, double result);
    List<TransactionRecord> getTransactionHistory();
}
