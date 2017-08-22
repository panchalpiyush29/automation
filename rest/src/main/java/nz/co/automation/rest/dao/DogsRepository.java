package nz.co.automation.rest.dao;

import nz.co.automation.rest.domain.Dog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface DogsRepository extends PagingAndSortingRepository<Dog, Integer> {
}
