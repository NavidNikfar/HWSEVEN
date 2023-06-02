CREATE DATABASE HWSeven;

CREATE TABLE author
(id SERIAL PRIMARY KEY,
 first_name varchar(25) NOT NULL ,
 last_name varchar(40) NOT NULL ,
 age SMALLINT NOT NULL
);

CREATE TABLE book
(id SERIAL PRIMARY KEY,
 title varchar(50) NOT NULL ,
 author SMALLINT NOT NULL ,
 year_of_publication SMALLINT NOT NULL
);

alter table public.book
add constraint book_author_id_fk
foreign key (author) references public.author;
