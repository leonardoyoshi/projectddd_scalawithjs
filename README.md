# Nome do repositório: projectddd_scalawithjs

4º Ano / 7º S  - BCC - Tópicos Especiais I

Alunos:
João Claudio Silva Souza        RA: 529087  
Leonardo Yoshiharu Miyazawa     RA: 531464

Este é um repositorio criado para projeto Web Api em DDD utilizando linguagem Scala com interface em html/javascript.
Version: 1.0.0 - 25/05

- Criação de GET e POST (funcionamento 100% no 'postman');
- Interface em HTML / JS (poderia ter usado Views do próprio Scala)
- Backend em Scala (
		2 entidades: user e produto;
		2 controllers (userController e productController);
		1 value object (endereço para user); 
		1 service (validator cpfcnpj)
					);

---------- // ------ // --------------

Update: Version 1.1.0 - 08/06

- Adicionado Persistência de Dados em Scala com integração em Slick com MySQL (UserTableDef);
- Adicionado um novo serviço (UserService) [Antigo service era o "Validator" de CPF];