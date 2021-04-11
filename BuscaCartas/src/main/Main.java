package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

import processo.ConsultaCartasThread;

public class Main {

	public static void main(String[] args) throws IOException {
		List<String> cartas = new ArrayList<String>();
		cartas.add("Sinete Arcano");
		cartas.add("A Ancianomancia");
		cartas.add("Paradise Druid");
		ConsultaCartasThread thread = new ConsultaCartasThread(cartas);
		Timer timer = new Timer();
		timer.schedule(thread, 0, 100000);
		thread.run();
	}

}
