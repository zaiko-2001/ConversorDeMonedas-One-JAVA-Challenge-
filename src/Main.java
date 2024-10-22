import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ConsultaConversion conversion = new ConsultaConversion();
        boolean continuar = true;

        while (continuar) {
            System.out.println("""
                Ingrese la opción:
                1. EUR a CLP
                2. CLP a EUR
                3. USD a CLP
                4. CLP a USD
                5. CLP a AUD
                6. AUD a CLP
                7. Salir
                """);
            System.out.println("Ingrese la opción:");
            int opcion = scanner.nextInt();

            if (opcion == 7) {
                continuar = false;
                System.out.println("Saliendo del programa...");
                break;
            }

            System.out.println("Ingrese la cantidad:");
            double cantidad = scanner.nextDouble();
            String base_code = "";
            String target_code = "";

            switch (opcion) {
                case 1 -> {
                    base_code = "EUR";
                    target_code = "CLP";
                }
                case 2 -> {
                    base_code = "CLP";
                    target_code = "EUR";
                }
                case 3 -> {
                    base_code = "USD";
                    target_code = "CLP";
                }
                case 4 -> {
                    base_code = "CLP";
                    target_code = "USD";
                }
                case 5 -> {
                    base_code = "CLP";
                    target_code = "AUD";
                }
                case 6 -> {
                    base_code = "AUD";
                    target_code = "CLP";
                }
                default -> {
                    System.out.println("Opción no válida. Intente de nuevo.");
                    continue;
                }
            }

            try {
                Conversion consulta = conversion.crearConversion(base_code, target_code, cantidad);
                System.out.println("Conversión realizada: " + consulta);
            } catch (NumberFormatException e) {
                System.out.println("Formato incorrecto, por favor ingrese un número.");
            } catch (RuntimeException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}
