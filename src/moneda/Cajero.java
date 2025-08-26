package moneda;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cajero {
    private double cantidad;
    private Map<Integer, Integer> disponibilidad;

    public Cajero() {
        disponibilidad = new LinkedHashMap<>();
        int[] denominaciones = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

        // Suponemos que hay 10 de cada billete/moneda
        for (int valor : denominaciones) {
            disponibilidad.put(valor, 10);
        }
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public double getCantidad() {
        return cantidad;
    }

    public double Cambio() {
        double cantidadR = cantidad;
        Map<Integer, Integer> resultado = new LinkedHashMap<>();

        for (Map.Entry<Integer, Integer> entry : disponibilidad.entrySet()) {
            int denominacion = entry.getKey();
            int disponible = entry.getValue();

            int necesarios = (int) (cantidadR / denominacion);

            if (necesarios > 0) {
                int usados = Math.min(necesarios, disponible);
                if (usados > 0) {
                    resultado.put(denominacion, usados);
                    cantidadR -= usados * denominacion;
                }
            }
        }

        if (cantidadR > 0) {
            System.out.println("No hay suficiente cambio disponible para cubrir " + cantidad);
            return cantidadR;
        }

        // Descontar lo utilizado del inventario
        for (Map.Entry<Integer, Integer> entry : resultado.entrySet()) {
            int denom = entry.getKey();
            int usados = entry.getValue();
            disponibilidad.put(denom, disponibilidad.get(denom) - usados);
        }

        // Imprimir resultado
        for (Map.Entry<Integer, Integer> entry : resultado.entrySet()) {
            int valor = entry.getKey();
            int cantidadUsada = entry.getValue();
            if (valor >= 20) {
                System.out.println("Billetes de " + valor + ": " + cantidadUsada);
            } else {
                System.out.println("Monedas de " + valor + ": " + cantidadUsada);
            }
        }

        return 0;
    }

    public void mostrarDisponibilidad() {
        System.out.println("=== Disponibilidad actual en el cajero ===");
        for (Map.Entry<Integer, Integer> entry : disponibilidad.entrySet()) {
            int valor = entry.getKey();
            int disponibles = entry.getValue();
            if (valor >= 20) {
                System.out.println("Billetes de " + valor + ": " + disponibles);
            } else {
                System.out.println("Monedas de " + valor + ": " + disponibles);
            }
        }
        System.out.println("==========================================");
    }
}