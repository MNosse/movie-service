package br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.movie.gateway

import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.gateway.MovieGateway
import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.model.Movie
import br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.database.repository.movie.MovieRepository
import br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.database.schema.movie.MovieSchema
import br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.movie.gateway.converter.convert
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class MovieDatabaseGateway(private val movieRepository: MovieRepository) : MovieGateway {
    override fun create(imdb: String, name: String, description: String, duration: Int): Movie {
        return convert(
            movieRepository.save(
                MovieSchema(
                    imdb = imdb,
                    name = name,
                    description = description,
                    duration = duration
                )
            )
        )
    }

    override fun getAll(): List<Movie> {
        return movieRepository.findAll().map { movie ->
            convert(movie)
        }
    }

    override fun getByImdb(imdb: String): Movie? {
        return movieRepository.findByImdb(imdb)?.let { movie ->
            convert(movie)
        }
    }

}