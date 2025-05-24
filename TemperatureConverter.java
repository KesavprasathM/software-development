import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double temperature, converted;
        int choice;

        System.out.println("Temperature Converter");
        System.out.println("1. Celsius to Fahrenheit");
        System.out.println("2. Fahrenheit to Celsius");
        System.out.print("Enter your choice (1 or 2): ");
        choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Celsius: ");
                temperature = scanner.nextDouble();
                converted = (temperature * 9/5) + 32;
                System.out.printf("Temperature in Fahrenheit: %.2f°F%n", converted);
                break;
            case 2:
                System.out.print("Enter temperature in Fahrenheit: ");
                temperature = scanner.nextDouble();
                converted = (temperature - 32) * 5/9;
                System.out.printf("Temperature in Celsius: %.2f°C%n", converted);
                break;
            default:
                System.out.println("Invalid choice!");
        }

        scanner.close();
    }
}