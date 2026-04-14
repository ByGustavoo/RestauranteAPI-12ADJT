INSERT INTO tipo_usuario (descricao) VALUES
('DONO'),
('CLIENTE');

INSERT INTO situacao_cadastro (descricao) VALUES
('EXCLUIDO'),
('ATIVO');

INSERT INTO usuarios (nome, email, login, senha, id_tipousuario) VALUES
('Ana Costa', 'ana@email.com', 'ana', '$2a$10$e0NR3rRkqXy5xGQz6zYF1u1wPz8xF5eG6F9j1bKq8z0QvHn8Zx1QK', 1),
('João Silva', 'joao@email.com', 'joao', '$2a$10$7YfZKx1mQp9sLw8bR3tV4eJc8N2aH6yU5dF0kPqXz9WmT1rY8uL2C', 1),
('Maria Souza', 'maria@email.com', 'maria', '$2a$10$K8pQz1Xc9vN7mL4sD2fG5hJ6kL8pO1iU3yT5rE7wQ9zXcVbN6mA2S', 2),
('Carlos Lima', 'carlos@email.com', 'carlos', '$2a$10$T9xW2eR4tY6uI8oP0aS1dF3gH5jK7lZ9xC2vB4nM6qW8eR0tY2uI3', 2);

INSERT INTO enderecos (id_usuario, rua, cidade, estado, complemento, ponto_referencia, cep) VALUES
(1, 'Rua A', 'Limeira', 'SP', NULL, NULL, '13480001'),
(1, 'Rua Central', 'Campinas', 'SP', 'Loja', 'Centro', '13010000'),
(2, 'Rua B', 'Piracicaba', 'SP', 'Fundos', 'Próximo ao posto', '13400000'),
(3, 'Av. Paulista', 'São Paulo', 'SP', 'Apto 101', 'Perto do metrô', '01311000'),
(4, 'Rua das Flores', 'Limeira', 'SP', 'Casa 1', 'Próximo ao mercado', '13480000');
