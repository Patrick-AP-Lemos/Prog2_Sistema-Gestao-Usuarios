# Programação 2 - Sistema de Gestao de Usuarios

Projeto academico desenvolvido na disciplina de Programacao 2 do curso de Ciencia da Computacao.

A aplicacao recebe uma base de usuarios pela entrada padrao e oferece operacoes de ordenacao, busca e contagem de nomes.

## Funcionalidades

- Ordenacao por nome em ordem crescente e decrescente;
- Ordenacao por idade em ordem crescente e decrescente;
- Busca binaria por nome;
- Contagem de ocorrencias de um primeiro nome;
- Uso de vetores de indices para preservar a base original durante as ordenacoes.

## Conceitos praticados

- `Selection Sort`;
- Busca binaria;
- Vetores e indices;
- Leitura e validacao de entrada;
- Analise de algoritmos.

## Formato da entrada

O programa espera 1.000 registros, um por linha, no formato:

```text
Nome Completo#idade
```

Depois dos registros, informe uma opcao do menu de `1` a `7`. A opcao `7` encerra o programa. Para a opcao `5`, informe o nome a ser pesquisado; para a opcao `6`, informe o primeiro nome.

Os arquivos de entrada originais nao fazem parte deste repositorio porque contem nomes e idades. Use dados ficticios para executar o projeto.

## Como executar

Compile a classe principal:

```powershell
javac -d bin src\Gestao_usuarios.java
```

Execute o programa:

```powershell
java -cp bin Gestao_usuarios
```

## Tecnologias

- Java 17 ou superior;
- API `java.util.Scanner`.

## Status

Projeto academico concluido.