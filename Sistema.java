import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sistema
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));

		    System.out.println ("Digite quantas equa��es seu sistema ter�: ");
		    	int qtdEquacoes = Integer.parseInt(entrada.readLine());

			Equacao e = new Equacao(qtdEquacoes);
		   	SistemaLinear s = new SistemaLinear(qtdEquacoes);


				for(int i=0;i<qtdEquacoes;i++)
				{
					System.out.println("Qual vai ser a "+(i+1)+"�vari�vel do sistema? ");
					char var = entrada.readLine().charAt(0);

					e.addVar(var,i);

					System.out.println("\n");
				}

				for(int i=0;i<qtdEquacoes;i++)
				{
					for(int x=0;x<qtdEquacoes;x++)
					{
						System.out.println("Qual vai ser o "+(x+1)+"�coeficiente da "+(i+1)+"�equa��o? ");
						Double num = Double.parseDouble(entrada.readLine());

						e.addNum(num,x);

						System.out.println("\n");
					}

					System.out.println("Qual ser� a igualdade da "+(i+1)+"�equa��o? ");
					Double igualdade = Double.parseDouble(entrada.readLine());

					e.addNum(igualdade,qtdEquacoes);

					System.out.println("\n");

					s.addEquacao(e,i);
				}

			System.out.println(s);
		}

		catch(Exception erro){System.out.println(erro);}
	}
}