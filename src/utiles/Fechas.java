package utiles;

/**
 * Esta es una clase de utilidad, con metodos static. Se trata de metodos utiles
 * para trabajar con fechas.
 * 
 * @author nombre del alumno/a
 *
 */
public class Fechas {

	/**
	 * Determina si un anyo es o no bisiesto.
	 * 
	 * @param anyo
	 *            el anyo
	 * @return true si el anyo es bisiesto y false en caso contrario
	 */
	public static boolean esBisiesto(int anyo) {

		boolean bisiesto = anyo % 400 == 0 || anyo % 4 == 0 && anyo % 100 != 0;
		return bisiesto;

	}

	/**
	 * Devuelve el numero de dias que tiene un mes de determinado anyo. El anyo
	 * es necesario porque el mes de febrero puede tener un numero distinto de
	 * dias dependiendo de si el anyo es o no bisiesto.
	 * 
	 * @param mes
	 *            El mes. Estara entre 1 y 12.
	 * @param anyo
	 *            El anyo. Valor positivo
	 * @return el numero de dias que tiene el mes
	 */
	public static int diasDelMes(int mes, int anyo) {
		// COMPLETAR ...
		// Habra que llamar al metodo esBisiesto cuando el mes sea febrero, para
		// averiguar el numero de dias

		int diasMes = 0;

		switch (mes) {
		case 2:
			if (esBisiesto(anyo))
				diasMes = 29;
			else
				diasMes = 28;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diasMes = 30;
			break;
		default:
			diasMes = 31;
			break;
		}

		return diasMes;

	}

	/**
	 * Devuelve el nombre de un mes: "Enero", "Febrero", ....
	 * 
	 * @param mes
	 *            El mes del que se pide el nombre. Estara entre 1 y 12
	 * @return el nombre del mes correspondiente
	 */
	public static String nombreDelMes(int mes) {
		// Completar ...

		String mesString = null;

		switch (mes) {
		case 1:
			mesString = "Enero";
			break;
		case 2:
			mesString = "Febrero";
			break;
		case 3:
			mesString = "Marzo";
			break;
		case 4:
			mesString = "Abril";
			break;
		case 5:
			mesString = "Mayo";
			break;
		case 6:
			mesString = "Junio";
			break;
		case 7:
			mesString = "Julio";
			break;
		case 8:
			mesString = "Agosto";
			break;
		case 9:
			mesString = "Septiembre";
			break;
		case 10:
			mesString = "Octubre";
			break;
		case 11:
			mesString = "Noviembre";
			break;
		case 12:
			mesString = "Diciembre";
			break;
		}

		return mesString;

	}

	/**
	 * Dado un String que contiene una fecha en formato dd/mm/aaaa devuelve un
	 * entero con el dia de la fecha.
	 * 
	 * @param fecha
	 *            String con formato dd/mm/aaaa. La longitud del string no tiene
	 *            por que ser 10, pues el dia y el mes se pueden expresar con
	 *            uno o dos digitos.
	 * @return el dia de la fecha
	 */
	public static int extraerDia(String fecha) {
		// Completar ...

		String dia = fecha.substring(0, 2);

		int diaInt = Integer.parseInt(dia);

		return diaInt;

	}

	/**
	 * Dado un String que contiene una fecha en formato dd/mm/aaaa devuelve un
	 * entero con el mes de la fecha.
	 * 
	 * @param fecha
	 *            String con formato dd/mm/aaaa. La longitud del string no tiene
	 *            por que ser 10, pues el dia y el mes se pueden expresar con
	 *            uno o dos digitos.
	 * @return el mes de la fecha
	 */
	public static int extraerMes(String fecha) {
		// Completar ...

		String mes = fecha.substring(3, 5);

		int mesInt = Integer.parseInt(mes);

		return mesInt;

	}

	/**
	 * Dado un String que contiene una fecha en formato dd/mm/aaaa devuelve un
	 * entero con el anyo de la fecha.
	 * 
	 * @param fecha
	 *            String con formato dd/mm/aaaa. La longitud del string no tiene
	 *            por que ser 10, pues el dia y el mes se pueden expresar con
	 *            uno o dos digitos.
	 * @return el anyo de la fecha
	 */
	public static int extraerAnyo(String fecha) {
		// Completar ...

		String anyo = fecha.substring(6, 10);

		int anyoInt = Integer.parseInt(anyo);

		return anyoInt;

	}

	/**
	 * Dada una fecha expresada con tres valores (dia, mes y anyo), devuelve si
	 * la fecha es valida o no. Para que una fecha sea correcta: - El dia tiene
	 * que ser mayor que cero. - El dia tiene que ser menor o igual que el
	 * numero de dias que tiene el mes - El mes tiene que estar entre 1 y 12 -
	 * El anyo tiene que ser positivo.
	 * 
	 * @param dia
	 *            El dia de la fecha
	 * @param mes
	 *            El mes de la fecha
	 * @param anyo
	 *            El anyo de la fecha
	 * @return true si la fecha es valida y false si no lo es
	 */
	public static boolean esFechaValida(int dia, int mes, int anyo) {
		// Completar ...
		// Este metodo tendra que llamar a diasDelMes para averiguar cuantos
		// dias tiene el mes de la fecha que nos dan y asi comprobar
		// si el dia es correcto o no

		boolean valido = true;

		if (dia > 0 && dia <= diasDelMes(mes, anyo) && mes > 0 && mes <= 12 && anyo >= 0)
			valido = true;
		else
			valido = false;

		return valido;
	}

	/**
	 * Compara dos fechas para averiguar cual de ellas es la menor. Cada fecha
	 * vendra expresada por tres valores (dia, mes y anyo)
	 * 
	 * @param d1
	 *            Dia de la primera fecha
	 * @param m1
	 *            Mes de la primera fecha
	 * @param a1
	 *            Anyo de la primera fecha
	 * @param d2
	 *            Dia de la segunda fecha
	 * @param m2
	 *            Mes de la segunda fecha
	 * @param a2
	 *            Anyo de la segunda fecha
	 * @return un entero que ser�: -1 si la primera fecha es menor (anterior)
	 *         que la segunda 0 si las dos fechas son iguales +1 si la primera
	 *         fecha es mayor (posterior) que la segunda
	 */
	public static int compararFechas(int d1, int m1, int a1, int d2, int m2, int a2) {

		int fechaMayor = 0;

		if (a1 < a2)
			fechaMayor--;
		else if (a1 > a2)
			fechaMayor++;
		else if (m1 < m2)
			fechaMayor--;
		else if (m1 > m2)
			fechaMayor++;
		else if (d1 < d2)
			fechaMayor--;
		else if (d1 > d2)
			fechaMayor++;

		return fechaMayor;

	}
}
