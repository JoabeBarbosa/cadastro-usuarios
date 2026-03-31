CREATE TABLE users(
	user_id UUID PRIMARY KEY UNIQUE NOT NULL DEFAULT gen_random_uuid(),
	user_name TEXT NOT NULL,
	user_age INTEGER NOT NULL,
	user_email TEXT UNIQUE NOT NULL
);

INSERT INTO users (user_name, user_age, user_email) 
VALUES 
    ('João Silva', 25, 'joao.silva@example.com'),
    ('Maria Santos', 30, 'maria.santos@example.com'),
    ('Carlos Olivra', 35, 'carlos.oliveira@example.com');