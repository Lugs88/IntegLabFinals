

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface DormDetails extends Remote
{
	//tenant
	public String getDormName() throws RemoteException;
	public int occupiedSlots() throws RemoteException;
	public int vacantSlots() throws RemoteException;
	public int allCap() throws RemoteException;
	public void checkIn() throws RemoteException;
	public void checkOut() throws RemoteException;
	public String getNotification() throws RemoteException;
	
	
	//landlord
	public void setDormName(String newName) throws RemoteException;
	public void setDormCapacity(int capacity) throws RemoteException;
	public void sendNotification(String notice) throws RemoteException;
	
	
}