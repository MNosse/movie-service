package br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.movie.controller

import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.model.Movie
import br.com.udesc.ceavi.eso.ese.movieservice.useCase.movie.GetAllMoviesUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/movie-web-service/api/movies")
class GetAllMoviesController(private val getAllMoviesUseCase: GetAllMoviesUseCase) {

    val logger: Logger = LoggerFactory.getLogger(GetAllMoviesController::class.java)

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    fun getAllMovies(): Response {
        val response = Response(getAllMoviesUseCase.execute().movies)
        logger.info("Movies retrieved")
        return response
    }

    data class Response(
        val movies: List<Movie>
    )
}