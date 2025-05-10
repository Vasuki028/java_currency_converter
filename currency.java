import java.util.HashMap; 
import java.util.Map; 
import java.util.Scanner; 
class CurrencyConverter { 
private Map<String, Double> exchangeRates; 
public CurrencyConverter() { 
this.exchangeRates = new HashMap<>(); 
initializeExchangeRates(); 
} 
private void initializeExchangeRates() { 
exchangeRates.put("USD", 1.0); 
exchangeRates.put("EUR", 0.85); 
exchangeRates.put("GBP", 0.73); 
exchangeRates.put("JPY", 109.27); 
exchangeRates.put("INR", 83.22);  
} 
public void updateExchangeRate(String currencyCode, double newRate) { 
if (exchangeRates.containsKey(currencyCode)) { 
exchangeRates.put(currencyCode, newRate); 
System.out.println("Exchange rate updated successfully for " + currencyCode); 
} else { 
System.out.println("Invalid currency code. Unable to update exchange rate."); 
} 
} 
public double convertCurrency(double amount, String fromCurrency, String toCurrency) { 
if (exchangeRates.containsKey(fromCurrency) && 
exchangeRates.containsKey(toCurrency)) { 
double fromRate = exchangeRates.get(fromCurrency); 
double toRate = exchangeRates.get(toCurrency); 
return (amount / fromRate) * toRate; 
} else { 
System.out.println("Invalid currency code(s). Unable to perform conversion."); 
return -1.0; 
} 
} 
public void displayExchangeRates() { 
System.out.println("Current Exchange Rates:"); 
for (Map.Entry<String, Double> entry : exchangeRates.entrySet()) { 
System.out.println(entry.getKey() + ": " + entry.getValue()); 
} 
} 
} 
public class currency { 
public static void main(String[] args) { 
Scanner scanner = new Scanner(System.in); 
CurrencyConverter currencyConverter = new CurrencyConverter(); 
while (true) { 
System.out.println("\nAdvanced Currency Converter Menu:"); 
System.out.println("1. Convert Currency"); 
System.out.println("2. Display Exchange Rates"); 
System.out.println("3. Update Exchange Rate"); 
System.out.println("4. Exit"); 
System.out.print("Enter your choice: "); 
int choice = scanner.nextInt(); 
scanner.nextLine();  
switch (choice) { 
case 1: 
System.out.print("Enter the amount to convert: "); 
double amount = scanner.nextDouble(); 
scanner.nextLine();  
System.out.print("Enter the currency code to convert from (e.g., USD): "); 
String fromCurrency = scanner.nextLine().toUpperCase(); 
System.out.print("Enter the currency code to convert to (e.g., EUR): "); 
String toCurrency = scanner.nextLine().toUpperCase(); 
double convertedAmount = currencyConverter.convertCurrency(amount,          
fromCurrency, toCurrency); 
if (convertedAmount != -1.0) { 
System.out.println("Converted Amount: " + convertedAmount + " " + 
toCurrency); 
} 
break; 
case 2: 
currencyConverter.displayExchangeRates(); 
break;
case 3: 
System.out.print("Enter the currency rate (e.g., USD): ");
String updateCurrency = scanner.nextLine().toUpperCase(); 
System.out.print("Enter the new exchange rate: "); 
double newRate = scanner.nextDouble(); 
currencyConverter.updateExchangeRate(updateCurrency, newRate); 
break; 
case 4: 
System.out.println("Exiting Currency Converter. Goodbye!"); 
scanner.close(); 
System.exit(0); 
default: 
System.out.println("Invalid choice. Please enter a number between 1 and 4."); 
} 
}
}
}
