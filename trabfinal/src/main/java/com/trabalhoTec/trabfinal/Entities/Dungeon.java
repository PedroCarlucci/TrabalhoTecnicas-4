package com.trabalhoTec.trabfinal.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dungeon {
    @Id
    private String nome;
    private String desc;
    private int armadilhas;
    private int forcaBoss;
    private int quantidadeInimigos;
    private int visibilidade;
    private int recompensa;

    public Dungeon() {
    }

    public Dungeon(String nome, String desc, int armadilhas, int forcaBoss, int quantidadeInimigos, int visibilidade, int recompensa) {
        this.nome = nome;
        this.desc = desc;
        this.armadilhas = armadilhas;
        this.forcaBoss = forcaBoss;
        this.quantidadeInimigos = quantidadeInimigos;
        this.visibilidade = visibilidade;
        this.recompensa = recompensa;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return this.desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getArmadilhas() {
        return this.armadilhas;
    }

    public void setArmadilhas(int armadilhas) {
        this.armadilhas = armadilhas;
    }

    public int getForcaBoss() {
        return this.forcaBoss;
    }

    public void setForcaBoss(int forcaBoss) {
        this.forcaBoss = forcaBoss;
    }

    public int getQuantidadeInimigos() {
        return this.quantidadeInimigos;
    }

    public void setQuantidadeInimigos(int quantidadeInimigos) {
        this.quantidadeInimigos = quantidadeInimigos;
    }

    public int getVisibilidade() {
        return this.visibilidade;
    }

    public void setVisibilidade(int visibilidade) {
        this.visibilidade = visibilidade;
    }

    public int getRecompensa(){
        return this.recompensa;
    }
    public void setRecompensa(int recompensa){
        this.recompensa = recompensa;
    }

}