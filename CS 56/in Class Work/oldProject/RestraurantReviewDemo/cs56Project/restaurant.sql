drop database if exists restaurants;

create database restaurants;

use restaurants;

create table rests (
  name char(50) null,
  city char(50) null,
  cuisine char(30) null,
  rating smallint null,
  chef char(50) null,
  address char(60) null,
  state char(2) null,
  zip integer unsigned null,
  foodRat smallint null,
  serviceRat smallint null,
  ambianceRat smallint null,
  phone char(13) null,
  fax char(13)  null,
  website char(30) null,
  email char(45) null,
  review char(255) null,
  id int unsigned auto_increment not null primary key
);
 
insert into rests (name, city, cuisine, rating, address, state, zip, foodRat, serviceRat, ambianceRat, phone, fax, website, email, review) 
	values ("Velocity Cafe", "Santa Monica", "Coffee", 4, "2127 Lincoln Blvd.", "CA", 90405, 4, 5, 3, "310-334-3068", "310-334-3068", 
			"http://velocity-cafe.com/", "velocitycafe@brandx.net", "This coffee shop has free internet and a nice staff"); 
insert into rests (name, city, cuisine, rating) values ('The Bombay Cafe', 'Los Angeles', 'Indian', 4);
insert into rests (name, city, cuisine, rating) values ('El Cholo', 'Santa Monica', 'Mexican', 4);
insert into rests (name, city, cuisine, rating) values ('The Rose Cafe', 'Venice', 'Californian', 3);
insert into rests (name, city, cuisine, rating) values ('California Pizza Kitchen', 'Santa Monica', 'Pizza', 3);
insert into rests (name, city, cuisine, rating) values ('Abbots', 'Santa Monica', 'Pizza', 3);
insert into rests (name, city, cuisine, rating) values ('Marmalades', 'Malibu', 'French', 4);
insert into rests (name, city, cuisine, rating) values ('Coogi', 'Malibu', 'American', 2);
insert into rests (name, city, cuisine, rating) values ('Wolfgang Pucks', 'Los Angeles', 'Californian', 3);
insert into rests (name, city, cuisine, rating) values ('Cholada', 'Malibu', 'Thai', 4);
insert into rests (name, city, cuisine, rating) values ('Ts Thai', 'Santa Monica', 'Thai', 3);
insert into rests (name, city, cuisine, rating) values ('Good Stuff', 'Los Angeles', 'American', 3);
insert into rests (name, city, cuisine, rating) values ('Dennys', '', 'Diner', 2);
insert into rests (name, city, cuisine, rating) values ('Norms', 'Santa Monica', 'Diner', 3);
