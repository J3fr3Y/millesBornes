package cartes;

public class Borne extends Carte {
	private int km;

	public Borne(int km) {
		this.km = km;
	}

	public int getKm() {
		return km;
	}
	
	@Override
	public String toString() {
		return km + "km";
	}
	//redefinition de la methode equals
	@Override
	public boolean equals(Object obj) {
		if(obj != null && getClass() == obj.getClass()) {
			Borne borneToCompare = (Borne) obj;
			return km == borneToCompare.getKm();
		}
		return false;
	}
	
	/*@Override
	public boolean equals(Object obj) {
		if(obj instanceof Borne borne) {
			return this.km == borne.getKm();
		}
		return false;
	}*/
	
	@Override
	public int hashCode() {
		return 31 * Integer.hashCode(km);
	}
	
	
	
	
}
