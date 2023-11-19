package br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.movie.controller

import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.model.Movie
import br.com.udesc.ceavi.eso.ese.movieservice.useCase.movie.GetMovieByImdbUseCase
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/movie-web-service/api/movies")
class GetMovieByImdbController(private val getMovieByImdbUseCase: GetMovieByImdbUseCase) {

    val logger: Logger = LoggerFactory.getLogger(GetMovieByImdbController::class.java)

    @GetMapping("/{imdb}/")
    @ResponseStatus(HttpStatus.OK)
    fun getMovieByImdb(@RequestParam imdb: String): Response {
        val response = Response(
            getMovieByImdbUseCase.execute(
                input = GetMovieByImdbUseCase.Input(
                    imdb = imdb
                )
            ).movie
        )
        if (response.movie != null) {
            logger.info("Movie Retrieved")
        } else {
            logger.info("Movie Not Found")
        }
        return response
    }

    data class Response(
        val movie: Movie?
    )
}