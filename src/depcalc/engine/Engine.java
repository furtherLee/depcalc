package depcalc.engine;

import java.io.*;
import java.util.*;
import depcalc.theory.*;
import depcalc.rules.*;

public class Engine {

	public static Production makeProduction(String str) {
		String[] args = str.split("->");
		if (args.length != 2)
			throw new SyntaxException();
		Set<Symbol> newHead = new HashSet<Symbol>();
		Set<Symbol> newBody = new HashSet<Symbol>();
		for (String s : args[0].split(",")) {
			String head = s.trim();
			if (!head.equals(""))
				newHead.add(Symbol.valueOf(head));
		}

		for (String s : args[1].split(",")) {
			String body = s.trim();
			if (!body.equals(""))
				newBody.add(Symbol.valueOf(body));
		}

		return new Production(newHead, newBody);
	}

	public static Theory parse(String path) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(path));
		Theory theory = new Theory();
		String line = reader.readLine();
		while (line != null) {
			if(line.trim().equals("")){
				line = reader.readLine();
				continue;
			}
			theory.add(makeProduction(line));
			line = reader.readLine();
		}
		return theory;
	}

	public static Set<Rule> getClosureRules() {
		Set<Rule> rules = new HashSet<Rule>();
		rules.add(new Augmentation());
		rules.add(new Reflexivity());
		rules.add(new Transitivity());
		return rules;
	}

}