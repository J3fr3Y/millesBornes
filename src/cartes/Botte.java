package cartes;

public class Botte extends Probleme {

	public Botte(Type type) {
		super(type);
	}

	@Override
	public String toString() {
		return getType().getBotte();
	}
	// on compare par rapport a la claase et au type
	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		if(obj == null || getClass() != obj.getClass()) return false;
		Botte botte = (Botte) obj;
		return getType() == botte.getType();
	}
	
	@Override
	public int hashCode() {
		return 31 * getClass().hashCode() + getType().hashCode();
	}
}
