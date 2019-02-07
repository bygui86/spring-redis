package com.rabbit.samples.springredisdb.domain;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.FieldDefaults;
import org.springframework.data.redis.core.RedisHash;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.io.Serializable;


/**
 * @author Matteo Baiguini
 * matteo@solidarchitectures.com
 * 04 Feb 2019
 */
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
@EqualsAndHashCode
@ToString
@NotNull
@RedisHash("students")
public class Student implements Serializable {

	public enum Gender {
		MALE, FEMALE
	}


	String id;

	@NotEmpty(message = "Name can not be null or empty")
	String name;

	@NotNull(message = "Gender can not be null")
	Gender gender;

	@Min(value = 18, message = "Age can not be less than 18")
	int age;

	String errMsg;

}
