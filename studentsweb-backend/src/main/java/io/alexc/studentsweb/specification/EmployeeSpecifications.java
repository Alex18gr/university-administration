package io.alexc.studentsweb.specification;

import io.alexc.studentsweb.entity.Employee;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class EmployeeSpecifications {

    public static Specification<Employee> textInName(String text) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("name")), "%" + text.toLowerCase() + "%" );
            }
        };
    }

    public static Specification<Employee> textInSurname(String text) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(criteriaBuilder.lower(root.get("surname")), "%" + text.toLowerCase() + "%" );
            }
        };
    }

    public static Specification<Employee> textInNameOrSurname(String text) {
        return Specification.where(textInName(text)).or(textInSurname(text));
    }

    public static Specification<Employee> employeeInDepartment(Integer departmentId) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("department").get("departmentId"), departmentId);
            }
        };
    }

    public static Specification<Employee> employeeInService(Integer serviceId) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.equal(root.get("universityService").get("serviceId"), serviceId);
            }
        };
    }

//    public static Specification<Employee> nameContainsText(String text) {
//        return new Specification<Employee>() {
//            @Override
//            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
//                return criteriaBuilder.
//            }
//        };
//    }


//    public static Specification<Customer> customerHasBirthday() {
//        return new Specification<Customer> {
//            public Predicate toPredicate(Root<T> root, CriteriaQuery query, CriteriaBuilder cb) {
//                return cb.equal(root.get(Customer_.birthday), today);
//            }
//        };
//    }

}
