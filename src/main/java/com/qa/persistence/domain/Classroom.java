package com.qa.persistence.domain;

import java.util.ArrayList;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "classroomID")
	private Long classroomID;
	@Column(length = 100)
	private String trainerName;
	@OneToMany
	@JoinColumn(name="traineeID", referencedColumnName="classroomID")
	public ArrayList<Trainee> trainees;

	public Classroom() {

	}

	public Classroom(Long id, String name) {
		this.classroomID = id;
		this.trainerName = name;
	}

	public ArrayList<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(ArrayList<Trainee> trainees) {
		this.trainees = trainees;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setFirstName(String name) {
		this.trainerName = name;
	}

}
