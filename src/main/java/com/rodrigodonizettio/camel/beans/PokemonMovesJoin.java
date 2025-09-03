package com.rodrigodonizettio.camel.beans;


import java.util.List;

import org.apache.camel.Exchange;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;


@ApplicationScoped
@Named("pokemonMovesJoin")
public class PokemonMovesJoin {

    public String join(Exchange exchange) {
        List<String> moves = exchange.getMessage().getBody(List.class);
        String pokemonName = exchange.getMessage().getHeader("pokemonName", String.class);
        System.out.println(">>> Joining moves for Pokemon: " + pokemonName + " Moves: " + moves);
        return "Pokemon '" + pokemonName + "' moves: " + String.join(", ", moves);
    }

}