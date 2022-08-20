insert into usuario (dtype, id, cpf, data_criacao, email, nome, perfil, senha) values ("Leitor", 1, "66421663451", "2022-07-25 16:29:56.321275", "otoniel@email.com", "Otoniel Camara Grilo", "LEITOR", "123123")
insert into usuario (dtype, id, cpf, data_criacao, email, nome, perfil, senha) values ("Leitor", 2, "39735699087", "2022-07-25 16:30:34.069489", "josecampelo@email.com", "José Campelo Mattos", "LEITOR", "123123")
insert into usuario (dtype, id, cpf, data_criacao, email, nome, perfil, senha) values ("Leitor", 3, "02801320005", "2022-07-25 16:30:53.343830", "emanuel@email.com", "Emanoel Giacomini Rabelo", "LEITOR", "123123")
insert into usuario (dtype, id, cpf, data_criacao, email, nome, perfil, senha) values ("Leitor", 4, "51926252039", "2022-07-25 16:31:09.737306", "isabel@email.com", "Isabel dos Anjos Auzier", "LEITOR", "123123")
insert into usuario (dtype, id, cpf, data_criacao, email, nome, perfil, senha) values ("Leitor", 5, "68316006030", "2022-07-25 19:27:10.480321", "honoria@email.com", "Honoria Couto Carino", "LEITOR", "123123")
insert into usuario (dtype, id, cpf, data_criacao, email, nome, perfil, senha) values ("Autor", 6, "91155926005", "2022-07-25 21:58:30.738461", "ivania@email.com", "Ivania Rangel Giron", "AUTOR", "123123")
insert into usuario (dtype, id, cpf, data_criacao, email, nome, perfil, senha) values ("Autor", 7, "47426838030", "2022-07-25 21:59:09.647450", "mariano@email.com", "Mariano Inácio Saldanha", "AUTOR", "123123")
insert into usuario (dtype, id, cpf, data_criacao, email, nome, perfil, senha) values ("Autor", 8, "94884482026", "2022-07-25 21:59:28.631803", "pedro@email.com", "Pedro Henrique Bragança Cocelo", "AUTOR", "123123")
insert into usuario (dtype, id, cpf, data_criacao, email, nome, perfil, senha) values ("Autor", 9, "53322871002", "2022-07-25 21:59:47.757147", "norival@email.com", "Norival Marques Pimenta", "AUTOR", "123123")
insert into usuario (dtype, id, cpf, data_criacao, email, nome, perfil, senha) values ("Autor", 10, "72178068014", "2022-07-25 22:00:05.654833", "estefani@email.com", "Estefani Guzzo Miranda", "AUTOR", "123123")

insert into noticia (id, conteudo, data_criacao, titulo, autor_id, likes) values (1, "Copa foi cancelada por causa da pandemia", "2022-07-26 14:12:59.777137", "Copa do mundo cancelada", 6, 2)
insert into noticia (id, conteudo, data_criacao, titulo, autor_id, likes) values (2, "A empresa dona da marca PlayStation disse que tem planos para abaixar o preço do console no Brasil.", "2022-07-26 14:12:51.045132", "Sony abaixará o preço do PS5 no Brasil", 7, 1)
insert into noticia (id, conteudo, data_criacao, titulo, autor_id, likes) values (3, "O Dólar Americano fechou R$ 5,50 nessa última sexta-feira (22/07/2022).", "2022-07-26 14:14:30.724351", "Dólar tem alta e volta a subir", 6, 3)
insert into noticia (id, conteudo, data_criacao, titulo, autor_id, likes) values (4, "Rumores estão circulando, sobre o programa de Fátima Bernardes ser substituído pela Tv Globinho aos sábados.", "2022-07-26 14:12:41.280062", "Tv Globinho está de volta", 8, 2)
insert into noticia (id, conteudo, data_criacao, titulo, autor_id, likes) values (5, "Benchmarks vazados apontam salto de 5 vezes no desempenho entre uma RTX 3090TI e uma RTX 4090, aponta site.", "2022-07-26 14:12:47.032143", "RTX 4000 serão 5x melhores que a série 3000", 9, 1)

insert into leitor_noticias (leitor_id, noticia_id) values (1, 1)
insert into leitor_noticias (leitor_id, noticia_id) values (1, 4)
insert into leitor_noticias (leitor_id, noticia_id) values (2, 4)
insert into leitor_noticias (leitor_id, noticia_id) values (2, 5)
insert into leitor_noticias (leitor_id, noticia_id) values (3, 2)
insert into leitor_noticias (leitor_id, noticia_id) values (3, 3)
insert into leitor_noticias (leitor_id, noticia_id) values (4, 3)
insert into leitor_noticias (leitor_id, noticia_id) values (4, 1)
insert into leitor_noticias (leitor_id, noticia_id) values (5, 3)





