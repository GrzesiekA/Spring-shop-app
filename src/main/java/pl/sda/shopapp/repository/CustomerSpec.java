package pl.sda.shopapp.repository;


import org.springframework.data.jpa.domain.Specification;
import org.springframework.util.StringUtils;
import pl.sda.shopapp.dto.CustomerQueryDto;
import pl.sda.shopapp.entity.Customer;

public final class CustomerSpec {

    public static Specification<Customer> withQuery(CustomerQueryDto query) {
        return (root, criteriaQuery, criteriaBuilder) -> {

            //where 1=1
            var predicate = criteriaBuilder.conjunction();

            //where 1=1 and (name like :?)
            if (StringUtils.hasText(query.getName())) {
                var namePredicate = criteriaBuilder.like(root.get("name"), query.getName() + "%");
                predicate = criteriaBuilder.and(predicate, namePredicate);
            }

            //where 1=1 and (taxId = :?)
            //where 1=1 and (name like :?) and (taxId = :?)
            if (StringUtils.hasText(query.getTaxId())) {
                var taxPredicate = criteriaBuilder.equal(root.get("taxId"), query.getTaxId());
                predicate = criteriaBuilder.and(predicate, taxPredicate);
            }

            return predicate;
        };
    }
}
