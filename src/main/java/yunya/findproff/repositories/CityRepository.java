package yunya.findproff.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import yunya.findproff.models.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {
}