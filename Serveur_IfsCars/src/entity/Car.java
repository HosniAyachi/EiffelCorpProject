package entity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;


import shared.ICar;

public class Car extends UnicastRemoteObject implements ICar {

	private int id;
	private String brand, model;
	private boolean availability;
	
	
	
	
	
	public Car() throws RemoteException  {
		super();
	}





	public Car(int id, String brand, String model) throws RemoteException {
		super();
		this.id = id;
		this.brand = brand;
		this.model = model;
		this.availability = true ;
	}





	public int getId() throws RemoteException {
		return id;
	}





	public void setId(int id) throws RemoteException {
		this.id = id;
	}





	public String getBrand() throws RemoteException {
		return brand;
	}





	public void setBrand(String brand) throws RemoteException {
		this.brand = brand;
	}





	public String getModel() throws RemoteException{
		return model;
	}





	public void setModel(String model) throws RemoteException {
		this.model = model;
	}





	public boolean getAvailability() throws RemoteException {
		return availability;
	}





	public void setAvailability(boolean availability) throws RemoteException {
		this.availability = availability;
	}





	@Override
	public String toString() {
		return "Car [id=" + id + ", brand=" + brand + ", model=" + model + ", availability=" + availability + "]";
	} 
	
	
	
	
	
	
	
	
}
