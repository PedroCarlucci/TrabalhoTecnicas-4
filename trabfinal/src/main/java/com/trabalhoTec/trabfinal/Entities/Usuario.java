package com.trabalhoTec.trabfinal.Entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Usuario {
    @Id
    private String nome;
    private String senha;
    @Column
    private int forca;
    @Column
    private int habilidade;
    @Column
    private int resistencia;
    @Column
    private int armadura;
    @Column
    private int poderDeFogo;

    public Usuario(String nome, String senha, int forca, int habilidade, int resistencia, int armadura, int poderDeFogo){
        this.nome = nome;
        this.senha = senha;
        this.forca = forca;
        this.habilidade = habilidade;
        this.resistencia = resistencia;
        this.armadura = armadura;
        this.poderDeFogo = poderDeFogo;
    }

    public Usuario(){
        
    }

    public String getNome(){
        return nome;
    }
    public String getSenha(){
        return senha;
    }
    public int getForca(){
        return forca;
    }
    public int getHabilidade(){
        return habilidade;
    }
    public int getResistencia(){
        return resistencia;
    }
    public int getArmadura(){
        return armadura;
    }
    public int getPoderDeFogo(){
        return poderDeFogo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setForca(int forca){
        this.forca = forca;
    }
    public void setHabilidade(int habilidade){
        this.habilidade = habilidade;
    }
    public void setResistencia(int resistencia){
        this.resistencia = resistencia;
    }
    public void setArmadura(int armadura){
        this.armadura = armadura;
    }
    public void setPoderDeFogo(int poderDeFogo){
        this.poderDeFogo = poderDeFogo;
    }    
}