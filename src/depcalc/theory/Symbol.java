package depcalc.theory;

import java.util.*;

public class Symbol {

	private static Map<String, Symbol> identity = new HashMap<String, Symbol>();

	public static Symbol valueOf(String str) {
		Symbol ret = identity.get(str);

		if (ret == null)
			ret = new Symbol(str);

		identity.put(str, ret);

		return ret;
	}

	private final String name;

	private Symbol(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public boolean equals(Object o) {
		if (!(o instanceof Symbol))
			return false;

		return ((Symbol) o).name.equals(this.name);
	}

	public int hashCode() {
		return name.hashCode();
	}

}
