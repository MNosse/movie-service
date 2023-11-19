package br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.gateway

import br.com.udesc.ceavi.eso.ese.movieservice.entity.movie.model.Movie

interface MovieGateway {
    fun create(imdb: String, name: String, description: String, duration: Int): Movie
    fun getAll(): List<Movie>
    fun getByImdb(imdb: String): Movie?
}