package assignment_3;

import java.io.*;

class Address implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String addressLocation;
	private String city;
	private String country;

	public String getAddressLocation() {
		return addressLocation;
	}

	public void setAddressLocation(String addressLocation) {
		this.addressLocation = addressLocation;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Address(String addressLocation, String city, String country) {
		this.addressLocation = addressLocation;
		this.city = city;
		this.country = country;
	}

	public Address() {}

	@Override
	public String toString() {
		return "Address [addressLocation=" + addressLocation + 
				", city=" + city + ", country=" + country + "]";
	}
	
}

class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private Address address;
	transient private double salary;

	public Employee(int id, String name, Address address, int salary) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

}

public class Q3 {
	
	public static void main(String[] args) {

		Address address=new Address("A21, Preet vihar", "delhi", "India");
		Employee employee=
				new Employee(121, "raj", address, 400000);
		
		//Serilization
		try {
			ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("temp.ser")));
			oos.writeObject(employee);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//Deserilization
		employee=null;
		try {
			ObjectInputStream oos=new ObjectInputStream(new FileInputStream(new File("temp.ser")));
			employee=(Employee) oos.readObject();
			System.out.println(employee);
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		
	}

}
