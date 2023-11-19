package br.com.udesc.ceavi.eso.ese.movieservice.useCase.movie

import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.gateway.MovieGateway
import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.model.Movie
import org.springframework.stereotype.Service

@Service
class CreateMovieUseCase(
    private val movieGateway: MovieGateway
) {
    fun execute(input: Input): Output {
        return Output(
            movieGateway.create(
                imdb = input.imdb,
                name = input.name,
                description = input.description,
                duration = input.duration
            )
        )
    }

    data class Input(
        val imdb: String,
        val name: String,
        val description: String,
        val duration: Int
    )

    data class Output(
        val movie: Movie
    )
}