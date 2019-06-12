package br.community.javaclean.usecases

import br.community.javaclean.domains.Pokemon
import br.community.javaclean.domains.exceptions.NotFoundException
import br.community.javaclean.domains.types.Features
import br.community.javaclean.gateways.PokemonGateway
import br.community.javaclean.gateways.ff4j.FeatureGateway
import org.jeasy.random.EasyRandom
import spock.lang.Specification

class DetailPokemonTest extends Specification {

    FeatureGateway featureGateway = Mock(FeatureGateway)
    PokemonGateway pokemonGateway = Mock(PokemonGateway)
    DetailPokemon detailPokemon = new DetailPokemon(pokemonGateway, featureGateway)

    def "Should detail pokemon"() {
        given:
        String name = "ditto"
        Pokemon pokemon = new EasyRandom().nextObject(Pokemon.class)

        when:
        Pokemon detail = detailPokemon.execute(pokemon.id, name)

        then:
        1 * pokemonGateway.detail(name) >> pokemon
        1 * featureGateway.check(Features.FEATURE_DETAIL_POKEMON) >> true
        and:
        detail == pokemon
    }

    def "Should not found pokemon"() {
        given:
        Pokemon pokemon = new EasyRandom().nextObject(Pokemon.class)

        when:
        detailPokemon.execute(pokemon.id + 1, "ditto")

        then:
        1 * pokemonGateway.detail(_) >> pokemon
        1 * featureGateway.check(Features.FEATURE_DETAIL_POKEMON) >> true
        and:
        Throwable exception = thrown()
        exception.class == NotFoundException.class
        exception.message == "Pokemon not found"
    }

    def "Should pokemon is invalid"() {
        when:
        detailPokemon.execute(1, "ditto")

        then:
        1 * pokemonGateway.detail(_) >> null
        1 * featureGateway.check(Features.FEATURE_DETAIL_POKEMON) >> true
        and:
        Throwable exception = thrown()
        exception.class == NotFoundException.class
        exception.message == "Pokemon not found"
    }

    def "Should detail pokemon without feature"() {
        when:
        detailPokemon.execute(1, "ditto")

        then:
        0 * pokemonGateway.detail(_)
        1 * featureGateway.check(Features.FEATURE_DETAIL_POKEMON) >> false
        and:
        Throwable exception = thrown()
        exception.class == NotFoundException.class
        exception.message == "Feature detail pokemon not enable"
    }
}
