package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import model.Emp;


public class EmpDaoImpl implements EmpDao{
    @Autowired
	private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    @Override
    public List<Emp> getEmployees() {
        System.out.println("jdfjkd"); 
         
        return jdbcTemplate.query("select * from employee",new RowMapper<Emp>(){  

            public Emp mapRow(ResultSet rs, int row) throws SQLException {    
                Emp e=new Emp();    
                e.setId(rs.getInt(1));    
                e.setEmployeeId(rs.getInt(2));  
                e.setEmployeeName(rs.getString(3));
                e.setDob(rs.getString(4));
                e.setAllocatedProject(rs.getString(7));
                e.setKnownModel(rs.getString(6));
                e.setEmail(rs.getString(5));
                e.setPhonenumber(rs.getLong(8));

                 
                return e;    
            }    
        });    
    }

    @Override
    public void saveEmployee(Emp theEmployee) {

        String sql = "insert into Employee values(?,?,?,?)";

        jdbcTemplate.update(sql, new Object[]

        { 
            theEmployee.getId(), theEmployee.getEmployeeId(), theEmployee.getDob(), theEmployee.getAllocatedProject() ,theEmployee.getKnownModel(),theEmployee.getEmail(),theEmployee.getPhonenumber()
        });
    }

    @Override
    public void deleteEmployee(int theId) {
        String sql = "delete employee where id=?";
        jdbcTemplate.update(sql, new Object[]
        { theId });
        
    }

    // @Override
    // public int getEmployee(int theId) {
    //     // String sql = "update employee set first_name = ?, last_name = ?, email = ?, dob = ? where id = ?";
	// 	// int resp = jdbcTemplate.update(sql, new Object[] { theId.getEmployeeId(), theId.getLastName(),
    //     //     theId.getEmail(), theId.getDob(), theId.getId() });
	// 	// return resp;
    // }
     
    


    }
    
    

