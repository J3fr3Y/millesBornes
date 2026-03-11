package cartes;


public class JeuDeCartes {
	//tableau de configuration
	private Configuration[] configurations;
	
	//constructor
	public JeuDeCartes() {
		configurations = new Configuration[19];
		//init de la configuration
		int i = 0;
		
		//Bornes
		configurations[i++] = new Configuration(new Borne(25), 10);
		configurations[i++] = new Configuration(new Borne(50), 10);
		configurations[i++] = new Configuration(new Borne(75), 10);
		configurations[i++] = new Configuration(new Borne(100), 12);
		configurations[i++] = new Configuration(new Borne(200), 4);
		
		//Parades
		configurations[i++] = new Configuration(new Parade(Type.FEU), 14); // feux verts
		configurations[i++] = new Configuration(new Parade(Type.ESSENCE), 6); //Bidon d'essence
		configurations[i++] = new Configuration(new Parade(Type.CREVAISON), 6); //roue de secours
		configurations[i++] = new Configuration(new Parade(Type.ACCIDENT), 6); //réparation
		
		//limites
		configurations[i++] = new Configuration(new DebutLimite(),4);
		configurations[i++] = new Configuration(new FinLimite(),6);
		
		//Attaques 
		configurations[i++] = new Configuration(new Attaque(Type.FEU), 5);// feux rouge
		configurations[i++] = new Configuration(new Attaque(Type.ESSENCE), 3); //panne essence
		configurations[i++] = new Configuration(new Attaque(Type.CREVAISON), 3); //crevaison
		configurations[i++] = new Configuration(new Attaque(Type.ACCIDENT), 3); //accident
		
		//Bottes
		configurations[i++] = new Configuration(new Botte(Type.FEU), 1);// vehicule prioritaire
		configurations[i++] = new Configuration(new Botte(Type.ESSENCE), 1);//citerne
		configurations[i++] = new Configuration(new Botte(Type.CREVAISON), 1);//increvable
		configurations[i++] = new Configuration(new Botte(Type.ACCIDENT), 1);//Lewis Hamilton
		
	}
	
	public String affichageJeuDeCartes() {
		StringBuilder jeu = new StringBuilder("JEU :\n");
		for(Configuration configuration: configurations) {
			jeu.append(configuration.getNbExemplaires());
			jeu.append(" ");
			jeu.append(configuration.getCarte());
			jeu.append("\n");
		}
		return jeu.toString();
	}
	
	public Carte[] donnerCartes() {
		int totalCartes = 0;
		for(Configuration config: configurations) {
			totalCartes += config.getNbExemplaires();
		}
		
		Carte[] cartesRep = new Carte[totalCartes];
		int i = 0;
		for(Configuration config: configurations) {
			for(int j = 0 ; j < config.getNbExemplaires();j++) {
				cartesRep[i++] = config.getCarte();
			}
		}
		return cartesRep;
		
	}
	//classe interne configuration
	private static class Configuration{
		//le nombre de cartes est toujours le meme pendant le jeu
		private final int nbExemplaires;
		private final Carte carte;
		
		//constructor
		private Configuration(Carte carte, int nbExemplaires) {
			this.nbExemplaires = nbExemplaires;
			this.carte = carte;
		}

		public int getNbExemplaires() {
			return nbExemplaires;
		}

		public Carte getCarte() {
			return carte;
		}		
	}

}
