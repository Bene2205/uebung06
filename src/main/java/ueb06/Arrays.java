package ueb06;

import java.util.NoSuchElementException;

class Arrays {
	/**
	 * Gibt eine Stringrepraesentation des Arrays zurueck, z.B. [] oder [1, 2, 3]
	 */
	static <T> String toString(T[] array) {
		return toString(array, "[", 0);
	}

	static <T> String toString(T[] array, String s, int count) {
		if (array.length == 0) {
			return "[]";
		} else if(count == array.length -1) {
			return s + array[count] + "]";
		} else {
			s = s + array[count] + ", ";
			return toString(array, s, count+1);
		}
	}
	/**
	 * Gib zurück, ob ein Objekt in dem Array enthalten ist; verwendet `equals`
	 */
	static <T> boolean contains(T[] array, T object) {

		return contains(array, object, 0);
	}

	static <T> boolean contains(T[] array, T object, int count) {
		if(count > array.length -1){
			return false;
		}else if (array.length == 0) {
			return false;
		} else if (array[count].equals(object)) {
			return true;
		} else {
			return contains(array, object, count+1);
		}
	}
}
