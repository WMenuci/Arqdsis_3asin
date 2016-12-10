package br.will.arqdesis.clientefinal;

import java.io.Serializable;


//Cria uma classe serializavel, pega os valores do objeto e salva em memória (serializou)
//chama outra activity e entrega os dados deserializa
public class Cliente implements Serializable {
    private int id;
    private String nome, fone, email;

    public Cliente(int id, String nome, String fone, String email) {
        this.id = id;
        this.nome = nome;
        this.fone = fone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
