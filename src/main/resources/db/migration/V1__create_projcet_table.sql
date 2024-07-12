CREATE TABLE IF NOT EXISTS task_manager.projects (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL UNIQUE,
    description TEXT
);

CREATE TABLE IF NOT EXISTS task_manager.projects_users (
    project_id INTEGER NOT NULL,
    user_id INTEGER NOT NULL,
    PRIMARY KEY (project_id, user_id),
    FOREIGN KEY (project_id) REFERENCES task_manager.projects (id),
    FOREIGN KEY (user_id) REFERENCES task_manager.users (id)
);
