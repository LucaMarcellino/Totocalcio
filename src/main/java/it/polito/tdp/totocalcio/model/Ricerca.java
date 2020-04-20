package it.polito.tdp.totocalcio.model;

import java.util.ArrayList;
import java.util.List;

public class Ricerca {
	
	private Pronostico pronostico;
	private int N;
	List<Risultato> soluzione;
	
	public List<Risultato> cerca(Pronostico pronostico) {
		this.pronostico=pronostico;
		this.N=pronostico.size();
		this.soluzione=new ArrayList<Risultato>();
		
		List<RisultatoPartita> parziale= new ArrayList<>();
		int livello=0;
		
		ricorsiva(parziale,livello);
		
		
		
		
		return soluzione;
	}
	private void ricorsiva(List<RisultatoPartita> parziale,int livello ) {
		
		//caso terminale
		if(livello==N) {
			this.soluzione.add(new Risultato(parziale));
		}else {
			//caso generale
			PronosticoPartita pp = pronostico.get(livello);
			//pp sotto problemi da provare 
			for(RisultatoPartita ris:pp.getRisultati()) {
				//provo a mettere ris in posizione 'livello' della soluzione parziale
				
				//costruzione soluzione parziale 
				parziale.add(ris);
				//chiamata ricorsiva
				ricorsiva(parziale,livello+1);
				//backtracking
				parziale.remove(parziale.size()-1);
			}
			
		}
		
	}

	
	
}
