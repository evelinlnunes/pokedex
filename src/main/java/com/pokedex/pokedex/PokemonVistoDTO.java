package com.pokedex.pokedex;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class PokemonVistoDTO {

    @NotNull(message = "Número é obrigatório")
    private Integer numero;

    @NotNull(message = "Nome é obrigatório")
    @Size(min = 1, message = "Nome não pode ser vazio")
    private String nome;

    private String imagemUrl;

    @NotNull(message = "Área de Habitat é obrigatória")
    private String areaHabitat;

    // Getters and Setters
    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public String getAreaHabitat() {
        return areaHabitat;
    }

    public void setAreaHabitat(String areaHabitat) {
        this.areaHabitat = areaHabitat;
    }
}
