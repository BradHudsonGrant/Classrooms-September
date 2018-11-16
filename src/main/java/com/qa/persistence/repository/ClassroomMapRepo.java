package com.qa.persistence.repository;

import java.util.HashMap;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import com.qa.persistence.domain.Classroom;
import com.qa.utils.JSONUtil;

@ApplicationScoped
@Alternative
public class ClassroomMapRepo implements ClassroomRepo {

	private final Long counter = 1L;
	private Map<Long, Classroom> classroomMap;
	private Long ID;

	@Inject
	private JSONUtil util;

	public ClassroomMapRepo() {
		this.classroomMap = new HashMap<Long, Classroom>();
		ID = counter;
		initClassroomMap();
	}

	public String getAll() {
		return util.getJSONForObject(classroomMap.values());
	}

	public String createClassroom(String classroom) {
		ID++;
		Classroom newClassroom = util.getObjectForJSON(classroom, Classroom.class);
		classroomMap.put(ID, newClassroom);
		return "{\"message\": \"Classroom sucessfully created\"}";
	}

	public String updateClassroom(Long id, String classroomToUpdate) {
		Classroom newClassroom = util.getObjectForJSON(classroomToUpdate, Classroom.class);
		classroomMap.put(id, newClassroom);
		return "{\"message\": \"Classroom sucessfully updated\"}";
	}

	public String deleteClassroom(Long id) {
		classroomMap.remove(id);
		return "{\"message\": \"Classroom sucessfully removed\"}";
	}

	private void initClassroomMap() {
		Classroom classroom = new Classroom();
		classroomMap.put(1L, classroom);
	}

}
