package com.appmessagerie.Model;

import jakarta.persistence.*;

@Entity
@Table(name = "message")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idMessage")
    private int id;
    private int idPersonne;
    private String sujet;
    private String contenu;

    // Constructeurs
    public Message() {}

    public Message(int id, int idPersonne, String sujet, String contenu) {
        this.id = id;
        this.idPersonne = idPersonne;
        this.sujet = sujet;
        this.contenu = contenu;
    }

    // Getters et Setters
    public int getIdMessage() {
        return id;
    }

    public void setIdMessage(int id) {
        this.id = id;
    }

    public int getIdPersonne() {
        return idPersonne;
    }

    public void setIdPersonne(int idPersonne) {
        this.idPersonne = idPersonne;
    }

    public String getSujet() {
        return sujet;
    }

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }
}