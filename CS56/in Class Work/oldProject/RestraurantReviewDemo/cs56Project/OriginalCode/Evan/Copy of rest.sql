{\rtf1\ansi\ansicpg1252\deff0\deflang1033{\fonttbl{\f0\fswiss\fcharset0 Arial;}}
{\*\generator Msftedit 5.41.15.1507;}\viewkind4\uc1\pard\f0\fs20 drop database restaurants;\par
\par
create database restaurants;\par
\par
use restaurants;\par
\par
create table rests \{\par
  id integer unsigned auto increment,\par
  name varchar(50),\par
  city varchar(50),\par
  state char(2),\par
  zip integer usigned,\par
  rating smallint,\par
  foodType varchar(30)\par
\};\par
\par
insert into rests (name, city,state,zip,rating,foodType) values ('test', 'los angeles', 'ca', 90017, 4, 'french');\par
insert into rests (name, city,state,zip,rating,foodType) values ('test', 'los angeles', 'ca', 90017, 4, 'french');\par
insert into rests (name, city,state,zip,rating,foodType) values ('test', 'los angeles', 'ca', 90017, 4, 'french');\par
insert into rests (name, city,state,zip,rating,foodType) values ('test', 'los angeles', 'ca', 90017, 4, 'french');\par
insert into rests (name, city,state,zip,rating,foodType) values ('test', 'los angeles', 'ca', 90017, 4, 'french');\par
\par
}
 