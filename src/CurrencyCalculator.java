public class CurrencyCalculator implements iCurrencyCalculator {
    @Override
    public double toConvert(double amount, float rateFrom, float rateTo) {
        return amount * rateTo / rateFrom;
    }


}
