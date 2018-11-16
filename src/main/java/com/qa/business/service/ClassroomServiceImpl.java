package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.ClassroomRepo;



public class ClassroomServiceImpl implements ClassroomService {

	private static final Logger LOGGER = Logger.getLogger(ClassroomService.class);

	@Inject
	private ClassroomRepo repo;

	public String getAll() {
		LOGGER.info("In AccountServiceImpl getAllAccounts ");
		return repo.getAll();
	}

	public String addClassroom(String classroom) {
		return repo.createClassroom(classroom);
	}

	public String updateClassroom(Long id, String classroom) {
		return repo.updateClassroom(id, classroom);
	}

	public String deleteClassroom(Long id) {
		return repo.deleteClassroom(id);

	}

	public void setRepo(ClassroomRepo repo) {
		this.repo = repo;
	}
}
