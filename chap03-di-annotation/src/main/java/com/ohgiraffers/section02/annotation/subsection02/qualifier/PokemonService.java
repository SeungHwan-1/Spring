package com.ohgiraffers.section02.annotation.subsection02.qualifier;

import com.ohgiraffers.section02.common.Pokemon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("pokemonServiceQualifier")
public class PokemonService {


    @Autowired
    @Qualifier("pikachu")
    private Pokemon pokemon; // 포켓몬자료형을 가진중에서 피카츄로
    public PokemonService(Pokemon pokemon) {
        this.pokemon = pokemon;
    }
    public void pokemonAttack(){
        pokemon.attack();
    }
}