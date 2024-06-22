-- Inserir dados na tabela Departamento
INSERT INTO departamentos (id, nome, local) VALUES (1, 'Recursos Humanos', 'São Paulo');
INSERT INTO departamentos (id, nome, local) VALUES (2, 'Tecnologia da Informação', 'Rio de Janeiro');
INSERT INTO departamentos (id, nome, local) VALUES (3, 'Financeiro', 'Belo Horizonte');


-- Inserir dados na tabela Funcionario
INSERT INTO funcionarios (id, nome, endereco, telefone, email, data_nascimento, departamento_id) VALUES
(1, 'João Silva', 'Rua das Flores, 123', '11987654321', 'joao.silva@example.com', '1980-01-15', 1);

INSERT INTO funcionarios (id, nome, endereco, telefone, email, data_nascimento, departamento_id) VALUES
(2, 'Maria Santos', 'Avenida Paulista, 456', '11987654322', 'maria.santos@example.com', '1985-03-22', 2);

INSERT INTO funcionarios (id, nome, endereco, telefone, email, data_nascimento, departamento_id) VALUES
(3, 'Pedro Oliveira', 'Praça da Sé, 789', '11987654323', 'pedro.oliveira@example.com', '1990-07-30', 3);

INSERT INTO funcionarios (id, nome, endereco, telefone, email, data_nascimento, departamento_id) VALUES
(4, 'Ana Costa', 'Rua Augusta, 101', '11987654324', 'ana.costa@example.com', '1982-11-05', 1);

INSERT INTO funcionarios (id, nome, endereco, telefone, email, data_nascimento, departamento_id) VALUES
(5, 'Carlos Pereira', 'Avenida Faria Lima, 202', '11987654325', 'carlos.pereira@example.com', '1988-05-17', 2);
