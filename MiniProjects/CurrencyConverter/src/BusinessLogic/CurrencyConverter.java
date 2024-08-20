package BusinessLogic;

import java.util.HashMap;
import java.util.Map;

public class CurrencyConverter {
    private static final Map<String, Double> exchangeRates = new HashMap<>();

    static {
        // Static conversion rates (example rates)
        exchangeRates.put("USD_EUR", 0.85);
        exchangeRates.put("USD_JPY", 110.0);
        exchangeRates.put("EUR_USD", 1.18);
        exchangeRates.put("EUR_JPY", 129.0);
        exchangeRates.put("JPY_USD", 0.0091);
        exchangeRates.put("JPY_EUR", 0.0078);
    }

    public static double convert(double amount, String fromCurrency, String toCurrency) throws Exception {
        if (fromCurrency.equals(toCurrency)) {
            return amount; // No conversion needed if currencies are the same
        }

        String key = fromCurrency + "_" + toCurrency;
        Double conversionRate = exchangeRates.get(key);

        if (conversionRate == null) {
            throw new Exception("Conversion rate not found for " + key);
        }

        return amount * conversionRate;
    }
}
