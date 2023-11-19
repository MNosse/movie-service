package br.com.udesc.ceavi.eso.ese.movieservice.useCase.movie

import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.gateway.MovieGateway
import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.model.Movie
import org.springframework.stereotype.Service

@Service
class GetMovieByImdbUseCase(
    private val movieGateway: MovieGateway
) {
    fun execute(input: Input): Output {
        return Output(
            movieGateway.getByImdb(
                imdb = input.imdb
            )
        )
    }

    data class Input(
        val imdb: String
    )

    data class Output(
        val movie: Movie?
    )
}