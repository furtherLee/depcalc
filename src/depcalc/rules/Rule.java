package depcalc.rules;

import java.util.*;

import depcalc.theory.Production;
import depcalc.theory.Symbol;

public interface Rule{

    public Set<Production> genFromTwo(Production left, Production right);
	
    public Set<Production> selfGen(Production production, Set<Symbol> symbols);

}