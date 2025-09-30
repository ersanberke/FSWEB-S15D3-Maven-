package org.example;

import org.example.entity.Employee;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();

        employees.add(new Employee(1, "Ahmet", "Yilmaz"));
        employees.add(new Employee(2, "Ayse", "Demir"));
        employees.add(new Employee(1, "Ahmet", "Yilmaz"));
        employees.add(new Employee(3, "Mehmet", "Kaya"));
        employees.add(new Employee(2, "Ayse", "Demir"));
        employees.add(new Employee(4, "Fatma", "Celik"));
        employees.add(new Employee(1, "Ahmet", "Yilmaz"));

        System.out.println(findDuplicates(employees));

        System.out.println(findUniques(employees));

        System.out.println(removeDuplicates(employees));

        System.out.println(WordCounter.calculatedWord());
    }

    public static List<Employee> findDuplicates(List<Employee> employees){
        Map<Integer, Employee> employeeMap = new LinkedHashMap<>();
        List<Employee> duplicatedEmployee = new LinkedList<>();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                System.out.println("Null record");
                continue;
            }
            if (employeeMap.containsKey(employee.getId())){
                duplicatedEmployee.add(employee);
            }
            else {
                employeeMap.put(employee.getId(), employee);
            }
        }
        return duplicatedEmployee;
    }

    public static Map<Integer, Employee> findUniques(List<Employee> employees){
        Map<Integer, Employee> employeeMap = new HashMap<>();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if (employee == null){
                System.out.println("Null record");
                continue;
            }
            if (!employeeMap.containsKey(employee.getId())){
                employeeMap.put(employee.getId(), employee);
            }
        }
        return employeeMap;
    }

    public static List<Employee> removeDuplicates(List<Employee> employees){
        Map<Integer, Integer> countMap = new HashMap<>();
        List<Employee> result = new LinkedList<>();
        for (Employee employee: employees){
            if (employee == null) continue;
            countMap.put(employee.getId(), countMap.getOrDefault(employee.getId(), 0) + 1);
        }
        for (Employee employee: employees){
            if (employee == null) continue;
            if (countMap.get(employee.getId()) == 1){
                result.add(employee);
            }
        }
        return result;

    }
}