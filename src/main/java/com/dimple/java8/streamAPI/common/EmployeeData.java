package com.dimple.java8.streamAPI.common;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @className: EmployeeData
 * @description: Employee data
 * @auther: Dimple
 * @date: 07/11/19
 * @version: 1.0
 */
public class EmployeeData {

    public static List<Employee> getEmployee() {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Employee employee = new Employee();
            employee.setId(i);
            employee.setMoney((double) (i * 100));
            employee.setName(UUID.randomUUID().toString().substring(0, 3));
            employees.add(employee);
        }
        return employees;
    }
}
