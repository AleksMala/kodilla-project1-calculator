package com.kodilla.patterns2.adapter.company.newhrsystem;

import java.math.BigDecimal;
import java.util.List;

public class CompanyProcessorSalary implements SalaryProcessor {

    @Override
    public BigDecimal calculatesalaries(List<Employee> employees) {
        BigDecimal sum = BigDecimal.ZERO;
        for (Employee employee : employees) {
            System.out.println(employee);
            sum = sum.add(employee.getBaseSalary());
        }
        return sum;
    }
}
