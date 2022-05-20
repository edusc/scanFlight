package br.com.theasier.searchflight;

import br.com.theasier.searchflight.main.SearchFlightChain;

/**
 * Classe principal para a execução das scrappings
 * 
 * 
 * @author Eduardo Costa
 * 
 * */
public class SearchFlightMain {
	
	public static void main(String[] args) {
		try {
			new SearchFlightChain().execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
