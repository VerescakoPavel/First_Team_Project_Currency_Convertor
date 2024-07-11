public class CurrencyCalculator implements iCurrencyCalculator {
    @Override
    public double convertedResult(double amount, float rateFrom, float rateTo) {
        return amount * rateTo / rateFrom;
    }


}
