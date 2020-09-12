public class SistemaLinear implements Cloneable
{
	private int qtd;
	private Equacao[] equacoes;

	public SistemaLinear(int qtd)//Recebe como parâmetro um inteiro que será quantas equações o sistema terá;
	{
		this.equacoes = new Equacao[qtd];

		this.qtd = qtd;
	}

	public SistemaLinear(SistemaLinear modelo)throws Exception
	{
		if(modelo == null)
			throw new Exception("modelo inválido");

		this.qtd = modelo.getQtd();
		this.equacoes = new Equacao[(modelo.getQtd())];

		for(int i=0;i<this.qtd;i++)
		{
			for(int x=0;x<this.qtd;x++)
				this.equacoes[i].addVar(modelo.getEquacao(i).getVar(x),x);//Adiciono todas as variáveis;

			for(int x=0;x<this.qtd+1;x++)
				this.equacoes[i].addNum(modelo.getEquacao(i).getNum(x),x);//Adiciono todos os coeficientes e igualdades;
		}
	}

	public int getQtd()
	{
		return this.qtd;
	}

	public Equacao getEquacao(int i)
	{
		return this.equacoes[i];
	}

	public void addEquacao(Equacao e, int i)throws Exception//Adiciona uma Equacao em this.equacoes
	{
		if(e==null)
		   throw new Exception("Equação ausente");


		this.equacoes[i] = (Equacao)e.clone();
	}

	public String toString()
	{
		String ret = "";

		for(int i=0;i<this.qtd;i++)
			ret = ret + this.equacoes[i].toString()+"\n";

		return "Sistema: \n" + ret;
	}

	public boolean equals(Object obj)//equals
	{
		if(this==obj)
			return true;

		if(obj==null)
			return false;

		if(this.getClass()!=obj.getClass())
			return false;

		SistemaLinear s = (SistemaLinear)obj;

		if(this.qtd != s.qtd)
		   return false;

		for(int i=0; i<this.qtd; i++)
			if(this.equacoes[i]!= s.equacoes[i])
			   return false;

		return true;
	}

	public int hashCode()//hashCode
	{
		int ret = 10;

		ret = ret*7 + new Integer(this.qtd).hashCode();

		for(int i=0;i<this.qtd;i++)
			ret = ret*7 + this.equacoes[i].hashCode();


		if(ret<0)
		   ret = -ret;

		return ret;
	}

	public SistemaLinear clone()
	{
		SistemaLinear ret = null;

		try
		{
			ret = new SistemaLinear(this);
		}
		catch(Exception erro){System.out.println(erro);}

		return ret;
	}

}