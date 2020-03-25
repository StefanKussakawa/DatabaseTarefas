DROP TABLE usuario;
DROP TABLE tarefa;
DROP TABLE item;

CREATE TABLE usuario(
    usuarioId INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(100) not null,
    email varchar(100),
    telefone varchar(100),
    dataNascimento DATE
);

CREATE TABLE tarefa(
    tarefaId INT AUTO_INCREMENT PRIMARY KEY,
    titulo varchar(100) not null,
    descricao varchar(100),
    usuarioId INT,
    CONSTRAINT fk_usuario
    FOREIGN KEY (usuarioId) 
        REFERENCES usuario(usuarioId)
);

CREATE TABLE item(
    itemId INT AUTO_INCREMENT PRIMARY KEY,
    nome varchar(100) not null,
    pronto boolean,
    tarefaId INT,
    CONSTRAINT fk_tarefa
    FOREIGN KEY (tarefaId) 
        REFERENCES tarefa(tarefaId)
);

INSERT INTO usuario VALUES(NULL, "Joao Batista", "joao22@gmail.com", "4493-2322", "2000-01-02"), (NULL, "Ana Camargo", "anasss@gmail,com","3332-2223","1999-09-09"), (NULL, "Pedro Jose", "pj2000@gmail.com","6969-2323","2000-06-09"), (NULL, "Karol Kaiss", "kkaiss@gmail.com","9090-1222","1998-09-23");

INSERT INTO tarefa VALUES(NULL,"Escrever 2 livros","Um livro sobre A e um sobre B",1),(NULL,"Andar no parque","De segunda a sexta",2),(NULL,"Pesquisa sobre passaros","Contar um pouco sobre araras",2),(NULL,"Comprar leite","Comprar um desnatado",3),(NULL,"Fazer tabelas","Nao deixar para depois",3); 

INSERT INTO item VALUES(NULL,"Item 1",0,2),(NULL,"Item 2",1,2),(NULL,"Item 3",0,4),(NULL,"Item 4",1,4),(NULL,"Item 5",1,1),(NULL,"Item 6",0,5),(NULL,"Item 7",0,3);