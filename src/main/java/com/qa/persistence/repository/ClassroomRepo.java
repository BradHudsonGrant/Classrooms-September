package com.qa.persistence.repository;

public interface ClassroomRepo {

	String getAll();

	String createClassroom(String classroom);

	String updateClassroom(Long id, String classroom);

	String deleteClassroom(Long id);

}