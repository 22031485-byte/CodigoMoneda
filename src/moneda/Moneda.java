package moneda;
import java.util.Scanner;

public class Moneda {
    public static void main(String[] args) {
        Scanner leer = new Scanner(System.in);
        Cajero cajero = new Cajero();

        System.out.println("Ingresa los euros a transformar");
        System.out.println("Nota: Deben ser enteros positivos.");
        System.out.println("Ingresa 0 para terminar.");

        while (true) {
            System.out.print("Euros: ");
            int cantidad = leer.nextInt();

            if (cantidad == 0) {
                System.out.println("Programa finalizado.");
                break;
            }

            if (cantidad < 0) {
                System.out.println("Por favor, ingresa solo números positivos.");
                continue;
            }

            cajero.setCantidad(cantidad);
            System.out.println("Desglose:");
            cajero.Cambio();  // Esto ya imprime el desglose
            System.out.println(); // Línea vacía para separar cada resultado
        }

        leer.close();
    }
}
