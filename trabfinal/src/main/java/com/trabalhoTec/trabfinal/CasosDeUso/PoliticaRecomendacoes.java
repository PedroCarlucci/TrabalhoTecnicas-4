package com.trabalhoTec.trabfinal.CasosDeUso;

import com.trabalhoTec.trabfinal.Entities.Dungeon;
import com.trabalhoTec.trabfinal.Entities.Usuario;
import com.trabalhoTec.trabfinal.Entities.UsuarioBuilder;

import org.springframework.stereotype.Service;

@Service
public class PoliticaRecomendacoes {
    public static int ameacaUser(Usuario user, Dungeon dungeon){
        int threat =  user.getHabilidade() * 2 - dungeon.getQuantidadeInimigos() + (user.getResistencia() + user.getArmadura()+10) / 2; 
        threat = threat - dungeon.getArmadilhas() + user.getForca() - dungeon.getForcaBoss() + user.getPoderDeFogo() - dungeon.getVisibilidade();
        return (100)-threat;
    }

    public static int threatWithBuddy(Usuario user, Usuario user2, Dungeon dungeon){
        UsuarioBuilder ub = new UsuarioBuilder();
        ub.setForca(Math.max(user.getForca(), user2.getForca()));
        ub.setHabildade(Math.max(user.getHabilidade(), user2.getHabilidade()));
        ub.setArmadura(Math.max(user.getArmadura(), user2.getArmadura()));
        ub.setResistencia(Math.max(user.getResistencia(), user2.getResistencia()));
        ub.setPoderDeFogo(Math.max(user.getPoderDeFogo(), user2.getPoderDeFogo()));
        return ameacaUser(ub.build(), dungeon);
    }

    public static int getDungeonValue(Usuario user, Dungeon dungeon){
        return dungeon.getRecompensa() / ameacaUser(user, dungeon);
    }


}