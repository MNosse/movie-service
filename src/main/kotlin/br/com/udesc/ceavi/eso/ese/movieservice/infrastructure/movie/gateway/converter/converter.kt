package br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.movie.gateway.converter

import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.model.Movie
import br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.database.schema.movie.MovieSchema

fun convert(movie: MovieSchema) : Movie {
    return Movie(
        imdb = movie.imdb,
        name = movie.name,
        description = movie.description,
        duration = movie.duration
    )
}