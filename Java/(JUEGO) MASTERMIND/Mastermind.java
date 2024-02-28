package SEGUNDAEVALUACION;

import java.util.Arrays;
import java.util.Scanner;

public class Ejercicio16 {
public static void main(String[] args) {
Scanner sn = new Scanner (System.in);

int intentos_gastados = 1;

System.out.println("\r\n"
+ "                       _                      _           _ \r\n"
+ "                      | |                    (_)         | |\r\n"
+ "   _ __ ___   __ _ ___| |_ ___ _ __ _ __ ___  _ _ __   __| |\r\n"
+ "  | '_ ` _ \\ / _` / __| __/ _ \\ '__| '_ ` _ \\| | '_ \\ / _` |\r\n"
+ "  | | | | | | (_| \\__ \\ ||  __/ |  | | | | | | | | | | (_| |\r\n"
+ "  |_| |_| |_|\\__,_|___/\\__\\___|_|  |_| |_| |_|_|_| |_|\\__,_|\r\n");
System.out.println("  ----------------------------------------------------------");
System.out.println("");
System.out.println("                        CONFIGURACIÓN");
System.out.println("");
System.out.println("  ..........................................................");
System.out.println("");
System.out.print(" - Cantidad de digitos: ");
int cantidad_digitos = sn.nextInt();
System.out.println("");
System.out.print(" - Cantidad de intentos: ");
int cantidad_intentos = sn.nextInt();
System.out.println("");
System.out.println("                    --------------------");
System.out.println("                    | INICIO DEL JUEGO |");
System.out.println("                    --------------------");
System.out.println("");

int[] jugador1_codigo;
jugador1_codigo = new int [cantidad_digitos];
int[] jugador1_guess;
jugador1_guess = new int [cantidad_digitos];

int[] jugador2_codigo;
jugador2_codigo = new int [cantidad_digitos];
int[] jugador2_guess;
jugador2_guess = new int [cantidad_digitos];

System.out.println(" + Jugador 1 - escribe tu número secreto.");
System.out.println(" + (Solo contendrá " + cantidad_digitos + " digitos.)");
System.out.println("");


jugador1_codigo = CogerNumeros(jugador1_codigo,cantidad_digitos);
System.out.println("");
System.out.println("");
System.out.println(" + Tu código secreto es el:");
System.out.println(" + " + Arrays.toString(jugador1_codigo));

for (int contador = 0; contador < 30; contador++)
{
System.out.println("");
System.out.println("");
}

System.out.println(" + Jugador 2 - escribe tu número secreto.");
System.out.println(" + (Solo contendrá " + cantidad_digitos + " digitos.)");
System.out.println("");


jugador2_codigo = CogerNumeros(jugador2_codigo,cantidad_digitos);
System.out.println("");
System.out.println("");
System.out.println(" + Tu código secreto es el:");
System.out.println(" + " + Arrays.toString(jugador2_codigo));

for (int contador = 0; contador < 30; contador++)
{
System.out.println("");
System.out.println("");
}

//EMPIEZAN A ADIVINAR
for (intentos_gastados = cantidad_intentos; intentos_gastados > 0; intentos_gastados--)
{
System.out.println(" + Jugador 1 - te toca adivinar");
System.out.println(" + (Introduce tu tirada, deberás introducir " + cantidad_digitos + " digitos.)");
System.out.println(" + (Te quedan " + intentos_gastados + " intentos.");

System.out.println("");
jugador1_guess = CogerNumeros(jugador1_guess,cantidad_digitos);
System.out.println("");
Muertos(jugador2_codigo, jugador1_guess, cantidad_digitos);
System.out.println("");
Heridos(jugador2_codigo, jugador1_guess, cantidad_digitos);
System.out.println("");

for (int contador = 0; contador < 5; contador++)
{
System.out.println("");
System.out.println("   --------------------------------");
System.out.println("");
}

System.out.println("");
System.out.println(" - Jugador 2 - te toca adivinar");
System.out.println(" - (Introduce tu tirada, deberás introducir " + cantidad_digitos + " digitos.)");
System.out.println(" - (Te quedan " + intentos_gastados + " intentos.");
System.out.println("");
jugador2_guess = CogerNumeros(jugador2_guess,cantidad_digitos);
System.out.println("");
Muertos(jugador1_codigo, jugador2_guess, cantidad_digitos);
System.out.println("");
Heridos(jugador1_codigo, jugador2_guess, cantidad_digitos);
System.out.println("");

for (int contador = 0; contador < 5; contador++)
{
System.out.println("");
System.out.println("   --------------------------------");
System.out.println("");
}

LimpiezaCasillas(jugador1_guess);
LimpiezaCasillas(jugador2_guess);
}

if (intentos_gastados == 0)
{
	System.out.println("");
	System.out.println("   FIN DE LA PARTIDA, SE HAN ACABADO LOS INTENTOS");
	System.out.println("");
}
}

//COGERÁ LOS NUMEROS SECRETOS DE LOS JUGADORES AL PRINCIPIO DE LA PARTIDA//
static int [] CogerNumeros (int Tabla[], int cantidad_digitos)
{
Scanner sn = new Scanner (System.in);
for(int casilla = 0; casilla < cantidad_digitos; casilla++)
{
System.out.println("");
System.out.println("");
System.out.print("   Introduce cifra: ");

int numero_input = sn.nextInt();
System.out.println("");
System.out.print("   ");
for (int contador = 0; contador < cantidad_digitos; contador++)
{
Tabla[casilla] = numero_input;
if(Tabla[casilla] > 9)
{
Tabla[casilla] = 9;
}

if (Tabla[contador] > 0)
{
//ESTO SIMPLEMENTE ES DECORACIÓN//
System.out.print(Tabla[contador] + " ");
}

else
{

System.out.print(" _ ");
}
}
}
return Tabla;
}

static void Muertos (int TablaRespuesta[], int TablaAdivinanza[], int cantidad_digitos)
{   System.out.println("");
System.out.print("   MUERTOS: ");
int ganador = 0;
for (int contador = 0; contador < cantidad_digitos; contador++)
{
//HAS ADIVINADO//
	
if (TablaRespuesta[contador] == TablaAdivinanza[contador])
{
System.out.print(TablaRespuesta[contador] + " ");
ganador++;
}

else
{
System.out.print("X ");
}

if (ganador == cantidad_digitos)
{
	System.out.println("");
	System.out.println("   El jugador ha ganado la partida!");
	System.out.println("");
	System.exit(1);
}

}
}

static void Heridos(int TablaRespuesta[], int TablaAdivinanza[], int cantidad_digitos) {
   System.out.println("");
   System.out.print("   HERIDOS: ");
   for (int contador = 0; contador < cantidad_digitos; contador++) {
       boolean encontrado = false;

       for (int contador2 = 0; contador2 < cantidad_digitos; contador2++) {
           if (TablaRespuesta[contador] == TablaAdivinanza[contador2] && contador != contador2) {
               encontrado = true;
               break;
           }
       }
       if (encontrado == false) {
           System.out.print("X ");
       } else {
           System.out.print(TablaAdivinanza[contador] + " ");
       }
   }
}


static int [] LimpiezaCasillas(int Tabla[])
{
	for (int contador = 0; contador < Tabla.length; contador++)
	{
		Tabla[contador] = 0;
	}
	return Tabla;
}

}