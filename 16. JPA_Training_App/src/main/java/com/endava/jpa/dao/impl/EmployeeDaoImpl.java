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

	private String QUERY_FIND_EMPLOYEE_BY_CITY = "Select e from Employee e where e.city = :city";

	public Employee find(int id) {
		return entityManager.find(Employee.class, id);
	}

	public List<Employee> find(String city) {
		return entityManager.createQuery(QUERY_FIND_EMPLOYEE_BY_CITY)
				.setParameter("city", city)
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
		Employee employee = entityManager.find(Employee.class, toBeRemoved.getId());
		entityManager.merge(employee);
		entityManager.remove(employee);

	}
}
