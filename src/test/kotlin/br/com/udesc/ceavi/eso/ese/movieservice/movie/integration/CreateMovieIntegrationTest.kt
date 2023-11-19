package br.com.udesc.ceavi.eso.ese.movieservice.movie.integration

import br.com.udesc.ceavi.eso.ese.movieservice.infrastructure.movie.controller.CreateMovieController
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.annotation.DirtiesContext
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class CreateMovieIntegrationTest @Autowired constructor(
    private val createMovieController: CreateMovieController
) {
    private val imdb = "tt1375670"
    private val name = "Gente Grande"
    private val description =
        "A morte do treinador de basquete de infância de velhos amigos reúne a turma no mesmo lugar que celebraram um campeonato anos atrás. Os amigos, acompanhados de suas esposas e filhos, descobrem que idade não significa o mesmo que maturidade."
    private val duration = 102

    @Test
    fun test() {
        assertDoesNotThrow {
            createMovieController.createMovie(
                CreateMovieController.Request(
                    imdb = imdb,
                    name = name,
                    description = description,
                    duration = duration
                )
            ).movie.let { movie ->
                assert(
                    movie.imdb == imdb
                            && movie.name == name
                            && movie.description == description
                            && movie.duration == duration
                )
            }
        }
    }
}