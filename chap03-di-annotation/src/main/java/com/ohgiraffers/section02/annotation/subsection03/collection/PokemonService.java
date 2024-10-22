package com.ohgiraffers.section02.annotation.subsection03.collection;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("pokemonServiceCollection")
public class PokemonService {

    @Autowired
    private List<Pokemon> pokemonList;

    public void pokemonAttack(){
        for(Pokemon pokemon : pokemonList){
            pokemon.attack();
        }
    }


}
