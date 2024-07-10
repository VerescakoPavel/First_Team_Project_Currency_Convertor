public class Currency {
    public String currencyName;
    public static final float USD_TO_EUR = 0.92f;
    public static final float USD_TO_GBP = 0.78f;
    public static final float EUR_TO_GBP = 1 / (USD_TO_EUR / USD_TO_GBP);
    public static final float EUR_TO_USD = 1 / USD_TO_EUR;
    public static final float GBP_TO_USD = 1 / USD_TO_GBP;
    public static final float GBP_TO_EUR = 1 / EUR_TO_GBP;
    public Currency(String currencyName) {
        this.currencyName = currencyName;
    }

    public String getCurrencyName() {
        return currencyName;
    }

    public void setCurrencyName(String currencyName) {
        this.currencyName = currencyName;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "currencyName='" + currencyName + '\'' +
                '}';
    }
}
