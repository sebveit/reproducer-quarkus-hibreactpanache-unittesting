create table "animal" (
  "id" serial,
  "name" varchar(75) not null,
  constraint "animal_pk" primary key ("id"),
  constraint "animal_uq" unique ("name")
);