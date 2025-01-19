create table review
(
    id         bigint auto_increment
        primary key,
    created_at date         null,
    enabled    bit          not null,
    rating     int          not null,
    review     varchar(255) null,
    updated_at date         null,
    author_id  bigint       null,
    movie_id   bigint       null,
    constraint movie_id_fk
        foreign key (movie_id) references movie (id),
    constraint author_id_fk
        foreign key (author_id) references author (id)
);