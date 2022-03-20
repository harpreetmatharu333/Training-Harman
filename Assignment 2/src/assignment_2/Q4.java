package assignment_2;

class SalariedEmployee extends Employee1{

	private double fixedWeeklySalary;
	public SalariedEmployee(int id, String name, double fixedWeeklySalary) {
		super(id, name);
		this.fixedWeeklySalary=fixedWeeklySalary;
	}
	@Override
	public double getPayment() {
		return fixedWeeklySalary;
	}
	
}

class HourlyEmployee extends Employee1{
	private double  hourlyRate;
	private int numberOfHours;
	
	public HourlyEmployee(int id, String name,double  hourlyRate,
	 int numberOfHours ) {
		super(id, name);
		this.hourlyRate=hourlyRate;
		this.numberOfHours=numberOfHours;
	}

	@Override
	public String toString() {
		return super.toString()+
				"HourlyEmployee [hourlyRate=" + hourlyRate + ", "
				+ "numberOfHours=" + numberOfHours + "]";
	}

	@Override
	public double getPayment() {
		return hourlyRate*numberOfHours;
	}
		
}

abstract class Employee1{
	private int id;
	private String name;

	public Employee1(int id, String name) {
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}

	abstract public double getPayment() ;
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}	
	
}

class CommissionEmployee extends Employee1 {
	private double commisionPercentage;
	private double totalSales;

	public CommissionEmployee(int id, String name, double commisionPercentage, double totalSales) {
		super(id, name);
		this.commisionPercentage = commisionPercentage;
		this.totalSales = totalSales;
	}

	@Override
	public double getPayment() {
		return totalSales * commisionPercentage / 100;
	}

}

public class Q4 {
	public static void main(String[] args) {
		Employee1 employee=new
				CommissionEmployee(121, "amit", 2.1, 2000000);
		System.out.println(employee.getPayment());
	}

}
