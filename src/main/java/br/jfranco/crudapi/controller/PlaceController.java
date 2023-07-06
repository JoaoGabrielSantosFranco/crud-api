package br.jfranco.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.jfranco.crudapi.model.Place;
import br.jfranco.crudapi.repository.PlaceRepository;

@RestController
@RequestMapping("/place")
public class PlaceController {

    @Autowired
    private PlaceRepository placeRepository;

    @GetMapping
    public List<Place> get() {
        return placeRepository.findAll();
    }

    @PostMapping
    public void create(@RequestBody Place place) {
        placeRepository.save(place);
    }

    @PutMapping
    public Place update(@RequestBody Place place) {
        if (place.getId() > 0) {
            place.setUpdatedAt(new java.sql.Date(System.currentTimeMillis()));
            return placeRepository.save(place);
        }
        return null;
    }

    @DeleteMapping
    public String delete(@RequestBody Place place) {
        if (place.getId() > 0) {
            placeRepository.delete(place);
            return "Removido com sucesso";
        }
        return "Local não encontrado";
    }
}
