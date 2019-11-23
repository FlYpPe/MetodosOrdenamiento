import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

class MetodosOrdenamiento {

	long t = 0;
	long c = 0;
	long in = 0;
	long r = 0;

	public void ordenamientoBurbuja1(int arr[]) {
		t = System.nanoTime();
		
		
		for (int i = 1; i < arr.length; i++) {
			r++;
			for (int j = 0; j < arr.length - i; j++) {
				r++;
				c++;
				if (arr[j] > arr[j + 1]) {
					int aux = arr[j];
					in++;
					arr[j] = arr[j + 1];
					arr[j + 1] = aux;
				}
			}
		}
		
		System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));

	}

	public void ordenamientoBurbuja2(int[] arr) {
		t = System.nanoTime();
		
		int i = 1;
		boolean ordenado = false;
		while ((i < arr.length) || (ordenado == false)) {

			i = i + 1;
			ordenado = true;
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {

					ordenado = false;
					in ++;
					int aux = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = aux;

				}
			}

		}
	System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));
	}

	public void ordenamientoBurbuja3(int[] arr) {
		t = System.nanoTime();

		int i = 1;
		boolean ordenado = true;
		do {
			i = i + 1;
			for (int j = 0; j < arr.length - i; j++) {
				if (arr[j] > arr[j + 1]) {
					ordenado = false;
					in ++;
					int aux = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = aux;
				}
			}

		} while (i < arr.length || ordenado == true);
		System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));
	}

	//////// ShellSort ////////////////////

	public int shellSort(int arr[]) {
		t = System.nanoTime();
		int n = arr.length;
		for (int gap = n / 2; gap > 0; gap /= 2) {
			r++;
			for (int i = gap; i < n; i += 1) {
				r++;
				int temp = arr[i];
				int j;
				for (j = i; j >= gap && arr[j - gap] > temp; j -= gap) {
					r++;
					in ++;
					arr[j] = arr[j - gap];
				}
				arr[j] = temp;
			}
		}

		System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));
		return 0;
	}

	//////// Intercalación //////////////////

	public void intercalacion(int[] arregloA, int[] arregloB) {
		t = System.nanoTime();
		int i, j, k;
		int arregloC[] = new int[arregloA.length + arregloB.length];
		// Repetir minetras los arreglos A y B tengan elementos a comparar
		for (i = j = k = 0; i < arregloA.length && j < arregloB.length; k++) {
			r++;
			c++;
			if (arregloA[i] < arregloB[j]) {
				in++;
				arregloC[k] = arregloA[i];
				i++;

			} else {
				in++;
				arregloC[k] = arregloB[j];
				j++;
			}

		}

		// Añadir sobrantes del arreglo A en caso de haberlos
		for (; i < arregloA.length; i++, k++) {
			r++;
			in++;
			arregloC[k] = arregloA[i];
		}
		// Añadir sobrantes del arreglo B en caso de haberlos

		for (; j < arregloB.length; j++, k++) {
			r++;
			in ++;
			arregloC[k] = arregloA[j];
		}
		System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));
	}

	//////// RadixSort //////////////////////

	public void radixSort(int arr[]) {
		t = System.nanoTime();
		
		int x, i, j;
		for (x = Integer.SIZE - 1; x >= 0; x--) {
			r++;
			int aux[] = new int[arr.length];
			j = 0;
			for (i = 0; i < arr.length; i++) {
				r++;

				boolean mover = arr[i] << x > 0;

				c++;
				if (x == 0 ? !mover : mover) {
					in ++;
					aux[j] = arr[i];
					j++;

				} else {
					in ++;
					arr[i - j] = arr[i];

				}

			}
			for (i = j; i < aux.length; i++) {
				r++;
				in ++;
				aux[i] = arr[i] - j;
			}

			arr = aux;

		}
	System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - t));
	}

	//////// Mezcla Directa /////////////

	public int[] mezclaDirecta(int[] arreglo) {

		int i, j, k;

		c++;
		if (arreglo.length > 1) {

			int nElementosIzq = arreglo.length / 2;
			int nElementosDer = arreglo.length - nElementosIzq;
			int arregloIzq[] = new int[nElementosIzq];
			int arregloDer[] = new int[nElementosDer];

			// Cepiando los elementos al primer arreglo
			for (i = 0; i < nElementosIzq; i++) {
				in++;
				r++;
				arregloIzq[i] = arreglo[i];

			}
			// Copiando los elementos al segundo arreglo
			for (i = nElementosIzq; i < nElementosIzq + nElementosDer; i++) {
				in++;
				r++;
				arregloDer[i - nElementosIzq] = arreglo[i];

			}
			// Recursividad
			arregloIzq = mezclaDirecta(arregloIzq);
			arregloDer = mezclaDirecta(arregloDer);

			i = 0;
			j = 0;
			k = 0;

			while (arregloIzq.length != j && arregloDer.length != k) {
				r++;
				c++;
				if (arregloIzq[j] < arregloDer[k]) {
					in++;
					arreglo[i] = arregloIzq[j];
					i++;
					j++;

				} else {
					arreglo[i] = arregloDer[k];
					in++;
					i++;
					k++;

				}

			}
			// Arreglo final
			while (arregloIzq.length != j) {
				r++;
				in++;
				arreglo[i] = arregloIzq[j];
				i++;
				j++;

			}
			while (arregloDer.length != k) {
				r++;
				in++;
				arreglo[i] = arregloDer[k];
				i++;
				k++;

			}
		} // fin del c++; if

		return arreglo;
	}

	//////// Quick Sort////////////////////

	public void quickSort(int arr[], int menor, int mayor) {
		c++;
		if (menor < mayor) {

			int pi = particion(arr, menor, mayor);

			quickSort(arr, menor, pi - 1);
			quickSort(arr, pi + 1, mayor);
		}
	}

	public int particion(int arr[], int menor, int mayor) {
		int pivot = arr[mayor];
		int i = (menor - 1);

		for (int j = menor; j < mayor; j++) {
			r++;
			c++;
			if (arr[j] < pivot) {
				i++;
				in ++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;

			}
		}

		int temp = arr[i + 1];
		in++;
		arr[i + 1] = arr[mayor];
		arr[mayor] = temp;

		return i + 1;
	}

}

