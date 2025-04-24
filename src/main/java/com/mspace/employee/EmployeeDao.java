/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mspace.employee;


import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;


/**
 *
 * @author nomad
 */

@ApplicationScoped
public class EmployeeDao{
    @PersistenceContext
    private EntityManager entityManager;
    
   public List<Employee> findAll()
   {
       return entityManager.createQuery("SELECT a FROM Employee a", Employee.class).getResultList();
   }
   
   public Optional<Employee> findBYId(Long id)
   {
       Employee employee = entityManager.find(Employee.class, id);
       return Optional.ofNullable(employee);
   }
   
   @Transactional
   public void save(Employee employee)
   {
     entityManager.persist(employee);
   }
   
   @Transactional
   public void edit(Employee employee)
   {
       if(employee.getId() != null)
       {
           entityManager.merge(employee);
        }
       else
       {
           System.out.println("id does not exist !! ");
       }
   }
   
    @Transactional
     public void delete(Employee employee)
     {
        if(employee.getId() != null) {
         Employee thisEmployee = entityManager.find(Employee.class, employee.getId());
         if(thisEmployee != null)
         {
             entityManager.remove(thisEmployee);
         }
         
           else
       {
           
           System.out.println("Employee not found with id=" + employee.getId());
       }
    }else
        {
            System.out.println("id does not exist!!");
        }
         
     }
}
