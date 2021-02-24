/**
*
*/
package fecha;

/**
* @author Raul
*
*/
public class Fecha {

public int d;
public int m;
public int a;

public Fecha(int d, int m, int a) {
this.d = d;
this.m = m;
this.a = a;
}

public boolean valida() {

if (d < 1 || d > 31)
return false;
if (m < 1 || m > 12)
return false;

// Determinamos la cantidad de días del mes:
int diasMes = 0;
switch (m) {
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
if ((a % 400 == 0) || ((a % 4 == 0) && (a % 100 != 0)))
diasMes = 29;
else
diasMes = 28;
break;

}

if (d > diasMes)
return false;
else
return true;

}

}