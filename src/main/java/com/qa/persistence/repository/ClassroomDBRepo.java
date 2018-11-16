package com.qa.persistence.repository;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static javax.transaction.Transactional.TxType.SUPPORTS;

import java.util.ArrayList;

import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import com.qa.persistence.domain.Classroom;
import com.qa.utils.JSONUtil;


@Transactional(SUPPORTS)
@Default
public class ClassroomDBRepo implements ClassroomRepo {

	@PersistenceContext(unitName = "primary")
	private EntityManager manager;

	@Inject
	private JSONUtil util;

	public String getAll() {
		Query query = manager.createQuery("Select a FROM Classroom a");
		ArrayList<Classroom> classrooms = (ArrayList<Classroom>) query.getResultList();
		return util.getJSONForObject(classrooms);
	}

	@Transactional(REQUIRED)
	public String createClassroom(String newClassroom) {
		Classroom classroom = util.getObjectForJSON(newClassroom, Classroom.class);
		manager.persist(classroom);
		return "{\"message\": \"account has been sucessfully added\"}";
	}

	@Transactional(REQUIRED)
	public String updateClassroom(Long id, String classroomToUpdate) {
		Classroom updatedClassroom = util.getObjectForJSON(classroomToUpdate, Classroom.class);
		Classroom classroomFromDB = findClassroom(id);
		if (classroomToUpdate != null) {
			classroomFromDB = updatedClassroom;
			manager.merge(classroomFromDB);
		}
		return "{\"message\": \"account sucessfully updated\"}";
	}

	@Transactional(REQUIRED)
	public String deleteClassroom(Long id) {
		Classroom classroomInDB = findClassroom(id);
		if (classroomInDB != null) {
			manager.remove(classroomInDB);
		}
		return "{\"message\": \"account sucessfully deleted\"}";
	}

	private Classroom findClassroom(Long id) {
		return manager.find(Classroom.class, id);
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	public void setUtil(JSONUtil util) {
		this.util = util;
	}

}
