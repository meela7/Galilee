package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name="Fishes")
public class Fishes {
	
	@Id
	@GeneratedValue
	private int FishID;

	private String FishClass;
	private String Order;
	private String Family;
	private String ScientificName;
	private String Species;
	private String ToleranceGuild;
	private String TrophicGuild;
	private String HabitatGuild;
	private String InvasiveSpecies;
	private String EndangeredSpecies;
	private String NatureMonument;
	private String ImageLink;
	private String Description;
	
	public Fishes(){
		
	}
	
	@Column (name = "Class")
	public int getFishID() {
		return FishID;
	}
	public void setFishID(int fishID) {
		FishID = fishID;
	}
	
	public String getFishClass() {
		return FishClass;
	}
	
	public void setFishClass(String fishClass) {
		FishClass = fishClass;
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
	public String getScientificName() {
		return ScientificName;
	}
	public void setScientificName(String scientificName) {
		ScientificName = scientificName;
	}
	public String getSpecies() {
		return Species;
	}
	public void setSpecies(String species) {
		Species = species;
	}
	public String getToleranceGuild() {
		return ToleranceGuild;
	}
	public void setToleranceGuild(String toleranceGuild) {
		ToleranceGuild = toleranceGuild;
	}
	public String getTrophicGuild() {
		return TrophicGuild;
	}
	public void setTrophicGuild(String trophicGuild) {
		TrophicGuild = trophicGuild;
	}
	public String getHabitatGuild() {
		return HabitatGuild;
	}
	public void setHabitatGuild(String habitatGuild) {
		HabitatGuild = habitatGuild;
	}
	public String getInvasiveSpecies() {
		return InvasiveSpecies;
	}
	public void setInvasiveSpecies(String invasiveSpecies) {
		InvasiveSpecies = invasiveSpecies;
	}
	public String getEndangeredSpecies() {
		return EndangeredSpecies;
	}
	public void setEndangeredSpecies(String endangeredSpecies) {
		EndangeredSpecies = endangeredSpecies;
	}
	public String getNatureMonument() {
		return NatureMonument;
	}
	public void setNatureMonument(String natureMonument) {
		NatureMonument = natureMonument;
	}
	public String getImageLink() {
		return ImageLink;
	}
	public void setImageLink(String imageLink) {
		ImageLink = imageLink;
	}
	public String getDescription() {
		return Description;
	}
	public void setDescription(String description) {
		Description = description;
	}
	
	@Override
	public String toString() {
		return "Fishes [FishID=" + FishID + ", FishClass=" + FishClass
				+ ", Order=" + Order + ", Family=" + Family
				+ ", ScientificName=" + ScientificName + ", Species=" + Species
				+ ", ToleranceGuild=" + ToleranceGuild + ", TrophicGuild="
				+ TrophicGuild + ", HabitatGuild=" + HabitatGuild
				+ ", InvasiveSpecies=" + InvasiveSpecies + ", EndangeredSpecies="
				+ EndangeredSpecies + ", NatureMonument=" + NatureMonument
				+ ", ImageLink=" + ImageLink + ", Description=" + Description
				+ "]";
	}
}
