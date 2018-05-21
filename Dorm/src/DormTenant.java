


import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DormTenant extends FrameD implements ActionListener
{
	JButton dName,occupied,vacant,check_in,check_out,notification;
    JLabel jl,jls;
    DormTenant()
    {
        setTitle("Tenant Panel");
        setLayout(new GridLayout(6,1));
        
        dName=new JButton("View Dorm Name");
        occupied=new JButton("View Occupied slots");
        vacant=new JButton("View Vacant slots");
        check_in=new JButton("Check-in");
        check_out=new JButton("Check-ou");
        notification=new JButton("Notifications");
        
        
        
        dName.addActionListener(this);
        occupied.addActionListener(this);
        vacant.addActionListener(this);
        check_in.addActionListener(this); 
        check_out.addActionListener(this);
        notification.addActionListener(this);
        
        //list.addActionListener(this);
        add(dName);
        add(occupied);
        add(vacant);
        add(check_in);
        add(check_out);
        add(notification);

        setSize(400,300);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //To change body of generated methods, choose Tools | Templates.
       if(e.getSource()==dName)
       { 
    	 System.out.println("Dorm View Works!");
         try 
         {
        	Registry registry = LocateRegistry.getRegistry("localhost",1099);
 			DormDetails dorm = (DormDetails)registry.lookup("dorm");

 			JOptionPane.showMessageDialog(null,"Welcome to "+dorm.getDormName()+" !",dorm.getDormName()+"",JOptionPane.PLAIN_MESSAGE);

         } catch(Exception ex) 
         {
         	ex.printStackTrace();
         }
         
       }
       else if(e.getSource()==occupied)
       {
    	 System.out.println("Occupied Works!");
         
         try 
         {
        	Registry registry = LocateRegistry.getRegistry("localhost",1099);
 			DormDetails dorm = (DormDetails)registry.lookup("dorm");
 			
 			int occ = dorm.occupiedSlots();
 			int cap = dorm.allCap();

 			JOptionPane.showMessageDialog(null,"There are currently "+occ+" room/s that are being occupied","Occupants",JOptionPane.PLAIN_MESSAGE);

         } catch(Exception ex) 
         {
         	ex.printStackTrace();
         }
       }
       else if(e.getSource()==vacant)
       {
	        System.out.println("vacant works");
  
	       try 
	       {
		      	Registry registry = LocateRegistry.getRegistry("localhost",1099);
				DormDetails dorm = (DormDetails)registry.lookup("dorm");
					
				int vac = dorm.vacantSlots();
				int cap = dorm.allCap();
				
				JOptionPane.showMessageDialog(null,"There are currently "+vac+" out of "+cap+" room/s that are vacant.","Vacancies",JOptionPane.PLAIN_MESSAGE);
		
		   }catch(Exception ex) 
		    {
		        	ex.printStackTrace();
		    }
	        
       }
       else if(e.getSource()==check_in)
       {
    	   System.out.println("check_in works");
    	   
	       try 
	       {
		      	Registry registry = LocateRegistry.getRegistry("localhost",1099);
				DormDetails dorm = (DormDetails)registry.lookup("dorm");
				
				dorm.checkIn();
				int vac = dorm.vacantSlots();
				int cap = dorm.allCap();
				
				JOptionPane.showMessageDialog(null,"You have checked in.","Check-in",JOptionPane.PLAIN_MESSAGE);
		
		   }catch(Exception ex) 
		    {
		        	ex.printStackTrace();
		    }
	        
       }
       else if(e.getSource()==check_out)
       {
    	   System.out.println("check_out works");
    	   
	       try 
	       {
		      	Registry registry = LocateRegistry.getRegistry("localhost",1099);
				DormDetails dorm = (DormDetails)registry.lookup("dorm");
				
				dorm.checkOut();
				int vac = dorm.vacantSlots();
				int cap = dorm.allCap();
				
				JOptionPane.showMessageDialog(null,"You have checked out.","Check-out",JOptionPane.PLAIN_MESSAGE);
		
		   }catch(Exception ex) 
		    {
		        	ex.printStackTrace();
		    }
           
       }
       else if(e.getSource()==notification)
       {
    	   System.out.println("notifcation works");
    	   
	       try 
	       {
		      	Registry registry = LocateRegistry.getRegistry("localhost",1099);
				DormDetails dorm = (DormDetails)registry.lookup("dorm");
				
				String notice = dorm.getNotification();
				
				JOptionPane.showMessageDialog(null,""+notice+"","Notification",JOptionPane.PLAIN_MESSAGE);
		
		   }catch(Exception ex) 
		    {
		        	ex.printStackTrace();
		    }
           
       }
       
       
       
   }
}
