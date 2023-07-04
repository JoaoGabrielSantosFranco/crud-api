package br.jfranco.crudapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.jfranco.crudapi.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Long> {
    

}
