package com.pokedex.pokedex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> findAll() {
        return pokemonRepository.findAll();
    }

    public Optional<Pokemon> findById(Long id) {
        return pokemonRepository.findById(id);
    }

    public Pokemon save(Pokemon pokemon) {
        return pokemonRepository.save(pokemon);
    }

    public void deleteById(Long id) {
        pokemonRepository.deleteById(id);
    }

    public Pokemon cadastrarPokemonVisto(PokemonVistoDTO dto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNumero(dto.getNumero());
        pokemon.setNome(dto.getNome());
        pokemon.setImagemUrl(dto.getImagemUrl());
        pokemon.setAreaHabitat(dto.getAreaHabitat());
        pokemon.setCapturado(false);
        return pokemonRepository.save(pokemon);
    }

    public Pokemon cadastrarPokemonCapturado(PokemonCapturadoDTO dto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNumero(dto.getNumero());
        pokemon.setNome(dto.getNome());
        pokemon.setDescricao(dto.getDescricao());
        pokemon.setImagemUrl(dto.getImagemUrl());
        pokemon.setTipo(dto.getTipo());
        pokemon.setCategoria(dto.getCategoria());
        pokemon.setAreaHabitat(dto.getAreaHabitat());
        pokemon.setAltura(dto.getAltura());
        pokemon.setPeso(dto.getPeso());
        pokemon.setCapturado(true);
        return pokemonRepository.save(pokemon);
    }
}
