CREATE TABLE IF NOT EXISTS user_table (
    ldap_login VARCHAR(50) PRIMARY KEY,
    name VARCHAR(50),
    surname VARCHAR(50)
    );

INSERT INTO user_table (ldap_login, name, surname) VALUES
                                                       ('ldap-1', 'LDAPUser', 'One'),
                                                       ('ldap-2', 'LDAPTest', 'Two');