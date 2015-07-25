package org.galilee.dms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Assessment")
public class Assessment {

	@Id 
	@Column(name="ID")
	@GeneratedValue
	private int ID;
	
	private int EvaluationType;
	private String Year;
	private int Degree;
	
	@JoinColumn(name="SiteID")
	private Sites Site;
	private String EvaluationGrade;
	
	public Assessment(){}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getEvaluationType() {
		return EvaluationType;
	}

	public void setEvaluationType(int evaluationType) {
		EvaluationType = evaluationType;
	}

	public String getYear() {
		return Year;
	}

	public void setYear(String year) {
		Year = year;
	}

	public int getDegree() {
		return Degree;
	}

	public void setDegree(int degree) {
		Degree = degree;
	}

	public Sites getSite() {
		return Site;
	}

	public void setSite(Sites site) {
		Site = site;
	}

	public String getEvaluationGrade() {
		return EvaluationGrade;
	}

	public void setEvaluationGrade(String evaluationGrade) {
		EvaluationGrade = evaluationGrade;
	}
}
