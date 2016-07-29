package com.endava.jpa.service;

import com.endava.jpa.model.Employee;

import java.util.List;

public interface EmployeeService {

    public Employee find(int id);

    public List<Employee> find(String departmentName);

    public void save(Employee toBeSaved);

    public void update(Employee toBeUpdated);

    public void remove(Employee toBeRemoved);
}
