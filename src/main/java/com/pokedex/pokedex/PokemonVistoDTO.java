package com.pokedex.pokedex;

public class PokemonVistoDTO {

    private Integer numero;
    private String nome;
    private String imagemUrl;
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
