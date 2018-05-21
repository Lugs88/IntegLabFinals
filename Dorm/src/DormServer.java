

import java.rmi.server.UnicastRemoteObject;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;

public class DormServer implements DormDetails
{
	public String dormName = "SLU Dorm";
	public String notification = "Welcome to "+dormName;
	
	public int occupiedSlots = 0;
	public int vacantSlots = 0;
	public int dormCapacity = occupiedSlots + vacantSlots;
	
	//System.setProperty("java.rmi.server.hostname","localhost");
	
	public String getDormName()
	{
		return dormName;
	}
	
	public int occupiedSlots() 
	{
		return occupiedSlots;
	}
	
	public int vacantSlots()
	{
		return vacantSlots;
	}
	
	public int allCap()
	{
		return dormCapacity;
	}
	
	public void checkIn()
	{
		if(vacantSlots != 0)
		{
			occupiedSlots++;
			vacantSlots--;
		}
		else
		{
			System.out.print("No more Space");
		}
	}
	
	public void checkOut()
	{
		vacantSlots++;
		occupiedSlots--;
	}
	
	public String getNotification()
	{
		return notification;
	}
	
	
	
	//landlord
	public void setDormName(String newName)
	{
		dormName = newName;
	}
	
	public void setDormCapacity(int capacity)
	{
		dormCapacity = capacity;
	}
	
	public void sendNotification(String notice)
	{
		notification = notice;
	}
	
	public static void main(String[] args) {
        try {
        	//System.setProperty("java.rmi.server.hostname","localhost");
        	DormServer server = new DormServer();
        	DormDetails stub = (DormDetails)UnicastRemoteObject.exportObject(server, 0);

        	//Registry registry = LocateRegistry.getRegistry();
        	Registry registry = LocateRegistry.getRegistry("localhost",1099);
        	System.setProperty("java.rmi.server.hostname","localhost");
        	registry.rebind("dorm", stub);
        	System.out.println("Huzzah! The Server Works");

        } catch(Exception e) {
        	e.printStackTrace();
        	System.exit(1);
        }
    }
	
}
