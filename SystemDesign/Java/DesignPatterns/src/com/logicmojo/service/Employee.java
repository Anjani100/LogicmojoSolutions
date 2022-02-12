package com.logicmojo.service;

public class Employee {
    int empId;
    private static Employee emp;

    private Employee() { }

    public static Employee createInstance() {
        if (emp == null) {
            synchronized (Employee.class) {
                if (emp == null) {
                    emp = new Employee();
                    System.out.println("Instance Created!");
                }
            }
        }
        return emp;
    }

    public static void main(String[] args) {
        // No-thread Version
        // Prints the "Instance Created!" when the below line runs
        Employee emp1 = Employee.createInstance();
        // Prints nothing when the below line runs as one instance is already created
        Employee emp2 = Employee.createInstance();

        // Thread Version, to be run after commenting the No-thread Version
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                Employee emp = Employee.createInstance();
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                Employee emp = Employee.createInstance();
            }
        });
        t1.start();
        t2.start();
    }
}
