create table message
(
    id         bigint       not null
        primary key,
    channel_id bigint       not null,
    content    TEXT         null,
    created_at date         null,
    enabled    bit          not null,
    guild_id   bigint       not null,
    timestamp  date         null,
    type       tinyint      null
        check (`type` between 0 and 0),
    updated_at date         null,
    author_id  bigint       null,
    constraint message_author_id_fk
        foreign key (author_id) references author (id)
);
