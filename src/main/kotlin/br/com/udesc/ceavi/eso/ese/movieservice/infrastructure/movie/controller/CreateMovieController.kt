package br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.movie.controller

import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.model.Movie
import br.com.udesc.ceavi.eso.ese.movieservice.useCase.movie.CreateMovieUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/movie-web-service/api/movies")
class CreateMovieController(private val createMovieUseCase: CreateMovieUseCase) {

    val logger: Logger = LoggerFactory.getLogger(CreateMovieController::class.java)

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    fun createMovie(@RequestBody request: Request): Response {
        val response = Response(
            createMovieUseCase.execute(
                CreateMovieUseCase.Input(
                    imdb = request.imdb,
                    name = request.name,
                    description = request.description,
                    duration = request.duration
                )
            ).movie
        )
        logger.info("Movie Created")
        return response
    }

    data class Request(
        val imdb: String,
        val name: String,
        val description: String,
        val duration: Int
    )

    data class Response(
        val movie: Movie
    )
}