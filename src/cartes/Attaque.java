package cartes;

public class Attaque extends Bataille {

	public Attaque(Type type) {
		super(type);
	}
	
	@Override
	public String toString() {
		return getType().getAttaque();
	}
	//compare avec la meme classe et meme type
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj instanceof Attaque attaque) {
			return getType() == attaque.getType();
		}
		return false;
	}
	
	/*@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if (obj == null || getClass() != obj.getClass()) return false;
	    Attaque other = (Attaque) obj;
		return false;
	}*/
	
	@Override
	public int hashCode() {
		return 31 * getClass().hashCode() + getType().hashCode();
	}
}
