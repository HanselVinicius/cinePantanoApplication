package com.pantano.cinePantanoApplication.gateway.movie.entities

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.JpaSpecificationExecutor
import org.springframework.stereotype.Repository
import java.util.Optional

@Repository
interface MovieEntityRepository : JpaRepository<MovieEntity, Long>, JpaSpecificationExecutor<MovieEntity>{
    fun findByExternalId(externalId: String): Optional<MovieEntity>
}
