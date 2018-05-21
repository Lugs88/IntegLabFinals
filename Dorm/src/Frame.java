/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Akshay
 */
public class Frame extends FrameD
{
  
   JButton bA,bCheck;

    Frame()
   {
       setTitle("Dormitory management system");
       setLayout(new GridLayout(2,1));
       
       Handler objH1=new Handler();
       bA=new JButton("Land Lord");
       bA.addActionListener(objH1);
       add(bA);
       
       bCheck=new JButton("Tenant");
       bCheck.addActionListener(objH1);
       add(bCheck);
       
      
   }
   
   private class Handler implements ActionListener
   {
      public void actionPerformed(ActionEvent ev)
       {
           if(ev.getSource()==bA)
           {
               System.out.println("It works");
             
              // JOptionPane jop=new JOptakionPane();
               String user=JOptionPane.showInputDialog("Enter Username");
               String pass=JOptionPane.showInputDialog("Enter Password");
               DB obj=new DB();
               if(obj.login(user,pass))
               {
                   JOptionPane.showMessageDialog(null,"Welcome "+user+" !","Login succsessfull :)",JOptionPane.PLAIN_MESSAGE);
                  //setVisible(false);
                   DormLandLord f=new DormLandLord();
                  //f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
       
                   f.setVisible(true);
               }
               else
                   JOptionPane.showMessageDialog(null,"Invalid username or password!","Login Failed :(",JOptionPane.PLAIN_MESSAGE);
               
           }
           else if(ev.getSource()==bCheck) 
           {
              //System.out.println("It sfdsf");
             
               //setVisible(false);
               DormTenant f=new DormTenant();
               //f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setSize(300, 400);
        f.setVisible(true);
           } 
       }
   }
}
