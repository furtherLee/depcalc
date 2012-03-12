package depcalc.theory;

import java.util.*;

public class Production{
    
    final private Set<Symbol> head;

    final private Set<Symbol> body;

    public Production (Set<Symbol> head, Set<Symbol> body){
	this.head = head;
	this.body = body;
    }

    public Set<Symbol> getHead(){
	return head;
    }

    public Set<Symbol> getBody(){
	return body;
    }

    public boolean equals(Object o){
	if(!(o instanceof Production))
	    return false;

		Production product = (Production)o;

		return head.equals(product.getHead()) & body.equals(product.getBody());
    }

    public int hashCode(){
	return head.hashCode()^body.hashCode();
    }

    public String toString(){
    	return headString() + " -> " + bodyString();
    }
    
    private String headString(){
    	StringBuilder sb = new StringBuilder();
    	for(Symbol symbol: head){
    		sb.append(symbol.getName() + ",");
    	}
    	return sb.substring(0, sb.length()-1);
    }
    
    private String bodyString(){
    	StringBuilder sb = new StringBuilder();
    	for(Symbol symbol: body){
    		sb.append(symbol.getName() + ",");
    	}
    	return sb.substring(0, sb.length()-1);
    }
}
