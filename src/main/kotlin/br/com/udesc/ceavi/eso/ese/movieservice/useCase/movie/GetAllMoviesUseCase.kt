package br.com.udesc.ceavi.eso.ese.movieservice.useCase.movie

import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.gateway.MovieGateway
import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.model.Movie
import org.springframework.stereotype.Service

@Service
class GetAllMoviesUseCase(
    private val movieGateway: MovieGateway
) {
    fun execute(): Output {
        return Output(movieGateway.getAll())
    }

    data class Output(
        val movies: List<Movie>
    )
}