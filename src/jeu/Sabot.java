package jeu;

import java.util.Iterator;

import cartes.Carte;
import cartes.JeuDeCartes;

public class Sabot implements Iterable<Carte> {
	
	private final Carte[] cartes;
	private int nbCartes;
	private int nbOperations;
	
	
	//constructor
	public Sabot(Carte[] cartes) {
		nbCartes = cartes.length;
		this.cartes = new Carte[nbCartes];
		//copie des cartes
		for(int i = 0; i< nbCartes;i++) {
			this.cartes[i] = cartes[i];
		}
		nbOperations = 0;
	}

	@Override
	public Iterator<Carte> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
