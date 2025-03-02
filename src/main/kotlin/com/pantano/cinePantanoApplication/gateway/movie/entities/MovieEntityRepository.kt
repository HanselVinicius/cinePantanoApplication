package com.pantano.cinePantanoApplication.gateway.movie.entities

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface MovieEntityRepository : JpaRepository<MovieEntity, Long>
