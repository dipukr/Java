public class Pair<A, B> {

	public final A fst;
	public final B snd;

	public Pair(A fst, B snd) {
		this.fst = fst;
		this.snd = snd;
	}

	public boolean equals(Object other) {
		return other instanceof Pair
			&& eq(fst, ((Pair)other).fst)
			&& eq(snd, ((Pair)other).snd);
	}

	public int hashCode() {
		if (fst == null) return (snd == null) ? 0 : snd.hashCode() + 1;
		else if (snd == null) return fst.hashCode() + 2;
		else return fst.hashCode() * 17 + snd.hashCode();
	}

	public String toString() { 
		return "("+fst+", "+snd+")";
	}

	public static <A, B> Pair<A, B> of(A a, B b) {
		return new Pair<A, B>(a, b);
	}

	private boolean eq(Object a, Object b) {
		return (a == null && b == null) || (a != null && a.equals(b));
	}
}