package moneda;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cajero {
    private double cantidad;

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double Cambio() {
        double cantidadR = cantidad;

        // Denominaciones en orden descendente
        int[] denominaciones = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        // Guardar resultados
        Map<Integer, Integer> resultado = new LinkedHashMap<>();

        for (int valor : denominaciones) {
            int cantidadMonedas = (int)(cantidadR / valor);
            if (cantidadMonedas > 0) {
                resultado.put(valor, cantidadMonedas);
                cantidadR %= valor;
            }
        }

        // Imprimir resultado
        for (Map.Entry<Integer, Integer> entry : resultado.entrySet()) {
            if (entry.getKey() >= 20) {
                System.out.println("Billetes de " + entry.getKey() + ": " + entry.getValue());
            } else {
                System.out.println("Monedas de " + entry.getKey() + ": " + entry.getValue());
            }
        }

        return cantidadR; // Debería ser 0 si todo fue exacto
    }
}