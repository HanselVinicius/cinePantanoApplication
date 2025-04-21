package com.pantano.cinePantanoApplication.gateway.movie.specifications

import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieEntity
import com.pantano.cinePantanoApplication.gateway.movie.entities.MovieStatusEntity
import jakarta.persistence.criteria.CriteriaBuilder
import jakarta.persistence.criteria.CriteriaQuery
import jakarta.persistence.criteria.Predicate
import jakarta.persistence.criteria.Root
import org.springframework.data.jpa.domain.Specification

class MovieSpecification(
    private val titleName: String?,
    private val movieEntityStatus: MovieStatusEntity?) : Specification<MovieEntity> {
    override fun toPredicate(
        root: Root<MovieEntity>,
        query: CriteriaQuery<*>?,
        criteriaBuilder: CriteriaBuilder
    ): Predicate? {

        val predicates = mutableListOf<Predicate>()

        titleName?.let {
            predicates.add(criteriaBuilder.like(root.get("title"), "%$it%"))
        }

        movieEntityStatus?.let {
            predicates.add(criteriaBuilder.equal(root.get<MovieStatusEntity>("movieStatus"), it))
        }

        return criteriaBuilder.and(*predicates.toTypedArray())

    }

}