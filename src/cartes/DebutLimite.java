package cartes;

public class DebutLimite extends Limite {

	@Override
	public String toString() {
		return "Limite 50";
	}
	
	@Override
	public boolean equals(Object obj) {
		return this == obj || (obj != null && getClass() == obj.getClass());
	}
	
	@Override
	public int hashCode() {
		return 31 * getClass().hashCode();
	}
}
