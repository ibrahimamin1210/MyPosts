create table system_users(
	id bigint(20) auto_increment,
	user_name varchar(200) unique,
	user_password varchar(400),
	create_date DATETIME default Now(),
    primary key(id)
);