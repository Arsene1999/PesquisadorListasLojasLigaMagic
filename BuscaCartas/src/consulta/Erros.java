package consulta;

public enum Erros {
	IO_EXCEPTION(1), URL_EXCEPTION(2);

	private final int valor;

	Erros(int valorOpcao){
	valor = valorOpcao;
	}

	public int getValor() {
		return valor;
	}

}
