package com.pokedex.pokedex;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    // Métodos personalizados podem ser adicionados aqui, se necessário
}
