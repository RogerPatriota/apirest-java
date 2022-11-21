/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/SQLTemplate.sql to edit this template
 */
/**
 * Author:  Preci
 * Created: 18 de nov. de 2022
 */

INSERT INTO USUARIOS(nome, email, cpf, endereco) VALUES('roger', 'rogerpatriota@gmail.com', '123456678', 'Avenida Paulista')
INSERT INTO USUARIOS(nome, email, cpf, endereco) VALUES('lucas', 'lucasmarques@gmail.com', '123456678', 'São Jorge')
INSERT INTO USUARIOS(nome, email, cpf, endereco) VALUES('saulo', 'lucasmarques@gmail.com', '123456678', 'São Jorge')

INSERT INTO HOSPITAIS(nome, email, endereco, especialidade) VALUES('SUS', 'sus@gov.com.br', 'Avenida Vaticano', 'GERAL')
INSERT INTO HOSPITAIS(nome, email, endereco, especialidade) VALUES('Albert Einsten', 'albert@gov.com.br', 'Avenida Rebouças', 'CARDIOLOGIA')

INSERT INTO CONSULTAS(usuario_id, hospital_id) VALUES('1', '1')
INSERT INTO CONSULTAS(usuario_id, hospital_id) VALUES('1', '2')
INSERT INTO CONSULTAS(usuario_id, hospital_id) VALUES('2', '2')
INSERT INTO CONSULTAS(usuario_id, hospital_id) VALUES('2', '1') 