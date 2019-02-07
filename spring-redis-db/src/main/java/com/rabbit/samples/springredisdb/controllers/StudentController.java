package com.rabbit.samples.springredisdb.controllers;

import com.rabbit.samples.springredisdb.domain.Student;
import com.rabbit.samples.springredisdb.services.StudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 04 Feb 2019
 */
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter
@RestController
@RequestMapping("/students")
public class StudentController {

	StudentService studentService;

	@GetMapping
	public List<Student> getAll() {

		log.info("Get all Students...");

		return getStudentService().getAll();
	}

	@GetMapping("/{id}")
	public Student getById(@PathVariable final String id) {

		if (StringUtils.isEmpty(id)) {
			log.error("Get Student by id: ID can not be null or empty!");
			return getStudentService().getErrorStudent("ID can not be null or empty");
		}

		log.info("Get Student by id {}...", id);

		return getStudentService().getById(id);
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Student insert(@RequestBody @Valid final Student student) {

		if (student == null) {
			log.error("Insert Student: Object can not be null!");
			return getStudentService().getErrorStudent("Object can not be null");
		}

		log.info("Insert Student {}...", student);

		return getStudentService().insert(student);
	}

	@PutMapping
	@ResponseStatus(HttpStatus.ACCEPTED)
	public Student update(@RequestBody @Valid final Student student) {

		if (student == null) {
			log.error("Update Student: Object can not be null!");
			return getStudentService().getErrorStudent("Object can not be null");
		}

		log.info("Update Student {}...", student);

		return getStudentService().update(student);
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable final String id) {

		if (StringUtils.isEmpty(id)) {
			log.error("Delete Student by id: ID can not be null or empty");
		}

		log.info("Delete Student by id {}...", id);

		getStudentService().deleteById(id);
	}

}
