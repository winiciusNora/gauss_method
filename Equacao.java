public class Equacao implements Cloneable
{
	private int qtd;
	private char[] var;
	private Double[] num;

	public Equacao(int qtd)//Recebe um inteiro como  parametro que sera a quantidade de coeficientes e variáveis da equação
	{
		this.var = new char[qtd];
		this.num = new Double[(qtd+1)];//qtd+1

		this.qtd = qtd;
	}

	public Equacao(Equacao modelo)throws Exception
	{
		if(modelo==null)
			throw new Exception("modelo inválido");

		this.var = new char[modelo.var.length];
		this.num = new Double[modelo.num.length+1];

		this.qtd = modelo.qtd;

		for(int i=0;i<this.qtd;i++)
			this.var[i] = modelo.var[i];

		for(int i=0;i<this.qtd+1;i++)//this.qtd+1
			this.num[i] = modelo.num[i];

	}

	public int getQtd()
	{
		return this.qtd;
	}

	public Double getNum(int i)
	{
		return this.num[i];
	}

	public char getVar(int i)
	{
		return this.var[i];
	}

	public void setNum(Double num,int pos)throws Exception
	{
		if(pos<0)
			throw new Exception();

		this.num[pos] = num;
	}

	public void setVar(int pos, char var)throws Exception
	{
		if(pos<0)
			throw new Exception();

		this.var[pos] = var;
	}

	public Double getIgualdade()
	{
		return this.num[this.qtd];
	}

	/*private void redimensioneSe(float num)//Redimensiona o vetor de acordo com sua necessidade
	{
		char  [] newVar = new char  [Math.round(this.var.length*num)];
		Double[] newNum = new Double[Math.round(this.num.length*num)];

		for(int i=0;i<this.qtd;i++)
		    newVar[i] = this.var[i];

		for(int i=0;i<this.qtd+1;i++)
		    newNum[i] = this.num[i];

		this.var = newVar;
		this.num = newNum;
	}*/

	public void addVar(char var, int i)throws Exception//Adiciona uma variável em this.var
	{
		if(this.equals(var))
		   throw new Exception("Variável existente");

		this.var[i] = var;
	}

	public void addNum(Double num, int i)throws Exception//Adiciona um numero em this.num
	{
		if(num==null)
		   throw new Exception("Número ausente");

		this.num[i] = num;
	}

	public String toString()//toString
	{
		String ret = "";

		for(int i=0;i<this.qtd-1;i++)
			ret = ret + this.num[i] + this.var[i] + " + ";

		ret = ret + this.num[this.qtd-1] + this.var[this.qtd-1];

		return ret + " = " + this.num[this.qtd];
	}

	public boolean equals(Object obj)//equals
	{
		if(this==obj)
		   	return true;

		if(obj==null)
			return false;

		if(this.getClass()!=obj.getClass())
			return false;

		Equacao e = (Equacao)obj;

		if(this.qtd != e.qtd)
		   return false;

		for(int i=0; i<this.qtd; i++)
			if(this.num[i]!= e.num[i] || this.var[i]!= e.var[i])
			   return false;

		return true;
	}

	public int hashCode()//hashCode
	{
		int ret = 10;

		ret = ret*7 + new Integer(this.qtd).hashCode();

		for(int i=0;i<this.qtd;i++)
		{
			ret = ret*7 + this.num[i].hashCode();
			ret = ret*7 + new Character(this.var[i]).hashCode();
		}

		if(ret<0)
		   ret = -ret;

		return ret;
	}

	public Object clone()//clone
	{
		Equacao ret = null;

		try
		{
			ret = new Equacao(this);
		}
		catch(Exception erro){System.out.println(erro);}

		return ret;
	}
}