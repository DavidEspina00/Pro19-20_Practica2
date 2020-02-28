package practica;

import java.util.Scanner;

public class ValidarHora {
	public static void main(String[] args) {

		Scanner tec = new Scanner(System.in);

		// Pido la hora al usuario
		System.out.println("Introduce la hora: ");
		String hora = tec.nextLine();

		// Si hay dos puntos:
		if (hora.indexOf(":") != -1) {

			// Averiguo la ubicacion de los dos puntos
			int dosPuntos = hora.indexOf(":");

			// Separo los minutos de las horas
			String horas = hora.substring(0, dosPuntos);
			String minutos = hora.substring(dosPuntos + 1);

			// Si el valor de las variables es nulo, las cambio por "0" para
			// pasarlo a entero
			if (horas.equals(""))
				horas = "00";
			else if (minutos.equals(""))
				minutos = "00";

			// Paso las horas y los minutos a enteros
			int horasInt = Integer.parseInt(horas);
			int minutosInt = Integer.parseInt(minutos);

			// Compruebo que la hora es correcta
			if (horasInt < 25 && minutosInt < 60) {

				// Si las horas estan vacias
				if (horasInt == 0) {
					horasInt += 12;
					System.out.format("%02d:%02d %n", horasInt, minutosInt);
					System.out.println("Es correcta");

				} else {
					System.out.format("%02d:%02d %n", horasInt, minutosInt);
					System.out.println("Es correcta");
				}

			} else
				System.out.println("La hora no es correcta");
		}

		// Si no hay dos puntos:
		else {

			// Paso las horas a entero y creo la variable minutos que rellenare
			// segun me pida
			int horas = Integer.parseInt(hora);
			int minutos;

			// Si solo se introduce un caracter
			if (horas < 10) {
				minutos = 0;

				System.out.format("%02d:%02d %n", horas, minutos);
				System.out.println("La hora es correcta");
			}

			// Si se introducen dos caracteres y es una hora correcta
			else if (horas > 9 && horas < 24) {
				minutos = 0;

				System.out.format("%02d:%02d %n", horas, minutos);
				System.out.println("La hora es correcta");
			}

			// Si se introducen dos caracteres y supera el valor de una hora
			// correcta
			// Pongo mayot que 24 para que supere el valor de una hora correcta
			// y menor que 96 porque la maxima hora que se podria
			// representar en este caso son las 09:50
			else if (horas > 24 && horas < 96) {
				minutos = (horas % 10) * 10;
				horas = horas / 10;

				System.out.format("%02d:%02d %n", horas, minutos);
				System.out.println("La hora es correcta");
			}

			// Si se introducen tres caracteres
			// Pongo mayor que 99 para que sean 3 caracteres y menor que 960
			// porque la maxima hora que se podria
			// representar en este caso son las 09:59
			else if (horas > 99 && horas < 960) {
				minutos = horas % 100;
				horas = horas / 100;

				System.out.format("%02d:%02d %n", horas, minutos);
				System.out.println("La hora es correcta");
			}

			// Si se introducen cuatro caracteres
			// Pongo mayor que 999 para que sean 4 caracteres y menor que 2360
			// porque la maxima hora que se podria
			// representar en este caso son las 29:59
			else if (horas > 999 && horas < 2360) {
				minutos = horas % 100;
				horas = horas / 100;

				System.out.format("%02d:%02d %n", horas, minutos);
				System.out.println("La hora es correcta");
			}
			
			//El resto de posibilidades son horas incorrectas
			else
				System.out.println("La hora es incorrecta");

		}

	}
}
