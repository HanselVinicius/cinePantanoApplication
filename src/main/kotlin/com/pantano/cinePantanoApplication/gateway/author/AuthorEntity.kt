package com.pantano.cinePantanoApplication.gateway.author

import com.pantano.cinePantanoApplication.gateway.movie.ReviewEntity
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.hibernate.annotations.SQLRestriction
import java.time.LocalDate

@Entity(name = "author")
@Table(name = "author")
@SQLRestriction("enabled = true")
class AuthorEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String,
    @OneToMany(mappedBy = "author")
    val review: Set<ReviewEntity>,
    val createdAt: LocalDate?,
    val updatedAt: LocalDate?,
    val enabled: Boolean
)
