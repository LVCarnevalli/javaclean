package br.community.javaclean.usecases

import br.community.javaclean.domains.Pokemon
import br.community.javaclean.domains.exceptions.NotFoundException
import br.community.javaclean.gateways.PokemonGateway
import org.jeasy.random.EasyRandom
import spock.lang.Specification

class DetailPokemonTest extends Specification {

    PokemonGateway pokemonGateway = Mock(PokemonGateway)
    DetailPokemon detailPokemon = new DetailPokemon(pokemonGateway)

    def "Should detail pokemon"() {
        given:
        String name = "ditto"
        Pokemon pokemon = new EasyRandom().nextObject(Pokemon.class)
        and:
        detailPokemon.@isDetailPokemon = true

        when:
        Pokemon detail = detailPokemon.execute(pokemon.id, name)

        then:
        1 * pokemonGateway.detail(name) >> pokemon
        and:
        detail == pokemon
    }

    def "Should not found pokemon"() {
        given:
        Pokemon pokemon = new EasyRandom().nextObject(Pokemon.class)
        and:
        detailPokemon.@isDetailPokemon = true

        when:
        detailPokemon.execute(pokemon.id + 1, "ditto")

        then:
        1 * pokemonGateway.detail(_) >> pokemon
        and:
        Throwable exception = thrown()
        exception.class == NotFoundException.class
        exception.message == "Pokemon not found"
    }

    def "Should pokemon is invalid"() {
        given:
        detailPokemon.@isDetailPokemon = true

        when:
        detailPokemon.execute(1, "ditto")

        then:
        1 * pokemonGateway.detail(_) >> null
        and:
        Throwable exception = thrown()
        exception.class == NotFoundException.class
        exception.message == "Pokemon not found"
    }

    def "Should detail pokemon without feature"() {
        given:
        detailPokemon.@isDetailPokemon = false

        when:
        detailPokemon.execute(1, "ditto")

        then:
        0 * pokemonGateway.detail(_)
        and:
        Throwable exception = thrown()
        exception.class == NotFoundException.class
        exception.message == "Feature detail pokemon not enable"
    }
}
