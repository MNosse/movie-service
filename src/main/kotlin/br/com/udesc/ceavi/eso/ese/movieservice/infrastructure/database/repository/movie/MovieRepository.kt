package br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.database.repository.movie

import br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.database.schema.movie.MovieSchema
import org.springframework.data.jpa.repository.JpaRepository

interface MovieRepository : JpaRepository<MovieSchema, String> {
    fun findByImdb(imdb: String): MovieSchema?
}