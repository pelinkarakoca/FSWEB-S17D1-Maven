package com.workintech.fswebs17d1.controller;

import com.workintech.fswebs17d1.entity.Animal;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/workintech")
public class AnimalController {
	private Map<Integer, Animal> animals = new HashMap<>();

	public AnimalController() {
	}

	@GetMapping("/animal")
	public List<Animal> getAnimalList() {
		return animals.values().stream().toList();
	}

	@GetMapping("/animal/{id}")
	public Animal getAnimal(@PathVariable Integer id) {
		return animals.get(id);
	}

	@PostMapping("/animal")
	public Map<Integer, Animal> addAnimal(@RequestBody Animal animal) {
		animals.put(animal.getId(), animal);
		return animals;
	}

	@PutMapping("/animal/{id}")
	public Map<Integer, Animal> updateAnimal(@PathVariable Integer id, @RequestBody String name) {
		Animal selectedAnimal = animals.get(id);
		selectedAnimal.setName(name);
		return animals;
	}
	@DeleteMapping("/animal/{id}")
public String deleteAnimal(@PathVariable Integer id){
		String animalName = animals.get(id).getName();
		animals.remove(id);
		return animalName + "is deleted";
	}
}
