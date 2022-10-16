package assignment3;

public abstract class Factory {
    // Employee
    public static Employee createEmployee(String id, String name, Double salaryGross) throws DefaultException, CannotBeBlankException {
        Employee employee;
        employee = new Employee(id, name, salaryGross);
        return employee;
    }

    // Manager
    public static Employee createEmployee(String id, String name, Double salaryGross, String degree) throws DefaultException, CannotBeBlankException {
        Employee employee;
        employee = new Manager(id, name, salaryGross, degree);
        return employee;
    }
                                                                        // Director
    public static Employee createEmployee(String id, String name, Double salaryGross, String degree, String department) throws DefaultException, CannotBeBlankException {
        Employee employee;
        employee = new Director(id, name, salaryGross, degree, department);

        return employee;
    }
                                                                        // Intern
    public static   Employee createEmployee(String id, String name, double salaryGross, int gpa) throws DefaultException, CannotBeBlankException {
        Employee employee;
        employee = new Intern(id, name, salaryGross, gpa);
        return employee;
    }


}
