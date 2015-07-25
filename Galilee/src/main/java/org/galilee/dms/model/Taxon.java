package org.galilee.dms.model;

public class Taxon {
	
	private String Domain;
	private String Kingdom;
	private String Phylum;
	private String Class;
	private String Order;
	private String Family;
	private String Cenus;
	private String Species;
	
	public Taxon(){
		
	}

	public String getDomain() {
		return Domain;
	}

	public void setDomain(String domain) {
		Domain = domain;
	}

	public String getKingdom() {
		return Kingdom;
	}

	public void setKingdom(String kingdom) {
		Kingdom = kingdom;
	}

	public String getPhylum() {
		return Phylum;
	}

	public void setPhylum(String phylum) {
		Phylum = phylum;
	}

	public String getClassName() {
		return this.Class;
	}

	public void setClassName(String class1) {
		Class = class1;
	}

	public String getOrder() {
		return Order;
	}

	public void setOrder(String order) {
		Order = order;
	}

	public String getFamily() {
		return Family;
	}

	public void setFamily(String family) {
		Family = family;
	}

	public String getCenus() {
		return Cenus;
	}

	public void setCenus(String cenus) {
		Cenus = cenus;
	}

	public String getSpecies() {
		return Species;
	}

	public void setSpecies(String species) {
		Species = species;
	}

	@Override
	public String toString() {
		return "Taxon [Domain=" + Domain + ", Kingdom=" + Kingdom + ", Phylum="
				+ Phylum + ", Class=" + Class + ", Order=" + Order
				+ ", Family=" + Family + ", Cenus=" + Cenus + ", Species="
				+ Species + "]";
	}
}
