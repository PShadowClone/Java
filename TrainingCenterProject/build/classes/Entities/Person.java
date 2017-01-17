package Entities;

import java.sql.Date;



public abstract class Person 
{
	private   String FirstName;
	private  String LastName;
	
	private  String Address;
	private  String Email;
	private  String Sex;
	private  int ID;
        private  String Password;
	private  float Salary;
	
	
        public Person(){}
    public Person(int ID ,String FirstName, String LastName,String Address, String Email, String Sex, String Password, float Salary) {
        this.FirstName = FirstName;
        this.LastName = LastName;     
        this.Address = Address;
        this.Email = Email;
        this.Sex = Sex;
        this.ID = ID;
        this.Password = Password;
        this.Salary = Salary;
    }
    public Person(int ID)
    {
        this.ID = ID;
        
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    
    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setSex(String Sex) {
        this.Sex = Sex;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setSalary(float Salary) {
        this.Salary = Salary;
    }
        
        

	public int getID() {
		return ID;
	}


	

	public String getFirstName() {
		return FirstName;
	}



	public String getLastName() {
		return LastName;
	}


	


	


	public String getAddress() {
		return Address;
	}


	

	public String getEmail() {
		return Email;
	}


	

	public String getSex() {
		return Sex;
	}


	
    public String getPassword() {
        return Password;
    }

    public float getSalary() {
        return Salary;
    }


   
 	 
        public abstract String personDesc();
          public abstract void getPermissions();
	

}
