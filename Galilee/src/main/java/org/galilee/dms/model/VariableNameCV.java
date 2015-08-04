package org.galilee.dms.model;

public class VariableNameCV {
	private String Term;
	private String Definition;
	
	public VariableNameCV(){
		
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
		return "VariableNameCV [Term=" + Term + ", Definition=" + Definition + "]";
	}
}
