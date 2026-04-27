INSERT INTO tipo_usuario (descricao) VALUES
('DONO'),
('CLIENTE');

INSERT INTO situacao_cadastro (descricao) VALUES
('ATIVO'),
('EXCLUIDO');

INSERT INTO usuarios (nome, email, login, senha, id_tipousuario) VALUES
('Ana Costa', 'ana@email.com', 'ana_user01', '$2a$10$yNutDXanvt3WJS1KqynYIuGqFElr6VFwjM9StoQq6LCruVJVbL1lW', 1),
('João Silva', 'joao@email.com', 'joao_user01', '$2a$10$yNutDXanvt3WJS1KqynYIuGqFElr6VFwjM9StoQq6LCruVJVbL1lW', 1),
('Maria Souza', 'maria@email.com', 'maria_user01', '$2a$10$yNutDXanvt3WJS1KqynYIuGqFElr6VFwjM9StoQq6LCruVJVbL1lW', 2),
('Carlos Lima', 'carlos@email.com', 'carlos_user01', '$2a$10$yNutDXanvt3WJS1KqynYIuGqFElr6VFwjM9StoQq6LCruVJVbL1lW', 2);

INSERT INTO enderecos (id_usuario, rua, cidade, estado, complemento, ponto_referencia, cep) VALUES
(1, 'Rua A', 'Limeira', 'SP', NULL, NULL, '13480001'),
(1, 'Rua Central', 'Campinas', 'SP', 'Loja', 'Centro', '13010000'),
(2, 'Rua B', 'Piracicaba', 'SP', 'Fundos', 'Próximo ao posto', '13400000'),
(3, 'Av. Paulista', 'São Paulo', 'SP', 'Apto 101', 'Perto do metrô', '01311000'),
(4, 'Rua das Flores', 'Limeira', 'SP', 'Casa 1', 'Próximo ao mercado', '13480000');
