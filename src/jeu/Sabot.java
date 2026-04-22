package jeu;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;

import cartes.Carte;

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
	
	//methode estVide
	public boolean estVide() {
		return nbCartes == 0;
	}
	
	//methode ajouter carte
	public void ajouterCarte(Carte carte) {
		if(nbCartes >= cartes.length) {
			throw new IllegalStateException("Sabot est plein!: capacité depassé");
		}
		//sinon on ajout
		cartes[nbCartes] = carte;
		nbCartes++;
		nbOperations++;
	}

	@Override
	public Iterator<Carte> iterator() {
		return new IterateurSabot();
	}
	
	//methode piocher
	public Carte piocher() {
		//crée l'iterator de carte
		Iterator<Carte> it = iterator();
		
		if(!it.hasNext()) {
			throw new NoSuchElementException("La pioche est vide!");
		}
		//prend la premiere carte
		Carte carte = it.next();
		//suppresion de la premiere carte
		it.remove();
		
		return carte;
		
	}
	
	private class IterateurSabot implements Iterator<Carte>{
		private int indiceIterateur = 0;
		private boolean nextEffectue = false;
		private int indiceDerniereCarte = -1;
	
		private int nbOperationsReference = nbOperations;
		
		@Override
		public boolean hasNext() {
			verificationConcurrence();
			return indiceIterateur < nbCartes;
		}
		
		@Override
		public Carte next() {
			if(hasNext()) {
				Carte carte = cartes[indiceIterateur];
				indiceDerniereCarte = indiceIterateur;
				indiceIterateur++;
				nextEffectue = true;
				
				return carte;
			}else {
				throw new NoSuchElementException();
			}
		}
		
		@Override
		public void remove() {
			verificationConcurrence();
			if(nbCartes < 1 || !nextEffectue) {
				throw new IllegalStateException();
			}
			for(int i = indiceDerniereCarte; i < nbCartes - 1;i++) {
				cartes[i] = cartes[i+1];			
			}
			indiceIterateur = indiceDerniereCarte;
			nextEffectue = false;
			cartes[nbCartes - 1] = null; //evite de dupliquer la carte suppprimer
			nbCartes--;

			nbOperations++;
			nbOperationsReference = nbOperations;
		}
		
		public void verificationConcurrence() {
			if(nbOperations != nbOperationsReference) {
				throw new ConcurrentModificationException();
			}
		}
	}

}
