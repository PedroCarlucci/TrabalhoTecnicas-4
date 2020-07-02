package com.trabalhoTec.trabfinal.Interface;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import com.trabalhoTec.trabfinal.CasosDeUso.PoliticaRecomendacoes;
import com.trabalhoTec.trabfinal.CasosDeUso.RepoDungeon;
import com.trabalhoTec.trabfinal.CasosDeUso.RepoUsuario;
import com.trabalhoTec.trabfinal.Entities.Dungeon;
import com.trabalhoTec.trabfinal.Entities.Usuario;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProfileControler {
    @Autowired
    private RepoUsuario userRepo;

    @Autowired
    private RepoDungeon dungeonRepo;

    @CrossOrigin("*")
    @GetMapping(path = "/user/{nome}")
    public Usuario getUsuario(@PathVariable String nome){
        return userRepo.findByNome(nome).get(0);
    }
    


    @CrossOrigin("*")
    @PostMapping(path = "/login")
    public Boolean valUser(@RequestBody Usuario user){
        if(userRepo.findByNome(user.getNome()).size()>0){
            Usuario check = userRepo.findByNome(user.getNome()).get(0);
            if(check.getSenha().equals(user.getSenha())){
                System.out.println(check.getSenha());
                return true;
            }
        }
        return false;
    }

    @CrossOrigin("*")
    @GetMapping(path ="/dungeons/{nome}")
    public List<Dungeon> recommendDungeon(@PathVariable String nome){
        Usuario usuario = userRepo.findByNome(nome).get(0);
        List<Dungeon> dungeons = dungeonRepo.findAll();
        Map<Integer, List<Dungeon>> fitting = new HashMap<Integer, List<Dungeon>>();
        //Find all fits
        for(Dungeon d : dungeons){
            int fit = PoliticaRecomendacoes.getDungeonValue(usuario, d);
            if(!fitting.keySet().contains(fit)){
                fitting.put(fit, new LinkedList<Dungeon>());   
            }
            fitting.get(fit).add(d);   
        }
        // Number of recommendations:
        int nRec;
        if (dungeons.size() < 3){
            nRec = dungeons.size();
        }else{
            nRec= 3;
        }
        List<Dungeon> returnables = new LinkedList<Dungeon>();
        while(nRec>0){
             //Find current max
            Integer max = 0;
            for(Integer i : fitting.keySet()){
                if(i>max) max = i;}

            for(Dungeon d : fitting.get(max)){
                if(nRec == 0){
                    break;
                }
                returnables.add(d);
                nRec--;
            }
            fitting.remove(max);
        }
        return returnables;
    }

    @CrossOrigin("*")
    @GetMapping(path ="/dungeon/{dungeon}")
    public Dungeon getDungeon(@PathVariable String dungeon){
        return dungeonRepo.findByNome(dungeon).get(0);
    }

    @CrossOrigin("*")
    @GetMapping(path="/dungeon/{dungeon}/{nome}")
    public Usuario getBuddy(@PathVariable String dungeon, @PathVariable String nome){
        System.out.println(dungeon);
        System.out.println(nome);
        List<Usuario> usuarios = userRepo.findAll();
        Usuario thisUser = userRepo.findByNome(nome).get(0);
        Dungeon thisDungeon = dungeonRepo.findByNome(dungeon).get(0);
        usuarios.remove(thisUser);
        Map<Integer, List<Usuario>> fitting = new HashMap<Integer, List<Usuario>>();
        for(Usuario u : usuarios){
            int fit = PoliticaRecomendacoes.threatWithBuddy(thisUser, u, thisDungeon);
            if(!fitting.keySet().contains(fit)){
                fitting.put(fit, new LinkedList<Usuario>());   
            }
            fitting.get(fit).add(u);   
        }
        Integer min = 0;
        for(Integer i : fitting.keySet()){
            if(i<min) min = i;}
        return fitting.get(min).get(0);
    }

}