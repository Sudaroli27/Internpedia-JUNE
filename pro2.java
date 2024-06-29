import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
public class Main {
    private static final Map<String, Double> exchangeRates = new HashMap<>();
    static 
    {
        exchangeRates.put("USD", 1.0); 
        exchangeRates.put("EUR", 0.85); 
        exchangeRates.put("GBP", 0.75); 
        exchangeRates.put("INR", 73.50); 
        exchangeRates.put("JPY", 110.0); 
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter source currency (USD, EUR, GBP, INR, JPY): ");
        String sourceCurrency = scanner.next().toUpperCase();
        System.out.print("Enter target currency (USD, EUR, GBP, INR, JPY): ");
        String targetCurrency = scanner.next().toUpperCase();
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();
        if (!exchangeRates.containsKey(sourceCurrency) || !exchangeRates.containsKey(targetCurrency)) {
            System.out.println("Invalid currency entered.");
            return;
        }
        double convertedAmount = convertCurrency(amount, sourceCurrency, targetCurrency);
        System.out.printf("Converted Amount: %.2f %s%n", convertedAmount, targetCurrency);
        scanner.close();
    }
    private static double convertCurrency(double amount, String sourceCurrency, String targetCurrency) {
        double sourceToUsdRate = exchangeRates.get(sourceCurrency);
        double targetToUsdRate = exchangeRates.get(targetCurrency);
        double amountInUsd = amount / sourceToUsdRate;
        return amountInUsd * targetToUsdRate;
    }
}
