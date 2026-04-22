package testsFonctionnels;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import cartes.Botte;
import cartes.Carte;
import cartes.JeuDeCartes;
import cartes.Type;
import jeu.Sabot;

public class TestSabot {
	JeuDeCartes jeu = new JeuDeCartes();
	Sabot sabot = new Sabot(jeu.donnerCartes());
	
	//test donner cartes
	//public void questionA() {

//		while (!sabot.estVide()) {
//			Carte carte = sabot.piocher();
//			System.out.println("Je pioche " + carte);
//		}
//		Console :
//		Je pioche Accident
//		Je pioche Accident
//		Je pioche Accident
//		Je pioche R�paration
//		Je pioche R�paration
//		Je pioche R�paration
//		Je pioche As du volant
//	}
	
//	public void questionB() {
//		//utiliser iterator et remove
//		for(Iterator<Carte> it = sabot.iterator() ; it.hasNext();) {
//			System.out.println("Je pioche " + it.next());
//			it.remove();
//		}
//		Iterator<Carte> iterator = sabot.iterator();
//		System.out.println("\nLa pioche contient encore des cartes ? " + iterator.hasNext());
//	}
	
	public void questionC() {
		//sabot.piocher();
		//System.out.println("Je pioche " + cartePiochee);
		try {
			for (Iterator<Carte> iterator = sabot.iterator(); iterator.hasNext();) {
				Carte carte = iterator.next();
				System.out.println("Je pioche " + carte);
				iterator.remove();
				sabot.piocher();//exception levée modif concurrente
				//sabot.ajouterCarte(new Botte(Type.ACCIDENT));
				
			}
		} catch (ConcurrentModificationException e) {
			e.printStackTrace();
		}
		Iterator<Carte> iterator = sabot.iterator();
		System.out.println("\nLa pioche contient encore des cartes ? " + iterator.hasNext());
	}

	public static void main(String[] args) {
		TestSabot test = new TestSabot();
		//test.questionA();
		//test.questionB();
		test.questionC();
		
	}

}
