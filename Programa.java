import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Programa
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));

		        System.out.println ("Digite quantos coeficientes e vari�veis sua equa��o ter�: ");
		        int qtdCoef = Integer.parseInt(entrada.readLine());

		        Equacao e = new Equacao(qtdCoef);//Instanc�o o objeto 'e', e de acordo com a quantidade de equa��es do sistema eu starto os vetores da class Equacao

		        for(int i=0;i<qtdCoef;i++)
		        {
		        	System.out.println("Qual vai ser o "+(i+1)+"�coeficiente da equa��o? ");
		        	Double num = Double.parseDouble(entrada.readLine());

		        	e.addNum(num,i);

		        	System.out.println("\n");

		        	System.out.println("Qual vai ser a "+(i+1)+"�vari�vel da equa��o? ");
		        	char var = entrada.readLine().charAt(0);

		        	e.addVar(var,i);

		        	System.out.println("\n");
		        }

		        System.out.println("Qual ser� a igualdade da equa��o? ");
		        Double igualdade = Double.parseDouble(entrada.readLine());

		        e.addNum(igualdade,qtdCoef);

		        System.out.println(e);
		}
		catch(Exception erro){System.out.println(erro);}
	}
}