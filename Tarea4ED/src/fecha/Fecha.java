/**
*
*/
package fecha;

/**
 * @author Raul
 * @version 1.6
 */
public class Fecha {

	public int dia;
	public int mes;
	public int anyo;

	public Fecha(int dia, int mes, int anyo) {
		this.dia = dia;
		this.mes = mes;
		this.anyo = anyo;
	}

	public boolean valida() { /* Comprueba que el día y el mes introducidos son válidos*/

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

	
	public int bisiesto() {
		int diasMes;
		if ((anyo % 400 == 0) || ((anyo % 4 == 0) && (anyo % 100 != 0)))
			diasMes = 29;
		else
			diasMes = 28;
		return diasMes;
	}

	/**
	 * @param diasMes es el número máximo de dias en un mes
	 * @return La fecha será válida o no válida
	 * @deprecated Use {@link #validarFecha(int)} instead
	 */
	public boolean validar(int diasMes) {
		return validarFecha(diasMes);
	}

	/**
	 * @param diasMes es el número máximo de dias en un mes
	 * @return La fecha será válida o no válida
	 */
	public boolean validarFecha(int diasMes) {
		if (dia > diasMes)
			return false;
		else
			return true;
	}

}
