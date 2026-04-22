package cartes;

public class FinLimite extends Limite {
	@Override
	public String toString() {
		return "Fin Limite";
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
