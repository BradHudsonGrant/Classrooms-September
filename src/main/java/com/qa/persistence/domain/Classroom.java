package com.qa.persistence.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Classroom {

	@Id
	@Column(name = "classroomID")
	private Long classroomID;
	@Column(length = 100)
	private String trainerName;
	@OneToMany(fetch=FetchType.EAGER, targetEntity=Trainee.class, cascade=CascadeType.ALL)
	public Set<Trainee> trainees = new HashSet<Trainee>();;

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
