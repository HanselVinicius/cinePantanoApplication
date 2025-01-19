create table attachment
(
    id         bigint       not null
        primary key,
    attachment varchar(255) null,
    created_at date         null,
    enabled    bit          not null,
    name       varchar(255) null,
    size       bigint       not null,
    updated_at date         null,
    url        varchar(255) null,
    message_id bigint       null,
    constraint attachment_message_id_fk
        foreign key (message_id) references message (id)
);