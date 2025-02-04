package org.example.devsoc25.repository;

import org.example.devsoc25.entity.Plant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlantRepository extends JpaRepository<Plant, Long> {
    @Override
    Optional<Plant> findById(Long plantid);
    List<Plant> findAllByFk_UserId(long userid);

}
