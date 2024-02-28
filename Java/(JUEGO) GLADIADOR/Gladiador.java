import java.util.Scanner;

public class Gladiador{
	public static void main(String[] args) {
	Scanner sn = new Scanner (System.in);
	
	int vida = 100;
	int asaltos = 0;
	String NombreGladiador;
	int preparado;
	int esquivar = 0;
	int EsquivarSeguidas = 0;
	
	int DireccionAtaqueMonstruo;
	int DañoAtaqueMonstruo;
	System.out.print("\r\n"
			+ "   ___ _           _ _           _            \r\n"
			+ "  / _ \\ | __ _  __| (_) __ _  __| | ___  _ __ \r\n"
			+ " / /_\\/ |/ _` |/ _` | |/ _` |/ _` |/ _ \\| '__|\r\n"
			+ "/ /_\\\\| | (_| | (_| | | (_| | (_| | (_) | |   \r\n"
			+ "\\____/|_|\\__,_|\\__,_|_|\\__,_|\\__,_|\\___/|_|   \r\n"
			+ "                                              \r\n"
			+ "");
	System.out.println("-------------------------------------------------");
	System.out.println("");
	System.out.print("Bienvenido a la arena, introduce tu nombre: ");
	NombreGladiador = sn.next();
	System.out.println("");
	System.out.println("El gladiador " + NombreGladiador + " se inscribe a la lucha.");
	System.out.println("");
	System.out.print("Pulsa 1 cuando desees entrar en la arena: ");
	preparado = sn.nextInt();
	if (preparado != 1)
	{
		System.out.print("Pulsa 1 cuando desees entrar en la arena: ");
		preparado = sn.nextInt();
	}
	while (preparado == 1)
	{
		if (vida <= 0)
		{
			System.out.println("");
			System.out.println("El gladiador " + NombreGladiador + " ha sido derrotado.");
			System.out.println("");
			System.out.println("Ha sobrevivido " + asaltos + " asaltos");
			System.exit(1);
		}
		
		else
		{
			
			if (vida <0 && asaltos == 15)
			{
				System.out.println("");
				System.out.println("Enhorabuena!!");
				System.out.println("");
				System.out.println("El gladiador " + NombreGladiador + " ha ganado!.");
				System.out.println("");
				System.out.println("Ha sobrevivido " + asaltos + " asaltos");
				System.out.println("");
				System.out.println(NombreGladiador + " se corona como lider de la arena!.");
			}
			
			asaltos ++;
			System.out.println("");
			System.out.println("");
			System.out.println("#·🏴‍☠️:-------------------------:🏴‍☠️");
			System.out.println("#·🏴‍☠️          ASALTO " + asaltos);           
			System.out.println("#·🏴‍☠️:-------------------------:🏴‍☠️");
			System.out.println("");
			System.out.println(" #-😈-# El monstruo te ataca #-😈-#");
			System.out.println("");
			System.out.println(" + | 🛡️+++++++++++++++++🛡️");
			System.out.println(" + | Rápido!, defiendete ");
			System.out.println(" + | 🛡️+++++++++++++++++🛡️");
			System.out.println("");
			System.out.println("    + | 0. Altura baja");
			System.out.println("    + | 1. Altura media");
			System.out.println("    + | 2. Altura alta");
			System.out.println("");
			System.out.println(" + | 🛡️++++++++++++++++++🛡️");
			System.out.print(" + | Introduce el número: ");
			esquivar = sn.nextInt();
			System.out.println(" + | 🛡️++++++++++++++++++🛡️");
			System.out.println("");
			
			while (esquivar < 0 || esquivar > 2)
			{
				System.out.println("");
				System.out.println(" + | 🛡️++++++++++++++++++🛡️");
				System.out.print(" + | Introduce el número: ");
				esquivar = sn.nextInt();
				System.out.println(" + | 🛡️++++++++++++++++++🛡️");
			}
			
			System.out.println("");
			System.out.println("");
			DireccionAtaqueMonstruo = (int)(Math.random()*3);
			System.out.println("#·🏴‍☠️:-------------------------:🏴‍☠️");
			System.out.println("#·🏴‍☠️ RESULTADO - ASALTO " + asaltos + " -:🏴‍☠️");
			System.out.println("#·🏴‍☠️:-------------------------:🏴‍☠️");
			System.out.println("");
			System.out.println("#-#-# ⚔️··················⚔️ #-#-#");
			System.out.println("#-#-# El monstruo te ataca al " + DireccionAtaqueMonstruo + " #-#-#");
			System.out.println("#-#-# ⚔️··················⚔️ #-#-#");
			System.out.println("");
			
			if (DireccionAtaqueMonstruo != esquivar)
			{
				EsquivarSeguidas = 0;
				DañoAtaqueMonstruo = (int)(Math.random()*30 + 1);
				vida = vida - DañoAtaqueMonstruo;
				System.out.println("  + | 🛡️++++++++++++++++++++++++++++++++🛡️");
				System.out.println("  + | #### Ugghh!!!, te has comido el ataque.");
				System.out.println("  + | ");
				System.out.println("  + | -" + DañoAtaqueMonstruo + " puntos de vida.");
				System.out.println("  + | ");
				System.out.println("  + | ---Tienes " + vida + " puntos de vida.---");
				System.out.println("  + | 🛡️++++++++++++++++++++++++++++++++🛡️");
			}
			
			else if (DireccionAtaqueMonstruo == esquivar)
			{
				EsquivarSeguidas ++;
				System.out.println("++++ Sii!!, lo has esquivado.");
				System.out.println("");
				System.out.println("---Tienes " + vida + " puntos de vida.---");
				System.out.println("");
				
			}
				if (EsquivarSeguidas >= 3)
				{
					System.out.println("Increible!, has esquivado 3 veces seguidas.");
					System.out.println("");
					System.out.println("Ganas 5 puntos de vida!.");
					vida = vida + 5;
					if (vida >= 100)
					{
						vida = 100;
					}
					System.out.println("Tienes " + vida + " puntos de vida.");
					EsquivarSeguidas = 0;	
				}
			}	
		}
	}
}