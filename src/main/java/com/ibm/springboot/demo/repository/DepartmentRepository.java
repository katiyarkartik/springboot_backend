package com.ibm.springboot.demo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ibm.springboot.demo.model.Department;
import java.util.List;
import java.util.Optional;


@Repository
public interface DepartmentRepository extends MongoRepository<Department, String>{

	Department findByManagerId(String managerId);
//	List<Department> findByDepartmentId(String departmentId); 


//	public abstract List<Department> findByDepartmentName(String departmentName);
}
