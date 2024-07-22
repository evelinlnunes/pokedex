package com.pokedex.pokedex;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    // Endpoint para cadastrar Pokémon visto
    @PostMapping("/visto")
    public PokemonVistoDTO cadastrarPokemonVisto(@Valid @RequestBody PokemonVistoDTO pokemonDTO) {
        return pokemonService.cadastrarPokemonVisto(pokemonDTO);
    }

    // Endpoint para cadastrar Pokémon capturado
    @PostMapping("/capturado")
    public PokemonCapturadoDTO cadastrarPokemonCapturado(@Valid @RequestBody PokemonCapturadoDTO pokemonDTO) {
        return pokemonService.cadastrarPokemonCapturado(pokemonDTO);
    }

    // Endpoint para atualizar Pokémon pelo número
    @PutMapping("/{numero}")
    public PokemonCapturadoDTO atualizarPokemon(@PathVariable Integer numero, @Valid @RequestBody PokemonCapturadoDTO pokemonDTO) {
        return pokemonService.atualizarPokemon(numero, pokemonDTO);
    }

    // Endpoint para deletar Pokémon pelo número
    @DeleteMapping("/{numero}")
    public void deletarPokemon(@PathVariable Integer numero) {
        pokemonService.deletarPokemon(numero);
    }

    // Endpoint para obter Pokémon pelo número
    @GetMapping("/{numero}")
    public PokemonCapturadoDTO obterPokemon(@PathVariable Integer numero) {
        return pokemonService.obterPokemon(numero);
    }

    // Endpoint para listar todos os Pokémon cadastrados com resumo
    @GetMapping("/listagem")
    public List<PokemonResumoDTO> listarPokemons() {
        return pokemonService.listarPokemons();
    }
}
