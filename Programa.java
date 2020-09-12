import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Programa
{
	public static void main(String[] args)
	{
		try
		{
			BufferedReader entrada = new BufferedReader (new InputStreamReader(System.in));

		        System.out.println ("Digite quantos coeficientes e variáveis sua equação terá: ");
		        int qtdCoef = Integer.parseInt(entrada.readLine());

		        Equacao e = new Equacao(qtdCoef);//Instancío o objeto 'e', e de acordo com a quantidade de equações do sistema eu starto os vetores da class Equacao

		        for(int i=0;i<qtdCoef;i++)
		        {
		        	System.out.println("Qual vai ser o "+(i+1)+"ºcoeficiente da equação? ");
		        	Double num = Double.parseDouble(entrada.readLine());

		        	e.addNum(num,i);

		        	System.out.println("\n");

		        	System.out.println("Qual vai ser a "+(i+1)+"ªvariável da equação? ");
		        	char var = entrada.readLine().charAt(0);

		        	e.addVar(var,i);

		        	System.out.println("\n");
		        }

		        System.out.println("Qual será a igualdade da equação? ");
		        Double igualdade = Double.parseDouble(entrada.readLine());

		        e.addNum(igualdade,qtdCoef);

		        System.out.println(e);
		}
		catch(Exception erro){System.out.println(erro);}
	}
}