package singleResponsibilityPrinciple;

public class Main {
	public static void main(String[] args) {
        Employee emp1 = new Employee("John", "Developer");
        Employee emp2 = new Employee("Jane", "Manager");

        SalaryCalculator salaryCalculator = new SalaryCalculator();
        
        System.out.println(emp1.getName() + "'s Salary: $" + salaryCalculator.calculateSalary(emp1));
        System.out.println(emp2.getName() + "'s Salary: $" + salaryCalculator.calculateSalary(emp2));
    }
}
