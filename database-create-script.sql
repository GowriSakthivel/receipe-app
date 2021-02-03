create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) type=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) type=InnoDB
create table notes (id bigint not null auto_increment, description longtext, recipe_id bigint, primary key (id)) type=InnoDB
create table receipe_category (receipe_id bigint not null, category_id bigint not null, primary key (receipe_id, category_id)) type=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer not null, description varchar(255), difficulty integer, directions longtext, image longblob, prep_time integer not null, serving integer not null, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) type=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) type=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table notes add constraint FKdbfsiv21ocsbt63sd6fg0t3c8 foreign key (recipe_id) references recipe (id)
alter table receipe_category add constraint FKr15hjr60psme5t59t944mg40a foreign key (category_id) references category (id)
alter table receipe_category add constraint FK54r57a0480kdkib36itkdj33n foreign key (receipe_id) references recipe (id)
alter table recipe add constraint FK37al6kcbdasgfnut9xokktie9 foreign key (notes_id) references notes (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) type=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) type=InnoDB
create table notes (id bigint not null auto_increment, description longtext, recipe_id bigint, primary key (id)) type=InnoDB
create table receipe_category (receipe_id bigint not null, category_id bigint not null, primary key (receipe_id, category_id)) type=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer not null, description varchar(255), difficulty integer, directions longtext, image longblob, prep_time integer not null, serving integer not null, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) type=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) type=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table notes add constraint FKdbfsiv21ocsbt63sd6fg0t3c8 foreign key (recipe_id) references recipe (id)
alter table receipe_category add constraint FKr15hjr60psme5t59t944mg40a foreign key (category_id) references category (id)
alter table receipe_category add constraint FK54r57a0480kdkib36itkdj33n foreign key (receipe_id) references recipe (id)
alter table recipe add constraint FK37al6kcbdasgfnut9xokktie9 foreign key (notes_id) references notes (id)
create table category (id bigint not null auto_increment, description varchar(255), primary key (id)) type=InnoDB
create table ingredient (id bigint not null auto_increment, amount decimal(19,2), description varchar(255), recipe_id bigint, uom_id bigint, primary key (id)) type=InnoDB
create table notes (id bigint not null auto_increment, description longtext, recipe_id bigint, primary key (id)) type=InnoDB
create table receipe_category (receipe_id bigint not null, category_id bigint not null, primary key (receipe_id, category_id)) type=InnoDB
create table recipe (id bigint not null auto_increment, cook_time integer not null, description varchar(255), difficulty integer, directions longtext, image longblob, prep_time integer not null, serving integer not null, source varchar(255), url varchar(255), notes_id bigint, primary key (id)) type=InnoDB
create table unit_of_measure (id bigint not null auto_increment, description varchar(255), primary key (id)) type=InnoDB
alter table ingredient add constraint FKj0s4ywmqqqw4h5iommigh5yja foreign key (recipe_id) references recipe (id)
alter table ingredient add constraint FK6iv5l89qmitedn5m2a71kta2t foreign key (uom_id) references unit_of_measure (id)
alter table notes add constraint FKdbfsiv21ocsbt63sd6fg0t3c8 foreign key (recipe_id) references recipe (id)
alter table receipe_category add constraint FKr15hjr60psme5t59t944mg40a foreign key (category_id) references category (id)
alter table receipe_category add constraint FK54r57a0480kdkib36itkdj33n foreign key (receipe_id) references recipe (id)
alter table recipe add constraint FK37al6kcbdasgfnut9xokktie9 foreign key (notes_id) references notes (id)
