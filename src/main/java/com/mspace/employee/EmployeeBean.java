/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mspace.employee;

import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
import org.primefaces.event.RowEditEvent;

/**
 *
 * @author nomad
 */
@Named
@ViewScoped
public class EmployeeBean implements Serializable{
    private static final long serialVersionUID = 1L;
    
    @Inject
    private EmployeeDao employeeDao;
    
    private Employee employee = new Employee();
    private List<Employee> employees;
    
    @PostConstruct
    public void init ()
    {
        listEmployees();
    }
    
    private void listEmployees()
    {
        employees = employeeDao.findAll();
    }
    
    public void saveEmployee()
    {
      
        try{
            
            employeeDao.save(employee);
    
            FacesMessage msgs = new FacesMessage("saved succesfully", String.valueOf(employee.getId()));
            FacesContext.getCurrentInstance().addMessage(null, msgs);
        }catch (Exception e)
        {
            FacesMessage msgs = new FacesMessage("Failed to save", e.toString());
            FacesContext.getCurrentInstance().addMessage(null, msgs);
        }
    } 
    
//    public void addEmployee(Employee employee)
//    {
//        try{
//            employeeDao.save(employee);
//        }catch(Exception e){
//            System.out.println(e.toString());
//        }
//    }

    public void editEmployee(RowEditEvent<Employee> event)
    {
          this.employee = event.getObject();
        try
        {
            employeeDao.edit(employee);
            FacesMessage msgs = new FacesMessage("edited succesfully", String.valueOf(employee.getId()));
            FacesContext.getCurrentInstance().addMessage(null, msgs);
        }catch (Exception e)
        {
             FacesMessage msgs = new FacesMessage("Failed to edit", e.toString());
            FacesContext.getCurrentInstance().addMessage(null, msgs);
        }
    }
    
    public void deleteEmployee(Employee employee)
    {   
        System.out.println("hello: " + employee.getId().toString());
        try
        {
            employeeDao.delete(employee);
            employees.remove(employee);
            employees = employeeDao.findAll();
            FacesMessage msgs;
            msgs = new FacesMessage("deleted succesfully", String.valueOf(employee.getId()));
            FacesContext.getCurrentInstance().addMessage(null, msgs);
        }catch(Exception e)
        {
            FacesMessage msgs = new FacesMessage("Failed to delete", e.toString());
            FacesContext.getCurrentInstance().addMessage(null, msgs);
        }
    }
    
    public void cancel()
    {
        FacesMessage msgs =  new FacesMessage("Edit Cancelled");
        FacesContext.getCurrentInstance().addMessage(null, msgs);
    }
    
    
    public Employee getEmployee()
    {
        return employee;
    }
    
    public void setEmployee(Employee employee)
    {
        this.employee = employee;
      }
    
    public List<Employee> getEmployees()
    {
        return employees;
    }
}
