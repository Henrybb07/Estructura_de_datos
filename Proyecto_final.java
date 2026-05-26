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
    //OPCION 1 RECURSIVIDAD
    public static int recursividad(int[] arr, int objetivo, int indice) {
        // Paso 1: Caso base - se llegó al final sin encontrarlo
        if (indice >= arr.length) {
            return -1;
        }
 
        // Paso 2: Verificar si el elemento actual es el buscado
        if (arr[indice] == objetivo) {
            return indice; // Encontrado, regresa la posición
        }
 
        // Paso 3: Llamada recursiva avanzando al siguiente índice
        return recursividad(arr, objetivo, indice + 1);
    }

    //OPCION 3 BUSQUEDA BINARIA
     public static int binario(int[] arr, int objetivo) {
        // Paso 1: Definir límites iniciales
        int izquierda = 0;
        int derecha   = arr.length - 1;
 
        // Paso 2: Repetir mientras quede rango por revisar
        while (izquierda <= derecha) {
 
            // Paso 3: Calcular el índice del medio
            int medio = (izquierda + derecha) / 2;
 
            // Paso 4: Comparar el elemento del medio con el objetivo
            if (arr[medio] == objetivo) {
                return medio; // Encontrado
 
            } else if (arr[medio] < objetivo) {
                // Paso 5a: El objetivo está en la mitad derecha
                izquierda = medio + 1;
 
            } else {
                // Paso 5b: El objetivo está en la mitad izquierda
                derecha = medio - 1;
            }
        }

    //OPCION 5 QUICKSORT
    public static void quickSort(int[] arr, int inicio, int fin) {
        // Paso 1: Caso base — si el rango tiene 1 o menos elementos, ya está ordenado
        if (inicio >= fin) return;
 
        // Paso 2: Parte el arreglo y obtener la posición final del pivote
        int indicePivote = particion(arr, inicio, fin);
 
        // Paso 3: Ordena recursivamente la mitad izquierda
        quickSort(arr, inicio, indicePivote - 1);
 
        // Paso 4: Ordena recursivamente la mitad derecha
        quickSort(arr, indicePivote + 1, fin);
    }
 
    // Método auxiliar de quickSort — coloca el pivote en su lugar correcto
    public static int particion(int[] arr, int inicio, int fin) {
        // Paso 1: Elegir el último elemento como pivote
        int pivote = arr[fin];
        int i = inicio - 1;
 
        // Paso 2: Recorre el arreglo comparando con el pivote
        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                // Paso 3: Intercambia elementos menores al pivote hacia la izquierda
                i++;
                int temp = arr[i];
                arr[i]   = arr[j];
                arr[j]   = temp;
            }
        }
 
        // Paso 4: Coloca el pivote en su posición correcta
        int temp   = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin]   = temp;
 
        return i + 1; // Regresa la posición final del pivote
    }


    //OPCION 6 SHELLSORT
    public static void shellSort(int[] arr) {
        int n = arr.length;
 
        // Paso 1: Empieza con un gap grande (mitad del arreglo) e irlo reduciendo
        for (int gap = n / 2; gap > 0; gap /= 2) {
 
            // Paso 2: Hace inserción directa con el gap actual
            for (int i = gap; i < n; i++) {
 
                // Paso 3: Guarda el elemento actual
                int temp = arr[i];
                int j    = i;
 
                // Paso 4: Desplaza hacia la derecha los elementos mayores que estén a distancia "gap"
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j     -= gap;
                }
 
                // Paso 5: Inserta el elemento guardado en su lugar correcto
                arr[j] = temp;
            }
        }
    }
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
                        System.out.print("¿Qué número desea buscar? ");
                        int objetivo1 = sc.nextInt();
                        int resultado1 = recursividad(lista, objetivo1, 0);
                        if (resultado1 != -1)
                            System.out.println("Número encontrado en la posición: " + resultado1);
                        else
                            System.out.println("Número no encontrado.");
                        break;
                    case 2:
                        System.out.println("    ---Secuencial---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Aquí se llamaría al método de búsqueda secuencial
                        break;
                    case 3:
                        System.out.println("    ---Binario---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Ordenar primero (binario requiere arreglo ordenado)
                        quickSort(lista, 0, lista.length - 1);
                        System.out.println("Arreglo ordenado previamente:");
                        for (int num : lista) System.out.print(num + " ");
                        System.out.println();
                        System.out.print("¿Qué número desea buscar? ");
                        int objetivo3 = sc.nextInt();
                        int resultado3 = binario(lista, objetivo3);
                        if (resultado3 != -1)
                            System.out.println("Número encontrado en la posición: " + resultado3);
                        else
                            System.out.println("Número no encontrado.");
                        break;
                    case 4:
                        System.out.println("    ---Burbuja---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        // Aquí se llamaría al método de ordenamiento burbuja
                        break;
                    case 5:
                        System.out.println("    ---Quicksort---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        System.out.println("Arreglo original:");
                        for (int num : lista) System.out.print(num + " ");
                        System.out.println();
                        quickSort(lista, 0, lista.length - 1);
                        System.out.println("Arreglo ordenado por Quicksort:");
                        for (int num : lista) System.out.print(num + " ");
                        System.out.println();
                        break;
                    case 6:
                        System.out.println("    ---Shellsort---");
                        lista = ingresar_datos.ingresarNumeros(sc);
                        System.out.println("Arreglo original:");
                        for (int num : lista) System.out.print(num + " ");
                        System.out.println();
                        shellSort(lista);
                        System.out.println("Arreglo ordenado por Shellsort:");
                        for (int num : lista) System.out.print(num + " ");
                        System.out.println();
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




