create table movie
(
    id          bigint auto_increment
        primary key,
    created_at  date         null,
    duration    int          not null,
    enabled     bit          not null,
    launch_date date         null,
    title       varchar(255) null,
    updated_at  date         null
);