package service;

import java.util.List;

import model.Emp;

public interface EmpService {

    List<Emp> getEmployees();

    void saveEmployee(Emp theEmployee);

    void deleteEmployee(int theId);

    // int getEmployee(int theId);
    
}
