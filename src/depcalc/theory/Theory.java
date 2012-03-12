package depcalc.theory;

import java.util.*;

import depcalc.rules.Rule;

public class Theory {

	private final Set<Production> productions;

	public Theory(Set<Production> productions) {
		this.productions = productions;
	}

	public Theory() {
		this.productions = new HashSet<Production>();
	}

	public Theory(Theory theory) {
		this.productions = new HashSet<Production>();
		this.addAll(theory);
	}

	public void addAll(Theory theory) {
		this.productions.addAll(theory.productions);
	}

	public void addAll(Set<Production> productions) {
		this.productions.addAll(productions);
	}

	public void add(Production production) {
		this.productions.add(production);
	}

	public Set<Symbol> getSymbols() {
		Set<Symbol> ret = new HashSet<Symbol>();
		for (Production production : productions) {
			ret.addAll(production.getBody());
			ret.addAll(production.getHead());
		}
		return ret;
	}

	public Theory makeClosure(Set<Rule> rules) {

		Theory ret;

		Set<Symbol> symbols = getSymbols();

		Set<Production> temp;

		Theory previous = new Theory(this);

		do {
			ret = new Theory(previous);
			for (Production production : ret.productions) {
				for (Rule rule : rules) {
					temp = rule.selfGen(production, symbols);
					previous.addAll(temp);

					for (Production another : ret.productions)
						if (!production.equals(another)) {
							temp = rule.genFromTwo(production, another);
							previous.addAll(temp);
						}
				}
			}
		} while (!ret.equals(previous));

		return ret;
	}

	public Theory makeCanonicalCover(Set<Rule> rules) {
		Theory ret = new Theory();
		ret.addAll(this);
		return ret;
	}

	public String toString() {

		StringBuilder sb = new StringBuilder();

		for (Production production : productions)
			sb.append(production + "\n");

		return sb.toString();
	}

	public boolean equals(Object o) {
		if (!(o instanceof Theory))
			return false;
		return ((Theory) o).productions.equals(productions);
	}
	
	public Theory getNonTrivial(){
		Theory ret = new Theory();
		
		for (Production production: productions)
			if(!production.getHead().containsAll(production.getBody()))
				ret.add(production);
		
		return ret;
	}

	public int getSize() {
		return productions.size();
	}
}