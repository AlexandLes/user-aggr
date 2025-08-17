CREATE TABLE IF NOT EXISTS users (
                                     user_id SERIAL PRIMARY KEY,
                                     login VARCHAR(50),
    first_name VARCHAR(50),
    last_name VARCHAR(50)
    );

INSERT INTO users (login, first_name, last_name) VALUES
                                                     ('user-1', 'User', 'Userenko'),
                                                     ('user-2', 'Testuser', 'Testov');