CREATE TABLE users(
                                                          id              SERIAL          PRIMARY KEY,
                                                          name            VARCHAR(50)     NOT NULL,
                                                          age             INT             NOT NULL,
                                                          maakunta        VARCHAR(50)     NOT NULL,
                                                          info            VARCHAR(500),
                                                          friendlist      TEXT,
                                                          sports          BOOLEAN         DEFAULT false,
                                                          freetime        BOOLEAN         DEFAULT false
                                    );