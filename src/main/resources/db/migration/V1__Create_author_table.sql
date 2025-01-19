create table author
(
    id         bigint       not null
        primary key,
    created_at date         null,
    enabled    bit          not null,
    is_bot     bit          not null,
    name       varchar(255) null,
    updated_at date         null
);
