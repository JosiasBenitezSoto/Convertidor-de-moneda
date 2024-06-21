import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        CurrencyConverter converter = new CurrencyConverter();
        Scanner scanner = new Scanner(System.in);
        CurrencyApiClient apiClient = new CurrencyApiClient();

        boolean exit = false;

        while (!exit) {
            try {
                System.out.println("Menú del Conversor de Monedas:");
                System.out.println("1. Convertir USD a EUR");
                System.out.println("2. Convertir EUR a USD");
                System.out.println("3. Convertir USD a DOP");
                System.out.println("4. Convertir DOP a USD");
                System.out.println("5. Convertir EUR a DOP");
                System.out.println("6. Convertir DOP a EUR");
                System.out.println("7. Salir");
                System.out.print("Ingrese su opción: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {
                    case 1:
                        System.out.print("Ingrese la cantidad en USD: ");
                        double amountInUsd = scanner.nextDouble();
                        scanner.nextLine();
                        double rateUsdToEur = apiClient.getConversionRate("USD", "EUR");
                        if (rateUsdToEur > 0) {
                            converter.setUsdToEurRate(rateUsdToEur);
                            double amountInEur = converter.convertUsdToEur(amountInUsd);
                            System.out.printf("%.2f USD son %.2f EUR%n", amountInUsd, amountInEur);
                        } else {
                            System.out.println("No se pudo obtener la tasa de conversión USD a EUR.");
                        }
                        break;

                    case 2:
                        System.out.print("Ingrese la cantidad en EUR: ");
                        double amountInEurToUsd = scanner.nextDouble();
                        scanner.nextLine();
                        double rateEurToUsd = apiClient.getConversionRate("EUR", "USD");
                        if (rateEurToUsd > 0) {
                            converter.setUsdToEurRate(1 / rateEurToUsd); // Ajustar para la conversión inversa
                            double amountInUsdFromEur = converter.convertEurToUsd(amountInEurToUsd);
                            System.out.printf("%.2f EUR son %.2f USD%n", amountInEurToUsd, amountInUsdFromEur);
                        } else {
                            System.out.println("No se pudo obtener la tasa de conversión EUR a USD.");
                        }
                        break;

                    case 3:
                        System.out.print("Ingrese la cantidad en USD: ");
                        double amountInUsdToDop = scanner.nextDouble();
                        scanner.nextLine();
                        double rateUsdToDop = apiClient.getConversionRate("USD", "DOP");
                        if (rateUsdToDop > 0) {
                            converter.setUsdToDopRate(rateUsdToDop);
                            double amountInDopFromUsd = converter.convertUsdToDop(amountInUsdToDop);
                            System.out.printf("%.2f USD son %.2f DOP%n", amountInUsdToDop, amountInDopFromUsd);
                        } else {
                            System.out.println("No se pudo obtener la tasa de conversión USD a DOP.");
                        }
                        break;

                    case 4:
                        System.out.print("Ingrese la cantidad en DOP: ");
                        double amountInDopToUsd = scanner.nextDouble();
                        scanner.nextLine();
                        double rateDopToUsd = apiClient.getConversionRate("DOP", "USD");
                        if (rateDopToUsd > 0) {
                            converter.setUsdToDopRate(1 / rateDopToUsd); // Ajustar para la conversión inversa
                            double amountInUsdFromDop = converter.convertDopToUsd(amountInDopToUsd);
                            System.out.printf("%.2f DOP son %.2f USD%n", amountInDopToUsd, amountInUsdFromDop);
                        } else {
                            System.out.println("No se pudo obtener la tasa de conversión DOP a USD.");
                        }
                        break;

                    case 5:
                        System.out.print("Ingrese la cantidad en EUR: ");
                        double amountInEurToDop = scanner.nextDouble();
                        scanner.nextLine();
                        double rateEurToDop = apiClient.getConversionRate("EUR", "DOP");
                        if (rateEurToDop > 0) {
                            converter.setEurToDopRate(rateEurToDop);
                            double amountInDopFromEur = converter.convertEurToDop(amountInEurToDop);
                            System.out.printf("%.2f EUR son %.2f DOP%n", amountInEurToDop, amountInDopFromEur);
                        } else {
                            System.out.println("No se pudo obtener la tasa de conversión EUR a DOP.");
                        }
                        break;

                    case 6:
                        System.out.print("Ingrese la cantidad en DOP: ");
                        double amountInDopToEur = scanner.nextDouble();
                        scanner.nextLine();
                        double rateDopToEur = apiClient.getConversionRate("DOP", "EUR");
                        if (rateDopToEur > 0) {
                            converter.setEurToDopRate(1 / rateDopToEur); // Ajustar para la conversión inversa
                            double amountInEurFromDop = converter.convertDopToEur(amountInDopToEur);
                            System.out.printf("%.2f DOP son %.2f EUR%n", amountInDopToEur, amountInEurFromDop);
                        } else {
                            System.out.println("No se pudo obtener la tasa de conversión DOP a EUR.");
                        }
                        break;

                    case 7:
                        exit = true;
                        System.out.println("Gracias por usar el conversor de monedas.");
                        break;

                    default:
                        System.out.println("Opción no válida. Por favor, intente de nuevo.");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingrese un número.");
                scanner.next(); // Consumir la entrada inválida
            }
        }
        scanner.close();
    }
}
