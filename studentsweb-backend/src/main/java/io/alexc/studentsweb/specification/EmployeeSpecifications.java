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
                return criteriaBuilder.like(root.get("name"), "%" + text + "%" );
            }
        };
    }

    public static Specification<Employee> textInSurname(String text) {
        return new Specification<Employee>() {
            @Override
            public Predicate toPredicate(Root<Employee> root, CriteriaQuery<?> criteriaQuery, CriteriaBuilder criteriaBuilder) {
                return criteriaBuilder.like(root.get("surname"), "%" + text + "%" );
            }
        };
    }


//    public static Specification<Customer> customerHasBirthday() {
//        return new Specification<Customer> {
//            public Predicate toPredicate(Root<T> root, CriteriaQuery query, CriteriaBuilder cb) {
//                return cb.equal(root.get(Customer_.birthday), today);
//            }
//        };
//    }

}
