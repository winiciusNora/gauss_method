public class Gauss
{
	private int qtd;
	private Equacao  [] linhas;
	private SistemaLinear sistema;

	public Gauss(SistemaLinear s)throws Exception
	{
		this.qtd     = s.getQtd();
		this.linhas  = new Equacao[s.getQtd()];
		this.sistema = new SistemaLinear(s.getQtd());

		this.setSistema(s);
	}

	public void setSistema(SistemaLinear s)throws Exception
	{
		if(s==null)
			throw new Exception("Sistema ausente");

		this.sistema = s;
	}

	public SistemaLinear getSistema()
	{
		return this.sistema;
	}

	public void Atribuidor(SistemaLinear s)
	{
		for(int i=0;i<this.qtd;i++)
			this.linhas[i] = s.getEquacao(i);
	}

	public SistemaLinear TrocadorDeLinhas(SistemaLinear s)throws Exception
	{
		this.Atribuidor(s);

		SistemaLinear ret = new SistemaLinear(s.getQtd());

		for(int i=0;i<this.qtd;i++)
			for(int x=this.qtd-1;x>=0;x--)
				ret.addEquacao(this.linhas[x],i);//recebe uma equacao como parâmetro e um inteiro pra indicar a posição no vetor


		return ret;
	}

	public boolean isValida()throws Exception
	{
		for(int i=0;i<this.qtd-1;i++)//this.qtd-1. Para ir até a penultima equação
		{
			int contador=0;
			Equacao e = this.sistema.getEquacao(i);
			Equacao eq = new Equacao(e.getQtd());

			for(int x=0;x<this.qtd;x++)
			{
				eq.addVar(e.getVar(x),x);//Adiciona todas as variáveis de Equacao e em Equacao eq;

				Double num = e.getNum(x)/this.sistema.getEquacao((i+1)).getNum(x);

				eq.addNum(num,x);
			}

			for(int x=1;x<=this.qtd;x++)
				if(eq.getNum(0).equals(eq.getNum(x)))
					contador++;

			if(contador == this.qtd)
				return false;

		}

		return true;
	}

	public boolean isZeroInDiagonal(SistemaLinear s)
	{
		for(int i=0;i<s.getQtd();i++)
			if(s.getEquacao(i).getNum(i) == 0)
				return true;

		return false;
	}

	public void diagonalAdapter(int pos)
	{
		try
		{
			Double num = this.sistema.getEquacao(pos).getNum(pos);//seleciono determinado numero da diagonal principal;

			Equacao e = this.sistema.getEquacao(pos);//seleciono determinada equacao do sistema;

        	if(isValida()==true)
				for(int i=0;i<this.qtd+1;i++)
					e.setNum(e.getNum(i)/num,i);//aplico o setNum em todos os numeros da equacao ret, mudando para a razão entre o getNum()/num;
		}
		catch(Exception erro){System.out.println(erro);}
	}

	public void zeroTransformer(int eq, int num)throws Exception
	{
		try
		{
			Equacao equacao = this.sistema.getEquacao(eq);
			Equacao e  = (Equacao)this.sistema.getEquacao(num).clone();//seleciono determinada equacao do sistema;
			Double numero1 = this.sistema.getEquacao(eq).getNum(num);

			for(int i=0;i<this.qtd+1;i++){
				e.setNum(e.getNum(i)*numero1,i);
				equacao.setNum((e.getNum(i)-equacao.getNum(i)),i);
			}
		}
		catch(Exception erro){System.out.println(erro);}
	}

	public boolean diagonalDetector(int linha, int coluna)
	{
		if(linha == coluna)
			return true;

		return false;
	}

	public boolean isIgualdade(int pos)
	{
		for(int i=0;i<this.qtd;i++)
		{
			Equacao e = this.sistema.getEquacao(i);
			Double num = e.getNum(pos);

			if(num == e.getNum(e.getQtd()+1))
				return true;
		}

		return false;
	}

	public void columAdapter(int coluna)throws Exception
	{
		if(coluna > this.qtd)
			throw new Exception("número inválido");

		for(int i=0;i<this.qtd;i++)
		{
			if(diagonalDetector(i,coluna)==true)
				continue;

			zeroTransformer(i,coluna);
		}
	}

	public void systemAdapter()
	{
		try
		{
			int aux=0;

			while(aux<=this.sistema.getQtd())
			{
				if(this.isZeroInDiagonal(this.sistema)==false)
				{
					for(int i=0;i<this.qtd;i++)
						diagonalAdapter(i);

					for(int x=0;x<this.qtd+1;x++)
						columAdapter(x);
				}
				else
					this.TrocadorDeLinhas(this.sistema);

				aux++;
			}
		}
		catch(Exception erro){System.out.println(erro);}

	}

	public String toString()
	{
		String ret="";

		ret = ret + this.sistema.toString()+"\n";

		return ret;
	}

}