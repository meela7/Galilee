package org.galilee.dms.model;

public class ValueTypeCV {
	private String Term;
	private String Definition;
	
	public ValueTypeCV(){
		
	}
	public String getTerm() {
		return Term;
	}
	public void setTerm(String term) {
		Term = term;
	}
	public String getDefinition() {
		return Definition;
	}
	public void setDefinition(String definition) {
		Definition = definition;
	}
	
	@Override
	public String toString() {
		return "ValueTypeCV [Term=" + Term + ", Definition=" + Definition + "]";
	}
}
