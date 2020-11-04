package service;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import entity.Car;
import shared.ICar;
import shared.ICarsManagement;

public class CarService extends UnicastRemoteObject implements ICarsManagement {

	
	List<ICar> cars;

	public CarService() throws RemoteException {
		super();
		cars = new ArrayList<ICar>();
		
	}

	public boolean addCar(String brand, String model) throws RemoteException {
		
		try {
			
			if(this.cars.isEmpty()) {
				this.cars.add(new Car(0,brand,model));
				return true;
				}
			
			else {
				this.cars.add(new Car(this.cars.get(this.cars.size()-1).getId()+1,brand,model));
				return true;
				}
				
			}
	
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the addition of car process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return false;
		
	}
	
	
	public List<ICar> searchCarByModel(String model) throws RemoteException {
		
		try {
			
			List result = new ArrayList<Car>(); 
			for(ICar c :this.cars) {
				
				if(c.getModel().toLowerCase().equals(model.toLowerCase())) {
					 
					result.add(c);
					
				}
				
				
			
			}
			
			
			
			return 	result;
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of car by model process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return null;
		
	}
	
	public List<ICar> searchCarByBrand(String brand) throws RemoteException {
		try {
			
			List result = new ArrayList<Car>(); 
			for(ICar c :this.cars) {
				
				if(c.getBrand().toLowerCase().equals(brand.toLowerCase())) {
					 
					result.add(c);
					
				}
			
			}
			
			return 	result;
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of car by brand process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return null;
		
	}
	
	public ICar searchCarById(int id) throws RemoteException {
		
		try {
			
			for(ICar c :this.cars) {
				
				if(c.getId()==id) {
					 
					
					return (ICar) c;
				}
			
			}
			
				
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the research of car by id process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return null;
		
	}
	
	public boolean removeCar(int id) throws RemoteException {
	
		try {
			
			for(ICar c :this.cars) {
				
				if(c.getId()==id) {
					 
					this.cars.remove(c);
					return true;
				}
			
			}
			
				
				
			}
			
		catch(Exception e) {
			
			System.out.println("An Error has occurend during the deletion of car process stacktrace : "+ e);
			e.printStackTrace();
			
			}
	
		return false;
		
	}
	
	
	public List<ICar> getCars() throws RemoteException {
		return cars;
	}

	public void setCars(List<ICar> cars)  throws RemoteException {
		this.cars = cars;
	}
	
	
	
	
	
	
}
