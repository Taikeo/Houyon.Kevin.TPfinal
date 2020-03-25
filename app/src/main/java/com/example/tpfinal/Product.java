package com.example.tpfinal;

public class Product {

    private int id;
    private int image;
    private String nom;
    private String continent;
    private String subcontinent;

    public Product(int id, int image, String nom, String continent, String subcontinent) {
        this.id = id;
        this.image = image;
        this.nom = nom;
        this.continent = continent;
        this.subcontinent = subcontinent;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getSubcontinent() {
        return subcontinent;
    }

    public void setSubcontinent(String subcontinent) {
        this.subcontinent = subcontinent;
    }
}
