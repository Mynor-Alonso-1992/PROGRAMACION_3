import java.util.Arrays;
import java.util.Scanner;

public class Busqueda {

    // Método de Búsqueda Secuencial
    public static int busquedaSecuencial(int[] arreglo, int objetivo) {
        for (int i = 0; i < arreglo.length; i++) {
            if (arreglo[i] == objetivo) {
                return i;  // Retorna el índice donde se encontró
            }
        }
        return -1; // Retorna -1 si no se encuentra
    }

    // Método de Búsqueda Binaria (Requiere que el arreglo esté ordenado)
    public static int busquedaBinaria(int[] arreglo, int objetivo) {
        int inicio = 0, fin = arreglo.length - 1;

        while (inicio <= fin) {
            int medio = inicio + (fin - inicio) / 2;

            if (arreglo[medio] == objetivo) {
                return medio;  // Elemento encontrado
            } else if (arreglo[medio] < objetivo) {
                inicio = medio + 1;  // Buscar en la mitad derecha
            } else {
                fin = medio - 1;  // Buscar en la mitad izquierda
            }
        }
        return -1; // Retorna -1 si no se encuentra
    }

    // Método Principal (Main)
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] datos = {3, 9, 1, 14, 7, 6, 20, 8, 15}; // Datos de ejemplo

        System.out.println("Arreglo original: " + Arrays.toString(datos));

        System.out.print("Ingrese el número a buscar: ");
        int numeroBuscar = scanner.nextInt();

        System.out.println("\nSeleccione el método de búsqueda:");
        System.out.println("1. Búsqueda Secuencial");
        System.out.println("2. Búsqueda Binaria (requiere ordenar)");
        int opcion = scanner.nextInt();

        int resultado = -1;
        if (opcion == 1) {
            resultado = busquedaSecuencial(datos, numeroBuscar);
        } else if (opcion == 2) {
            Arrays.sort(datos); // Ordenamos antes de hacer búsqueda binaria
            System.out.println("Arreglo ordenado: " + Arrays.toString(datos));
            resultado = busquedaBinaria(datos, numeroBuscar);
        } else {
            System.out.println("Opción no válida.");
            return;
        }

        // Mostrar resultado
        if (resultado != -1) {
            System.out.println("Número encontrado en la posición: " + resultado);
        } else {
            System.out.println("Número no encontrado en el arreglo.");
        }
    }
}
