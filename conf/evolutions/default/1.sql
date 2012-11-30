# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table my_model (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_my_model primary key (id))
;

create sequence my_model_seq;




# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists my_model;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists my_model_seq;

