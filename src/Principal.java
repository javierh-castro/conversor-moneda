import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        ConsultarMoneda consulta = new ConsultarMoneda();
        System.out.println("Escriba el nombre de las iniciales de la moneda que quiere cotizar");
        try {
            var siglaDeMoneda = lectura.nextLine();//Cambie de tipo a string
            Moneda moneda = consulta.buscarMoneda(siglaDeMoneda);
            System.out.println(moneda);
//            GeneradorDeArchivo generador = new GeneradorDeArchivo();
//            generador.guardarJson(pelicula);
        }catch (NumberFormatException e){
            System.out.println("Número no encontrado "+e.getMessage());
        } catch (RuntimeException e){//IOExeption
            System.out.println(e.getMessage());

        }
    }
}
