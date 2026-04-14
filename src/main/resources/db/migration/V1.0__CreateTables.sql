CREATE TABLE IF NOT EXISTS public.tipo_usuario (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS public.situacao_cadastro (
    id SERIAL PRIMARY KEY,
    descricao VARCHAR(50) NOT NULL UNIQUE
);

CREATE TABLE IF NOT EXISTS public.usuarios (
    id SERIAL PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(120) NOT NULL UNIQUE,
    login VARCHAR(50) NOT NULL UNIQUE,
    senha VARCHAR(255) NOT NULL,
    id_tipousuario INTEGER NOT NULL,
    id_situacaocadastro INTEGER DEFAULT 1 NOT NULL,
    data_alteracao DATE DEFAULT CURRENT_DATE,
    FOREIGN KEY (id_tipousuario) REFERENCES public.tipo_usuario(id),
    FOREIGN KEY (id_situacaocadastro) REFERENCES public.situacao_cadastro(id)
);

CREATE TABLE IF NOT EXISTS public.enderecos (
    id SERIAL PRIMARY KEY,
    id_usuario INTEGER NOT NULL,
    rua VARCHAR(100) NOT NULL,
    cidade VARCHAR(70) NOT NULL,
    estado VARCHAR(2) NOT NULL,
    complemento VARCHAR(100),
    ponto_referencia VARCHAR(100),
    cep VARCHAR(8) NOT NULL,
    FOREIGN KEY (id_usuario) REFERENCES usuarios(id)
);