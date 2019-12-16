CREATE TABLE users(
                                                                id                      SERIAL          PRIMARY KEY,
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
                                                                enabled                 BIT(1),
                                                                password                VARCHAR(255)

                                          );


