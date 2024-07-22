package com.pokedex.pokedex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public PokemonVistoDTO cadastrarPokemonVisto(PokemonVistoDTO dto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setNumero(dto.getNumero());
        pokemon.setNome(dto.getNome());
        pokemon.setImagemUrl(dto.getImagemUrl());
        pokemon.setAreaHabitat(dto.getAreaHabitat());
        pokemon.setCapturado(false); // Pokémon visto não é capturado
        pokemonRepository.save(pokemon);
        return dto;
    }

    public PokemonCapturadoDTO cadastrarPokemonCapturado(PokemonCapturadoDTO dto) {
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
        pokemon.setCapturado(true); // Pokémon capturado é marcado como capturado
        pokemonRepository.save(pokemon);
        return dto;
    }

    public PokemonCapturadoDTO atualizarPokemon(Integer numero, PokemonCapturadoDTO dto) {
        Optional<Pokemon> optionalPokemon = pokemonRepository.findById(numero.longValue());
        if (optionalPokemon.isPresent()) {
            Pokemon pokemon = optionalPokemon.get();
            pokemon.setNome(dto.getNome());
            pokemon.setDescricao(dto.getDescricao());
            pokemon.setImagemUrl(dto.getImagemUrl());
            pokemon.setTipo(dto.getTipo());
            pokemon.setCategoria(dto.getCategoria());
            pokemon.setAreaHabitat(dto.getAreaHabitat());
            pokemon.setAltura(dto.getAltura());
            pokemon.setPeso(dto.getPeso());
            // Não atualizamos 'capturado' aqui
            pokemonRepository.save(pokemon);
            return dto;
        } else {
            throw new RuntimeException("Pokémon não encontrado");
        }
    }

    public void deletarPokemon(Integer numero) {
        pokemonRepository.deleteById(numero.longValue());
    }

    public PokemonCapturadoDTO obterPokemon(Integer numero) {
        Optional<Pokemon> pokemon = pokemonRepository.findById(numero.longValue());
        if (pokemon.isPresent()) {
            Pokemon p = pokemon.get();
            PokemonCapturadoDTO dto = new PokemonCapturadoDTO();
            dto.setNumero(p.getNumero());
            dto.setNome(p.getNome());
            dto.setDescricao(p.getDescricao());
            dto.setImagemUrl(p.getImagemUrl());
            dto.setTipo(p.getTipo());
            dto.setCategoria(p.getCategoria());
            dto.setAreaHabitat(p.getAreaHabitat());
            dto.setAltura(p.getAltura());
            dto.setPeso(p.getPeso());
            return dto;
        } else {
            throw new RuntimeException("Pokémon não encontrado");
        }
    }

    public List<PokemonResumoDTO> listarPokemons() {
        List<Pokemon> pokemons = pokemonRepository.findAll();
        return pokemons.stream().map(p -> {
            PokemonResumoDTO dto = new PokemonResumoDTO();
            dto.setNumero(p.getNumero());
            dto.setNome(p.getNome());
            dto.setCapturado(p.getCapturado());
            dto.setTipo(p.getTipo());
            return dto;
        }).collect(Collectors.toList());
    }
}
