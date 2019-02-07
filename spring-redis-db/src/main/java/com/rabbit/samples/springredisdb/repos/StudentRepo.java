package com.rabbit.samples.springredisdb.repos;

import com.rabbit.samples.springredisdb.domain.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 04 Feb 2019
 */
@Repository
public interface StudentRepo extends CrudRepository<Student, String> {

	// no-op
}
