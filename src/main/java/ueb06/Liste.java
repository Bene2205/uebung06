package ueb06;

class Liste<T> {
	private class Element {
		T value;
		Element next;
		Element(T value) { this.value = value; }
	}

	private Element first;

	/**
	 * Hängt ein Element hinten an die Liste an.
	 */
	void add(T value) {
		if (first == null) {
			first = new Element(value);
			return;
		}

		Element it = first;
		while (it.next != null)
			it = it.next;

		it.next = new Element(value);
	}

	/**
	 * Wie `add`, aber rekursiv zu implementieren.
	 */
	void addRek(T value) {
		Element it = first;
		if (first == null) {
			first = new Element(value);
			return;
		} else {
			addRek(first, value);
		}
		return;
	}

	void addRek(Element element, T value) {
		if (element.next == null) {
			element.next = new Element(value);
		} else {
			element = element.next;
			addRek(element, value);
		}
	}

	/**
	 * Gibt `true` zurück, wenn der Wert `value` in der Liste enthalten ist.
	 */
	boolean contains(T value) {
		if (first == null)
			return false;
		Element it = first;

		while (it != null) {
			if (it.value.equals(value))
				return true;
			it = it.next;
		}

		return false;
	}

	/**
	 * Wie `contains`, nur rekursiv zu implementieren.
	 */
	boolean containsRek(T value) {
		return containsRek(first, value);
	}

	boolean containsRek(Element it, T v) {
		if (it == null) {
			return false;
		} else if (it.value.equals(v)) {
			return true;
		} else {
			return containsRek(it.next, v);
		}
	}

	/**
	 * Gibt eine Stringrepraesentation der Liste zurück, z.B. [] oder [1, 2, 3]
	 */
	public String toString() {
		if (first == null)
			return "[]";

		StringBuilder sb = new StringBuilder();
		sb.append("[").append(first.value);

		Element it = first.next;
		while (it != null) {
			sb.append(", ").append(it.value);
			it = it.next;
		}

		return sb.append("]").toString();
	}

	/**
	 * Zusatzaufgabe: Wie `toString`, nur rekursiv zu implementieren.
	 */
	String toStringRek() {
		return toStringRek(first, "[");
	}

	String toStringRek(Element it, String s) {
		if (it == null) {
			return "[]";
		} else if (it.next == null) {
			return s + it.value + "]";
		} else {
			s = s + it.value + ", ";
			return toStringRek(it.next, s);
		}
	}
}
