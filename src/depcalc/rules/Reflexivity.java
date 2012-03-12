package depcalc.rules;

import java.util.HashSet;
import java.util.Set;

import depcalc.theory.Production;
import depcalc.theory.Symbol;

public class Reflexivity implements Rule{

	@Override
	public Set<Production> genFromTwo(Production left, Production right) {
		return new HashSet<Production>();
	}

	@Override
	public Set<Production> selfGen(Production production, Set<Symbol> symbols) {
		
		Set<Production> ret;
		
		/*
			Set<Production> ret = new HashSet<Production>();
			Set<Set<Symbol>> candidate = getSubSets(production.getBody());
		
			for(Set<Symbol> set: candidate)
			ret.add(new Production(production.getBody(), set));
		 */
		return ret = new HashSet<Production>();
	}
	
}