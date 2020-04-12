package zed.springframework.msscbeerservice.repositories;

import org.springframework.data.repository.PagingAndSortingRepository;
import zed.springframework.msscbeerservice.domain.Beer;

import java.util.UUID;

public interface BeerRepository extends PagingAndSortingRepository<Beer, UUID> {
}
