package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import model.Emp;
import service.EmpService;




@Controller
@RequestMapping(value = "/student")

public class EmpController {

    @Autowired  

    EmpService empService; 
   {
    System.out.println("helo");
   }  
    
    @RequestMapping("/empform")    
    public String showform(Model m){    
        m.addAttribute("command", new Emp());  
        return "index";   
    }   
    
    
    @GetMapping("/list")
    public String listEmployees(Model theModel) {
        List<Emp> theEmployees = empService.getEmployees();
        System.out.println(theEmployees);
        theModel.addAttribute("employees", theEmployees);
        return "index";
    }

    @RequestMapping(value = "/employee",method=RequestMethod.POST)
    public String saveEmployee(@ModelAttribute("employee") Emp theEmployee) {
        System.out.println("controller");
        System.out.println(theEmployee);

        empService.saveEmployee(theEmployee);
        return "redirect:/list";
    }
   

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("EmpID") int theId) {
        System.out.println(theId);
        empService.deleteEmployee(theId);
        return "redirect:/list";
    }

    // @GetMapping("/updateForm")
    // public String showFormForUpdate(@RequestParam("EmpID") int theId, Model theModel) {
    //     int theEmployee = empService.getEmployee(theId);
    //     theModel.addAttribute("customer", theEmployee);
    //     return "index";
    // }




   
   
}
