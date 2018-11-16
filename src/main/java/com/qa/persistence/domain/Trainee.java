package com.qa.persistence.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Trainee {

	@Id
	@Column(name="traineeID")
	private Long traineeID;
	@Column(length = 100)
	private String traineeName;
/*	@ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "classroomID")
    private Classroom classroom;*/

	public Trainee() {
	}

	public Trainee(Long id, String name) {
		this.traineeID = id;
		this.traineeName = name;
	}

	public String getTraineeName() {
		return traineeName;
	}

	public void setTraineeName(String name) {
		this.traineeName = name;
	}

}
