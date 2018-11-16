package com.qa.persistence.domain;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@OneToMany(fetch=FetchType.EAGER)
	@JoinColumn(name="trainees", referencedColumnName="classroomID")
	public Set<Trainee> trainees;

	public Classroom() {

	}

	public Classroom(Long id, String name) {
		this.classroomID = id;
		this.trainerName = name;
	}

	public Set<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(Set<Trainee> trainees) {
		this.trainees = trainees;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setFirstName(String name) {
		this.trainerName = name;
	}

}
