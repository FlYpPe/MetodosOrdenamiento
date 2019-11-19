import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MetodosOrdenamiento {

	static class Burbuja {

		public static void ordenamientoBurbuja1(int arr[]) {
			int i = 1;
			boolean ordenado = false;
			while ((i < arr.length) || (ordenado == false)) {

				i = i + 1;
				ordenado = true;
				for (int j = 0; j < arr.length - i; j++) {
					if (arr[j] > arr[j + 1]) {

						ordenado = false;
						int aux = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = aux;

					}
				}

			}
		}

		public static void ordenamientoBurbuja2(int[] arr) {

			int i = 1;
			boolean ordenado = false;
			while ((i < arr.length) || (ordenado == false)) {

				i = i + 1;
				ordenado = true;
				for (int j = 0; j < arr.length - i; j++) {
					if (arr[j] > arr[j + 1]) {

						ordenado = false;
						int aux = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = aux;

					}
				}

			}

		}

		public static void ordenamientoBurbuja3(int[] arr) {

			int i = 1;
			boolean ordenado = true;
			do {
				i = i + 1;
				for (int j = 0; j < arr.length - i; j++) {
					if (arr[j] > arr[j + 1]) {
						ordenado = false;
						int aux = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = aux;
					}
				}

			} while (i < arr.length || ordenado == true);

		}

	}

	public int particion(int arr[], int menor, int mayor) {
		int pivot = arr[mayor];
		int i = (menor - 1);

		for (int j = menor; j < mayor; j++) {

			if (arr[j] < pivot) {
				i++;

				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}
		}

		int temp = arr[i + 1];
		arr[i + 1] = arr[mayor];
		arr[mayor] = temp;

		return i + 1;
	}

	public void quickSort(int arr[], int menor, int mayor) {
		if (menor < mayor) {

			int pi = particion(arr, menor, mayor);

			quickSort(arr, menor, pi - 1);
			quickSort(arr, pi + 1, mayor);
		}
	}

	public static class radixSort {
		public static void sort(int arr []) {
			
			int x, i ,j;
			for (x = Integer.SIZE-1; x>=0; x--) {
				int aux[] = new int [arr.length];
				j = 0;
				for (i = 0; i < arr.length; i++) {
					
					boolean mover = arr[i]<<x>0;
					
					if (x==0? !mover : mover) {
						aux[j] = arr[i];
						j++;
						
					}else {
						arr[i-j]= arr[i];
						
					}
					
				}
				for (i = j; i < aux.length; i++) {
					aux[i] = arr[i]-j;
				}
				
				arr = aux;
				
			}
			
			
			
		}
		

	}

}

public class PruebaMetodosOrdenamiento {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		boolean a = true;
		MetodosOrdenamiento ob = new MetodosOrdenamiento();
		int arr[] = new int [100000];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {
			
			arr[i] = r.nextInt(100);
		}
		int n = arr.length;
		int ar[] = Arrays.copyOf(arr, arr.length);
		
		do {
			arr = Arrays.copyOf(ar, ar.length);
			System.out.println("Seleccione un metodo de ordenamiento");
			System.out.println("1.- Metodo Burbuja");
			System.out.println("2.- Metodo QuickSort");
			System.out.println("3.- Metodo ShellSort");
			System.out.println("4.- Metodo RadixSort");
			System.out.println("5.- Metodo Intercalacion");
			System.out.println("6.- Metodo Mezcla directa");
			System.out.println("7.- Metodo Mezcla natural");
			System.out.println("8.- Metodo Busqueda binaria");
			System.out.println("9.- Metodo Busqueda por funciones hash");
			byte op = e.nextByte();
			switch (op) {
			case 1:
				System.out.println("Ordenando por el metodo Burbuja");
				MetodosOrdenamiento.Burbuja.ordenamientoBurbuja3(arr);
				break;
			case 2:
				System.out.println("Ordenando por el metodo QuickSort");
				ob.quickSort(arr, 0, n);
				System.out.println("Arreglo ordenado");
				System.out.println(Arrays.toString(arr));
				break;
			case 3:
				System.out.println("Ordenando por el metodo ShellSort");
				System.out.println("Arreglo ordenado");
				System.out.println(Arrays.toString(arr));
				break;
			case 4:
				System.out.println("Ordenando por el metodo Radix");
				
				MetodosOrdenamiento.radixSort.sort(arr);
				System.out.println("Arreglo ordenado");
				System.out.println(Arrays.toString(arr));
				break;
			case 5:
				System.out.println("Ordenando por el metodo Intercalacion");
				System.out.println("Arreglo ordenado");
				System.out.println(Arrays.toString(arr));
				break;
			case 6:
				System.out.println("Ordenando por el metodo Mezcla Directa");
				System.out.println("Arreglo ordenado");
				System.out.println(Arrays.toString(arr));
				break;
			case 7:
				System.out.println("Ordenando por el metodo Mezcla natural");
				System.out.println("Arreglo ordenado");
				System.out.println(Arrays.toString(arr));
				break;
			case 8:
				System.out.println("Ordenando por el metodo Busqueda Binaria");
				System.out.println("Arreglo ordenado");
				System.out.println(Arrays.toString(arr));
				break;
			case 9:
				System.out.println("Ordenando por el metodo Metodo busqueda por funciones hash");
				System.out.println("Arreglo ordenado");
				System.out.println(Arrays.toString(arr));
				break;
			case 10:
				System.out.println("Saliendo");
				a = false;
				break;

			default:
				break;
			}
			
			System.out.println(Arrays.toString(arr));

			
			Arrays.toString(ar);
			
			MetodosOrdenamiento.Burbuja.ordenamientoBurbuja3(arr);

			
		} while (a);
		e.close();
	}

}
