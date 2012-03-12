package depcalc.rules;

import java.util.HashSet;
import java.util.Set;

import depcalc.theory.Production;
import depcalc.theory.Symbol;

public class Augmentation implements Rule {

	@Override
	public Set<Production> genFromTwo(Production left, Production right) {
		return new HashSet<Production>();
	}

	@Override
	public Set<Production> selfGen(Production production, Set<Symbol> symbols) {
		Set<Production> ret = new HashSet<Production>();

		for (Symbol symbol : symbols) {
			if (!production.getHead().contains(symbol)
					&& !production.getBody().contains(symbol)) {
				Set<Symbol> head = new HashSet<Symbol>(production.getHead());
				Set<Symbol> body = new HashSet<Symbol>(production.getBody());
				head.add(symbol);
				body.add(symbol);
				ret.add(new Production(head, body));
//				System.out.println(production + "aug to:" + new Production(head, body));
			}
		}

		return ret;
	}
}