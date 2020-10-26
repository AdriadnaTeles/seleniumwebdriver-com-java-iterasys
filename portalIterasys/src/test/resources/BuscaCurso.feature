#language: pt
Funcionalidade: Busca Curso

  Cenario: Busca por um Curso Disponivel
    Dado que acesso o site da Iterasys
    Quando consulto  pelo  curso "TestLink"
    Entao exibe uma lista com curso "TestLink"
    Quando clico em Matricule-se
    Entao exibe o titulo "TestLink" e o valor "R$ 79,99"

  Cenario: Busca por um Curso Indisponivel
    Dado que acesso o site da Iterasys
    Quando consulto  pelo  curso "qwertqwert"
    Entao exibe mensagem que o  curso "qwertqwert" nao foi encontrado

  Esquema do Cenario: Buscar Varios Cursos
    Dado que acesso o site da Iterasys
    Quando consulto  pelo  <curso>
    Entao exibe uma lista com <curso>
    Quando clico em Matricule-se
    Entao exibe o titulo <curso> e o <valor>

    Exemplos: 
      | curso      | valor      |
      | "TestLink" | "R$ 79,99" |
      | "Mantis"   | "R$ 49,99" |
