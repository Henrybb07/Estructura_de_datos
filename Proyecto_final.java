import java.util.Scanner;
import java.util.ArrayList;

// Clase para ingresar los datos
class IngresarDatos {

    // Método auxiliar para leer un entero con validación
    private static int leerEntero(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("Entrada inválida. " + mensaje);
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    private static int leerCantidad(Scanner sc) {
        int n;
        while (true) {
            n = leerEntero(sc, "Ingrese cuántos números desea ingresar: ");
            if (n > 0) {
                break;
            } else {
                System.out.println("Debe ingresar un número mayor que 0.");
            }
        }
        return n;
    }

    public static int[] ingresarNumeros(Scanner sc) {
        int n = leerCantidad(sc);
        int[] numeros = new int[n];
        for (int i = 0; i < n; i++) {
            numeros[i] = leerEntero(sc, "Ingrese un número: ");
        }
        System.out.println("Los números que se registraron fueron:");
        for (int i = 0; i < n; i++) {
            System.out.print(numeros[i] + " ");
        }
        System.out.println();
        return numeros;
    }
}

public class Proyecto_final {
    
    // OPCION 1 - RECURSIVIDAD
    public static int recursividad(int[] arr, int objetivo, int indice) {
        if (indice >= arr.length) {
            return -1;
        }
        if (arr[indice] == objetivo) {
            return indice;
        }
        return recursividad(arr, objetivo, indice + 1);
    }

