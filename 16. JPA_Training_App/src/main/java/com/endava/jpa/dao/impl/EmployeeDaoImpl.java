package com.endava.jpa.dao.impl;

import com.endava.jpa.dao.EmployeeDao;
import com.endava.jpa.model.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	private String QUERY_FIND_DEPARTMENT_BY_NAME = "Select e from Employee where e.name = :emp_name";

	public Employee find(int id) {
		return entityManager.find(Employee.class, id);
	}

	public List<Employee> find(String departmentName) {
		return entityManager.createQuery(QUERY_FIND_DEPARTMENT_BY_NAME)
				.setParameter("emp_name", departmentName)
				.getResultList();
	}

	public void save(Employee toBeSaved) {
		entityManager.persist(toBeSaved);
		//entityManager.flush();
	}

	public void update(Employee toBeUpdated) {
		entityManager.merge(toBeUpdated);
	}

	public void remove(Employee toBeRemoved) {
		Employee department = entityManager.find(Employee.class, toBeRemoved.getId());
		entityManager.merge(department);
		entityManager.remove(department);

	}
}
