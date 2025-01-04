package com.pantano.cinePantanoApplication.gateway.movie

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.OneToMany
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.SQLRestriction
import org.hibernate.annotations.UpdateTimestamp
import java.time.LocalDate

@Entity(name = "movie")
@Table(name = "movie")
@SQLRestriction("enabled = true")
class MovieEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long?,
    val title: String,
    val launchDate: LocalDate,
    val duration: Int,
    @OneToMany(mappedBy = "movie")
    val review: Set<ReviewEntity>?,
    @CreationTimestamp
    @Column(updatable = false)
    val createdAt: LocalDate?,
    @UpdateTimestamp
    @Column(insertable = false)
    val updatedAt: LocalDate?,
    val enabled: Boolean
)
