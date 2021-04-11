package consulta;

import java.util.List;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import main.Common;

public class Consulta {

	private static Consulta consulta;

	private String urlBase = "https://www.multiversogamecafe.com/";

	private String parametros = "?view=ecom%2Fitens&page=1&id=181711&txt_order=1&txt_limit=20&txt_estoque=1&btFiltrar=Filtrar&busca=";

	private Consulta() {
	}

	public static Consulta getInstance() {
		if (consulta != null) {
			return consulta;
		} else {
			consulta = new Consulta();
			return consulta;
		}
	}

	public void consultar(String carta) {
		URL url;
		try {
			String urlCompleta = urlBase + parametros + Common.encodeValue(carta);
			url = new URL(urlCompleta);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));

			String inputLine;
			String fullInput = "";
			while ((inputLine = in.readLine()) != null)
				fullInput += inputLine;
			in.close();
			if (!fullInput.contains("Nenhum item encontrado com os filtros utilizados")) {
				System.out.println("Carta: '" + carta + "' encontrada > Link ->" + urlCompleta);
			} else {
				System.out.println(carta + " não encontrada");
			}
		} catch (MalformedURLException e) {
			System.out.println(carta + " não encontrada. Erro " + Erros.URL_EXCEPTION);
		} catch (IOException e) {
			System.out.println(carta + " não encontrada. Erro " + Erros.IO_EXCEPTION);
		}		
	}
	
	public void consultar(List<String> cartas) {
		for (String carta : cartas)
			consultar(carta);
	}
	
	

}