public class PruebaMetodosOrdenamiento {

	public static void main(String[] args) {
		Scanner e = new Scanner(System.in);
		boolean a = true;
		MetodosOrdenamiento ob = new MetodosOrdenamiento();
		System.out.println("Ingrese la cantidad de valores aleatorios con los que se va a traabajar");
		int num = e.nextInt();
		int arr[] = new int[num];
		Random r = new Random();
		for (int i = 0; i < arr.length; i++) {

			arr[i] = r.nextInt(100);
		}
		int n = arr.length;
		int ar[] = Arrays.copyOf(arr, arr.length);

		do {
			ob.c = 0;
			ob.in = 0;
			ob.r = 0;
			ob.t = 0;
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

				ob.ordenamientoBurbuja1(arr);

				System.out.println("Comparaciones: " + ob.c);
				System.out.println("Recorridos: " + ob.r);
				System.out.println("Intercambios: " + ob.in);
				break;
			case 2:
				System.out.println("Ordenando por el metodo QuickSort");
				ob.t = System.nanoTime();
				ob.quickSort(arr, 0, n - 1);
				System.out.println("Arreglo ordenado");
				System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
				System.out.println("Comparaciones: " + ob.c);
				System.out.println("Recorridos: " + ob.r);
				System.out.println("Intercambios: " + ob.in);
				// System.out.println(Arrays.toString(arr));
				break;
			case 3:
				System.out.println("Ordenando por el metodo ShellSort");
				ob.shellSort(arr);
				System.out.println("Arreglo ordenado");
				System.out.println("Comparaciones: " + ob.c);
				System.out.println("Recorridos: " + ob.r);
				System.out.println("Intercambios: " + ob.in);
				// System.out.println(Arrays.toString(arr));
				break;
			case 4:
				System.out.println("Ordenando por el metodo Radix");
				ob.radixSort(arr);
				System.out.println("Arreglo ordenado");
				System.out.println("Comparaciones: " + ob.c);
				System.out.println("Recorridos: " + ob.r);
				System.out.println("Intercambios: " + ob.in);
				// System.out.println(Arrays.toString(arr));
				break;
			case 5:
				System.out.println("Ordenando por el metodo Intercalacion");
				ob.intercalacion(arr, arr);
				System.out.println("Arreglo ordenado");
				System.out.println("Comparaciones: " + ob.c);
				System.out.println("Recorridos: " + ob.r);
				System.out.println("Intercambios: " + ob.in);
				// System.out.println(Arrays.toString(arr));
				break;
			case 6:
				System.out.println("Ordenando por el metodo Mezcla Directa");
				ob.t = System.nanoTime();
				ob.mezclaDirecta(arr);
				System.out.println("Arreglo ordenado");
				System.out.println("Tiempo de ejecucion: " + (System.nanoTime() - ob.t));
				System.out.println("Comparaciones: " + ob.c);
				System.out.println("Recorridos: " + ob.r);
				System.out.println("Intercambios: " + ob.in);
				// System.out.println(Arrays.toString(arr));
				break;
			case 7:
				System.out.println("Ordenando por el metodo Mezcla natural");

				System.out.println("Arreglo ordenado");
				System.out.println("Comparaciones: " + ob.c);
				System.out.println("Recorridos: " + ob.r);
				System.out.println("Intercambios: " + ob.in);
				// System.out.println(Arrays.toString(arr));
				break;
			case 8:
				System.out.println("Ordenando por el metodo Busqueda Binaria");

				System.out.println("Arreglo ordenado");
				System.out.println("Comparaciones: " + ob.c);
				System.out.println("Recorridos: " + ob.r);
				System.out.println("Intercambios: " + ob.in);
				// System.out.println(Arrays.toString(arr));
				break;
			case 9:
				System.out.println("Ordenando por el metodo Metodo busqueda por funciones hash");

				System.out.println("Arreglo ordenado");
				System.out.println("Comparaciones: " + ob.c);
				System.out.println("Recorridos: " + ob.r);
				System.out.println("Intercambios: " + ob.in);
				// System.out.println(Arrays.toString(arr));
				break;
			case 10:
				System.out.println("Saliendo");
				a = false;
				break;

			default:
				break;
			}


			System.out.println();
			
			
		} while (a);
		e.close();
	}

}
