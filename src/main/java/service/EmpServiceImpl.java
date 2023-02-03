package service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.EmpDao;
import model.Emp;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmpDao empDao;

    @Override
    @Transactional
    public List<Emp> getEmployees() {
        return empDao.getEmployees();
    }

    @Override
    @Transactional

    public void saveEmployee(Emp theEmployee) {
        empDao.saveEmployee(theEmployee);    
        
    }

    @Override
    @Transactional

    public void deleteEmployee(int theId) {
        empDao.deleteEmployee(theId);
        
    }

    // @Override
    // @Transactional

    // public int getEmployee(int theId) {
    //     return empDao.getEmployee(theId);

    // }
    
}
