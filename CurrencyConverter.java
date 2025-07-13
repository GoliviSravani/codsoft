package javatasks.com;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Static exchange rates (base currency: USD)
        Map<String, Double> rates = new HashMap<>();
        rates.put("USD", 1.0);      // US Dollar
        rates.put("INR", 83.12);    // Indian Rupee
        rates.put("EUR", 0.91);     // Euro
        rates.put("GBP", 0.78);     // British Pound
        rates.put("JPY", 157.34);   // Japanese Yen

        System.out.println("=== Currency Converter ===");
        System.out.println("Available currencies: USD, INR, EUR, GBP, JPY");

        System.out.print("Enter base currency: ");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.print("Enter target currency: ");
        String targetCurrency = scanner.next().toUpperCase();

        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();

        // Validate currencies
        if (!rates.containsKey(baseCurrency) || !rates.containsKey(targetCurrency)) {
            System.out.println("Unsupported currency.");
        } else {
            // Convert: first convert base to USD, then USD to target
            double amountInUSD = amount / rates.get(baseCurrency);
            double convertedAmount = amountInUSD * rates.get(targetCurrency);

            System.out.printf(" %.2f %s = %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
        }

        scanner.close();
    }

}
