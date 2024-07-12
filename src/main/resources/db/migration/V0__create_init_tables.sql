CREATE SCHEMA IF NOT EXISTS task_manager;

-- Создание таблицы users
CREATE TABLE IF NOT EXISTS task_manager.users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    locked BOOLEAN NOT NULL,
    enabled BOOLEAN NOT NULL,
    role VARCHAR(255) NOT NULL
);

-- Создание таблицы user_details
CREATE TABLE IF NOT EXISTS task_manager.user_details (
    id SERIAL PRIMARY KEY,
    email VARCHAR(255) NOT NULL UNIQUE,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    info TEXT,
    phone_number VARCHAR(11),
    register_at TIMESTAMP NOT NULL,
    user_id INTEGER UNIQUE,
    FOREIGN KEY (user_id) REFERENCES task_manager.users(id)
);
