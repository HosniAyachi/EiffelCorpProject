package service;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import entity.Employee;


import shared.IEmploy;
import shared.IEmployManagement;


public class EmployeeService extends UnicastRemoteObject implements IEmployManagement  {

	
	 List<Employee> employees; 
	
	
	public EmployeeService() throws RemoteException {
		super();
		employees = new ArrayList<Employee>(); 
	}
	
	

	public boolean addEmployee(String firstName, String lastName, String email, String address, int age) throws RemoteException {
		
		try {
			
			if(this.employees.isEmpty()) {
				this.employees.add(new Employee(0,firstName,lastName,email,address,age));
				
				
				//set the available date field !!
				
				return true;
				}
			
			else {
				this.employees.add(new Employee(this.employees.get(this.employees.size()).getId()+1,firstName,lastName,email,address,age));
				return true;
				}
				
			}
	
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the addition of employee  process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return false;
		
	}
	
	
	public List<IEmploy> searchEmployeeByFirstName(String firstName) throws RemoteException {
		
		
		
		
		try {
				
			List result = new ArrayList<Employee>();
			
			for(Employee emp : employees ) {
				
				if(emp.getFirstName().toLowerCase().equals(firstName.toLowerCase())) 
					
					result.add(emp);
				
				}
					 
			System.out.println("Result for search : "+ result.get(0));		
			return result;	 
			}
					
		
		
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of employee by firstname process stacktrace : "+ e.getMessage());
			
		}
		
		
		return null;
	}
	
	public List<IEmploy> searchEmployeeById(int id) throws RemoteException {
		
		
		
		
		try {
				
			List result = new ArrayList<Employee>();
			
			for(Employee emp : employees ) {
				
				if(emp.getId()==id) 
					
					result.add(emp);
				
				}
			
			//testing :		 
			System.out.println("Result for search : "+ result.get(0));	
			
			return result;	 
			}
					
		
		
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of employee by firstname process stacktrace : "+ e.getMessage());
			
		}
		
		
		return null;
	}
	
	public boolean removeEmployeeById(int id) throws RemoteException {
			
		try {
			
			this.employees.remove(this.searchEmployeeById(id));
			
			return true;
		}
		
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the deletion of employee by id process stacktrace : "+ e.getMessage());
			
		}
		
		return false;
		
		}
	
	public boolean removeEmployeeByFirstName(String firstName) throws RemoteException {
		
		try {
			
			this.employees.remove(this.searchEmployeeByFirstName(firstName));
			
			return true;
		}
		
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the deletion of employee by firstnameZ process stacktrace : "+ e.getMessage());
			
		}
		
		return false;
		
		}

	//Add method to set availabilty and remove on cascade rental row for the emp conserned when
	//deleting it .


	
		
	
}
