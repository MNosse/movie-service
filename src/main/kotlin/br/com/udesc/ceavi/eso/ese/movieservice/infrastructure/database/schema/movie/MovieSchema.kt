package br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.database.schema.movie

import jakarta.persistence.*

@Entity
@Table(name = "movie")
data class MovieSchema(
    @Id
    val imdb: String,
    val name: String,
    val description: String,
    val duration: Int
) {
    constructor() : this("", "", "", 0)
}
