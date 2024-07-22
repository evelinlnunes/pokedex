package com.pokedex.pokedex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> getAllPokemon() {
        return pokemonService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pokemon> getPokemonById(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonService.findById(id);
        if (pokemon.isPresent()) {
            return ResponseEntity.ok(pokemon.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/visto")
    public Pokemon cadastrarPokemonVisto(@RequestBody PokemonVistoDTO dto) {
        return pokemonService.cadastrarPokemonVisto(dto);
    }

    @PostMapping("/capturado")
    public Pokemon cadastrarPokemonCapturado(@RequestBody PokemonCapturadoDTO dto) {
        return pokemonService.cadastrarPokemonCapturado(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pokemon> updatePokemon(@PathVariable Long id, @RequestBody Pokemon pokemonDetails) {
        Optional<Pokemon> pokemon = pokemonService.findById(id);
        if (pokemon.isPresent()) {
            Pokemon updatedPokemon = pokemon.get();
            updatedPokemon.setNome(pokemonDetails.getNome());
            updatedPokemon.setDescricao(pokemonDetails.getDescricao());
            updatedPokemon.setImagemUrl(pokemonDetails.getImagemUrl());
            updatedPokemon.setTipo(pokemonDetails.getTipo());
            updatedPokemon.setCategoria(pokemonDetails.getCategoria());
            updatedPokemon.setAreaHabitat(pokemonDetails.getAreaHabitat());
            updatedPokemon.setAltura(pokemonDetails.getAltura());
            updatedPokemon.setPeso(pokemonDetails.getPeso());
            updatedPokemon.setCapturado(pokemonDetails.getCapturado());
            pokemonService.save(updatedPokemon);
            return ResponseEntity.ok(updatedPokemon);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePokemon(@PathVariable Long id) {
        Optional<Pokemon> pokemon = pokemonService.findById(id);
        if (pokemon.isPresent()) {
            pokemonService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