    // OPCION 2 - BUSQUEDA SECUENCIAL
    public static int secuencial(int[] arr, int objetivo) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == objetivo) {
                return i;
            }
        }
        return -1;
    }

    // OPCION 3 - BUSQUEDA BINARIA
    public static int binario(int[] arr, int objetivo) {
        int izquierda = 0;
        int derecha = arr.length - 1;
        while (izquierda <= derecha) {
            int medio = (izquierda + derecha) / 2;
            if (arr[medio] == objetivo) {
                return medio;
            } else if (arr[medio] < objetivo) {
                izquierda = medio + 1;
            } else {
                derecha = medio - 1;
            }
        }
        return -1;
    }

    // OPCION 4 - BURBUJA
    public static void burbuja(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // OPCION 5 - QUICKSORT
    public static void quickSort(int[] arr, int inicio, int fin) {
        if (inicio >= fin) {
            return;
        }
        int indicePivote = particion(arr, inicio, fin);
        quickSort(arr, inicio, indicePivote - 1);
        quickSort(arr, indicePivote + 1, fin);
    }

    public static int particion(int[] arr, int inicio, int fin) {
        int pivote = arr[fin];
        int i = inicio - 1;
        for (int j = inicio; j < fin; j++) {
            if (arr[j] <= pivote) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[fin];
        arr[fin] = temp;
        return i + 1;
    }

    // OPCION 6 - SHELLSORT
    public static void shellSort(int[] arr) {
        int n = arr.length;
        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int temp = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > temp) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = temp;
            }
        }
    }

    // OPCION 7 - RADIXSORT
    public static void radixSort(int[] arr) {
        int max = getMax(arr);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(arr, exp);
        }
    }

    public static int getMax(int[] arr) {
        int max = arr[0];
        for (int num : arr) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static void countingSort(int[] arr, int exp) {
        int n = arr.length;
        int[] salida = new int[n];
        int[] conteo = new int[10];

        for (int i = 0; i < n; i++) {
            int digito = (arr[i] / exp) % 10;
            conteo[digito]++;
        }

        for (int i = 1; i < 10; i++) {
            conteo[i] += conteo[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digito = (arr[i] / exp) % 10;
            salida[conteo[digito] - 1] = arr[i];
            conteo[digito]--;
        }

        for (int i = 0; i < n; i++) {
            arr[i] = salida[i];
        }
    }

    // OPCION 8 - INTERCALACION
    public static void intercalar(int[] a, int[] b) {
        int i = 0, j = 0;
        System.out.println("Arreglo intercalado:");
        while (i < a.length && j < b.length) {
            if (a[i] <= b[j]) {
                System.out.print(a[i] + " ");
                i++;
            } else {
                System.out.print(b[j] + " ");
                j++;
            }
        }
        while (i < a.length) {
            System.out.print(a[i] + " ");
            i++;
        }
        while (j < b.length) {
            System.out.print(b[j] + " ");
            j++;
        }
        System.out.println();
    }

    // OPCION 9 - MEZCLA DIRECTA
    public static void mezclaDirecta(int[] arr, int izquierda, int derecha) {
        if (izquierda < derecha) {
            int medio = (izquierda + derecha) / 2;
            mezclaDirecta(arr, izquierda, medio);
            mezclaDirecta(arr, medio + 1, derecha);
            int[] temp = new int[derecha - izquierda + 1];
            int i = izquierda, j = medio + 1, k = 0;
            while (i <= medio && j <= derecha) {
                if (arr[i] <= arr[j]) {
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

    // OPCION 12 - GRAFO CON LISTA DE ADYACENCIA
    public static ArrayList<ArrayList<Integer>> crearGrafoLista(Scanner sc, int vertices, int aristas) {
        // Crear lista de adyacencia
        ArrayList<ArrayList<Integer>> grafo = new ArrayList<>();
        
        // Crear listas vacías para cada vértice
        for (int i = 0; i < vertices; i++) {
            grafo.add(new ArrayList<>());
        }
        
        // Agregar aristas
        for (int i = 0; i < aristas; i++) {
            System.out.println("\nArista #" + (i + 1));
            int origen = leerEnteroMenu(sc, "Vértice de origen: ");
            int destino = leerEnteroMenu(sc, "Vértice de destino: ");
            
            // Validar que los vértices existan
            if (origen >= 0 && origen < vertices && destino >= 0 && destino < vertices) {
                // Agregar arista en ambos sentidos (grafo no dirigido)
                if (!grafo.get(origen).contains(destino)) {
                    grafo.get(origen).add(destino);
                    grafo.get(destino).add(origen);
                    System.out.println("Arista " + origen + " - " + destino + " agregada.");
                } else {
                    System.out.println("Esta arista ya existe.");
                    i--; // Repetir esta iteración
                }
            } else {
                System.out.println("Vértice inválido. Los vértices van del 0 al " + (vertices - 1));
                i--; // Repetir esta iteración
            }
        }
        
        return grafo;
    }
    
    // OPCION 13 - GRAFO CON MATRIZ DE ADYACENCIA
    public static int[][] crearGrafoMatriz(Scanner sc, int vertices, int aristas) {
        // Inicializar matriz con ceros
        int[][] matriz = new int[vertices][vertices];
        
        // Agregar aristas
        for (int i = 0; i < aristas; i++) {
            System.out.println("\nArista #" + (i + 1));
            int origen = leerEnteroMenu(sc, "Vértice de origen: ");
            int destino = leerEnteroMenu(sc, "Vértice de destino: ");
            
            // Validar que los vértices existan
            if (origen >= 0 && origen < vertices && destino >= 0 && destino < vertices) {
                // Agregar arista en ambos sentidos (grafo no dirigido)
                if (matriz[origen][destino] == 0) {
                    matriz[origen][destino] = 1;
                    matriz[destino][origen] = 1;
                    System.out.println("Arista " + origen + " - " + destino + " agregada.");
                } else {
                    System.out.println("Esta arista ya existe.");
                    i--; // Repetir esta iteración
                }
            } else {
                System.out.println("Vértice inválido. Los vértices van del 0 al " + (vertices - 1));
                i--; // Repetir esta iteración
            }
        }
        
        return matriz;
    }

    private static int leerEnteroMenu(Scanner sc, String mensaje) {
        System.out.print(mensaje);
        while (!sc.hasNextInt()) {
            System.out.print("Entrada inválida. " + mensaje);
            sc.next();
        }
        int valor = sc.nextInt();
        sc.nextLine();
        return valor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int opcion = 0;
        int[] lista;
        
        System.out.println("====== Métodos de búsqueda, ordenamiento y grafos ======");

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1) Recursividad");
            System.out.println("2) Secuencial");
            System.out.println("3) Binario");
            System.out.println("4) Burbuja");
            System.out.println("5) Quicksort");
            System.out.println("6) Shellsort");
            System.out.println("7) Radixsort");
            System.out.println("8) Intercalación");
            System.out.println("9) Mezcla directa");
            System.out.println("10) Opción en desarrollo ;3");
            System.out.println("11) Opción en desarrollo también ;3");
            System.out.println("12) Grafo con Lista de Adyacencia");
            System.out.println("13) Grafo con Matriz de Adyacencia");
            System.out.println("14) Salir");
            System.out.print("Seleccione una opción: ");

            if (sc.hasNextInt()) {
                opcion = sc.nextInt();
                sc.nextLine();
            } else {
                System.out.println("Ingrese un número válido.");
                sc.next();
                opcion = 0;
                continue;
            }

            switch (opcion) {
                case 1:
                    System.out.println("--- Recursividad ---");
                    lista = IngresarDatos.ingresarNumeros(sc);
                    int objetivo1 = leerEnteroMenu(sc, "¿Qué número desea buscar? ");
                    int resultado1 = recursividad(lista, objetivo1, 0);
                    System.out.println(resultado1 != -1 ?
                            "Número encontrado en la posición: " + (resultado1 + 1) :
                            "Número no encontrado.");
                    break;

                case 2:
                    System.out.println("--- Secuencial ---");
                    lista = IngresarDatos.ingresarNumeros(sc);
                    int objetivo2 = leerEnteroMenu(sc, "¿Qué número desea buscar? ");
                    int resultado2 = secuencial(lista, objetivo2);
                    System.out.println(resultado2 != -1 ?
                            "Número encontrado en la posición: " + resultado2 :
                            "Número no encontrado.");
                    break;

                case 3:
                    System.out.println("--- Binario ---");
                    lista = IngresarDatos.ingresarNumeros(sc);
                    quickSort(lista, 0, lista.length - 1);
                    System.out.println("Arreglo ordenado:");
                    for (int num : lista) System.out.print(num + " ");
                    System.out.println();
                    int objetivo3 = leerEnteroMenu(sc, "¿Qué número desea buscar? ");
                    int resultado3 = binario(lista, objetivo3);
                    System.out.println(resultado3 != -1 ?
                            "Número encontrado en la posición: " + resultado3 :
                            "Número no encontrado.");
                    break;

                case 4:
                    System.out.println("--- Burbuja ---");
                    lista = IngresarDatos.ingresarNumeros(sc);
                    System.out.println("Arreglo original:");
                    for (int num : lista) System.out.print(num + " ");
                    System.out.println();
                    burbuja(lista);
                    System.out.println("Arreglo ordenado:");
                    for (int num : lista) System.out.print(num + " ");
                    System.out.println();
                    break;

                case 5:
                    System.out.println("--- Quicksort ---");
                    lista = IngresarDatos.ingresarNumeros(sc);
                    System.out.println("Arreglo original:");
                    for (int num : lista) System.out.print(num + " ");
                    System.out.println();
                    quickSort(lista, 0, lista.length - 1);
                    System.out.println("Arreglo ordenado por Quicksort:");
                    for (int num : lista) System.out.print(num + " ");
                    System.out.println();
                    break;

                case 6:
                    System.out.println("--- Shellsort ---");
                    lista = IngresarDatos.ingresarNumeros(sc);
                    System.out.println("Arreglo original:");
                    for (int num : lista) System.out.print(num + " ");
                    System.out.println();
                    shellSort(lista);
                    System.out.println("Arreglo ordenado por Shellsort:");
                    for (int num : lista) System.out.print(num + " ");
                    System.out.println();
                    break;

                case 7:
                    System.out.println("--- Radixsort ---");
                    lista = IngresarDatos.ingresarNumeros(sc);
                    boolean negativos = false;
                    for (int num : lista) {
                        if (num < 0) {
                            negativos = true;
                            break;
                        }
                    }
                    if (negativos) {
                        System.out.println("RadixSort solo acepta números positivos.");
                    } else {
                        System.out.println("Arreglo original:");
                        for (int num : lista) System.out.print(num + " ");
                        System.out.println();
                        radixSort(lista);
                        System.out.println("Arreglo ordenado por RadixSort:");
                        for (int num : lista) System.out.print(num + " ");
                        System.out.println();
                    }
                    break;

                case 8:
                    System.out.println("--- Intercalación ---");
                    System.out.println("Primer arreglo:");
                    int[] arreglo1 = IngresarDatos.ingresarNumeros(sc);
                    System.out.println("Segundo arreglo:");
                    int[] arreglo2 = IngresarDatos.ingresarNumeros(sc);
                    quickSort(arreglo1, 0, arreglo1.length - 1);
                    quickSort(arreglo2, 0, arreglo2.length - 1);
                    System.out.println("Primer arreglo ordenado:");
                    for (int num : arreglo1) System.out.print(num + " ");
                    System.out.println();
                    System.out.println("Segundo arreglo ordenado:");
                    for (int num : arreglo2) System.out.print(num + " ");
                    System.out.println();
                    intercalar(arreglo1, arreglo2);
                    break;

                case 9:
                    System.out.println("--- Mezcla directa ---");
                    lista = IngresarDatos.ingresarNumeros(sc);
                    System.out.println("Arreglo original:");
                    for (int num : lista) System.out.print(num + " ");
                    System.out.println();
                    mezclaDirecta(lista, 0, lista.length - 1);
                    System.out.println("Arreglo ordenado por mezcla directa:");
                    for (int num : lista) System.out.print(num + " ");
                    System.out.println();
                    break;

                case 10:
                    System.out.println("Opción en desarrollo, vuelva pronto ;3");
                    break;

                case 11:
                    System.out.println("Opción en desarrollo también, vuelva pronto ;3");
                    break;

                case 12:
                    System.out.println("--- Grafo con Lista de Adyacencia ---");
                    int verticesLista = leerEnteroMenu(sc, "Ingrese el número de vértices: ");
                    while (verticesLista <= 0) {
                        System.out.println("El número de vértices debe ser mayor que 0.");
                        verticesLista = leerEnteroMenu(sc, "Ingrese el número de vértices: ");
                    }
                    System.out.println("Los vértices están numerados del 0 al " + (verticesLista - 1));
                    int aristasLista = leerEnteroMenu(sc, "¿Cuántas aristas desea agregar? ");
                    
                    ArrayList<ArrayList<Integer>> grafoLista = crearGrafoLista(sc, verticesLista, aristasLista);
                    
                    System.out.println("\n--- Representación del grafo (Lista de Adyacencia) ---");
                    for (int i = 0; i < grafoLista.size(); i++) {
                        System.out.print("Vértice " + i + " -> ");
                        if (grafoLista.get(i).isEmpty()) {
                            System.out.print("(sin conexiones)");
                        } else {
                            for (Integer vecino : grafoLista.get(i)) {
                                System.out.print(vecino + " ");
                            }
                        }
                        System.out.println();
                    }
                    break;

                case 13:
                    System.out.println("--- Grafo con Matriz de Adyacencia ---");
                    int verticesMatriz = leerEnteroMenu(sc, "Ingrese el número de vértices: ");
                    while (verticesMatriz <= 0) {
                        System.out.println("El número de vértices debe ser mayor que 0.");
                        verticesMatriz = leerEnteroMenu(sc, "Ingrese el número de vértices: ");
                    }
                    System.out.println("Los vértices están numerados del 0 al " + (verticesMatriz - 1));
                    int aristasMatriz = leerEnteroMenu(sc, "¿Cuántas aristas desea agregar? ");
                    
                    int[][] grafoMatriz = crearGrafoMatriz(sc, verticesMatriz, aristasMatriz);
                    
                    System.out.println("\n--- Matriz de Adyacencia ---");
                    // Encabezado de columnas
                    System.out.print("    ");
                    for (int i = 0; i < verticesMatriz; i++) {
                        System.out.printf("%3d ", i);
                    }
                    System.out.println();
                    System.out.print("    ");
                    for (int i = 0; i < verticesMatriz; i++) {
                        System.out.print("----");
                    }
                    System.out.println();
                    
                    // Mostrar matriz
                    for (int i = 0; i < verticesMatriz; i++) {
                        System.out.printf("%2d | ", i);
                        for (int j = 0; j < verticesMatriz; j++) {
                            System.out.printf("%3d ", grafoMatriz[i][j]);
                        }
                        System.out.println();
                    }
                    
                    // Mostrar conexiones
                    System.out.println("\n--- Conexiones del grafo ---");
                    for (int i = 0; i < verticesMatriz; i++) {
                        System.out.print("Vértice " + i + " conectado con: ");
                        boolean hayConexion = false;
                        for (int j = 0; j < verticesMatriz; j++) {
                            if (grafoMatriz[i][j] == 1) {
                                System.out.print(j + " ");
                                hayConexion = true;
                            }
                        }
                        if (!hayConexion) {
                            System.out.print("ninguno");
                        }
                        System.out.println();
                    }
                    break;

                case 14:
                    System.out.println("Gracias por su tiempo, vuelva pronto.");
                    break;

                default:
                    System.out.println("Esa opción no es válida.");
                    break;
            }
        } while (opcion != 14);

        sc.close();
    }
}