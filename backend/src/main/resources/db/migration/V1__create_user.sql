create table "user"
(
    birth_date date,
    client_id  bigint,
    id         uuid not null
        primary key,
    firstname  varchar(255),
    gender     varchar(255)
        constraint user_gender_check
            check ((gender)::text = ANY ((ARRAY ['MALE'::character varying, 'FEMALE'::character varying])::text[])),
    surname    varchar(255)
);