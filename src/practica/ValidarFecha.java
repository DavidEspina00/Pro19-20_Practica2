package practica;

import java.util.Scanner;

import utiles.Fechas;

/**
 * Clase de programa que hara uso de la clase de utilidad Fechas para averigura
 * si una fecha que introduce el usuario es correcta o no.
 * 
 * @author nombre del alumno
 *
 */
public class ValidarFecha {
	// Definimos el objeto Scanner tec fuera de los metodos. Al hacerlo as�
	// podemos usar
	// tec tanto en el metodo main como en el resto de m�todos
	static Scanner tec = new Scanner(System.in);

	public static void main(String[] args) {
		int opcion;
		do {
			opcion = elegirOpcionMenu();
			switch (opcion) {
			case 0:
				System.out.println("Fin del programa");
				break;
			case 1:
				opcion1();
				break;
			case 2:
				opcion2();
				break;
			}
			System.out.println("----------------------------------------------");
		} while (opcion != 0); // Cuando es 0 termina el bucle

	}

	/**
	 * Muestra el menu descrito en el enunciado y permite al usuario elegir una
	 * opci�n. Si el usuario pone una opci�n incorrecta, le avisa y le deja
	 * volver a seleccionar una opcion
	 * 
	 * @return la opcion elegida por el usuario: 0, 1, 2, ....
	 */
	public static int elegirOpcionMenu() {
		// Completar: Bucle que muestre el menu y lea la opcion que elija el
		// usuario mientras que el usuario elija una opcion incorrecta.

		int opcion;
		boolean bucle;
		do {
			System.out.println("Elige una opcion: ");
			System.out.println("0 - Salir");
			System.out.println("1 - Validar una fecha");
			System.out.println("2 - Comparar dos fechas");
			opcion = tec.nextInt();
			tec.nextLine();

			bucle = opcion != 0 && opcion != 1 && opcion != 2;
			if (bucle)
				System.out.println("Opcion incorrecta");

		} while (bucle);

		return opcion;

	}

	/**
	 * Metodo para responder a la opcion 1 del menu. Lee una fecha y le dice �
	 * al usuario si es correcta o incorrecta
	 */
	public static void opcion1() {
		// Pedir y Leer una fecha como String
		System.out.println("Introduce una fecha");
		String fecha = tec.nextLine();

		// Descompomner la fecha en dia mes y anyo
		int barra = fecha.indexOf("/");
		int barra2 = fecha.indexOf("/", barra + 1);
		String dia = fecha.substring(0, barra);
		String mes = fecha.substring(barra + 1, barra2);
		String anyo = fecha.substring(barra2 + 1);

		// Comprobar si es valida y mostrar el mensaje correspondiente
		int diaInt = Integer.valueOf(dia);
		int mesInt = Integer.valueOf(mes);
		int anyoInt = Integer.valueOf(anyo);

		if (Fechas.esFechaValida(diaInt, mesInt, anyoInt))
			System.out.println(dia + " de " + Fechas.nombreDelMes(mesInt) + " de " + anyo + ": Fecha correcta");
		else
			System.out.println("Dia: " + diaInt + ", Mes: " + mesInt + " Anyo: " + anyoInt + ". Fecha incorrecta");

	}

	public static void opcion2() {

		int barra, barra2, diaInt, mesInt, anyoInt, diaInt2, mesInt2, anyoInt2;
		String fecha, dia, mes, anyo, fecha2;

		// Bucle que lea la primera fecha mientras el usuario introduzca una
		// fecha
		// incorrecta
		do {

			System.out.println("Introduce la primera fecha");
			fecha = tec.nextLine();

			barra = fecha.indexOf("/");
			barra2 = fecha.indexOf("/", barra + 1);
			dia = fecha.substring(0, barra);
			mes = fecha.substring(barra + 1, barra2);
			anyo = fecha.substring(barra2 + 1);

			diaInt = Integer.valueOf(dia);
			mesInt = Integer.valueOf(mes);
			anyoInt = Integer.valueOf(anyo);

			if (!Fechas.esFechaValida(diaInt, mesInt, anyoInt))
				System.out.println("Fecha incorrecta, introduce de nuevo");

		} while (!Fechas.esFechaValida(diaInt, mesInt, anyoInt));

		// Bucle que lea la segunda fecha mientras el usuario introduzca una
		// fecha
		// incorrecta
		do {

			System.out.println("Introduce la segunda fecha");
			fecha2 = tec.nextLine();

			barra = fecha2.indexOf("/");
			barra2 = fecha2.indexOf("/", barra + 1);
			dia = fecha2.substring(0, barra);
			mes = fecha2.substring(barra + 1, barra2);
			anyo = fecha2.substring(barra2 + 1);

			diaInt2 = Integer.valueOf(dia);
			mesInt2 = Integer.valueOf(mes);
			anyoInt2 = Integer.valueOf(anyo);

			if (!Fechas.esFechaValida(diaInt2, mesInt2, anyoInt2))
				System.out.println("Fecha incorrecta, introduce de nuevo");

		} while (!Fechas.esFechaValida(diaInt2, mesInt2, anyoInt2));

		// Comprobar cual es la menor, usando el metodo Fechas.compararFechas y
		// mostrar
		// el mensaje correspondiente
		if (Fechas.compararFechas(diaInt, mesInt, anyoInt, diaInt2, mesInt2, anyoInt2) == -1)
			System.out.println("La fecha menor es: " + fecha);

		else if (Fechas.compararFechas(diaInt, mesInt, anyoInt, diaInt2, mesInt2, anyoInt2) == 1)
			System.out.println("La fecha menor es: " + fecha2);

		else if (Fechas.compararFechas(diaInt, mesInt, anyoInt, diaInt2, mesInt2, anyoInt2) == 0)
			System.out.println("Las dos fechas son iguales");

	}

}
