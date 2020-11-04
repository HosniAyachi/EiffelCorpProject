package entity;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.Date;


import shared.IRental;

public class Rental extends UnicastRemoteObject implements IRental {

	int id, car_id, employee_id ; 
	
	Date start_date, end_date;

	public Rental() throws RemoteException {
		super();
	}

	public Rental(int id, int car_id, int employee_id, Date start_date, Date end_date)  throws RemoteException {
		super();
		this.id = id;
		this.car_id = car_id;
		this.employee_id = employee_id;
		this.start_date = start_date;
		this.end_date = end_date;
	}

	public int getId()  throws RemoteException {
		return id;
	}

	public void setId(int id)  throws RemoteException {
		this.id = id;
	}

	public int getCar_id()  throws RemoteException {
		return car_id;
	}

	public void setCar_id(int car_id)  throws RemoteException {
		this.car_id = car_id;
	}

	public int getEmployee_id()  throws RemoteException {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) throws RemoteException {
		this.employee_id = employee_id;
	}

	public Date getStart_date()  throws RemoteException {
		return start_date;
	}

	public void setStart_date(Date start_date)   throws RemoteException {
		this.start_date = start_date;
	}

	public Date getEnd_date()  throws RemoteException {
		return end_date;
	}

	public void setEnd_date(Date end_date)  throws RemoteException {
		this.end_date = end_date;
	}

	@Override
	public String toString() {
		return "Rental [id=" + id + ", car_id=" + car_id + ", employee_id=" + employee_id + ", start_date=" + start_date
				+ ", end_date=" + end_date + "]";
	}
	
	
	
	
}
