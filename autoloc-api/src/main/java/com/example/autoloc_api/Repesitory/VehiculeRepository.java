package com.example.autoloc_api.Repesitory;
import com.example.autoloc_api.domain.Vehicule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface VehiculeRepository extends JpaRepository<Vehicule, Long>{

}

