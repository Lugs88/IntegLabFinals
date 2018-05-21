

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.Scanner;
import java.rmi.registry.LocateRegistry;


public class DormLandLord extends FrameD implements ActionListener
{
    JButton add,notification,serv,dormName,cap;
    JLabel jl,jls;
    DormLandLord()
    {
        setTitle("Land Lord Panel");
        setLayout(new GridLayout(5,1));
        
        add=new JButton("Add");
        dormName=new JButton("Edit Dorm Name");
        cap=new JButton("Set Dorm Capacity");
        notification=new JButton("Notify Tenant");
        serv=new JButton("Services");
        
        
        
        dormName.addActionListener(this);
        add.addActionListener(this);
        notification.addActionListener(this);
        serv.addActionListener(this); 
        cap.addActionListener(this);
        
        //list.addActionListener(this);
        add(dormName);
        add(cap);
        add(notification);
        add(add);
        add(serv);

        setSize(400,300);
    }
     private void frameAdd() {
                 //To change body of generated methods, choose Tools | Templates.
        jl=new JLabel("Visible");
         add(jl);
            }
     private void frameRemove(){
         remove(jl);
     }

    @Override
    public void actionPerformed(ActionEvent e) {
         //To change body of generated methods, choose Tools | Templates.
        if(e.getSource()==dormName)
        {
          System.out.println("dormName works");
          String dormName=JOptionPane.showInputDialog("Enter New Dorm Name:");
          
          try 
          {
        	Registry registry = LocateRegistry.getRegistry("localhost",1099);
  			DormDetails dorm = (DormDetails)registry.lookup("dorm");
  			
  			dorm.setDormName(dormName);
  			JOptionPane.showMessageDialog(null,"Successfully renamed to "+dorm.getDormName()+" !","Sucess :)",JOptionPane.PLAIN_MESSAGE);

          } catch(Exception ex) 
          {
          	ex.printStackTrace();
          }
          
        }
        else if(e.getSource()==cap)
        {
          System.out.println("Cap works");

          String dormCapacity=JOptionPane.showInputDialog("Enter New Dorm Capacity:");
          
          try 
          {
        	Registry registry = LocateRegistry.getRegistry("localhost",1099);
  			DormDetails dorm = (DormDetails)registry.lookup("dorm");
  			
  			dorm.setDormCapacity(Integer.parseInt(dormCapacity));
  			//System.out.println(x);
  			JOptionPane.showMessageDialog(null,"Successfully entered "+dormCapacity+" as the new capacity.","Sucess :)",JOptionPane.PLAIN_MESSAGE);

          } catch(Exception ex) 
          {
          	ex.printStackTrace();
          }
        }
        else if(e.getSource()==notification)
        {
	        System.out.println("notification works");
	        String notice=JOptionPane.showInputDialog("Enter Notification: ");
        
        try 
        {
	      	Registry registry = LocateRegistry.getRegistry("localhost",1099);
			DormDetails dorm = (DormDetails)registry.lookup("dorm");
				
			dorm.sendNotification(notice);
			JOptionPane.showMessageDialog(null,"Successfully posted notification!","Sucess :)",JOptionPane.PLAIN_MESSAGE);
	
	     }catch(Exception ex) 
	     	{
	        	ex.printStackTrace();
	        }
	        
        }
        else if(e.getSource()==add)
        {
             System.out.println("Add works");
            FAdd objA=new FAdd();
            objA.addEventListen();
        }
         else if(e.getSource()==serv)
        {
             System.out.println("serv works");
            FService obj=new FService();
            obj.create();
            
        }
        
        
        
    }
            
}
