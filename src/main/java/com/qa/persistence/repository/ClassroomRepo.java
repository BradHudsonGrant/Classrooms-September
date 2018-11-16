package com.qa.persistence.repository;

public interface ClassroomRepo {

	String getAll();

	String createAccount(String accout);

	String updateClassroom(Long id, String accountToUpdate);

	String deleteClassroom(Long id);

}