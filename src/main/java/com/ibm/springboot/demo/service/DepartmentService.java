//package com.ibm.springboot.demo.service;
//
//import java.util.List;
//
//import com.ibm.springboot.demo.model.Department;
//
//public interface DepartmentService {
//
//	public abstract List<Department> getAllDepartments();
//
//	public abstract Department getDepartmentById(String departmentId);
//
//	public abstract Department addDepartment(Department department);
//
//}

package com.ibm.springboot.demo.service;

import java.util.List;
import org.bson.types.ObjectId;
import com.ibm.springboot.demo.model.Department;

public interface DepartmentService {

	public abstract List<Department> getAllDepartments();

	public abstract Department getDepartmentById(String departmentId);

	public abstract Department addDepartment(Department department);
	
	public abstract Department updateDepartment(Department department);
	
	public abstract Department deleteDepartment(String departmentId);
	
//	public abstract Department getDepartmentByName(String departmentName);

}
