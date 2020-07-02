package com.trabalhoTec.trabfinal.Entities;

import javax.persistence.Entity;

public class UsuarioBuilder {
    private String nome = "";
    private String senha = "";
    private int forca = 0;
    private int habilidade = 0;
    private int resistencia = 0;
    private int armadura = 0;
    private int poderDeFogo = 0;

    public UsuarioBuilder(){};

    public String getNome() {
        return this.nome;
    }

    public String getSenha() {
        return this.senha;
    }

    public int getForca() {
        return this.forca;
    }

    public int getHabilidade() {
        return this.habilidade;
    }

    public int getResistencia() {
        return this.resistencia;
    }

    public int getArmadura() {
        return this.armadura;
    }

    public int getPoderDeFogo() {
        return this.poderDeFogo;
    }


    public UsuarioBuilder setNome(String nome){
        this.nome = nome;
        return this;
    }

    public UsuarioBuilder setSenha(String senha){
        this.senha = senha;
        return this;
    }

    public UsuarioBuilder setForca(int forca){
        this.forca = forca;
        return this;
    }

    public UsuarioBuilder setHabildade(int habilidade){
        this.habilidade = habilidade;
        return this;
    }

    public UsuarioBuilder setResistencia(int resistencia){
        this.resistencia = resistencia;
        return this;
    }

    public UsuarioBuilder setArmadura(int armadura){
        this.armadura = armadura;
        return this;
    }

    public UsuarioBuilder setPoderDeFogo(int poderDeFogo){
        this.forca = poderDeFogo;
        return this;
    }
    public Usuario build(){
        Usuario returnable = new Usuario(nome, senha, forca, habilidade, resistencia, armadura, poderDeFogo);
        this.nome = "";
        this.senha = "";
        this.forca = 0;
        this.habilidade = 0;
        this.resistencia = 0;
        this.armadura = 0;
        this.poderDeFogo = 0;
        return returnable;
    }

}