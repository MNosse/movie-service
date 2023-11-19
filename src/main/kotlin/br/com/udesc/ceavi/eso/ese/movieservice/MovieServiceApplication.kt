package br.com.udesc.ceavi.eso.ese.movieservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MovieServiceApplication

fun main(args: Array<String>) {
	runApplication<MovieServiceApplication>(*args)
}
