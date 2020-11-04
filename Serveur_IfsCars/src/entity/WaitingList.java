package entity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;

import shared.IWaiting;

public class WaitingList extends UnicastRemoteObject implements IWaiting {

	
	private int id,car_id,employee_id;
	private Date date_available, request_date;
	
	public WaitingList() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}



	public WaitingList(int id, int car_id, int employee_id) throws RemoteException {
		super();
		this.id = id;
		this.car_id = car_id;
		this.employee_id = employee_id;
		this.request_date = new Date();
		
	}



	public int getId() throws RemoteException {
		return id;
	}

	public void setId(int id) throws RemoteException {
		this.id = id;
	}

	public int getCar_id() throws RemoteException {
		return car_id;
	}

	public void setCar_id(int car_id) throws RemoteException {
		this.car_id = car_id;
	}

	public int getEmployee_id() throws RemoteException {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) throws RemoteException {
		this.employee_id = employee_id;
	}

	public Date getDate_available() throws RemoteException {
		return date_available;
	}

	public void setDate_available(Date date_available) throws RemoteException {
		this.date_available = date_available;
	}



	public Date getRequest_date() throws RemoteException {
		return request_date;
	}



	public void setRequest_date(Date request_date) throws RemoteException {
		this.request_date = request_date;
	}



	@Override
	public String toString() {
		return "WaitingList [id=" + id + ", car_id=" + car_id + ", employee_id=" + employee_id + ", date_available="
				+ date_available + ", request_date=" + request_date + "]";
	}



	
	
	
	
}
