package Entities;

import UserInterfaces.SecretaryInterface;
import java.sql.Date;
import java.util.List;
import javax.swing.JFrame;



public class Secretary extends Person implements Employee
{
	
    String Type;     

	public Secretary(String firstName, String lastName,String address, String email, String sex, String password ,float Salary, String Type, int ID) {
		super(ID, firstName, lastName, address, email, sex, password, Salary);
                this.Type = Type;
		
	}

    public Secretary() {
    }


    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

	

    @Override
    public String personDesc() {
    return "Secretary";
    }

    @Override
    public void getPermissions() {
    new SecretaryInterface().setVisible(true);
    }

   @Override
	public String toString()
	{
		return this.getFirstName()+" "+this.getLastName();
	}
	
	

}
