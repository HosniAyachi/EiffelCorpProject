package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

import entity.Status;

public interface ICar extends Remote{

	public int getId() throws RemoteException;

	public void setId(int id) throws RemoteException; 

	public String getBrand() throws RemoteException;

	public void setBrand(String brand) throws RemoteException;

	public String getModel() throws RemoteException;

	public void setModel(String model) throws RemoteException;
	
	public boolean getAvailability() throws RemoteException ;
	
	public void setAvailability(boolean availability) throws RemoteException;
	
	
	
}
