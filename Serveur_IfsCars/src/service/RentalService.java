package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entity.Car;
import entity.Rental;
import shared.ICar;
import shared.IFeedBack;
import shared.IRental;
import shared.IRentalsManagement;

public class RentalService extends UnicastRemoteObject implements IRentalsManagement  {

	List<IRental> rentals ;
	
	public RentalService() throws RemoteException {
		super();
		rentals = new ArrayList<IRental>();
	}
	
	public boolean addRental(int car_id,int employee_id, Date start_date, Date end_date) throws RemoteException {
		
		try {
			
			if(this.rentals.isEmpty()) {
				this.rentals.add(new Rental(0,car_id,employee_id,start_date,end_date));
				
				//Set car availablity to IS_RENTED
				
				return true;
			}

			else {
				
				this.rentals.add(new Rental(this.rentals.get(this.rentals.size()-1).getId()+1,car_id,employee_id,start_date,end_date));
				return true;
				
				}
			
		}
		
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the addition of rental process stacktrace : "+ e);
			e.printStackTrace();
		}
		
		
		return false;
	}
	
	
	public boolean removeRental(int id) throws RemoteException {
			
			try {
				
				for(IRental r :this.rentals) {
					
					if(r.getId()==id) {
						 
						this.rentals.remove(r);
						//set car to available !!
						
						return true;
					}
				
				}
				
					
					
				}
				
			catch(Exception e) {
				
				System.out.println("An Error has occurend during the deletion of rental process stacktrace : "+ e);
				e.printStackTrace();
				
				}
		
			return false;
		}
		
	public List<IRental> searchRentByEmployeeId(int employee_id) throws RemoteException {
			
			try {
				
				List result = new ArrayList<Rental>(); 
				
				for(IRental r :this.rentals) {
					
					if(r.getEmployee_id()==employee_id) {
						 
						result.add(r);
						
					}
				
				}
				
				return 	result;
					
				}
				
			catch(Exception e) {
				
				System.out.println("An Error has occurend during the research of rental by employee id process stacktrace : "+ e);
				e.printStackTrace();
				
				}
		
			return null;
			
		}
		
	public List<IRental> searchRentByCarId(int car_id) throws RemoteException {
			try {
				
				List result = new ArrayList<Rental>(); 
				
				for(IRental r :this.rentals) {
					
					if(r.getCar_id()==car_id) {
						 
						result.add(r);
						
					}
				
				}
				
				return 	result;
					
				}
				
			catch(Exception e) {
				
				System.out.println("An Error has occurend during the research of rental by car id process stacktrace : "+ e);
				e.printStackTrace();
				
				}
		
			return null;
			
		}
		
	public IRental searchRentById(int id) throws RemoteException {
			
			try {
				
				for(IRental r :this.rentals) {
					
					if(r.getId()==id) {
						 
						
						return (IRental) r;
					}
				
				}
				
					
					
				}
				
			catch(Exception e) {
				
				System.out.println("An Error has occurend during the research of rental by id process stacktrace : "+ e);
				e.printStackTrace();
				
				}
		
			return null;
			
		}

	public List<IRental> getRentals() throws RemoteException  {
			return rentals;
		}

	public void setRentals(List<IRental> rentals) throws RemoteException  {
			this.rentals = rentals;
		}


		
			
	
}
