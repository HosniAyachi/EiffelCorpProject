package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.Date;
import java.util.List;

public interface IRentalsManagement extends Remote {

	public boolean addRental(int car_id,int employee_id, Date start_date, Date end_date) throws RemoteException ;
	
	public boolean removeRental(int id) throws RemoteException;
	
	public List<IRental> searchRentByEmployeeId(int employee_id) throws RemoteException;
	
	public List<IRental> searchRentByCarId(int car_id) throws RemoteException;
	
	public IRental searchRentById(int id) throws RemoteException;
	
	public void setRentals(List<IRental> rentals) throws RemoteException;
	
	public List<IRental> getRentals() throws RemoteException ;
	

	
}
