#language: pt
#encoding: iso-8859-1

Funcionalidade: Realizar Cadastro dos Clientes, 
								para validar o funcionamento do sistema 

Esquema do Cen�rio: Cadastrar clientes com sucesso 
Sistema dever� inserir os dados nos campos com sucesso
Dado Acessar a p�gina de cadastro do cliente
E Informar o nome do Funcion�rio <nome>
E Informar o rg do cliente <rg>
E Informar o CPF do do cliente <CPF>
E Informar a data de Nascimento do cliente <data>
E Selecione o tipo de processo seletivo <tipo>
Quando Solicitar realiza��o da inscri��o 
Ent�o Sistema informar� a mensagem de sucesso 

Exemplos: 
  | nome            | rg           | CPF              | data        | tipo                               |
  | "Jos� da Silva" | "012345678"  | "123.456.789.00" | 28/06/2021  | Vagas para Analista de Requisitos  |
  | "Maria Pereira" | "987654321"  | "456.789.123.00" | 20/02/2021  | Vagas para Teste de Software       |
  


Cen�rio: Validar os campos obrigat�rios 
Sistema dever� verificar os campos em brancos
Dado Acessar a p�gina de cadastro do cliente
Quando Solicitar realiza��o da inscri��o 
Ent�o Sistema informar� que precisam preencher todos os campos