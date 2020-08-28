create table posts(
id bigint(20) auto_increment,
content MEDIUMTEXT NOT NULL,
is_private tinyint(1) DEFAULT 0,
create_date DATETIME default Now(),
user_id bigint(20) NOT NULL,
primary key(id)
);

ALTER TABLE posts
ADD CONSTRAINT postsKey
FOREIGN KEY (user_id) REFERENCES system_users(id);