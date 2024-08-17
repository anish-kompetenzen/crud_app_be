package com.sboot.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sboot.crud.model.StudentModel;

@Repository // not necessary but is encouraged
public interface StudentRepository extends JpaRepository<StudentModel, Integer> {

}
