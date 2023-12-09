package CollegeManagement;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
private int id;
	
private String Name;
	
private String address;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return Name;
}
public void setName(String name) {
	Name = name;
}
public String getAdd() {
	return address;
}
public void setAdd(String add) {
	this.address = add;
}

public Student(int id, String name, String add) {
	super();
	this.id = id;
	Name = name;
	this.address = address;
}

public Student() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Student [id=" + id + ", Name=" + Name + ", add=" + address + "]";
}


}
