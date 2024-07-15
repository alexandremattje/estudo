package com.salsatechnology.repository;

import com.salsatechnology.model.ProductOrder;
import com.salsatechnology.repository.filter.OrderFilter;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;

@Repository
public interface ProductOrderRepository extends JpaRepository<ProductOrder, Long>, JpaSpecificationExecutor<ProductOrder> {

    static Specification<ProductOrder> filterBy(OrderFilter filter) {
        return ((root, query, criteriaBuilder) -> {
           List<Predicate> predicates = new ArrayList<>();

           predicates.add(criteriaBuilder.equal(root.get("productType"), filter.getProductType()));

           return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        });
    }
}
