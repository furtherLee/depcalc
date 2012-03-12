package depcalc.rules;

import java.util.HashSet;
import java.util.Set;

import depcalc.theory.Production;
import depcalc.theory.Symbol;

public class Transitivity implements Rule {

	@Override
	public Set<Production> genFromTwo(Production left, Production right) {
		Set<Production> ret = new HashSet<Production>();
		if (left.getBody().containsAll(right.getHead())) {
			ret.add(new Production(left.getHead(), right.getBody()));
//			System.out.println(left + " and " + right + " transit to "
//					+ new Production(left.getHead(), right.getBody()));
		}
		if (right.getBody().containsAll(left.getHead())){
			ret.add(new Production(right.getHead(), left.getBody()));
//			System.out.println(left + " and " + right + " transit to "
//					+ new Production(right.getHead(), left.getBody()));
		}
		return ret;
	}

	@Override
	public Set<Production> selfGen(Production production, Set<Symbol> symbols) {
		return new HashSet<Production>();
	}

}