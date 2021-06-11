package com.cts.studentmanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "marks")
public class Marks {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "physics")
	private Integer physicsScore;
	
	@Column(name = "chemistry")
	private Integer chemistryScore;
	
	@Column(name = "maths")
	private Integer mathScore;

	public Marks() {
		super();
	}
	
	public Marks(Integer id, Integer physicsScore, Integer chemistryScore, Integer mathScore) {
		super();
		this.id = id;
		this.physicsScore = physicsScore;
		this.chemistryScore = chemistryScore;
		this.mathScore = mathScore;
	}
	
	public Long averageMarks() {
		Integer sum = this.physicsScore + this.chemistryScore + this.mathScore;
		Long average = (long) (sum/3);
		return average;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getPhysicsScore() {
		return physicsScore;
	}

	public void setPhysicsScore(Integer physicsScore) {
		this.physicsScore = physicsScore;
	}

	public Integer getChemistryScore() {
		return chemistryScore;
	}

	public void setChemistryScore(Integer chemistryScore) {
		this.chemistryScore = chemistryScore;
	}

	public Integer getMathScore() {
		return mathScore;
	}

	public void setMathScore(Integer mathScore) {
		this.mathScore = mathScore;
	}

		
	
	
}
