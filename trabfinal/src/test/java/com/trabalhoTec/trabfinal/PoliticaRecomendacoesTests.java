package com.trabalhoTec.trabfinal;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.trabalhoTec.trabfinal.CasosdeUso.PoliticaRecomendacoes;
import com.trabalhoTec.trabfinal.Entities.Dungeon;
import com.trabalhoTec.trabfinal.Entities.Usuario;
import com.trabalhoTec.trabfinal.Entities.UsuarioBuilder;

import org.junit.jupiter.api.Test;

public class PoliticaRecomendacoesTests {
    

    @Test
    public void testaRecom(){
        UsuarioBuilder ub = new UsuarioBuilder();
        Usuario user = ub.setForca(1).setArmadura(2).setHabildade(3).setPoderDeFogo(4).setPoderDeFogo(5).build();
        Dungeon dg = new Dungeon("nome", "desc", 6, 5, 1, 1, 2);
        assertEquals(96, PoliticaRecomendacoes.ameacaUser(user, dg));
        
    }

    @Test
    public void testaRecomBuddy(){
        UsuarioBuilder ub = new UsuarioBuilder();
        Usuario user = ub.setForca(1).setArmadura(2).setHabildade(3).setPoderDeFogo(4).setPoderDeFogo(5).build();
        Usuario user2 = ub.setForca(3).setArmadura(5).setHabildade(3).setPoderDeFogo(4).setPoderDeFogo(5).build();
        Dungeon dg = new Dungeon("nome", "desc", 6, 5, 1, 1, 2);
        assertEquals(100, PoliticaRecomendacoes.threatWithBuddy(user, user2, dg));
        
    }
    @Test
    public void value(){
        UsuarioBuilder ub = new UsuarioBuilder();
        Usuario user = ub.setForca(1).setArmadura(2).setHabildade(3).setPoderDeFogo(4).setPoderDeFogo(5).build();
        Dungeon dg = new Dungeon("nome", "desc", 6, 5, 1, 1, 96);
        assertEquals(1, PoliticaRecomendacoes.getDungeonValue(user, dg));
    }
}