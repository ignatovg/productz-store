create table users (
                       id UUID primary key ,
                       username varchar(255) not null unique ,
                       password varchar(255) not null
);

insert into users values ('56fdf8c4-89ee-44f7-a4b3-e6b2230d0912', 'george', 'george123');
insert into users values ('a3840589-04e2-47c2-81dc-2df047bb86a7', 'john', 'john123');