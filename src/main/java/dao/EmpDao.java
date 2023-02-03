package dao;

import java.util.List;

import model.Emp;

public interface EmpDao {

    List<Emp> getEmployees();

    void saveEmployee(Emp theEmployee);

    void deleteEmployee(int theId);

    // int getEmployee(int theId);
    
}
