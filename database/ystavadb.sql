CREATE TABLE users(
                                                                id                      SERIAL          PRIMARY KEY,
                                                                username                VARCHAR(255)    NOT NULL UNIQUE,
                                                                first_name              VARCHAR(255)    NOT NULL,
                                                                last_name               VARCHAR(255)    NOT NULL,
                                                                age                     INT,
                                                                state                   VARCHAR(50),
                                                                info                    VARCHAR(500),
                                                                friendlist              TEXT,
                                                                sports                  BOOLEAN         DEFAULT false,
                                                                freetime                BOOLEAN         DEFAULT false,
                                                                confirmation_token      VARCHAR(255),
                                                                email                   VARCHAR(255)    NOT NULL UNIQUE,
                                                                enabled                 BOOLEAN,
                                                                password                VARCHAR(255),
                                                                picturl                 VARCHAR(255)

                                          );



create table authorities(
                             username varchar(50) not null,
                             authority varchar(50) not null DEFAULT 'ROLE_USER',
                             constraint fk_authorities_users foreign key(username) references users(username));
create unique index ix_auth_username on authorities (username,authority);

SELECT * FROM users;
SELECT * FROM authorities;







