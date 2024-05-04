package com.ibm.springboot.demo.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.springboot.demo.exception.DepartmentNotFoundException;
import com.ibm.springboot.demo.exception.EmployeeNotFoundException;
import com.ibm.springboot.demo.model.Department;
import com.ibm.springboot.demo.model.Employee;
import com.ibm.springboot.demo.repository.DepartmentRepository;

@Service
public class DepartmentServicelmpl implements DepartmentService{

	private final Logger LOG=LoggerFactory.getLogger(this.getClass());	
	
	@Autowired
	DepartmentRepository departmentRepository;
	
	@Override
	public List<Department> getAllDepartments() {
		// TODO Auto-generated method stub
		
		LOG.info("getAllDept");
		List<Department> depList=departmentRepository.findAll();
		// what if the collection is empty ?
//		return employeeRepository.findAll();
		if(depList.isEmpty()) {
			String errorMessage = "The department list is empty";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
		else {
			return depList;
		}
		
//		LOG.info("getAllDepartment");
//		return departmentRepository.findAll();
	}
	
	@Override
	public Department getDepartmentById(String departmentId) {
//		// TODO Auto-generated method stub
//		LOG.info(departmentId.toString());
//		return departmentRepository.findById(departmentId).get();
		
		Optional<Department> depOptional = departmentRepository.findById(departmentId);
		if (depOptional.isEmpty()) {
			String errorMessage = "department with the id " + departmentId + " is not found!";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		} else
			return depOptional.get();
	}

	@Override
	public Department addDepartment(Department department) {
		LOG.info(department.toString());
		Department managerOptional = departmentRepository.findByManagerId(department.getManagerId());
		if(managerOptional != null) {
			String errorMessage = "Department already exist with the same manager";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
			
		}else {
			return departmentRepository.save(department);
		}
		
		
	
	
	}

	@Override
	public Department deleteDepartment(String departmentId) {
		LOG.info(departmentId);
		Department deptToBeDeleted= this.getDepartmentById(departmentId);
		if(deptToBeDeleted == null) {
			String errorMessage = "Department not foundr";
			LOG.warn(errorMessage);
			throw new DepartmentNotFoundException(errorMessage);
		}
		else {
			departmentRepository.deleteById(departmentId);
			LOG.info("Department with departmentId: " + departmentId + " has been deleted");
			return deptToBeDeleted;
		}
		
	
	}

	@Override
	public Department updateDepartment(Department department) {
		// TODO Auto-generated method stub
		return null;
	}



	

}
