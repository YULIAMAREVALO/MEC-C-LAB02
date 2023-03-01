public class MergeSort {
  
  // Función para fusionar dos subarreglos de arr[]
  // Primer subarreglo es arr[l..m]
  // Segundo subarreglo es arr[m+1..r]
  void merge(int arr[], int l, int m, int r) {
    // Encuentra el tamaño de los subarreglos que se fusionarán
    int n1 = m - l + 1;
    int n2 = r - m;
 
    /* Crear arreglos temporales */
    int L[] = new int[n1];
    int R[] = new int[n2];
 
    //Copia los datos a los arreglos temporales/
    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];
 
    /* Fusiona los arreglos temporales */
 
    // Indices iniciales del primer y segundo subarreglo
    int i = 0, j = 0;
 
    // Índice inicial del subarreglo fusionado
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      }
      else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }
 
    /* Copia los elementos restantes de L[], si hay alguno */
    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }
 
    /* Copia los elementos restantes de R[], si hay alguno */
    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }
 
  // Función principal que ordena arr[l..r] usando
  // el algoritmo de ordenamiento Merge
  void sort(int arr[], int l, int r) {
    if (l < r) {
      // Encuentra el punto medio del arreglo
      int m = (l + r) / 2;
 
      // Ordena primero y segundo subarreglo
      sort(arr, l, m);
      sort(arr, m + 1, r);
 
      // Fusiona los subarreglos
      merge(arr, l, m, r);
    }
  }
 
  // Función para imprimir un arreglo de tamaño n
  static void printArray(int arr[]) {
    int n = arr.length;
    for (int i = 0; i < n; ++i)
      System.out.print(arr[i] + " ");
    System.out.println();
  }
 
  // Programa de prueba
  public static void main(String args[]) {
    int arr[] = { 12, 11, 13, 5, 6, 7 };
 
    System.out.println("Arreglo original:");
    printArray(arr);
 
    MergeSort ob = new MergeSort();
    ob.sort(arr, 0, arr.length - 1);
 
    System.out.println("\nArreglo ordenado:");
    printArray(arr);
  }
}