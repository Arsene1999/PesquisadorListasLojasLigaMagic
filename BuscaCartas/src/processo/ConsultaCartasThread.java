package processo;

import java.util.ArrayList;
import java.util.List;
import java.util.TimerTask;

import consulta.Consulta;

public class ConsultaCartasThread extends TimerTask {

	private List<String> cartas;

	public ConsultaCartasThread(String carta) {
		if (this.cartas == null) {
			this.cartas = new ArrayList<String>();
			this.cartas.add(carta);
		} else {
			this.cartas.add(carta);
		}
	}

	public ConsultaCartasThread(List<String> cartas) {
		this.cartas = cartas;
	}

	@Override
	public void run() {
		Consulta.getInstance().consultar(this.cartas);
	}

}
