package iuh.fit.se.controllers;

import iuh.fit.se.entities.Employee;
import iuh.fit.se.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class EmployeeController {
    EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping()
    public ModelAndView index(ModelAndView modelAndView) {
        List<Employee> employees = employeeService.getAll();
        modelAndView.addObject("employees", employees);
        modelAndView.setViewName("ListEmployee");
        return modelAndView;
    }

    @GetMapping("/show-form")
    public ModelAndView showForm(ModelAndView modelAndView) {
        Employee employee = new Employee();
        modelAndView.addObject("employee", employee);
        modelAndView.setViewName("Register");
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute Employee employee, BindingResult bindingResult, @RequestParam("action") String action) {

        if ("back".equals(action)) {
            return "redirect:";
        }

        if ("submit".equals(action)) {
            if (bindingResult.hasErrors()) {
                return "Register";
            }

            this.employeeService.save(employee);
        }
        return "redirect:";
    }

    @GetMapping("/show-form-update")
    public ModelAndView showFormUpdate(@RequestParam("employeId") Long id, ModelAndView modelAndView) {
        Employee employee = this.employeeService.getById(id);

        if (employee == null) {
            modelAndView.addObject("errorMessage", "Not found - employee id: " + id);
            modelAndView.setViewName("error");
        }
        else {
            modelAndView.addObject("employee", employee);
            modelAndView.setViewName("Register");
        }

        return modelAndView;
    }

    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeId") Long id) {
        employeeService.remove(id);
        return "redirect:";
    }
}
