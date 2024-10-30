create table public.organization
(
    id        bigserial
        primary key,
    fullname  varchar(255),
    inn       varchar(255)
        constraint uk_q0fumhuuom7yoaeb5hs59711q
            unique,
    kpp       varchar(255),
    ogrn      varchar(255),
    shortname varchar(255)
);