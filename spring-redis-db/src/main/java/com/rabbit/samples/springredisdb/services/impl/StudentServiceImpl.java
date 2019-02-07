package com.rabbit.samples.springredisdb.services.impl;

import com.rabbit.samples.springredisdb.domain.Student;
import com.rabbit.samples.springredisdb.repos.StudentRepo;
import com.rabbit.samples.springredisdb.services.StudentService;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;
import org.apache.commons.collections4.IteratorUtils;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 04 Feb 2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Getter(value = AccessLevel.PROTECTED)
@Service
public class StudentServiceImpl implements StudentService {

	StudentRepo studentRepo;

	@Override
	public List<Student> getAll() {

		return IteratorUtils.toList(
				getStudentRepo().findAll().iterator()
		);
	}

	@Override
	public Student getById(final String id) {

		return getStudentRepo()
				.findById(id)
				.orElse(
						getErrorStudent("No Student found with ID" + id)
				);
	}

	@Override
	public Student insert(final Student student) {

		return save(student);
	}

	@Override
	public Student update(final Student student) {

		return save(student);
	}

	@Override
	public void deleteById(final String id) {

		getStudentRepo().deleteById(id);
	}

	protected Student save(final Student student) {

		return getStudentRepo().save(student);
	}

	@Override
	public Student getErrorStudent(final String errMsg) {

		return Student.builder().errMsg(errMsg).build();
	}

}
