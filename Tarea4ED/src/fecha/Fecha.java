/**
*
*/
package fecha;

/**
 * @author Raul
 *
 */
public class Fecha {

	public int dia;
	public int mes;
	public int año;

	public Fecha(int dia, int mes, int año) {
		this.dia = dia;
		this.mes = mes;
		this.año = año;
	}

	public boolean valida() {

		if (dia < 1 || dia > 31)
			return false;
		if (mes < 1 || mes > 12)
			return false;

// Determinamos la cantidad de días del mes:
		int diasMes = 0;
		switch (mes) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			diasMes = 31;
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			diasMes = 30;
			break;
		case 2: // Verificamos si el año es bisiesto
			diasMes = bisiesto();
			break;

		}

		return validarFecha(diasMes);
		/*
		 * Comprueba que el número de dia es inferior al número maximo de dias de un mes
		 */
	}

	/**
	 * @return
	 */
	public int bisiesto() {
		int diasMes;
		if ((año % 400 == 0) || ((año % 4 == 0) && (año % 100 != 0)))
			diasMes = 29;
		else
			diasMes = 28;
		return diasMes;
	}

	/**
	 * @param diasMes es el número máximo de dias en un mes
	 * @return La fecha será valida o no válida
	 * @deprecated Use {@link #validarFecha(int)} instead
	 */
	public boolean validar(int diasMes) {
		return validarFecha(diasMes);
	}

	/**
	 * @param diasMes es el número máximo de dias en un mes
	 * @return La fecha será valida o no válida
	 */
	public boolean validarFecha(int diasMes) {
		if (dia > diasMes)
			return false;
		else
			return true;
	}

}