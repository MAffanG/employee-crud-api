package com.thymeleaf.springboot.cruddemo.controller;

import com.thymeleaf.springboot.cruddemo.entity.Employee;
import com.thymeleaf.springboot.cruddemo.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    // Constructor Injection (@Autowired is optional with a single constructor)
    public EmployeeController(EmployeeService theEmployeeService){
        employeeService=theEmployeeService;
    }

    /**
     * Display the list of employees.
     * Retrieves all employees from the database and adds them to the model.
     */
    @GetMapping("/list")
    public String listEmployeee(Model theModel){

        List<Employee> theEmployees=employeeService.findAll();
        theModel.addAttribute("employees",theEmployees);

        return "employees/list-employees";
    }

    /**
     * Show form for adding a new employee.
     * Binds the form data to a model attribute.
     */

    @GetMapping("/showFormForAdd")
    public String showFormForAddEmp(Model theModel){

        Employee theEmployee=new Employee();

        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }

    /**
     * Show form for updating an existing employee.
     * Fetches employee details by ID and prepopulates the form.
     */
    @GetMapping("/showFormForUpdate")
    public String showFormForUpdEmp(@RequestParam("employeeId") int id, Model theModel){


        Employee theEmployee=employeeService.findById(id);


        theModel.addAttribute("employee",theEmployee);

        return "employees/employee-form";
    }


    /**
     * Save the employee to the database.
     * Redirects to the list to prevent duplicate form submissions.
     */
    @PostMapping("/save")
    public String saveEmployee(@Valid@ModelAttribute("employee")Employee theEmployee, BindingResult bindingResult, Model model){
        if (employeeService.existsByEmailId(theEmployee)){
            model.addAttribute("error_message","This email address is already registered with another employee. Please try a different one.");
            return "employees/employee-form";
        }
        if(bindingResult.hasErrors()){
            model.addAttribute("errMsg","Please fill all required fields correctly.");
            return "employees/employee-form";

        }

        employeeService.save(theEmployee);

        return "redirect:/employees/list";
    }

    /**
     * Delete an employee by ID.
     * Redirects to the employee list page after deletion.
     */
    @GetMapping("/delete")
    public String showFormForUpdDel(@RequestParam("employeeId") int id, Model theModel){

        employeeService.deleteById(id);

        return "redirect:/employees/list";
    }

}
