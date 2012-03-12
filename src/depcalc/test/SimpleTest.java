package depcalc.test;

import depcalc.engine.Engine;
import depcalc.theory.Theory;

public class SimpleTest {
	public static void main(String[] args) {
		try {
			Theory theory = Engine.parse(args[0]);
			System.out.println(theory.makeClosure(Engine.getClosureRules()).getSize());
			//System.out.println(theory.makeCanonicalCover(Engine.getClosureRules()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
