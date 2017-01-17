package Entities;

import java.sql.Date;
import java.util.List;
import javax.swing.JFrame;



public class Trainer extends Person implements Employee
{
    
	
	public Trainer(){}
	public Trainer(String FirstName, String LastName, Date DOB, String Address, String Email, String Sex, int ID, String Password, float Salary) {
		super(ID, FirstName, LastName, Address, Email, Sex, Password, Salary);
		
	}

        public Trainer(int ID)
        {
            super(ID);
        }
	
	
	@Override
	public String toString()
	{
		return this.getFirstName()+" "+this.getLastName();
	}


    @Override
    public String personDesc() {
       return "Tranier";
    }
    
  

    @Override
        public void getPermissions() {

        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

   
}
