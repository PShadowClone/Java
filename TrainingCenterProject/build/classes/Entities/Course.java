package Entities;

import java.util.ArrayList;
import java.util.Date;

public class Course 
{
	private final String CourseName;
	private final int Hours;
	private final float Price;
	private final Trainer Trainer;
	private final int ID;

    public Course() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Date getSDate() {
        return SDate;
    }

    public void setSDate(Date SDate) {
        this.SDate = SDate;
    }

    public Date getEDate() {
        return EDate;
    }

    public void setEDate(Date EDate) {
        this.EDate = EDate;
    }
        private Date SDate;
        private Date EDate;
	public ArrayList<Student> Course_Student = new ArrayList<Student>();

    public String getCourseName() {
        return CourseName;
    }

    public int getHours() {
        return Hours;
    }

    public float getPrice() {
        return Price;
    }

    public Trainer getTrainer() {
        return Trainer;
    }

    public int getID() {
        return ID;
    }
	
	
	public Course(CourseBuilder courseB) {
		this.ID = courseB.getID();
		this.CourseName = courseB.getCourseName();
		this.Hours = courseB.getHours();
		this.Price = courseB.getPrice();
		this.Trainer = courseB.getTrainerID();
	}
        
        
        
        public static class CourseBuilder
        {
        private  String CourseName;
	private  int Hours;
	private  float Price;
	private  Trainer Trainer;
	private  int ID;
            
        public String getCourseName() {
		return CourseName;
	}

	public CourseBuilder setCourseName(String courseName) {
		this.CourseName = courseName;
                return this;
	}
       public float getPrice()
       {
           return Price;
       }

	public int getHours() {
		return Hours;
	}

	public CourseBuilder setHours(int hours) {
		this.Hours = hours;
                return this;
	}

	
	public CourseBuilder setPrice(float price) {
		this.Price = price;
                return this;
	}

	public Trainer getTrainerID() {
		return this.Trainer;
	}

	public CourseBuilder setTrainerID(Trainer trainer) {
		this.Trainer = trainer;
                return this;
	}
        public int getID() {
		return ID;
	}
	public CourseBuilder setID(int iD) {
		ID = iD;
                return this;
	}
        
        public Course buildCourse()
        {
            return new Course(this);
        }	

        }

	

	public ArrayList<Student> getCourse_Student() {
		return Course_Student;
	}

	public void setCourse_Student(ArrayList<Student> course_Student) {
		this.Course_Student = course_Student;
	}
	
	
        @Override
	public String toString()
        {
            return this.getCourseName();
        }
	

}
