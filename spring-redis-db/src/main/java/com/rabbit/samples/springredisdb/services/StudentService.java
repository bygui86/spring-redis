package com.rabbit.samples.springredisdb.services;

import com.rabbit.samples.springredisdb.domain.Student;

import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 04 Feb 2019
 */
public interface StudentService {

	List<Student> getAll();

	Student getById(final String id);

	Student insert(final Student student);

	Student update(final Student student);

	void deleteById(final String id);

	Student getErrorStudent(final String errMsg);

}
