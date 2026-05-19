import java.util.Scanner;

//Método para ingresar los datos con los que se va a trabajar durante la prueba ;D
class ingresar_datos {
    public static int[] ingresarNumeros(Scanner sc) {
        System.out.println("Ingrese cuántos números desea ingresar:");
        int n = sc.nextInt();
        int[] numeros = new int[n];

        for (int i=0; i<n; i++){
            System.out.println("Ingrese un número " + ":");
            numeros[i] = sc.nextInt();
        }

        System.out.println("Los números que se registraron fueron:");
        for (int i=0; i<n; i++){
            System.out.println(numeros[i]);
        }

        return numeros;
    }
}

public class Proyecto_final {
    // Aquí declaran sus métodos de para poder llamarlos en el menú
    //opción 9
    public static void mezclaDirecta(int[] arr, int izquierda, int derecha){
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            mezclaDirecta(arr, izquierda, medio);
            mezclaDirecta(arr, medio + 1, derecha);

            int[] temp = new int[derecha - izquierda + 1];
            int i = izquierda;
            int j = medio + 1;
            int k = 0;

            while (i <= medio && j <= derecha) {
                if (arr[i] <= arr[j]){
                    temp[k++] = arr[i++];
                } else {
                    temp[k++] = arr[j++];
                }
            }

            while (i <= medio) {
                temp[k++] = arr[i++];
            }

            while (j <= derecha) {
                temp[k++] = arr[j++];
            }

            for (int x = 0; x < temp.length; x++) {
                arr[izquierda + x] = temp[x];
            }
        }
    }

    //Menú para llamar una de las opciones por realizar ;D
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
         int[] lista;
        System.out.println("        ====== Métodos de busqueda y ordenamiento ======");
        do{
            System.out.println("    --- Menú ---");
            System.out.println("(Seleccionar una opción)");
            System.out.println("1) Recursividad");
            System.out.println("2) Secuencial");
            System.out.println("3) Binario");
            System.out.println("4) Burbuja");
            System.out.println("5) Quicksort");
            System.out.println("6) Shellsort");
            System.out.println("7) Radixsort");
            System.out.println("8) Intercalación");
            System.out.println("9) Mezcla directa");
            System.out.println("10) Salir");

            if(sc.hasNextInt()){  // este comando sirve para checar si es un número entero o el usuario esta imbecil.
                opcion = sc.nextInt();

                switch (opcion){
                    case 1:
                        System.out.println("---Recursividad---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Aquí se llamaría al método de recursividad
                        break;
                    case 2:
                        System.out.println("    ---Secuencial---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Aquí se llamaría al método de búsqueda secuencial
                        break;
                    case 3:
                        System.out.println("    ---Binario---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Aquí se llamaría al método de búsqueda binaria
                        break;
                    case 4:
                        System.out.println("    ---Burbuja---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Aquí se llamaría al método de ordenamiento burbuja
                        break;
                    case 5:
                        System.out.println("    ---Quicksort---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Aquí se llamaría al método de ordenamiento quicksort
                        break;
                    case 6:
                        System.out.println("    ---Shellsort---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Aquí se llamaría al método de ordenamiento shellsort
                        break;
                    case 7:
                        System.out.println("    ---Radixsort---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Aquí se llamaría al método de ordenamiento radixsort
                        break;
                    case 8:
                        System.out.println("    ---Intercalación---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Aquí se llamaría al método de intercalación
                        break;
                    case 9:
                        System.out.println("    ---Mezcla directa---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        System.out.println("Arreglo original:");

                        for (int num : lista) {
                            System.out.print(num + " ");
                        }
                        System.out.println();

                        mezclaDirecta(lista, 0, lista.length - 1);

                        System.out.println("Arreglo ordenado por mezcla directa:");
                        for (int num : lista) {
                            System.out.print(num + " ");
                        }
                        System.out.println();
                        break;
                    case 10:
                        System.out.println("Gracias por su tiempo, vuelva pronto.");
                        break;
                    default:
                        System.out.println("*~* Esa opción no es válida, ingrese un valor del 1 al 10.");
                        break;
                }
            } else {
                System.out.println("*~* Esa opción no es válida, ingree un valor del 1 al 10.");
                sc.next(); // Limpiar el scanner
                opcion = 0; // Reiniciar la opción para evitar salir del menú
            }

            System.out.println(); // Es una línea en blanco para que no se vea todo junto

        } while (opcion != 10);
        sc.close();
    }
}




