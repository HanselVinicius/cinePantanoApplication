package com.pantano.cinePantanoApplication.gateway.movie.entities

import com.pantano.cinePantanoApplication.gateway.author.entities.AuthorEntity
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.ManyToOne
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.SQLRestriction
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate

@Entity(name = "review")
@Table(name = "review")
@SQLRestriction("enabled = true")
class ReviewEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val review: String,
    @ManyToOne
    val movie: MovieEntity?,
    val rating: Int,
    @ManyToOne
    val author: AuthorEntity,
    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: LocalDate?,
    @UpdateTimestamp
    @Column(insertable = false)
    val updatedAt: LocalDate?,
    val enabled: Boolean
)
