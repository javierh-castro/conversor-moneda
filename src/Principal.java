import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();
        String respuesta = " ";
        List<String> codigosPermitidos = List.of("ARS", "USD", "BRL");
        System.out.println("Escriba el nombre de las iniciales de la moneda que quiere cotizar");


        while (!respuesta.equalsIgnoreCase("salir")) {
            try {
                System.out.println("Elija las siglas de la moneda(Ej: USD, ARS, etc): ");
                var siglaDeMoneda = lectura.nextLine();
                if (!codigosPermitidos.contains(siglaDeMoneda)) {
                    System.out.println("Moneda base no válida. Intente con: ARS, USD o BRL");
                    continue;
                }

                Moneda moneda = consulta.buscarMoneda(siglaDeMoneda);
                System.out.println("Lista de cotizaciones:");
                for (Map.Entry<String, Double> entry : moneda.conversion_rates().entrySet()) {
                    if (codigosPermitidos.contains(entry.getKey())) {
                        System.out.printf("- %s: %.2f%n", entry.getKey(), entry.getValue());
                    }
                }
                System.out.println("Ahora escriba la moneda a comparar: ");
                var comparacionMoneda = lectura.nextLine();
                Double cotizacion = moneda.conversion_rates().get(comparacionMoneda);
                if (cotizacion != null) {
                    System.out.println("Valor de la moneda " + siglaDeMoneda + " con la moneda " + comparacionMoneda + " da este resultado:");
                    System.out.printf("%.8f%n", cotizacion);
                } else {
                    System.out.println("Moneda no encontrada. ");
                }
//            GeneradorDeArchivo generador = new GeneradorDeArchivo();
//            generador.guardarJson(pelicula);
            } catch (NumberFormatException e) {
                System.out.println("Número no encontrado " + e.getMessage());
            } catch (RuntimeException e) {//IOExeption
                System.out.println(e.getMessage());
            }
            System.out.println("¿Quiere salir o continuar?");
            respuesta = lectura.nextLine();
            System.out.println("Uste dijo: " + respuesta);
        }
    }
}
