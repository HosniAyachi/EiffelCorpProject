package shared;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface IWaitingManagement extends Remote {
	
	public boolean addWaiting(int car_id, int employee_id) throws RemoteException ;
	
	public List<IWaiting> searchWaitingByCarId(int car_id) throws RemoteException ;
	
	public List<IWaiting> searchWaitingByEmployeeId(int employee_id) throws RemoteException;
	
	public IWaiting searchWaitingById(int id) throws RemoteException;
	
	public boolean removeWaiting(int id) throws RemoteException;	
	
	public void notifyEmployee( List<IWaiting> waitingList) throws RemoteException;
	
	public void setWaitingList(List<IWaiting> waitingList) throws RemoteException;
	
	public List<IWaiting> getWaitingList() throws RemoteException;
	
	

}
