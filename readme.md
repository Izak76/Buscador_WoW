# Buscador WoW

Buscador de palavras para o jogo <ins>Words of Wonders</ins>. A aplicação funciona buscando em um dicionário todas as palavras que podem ser formadas com as letras inseridas. Novos dicionários podem ser adicionados e serem alternados no menu configurações (vide [nota sobre os dicionários](#nota-importante-sobre-os-dicionários)).

## Instruções
Ao abrir o programa, insira no campo "Letras das palavras a serem buscadas" todas as letras que aparecem no momento do jogo, e então clique em "buscar". Após isso, uma lista com todas as palavras que podem ser formadas com as letras que foram inseridas serão exibidas no campo abaixo.

Os resultados podem ser filtrados, bastando inserir um filtro no campo "Filtro". O filtro é composto pelas letras presentes no campo "Letras das palavras a serem buscadas" e por caracteres curinga `*`. Por exemplo, se no campo "Letras das palavras a serem buscadas" estiver preenchido com `foobar` e a palavra desejada possui 5 letras, onde a segunda letra é `o` e a última letra é `a`, então o filtro seria `*o**a`, filtrando todas as palavras buscadas que possuem `o` e `a` como segunda e última letra, respectivamente.

### Observações
- Insira todas as letras que aparecem no momento do jogo na quantidade em que aparecem, isto é, se a letra `a` aparece 3 vezes, por exemplo, insira-a 3 vezes ao realizar a busca
- O campo de letras das palavras a serem buscadas aceita apenas caracteres de `a` à `z` (maiúsculas e minúsculas). Não é possível inserir outros caracteres. Caso apareça uma letra diferente disso (exemplo: `ç`), insira-o no formato de `a` à `z` (`ç` -> `c`).
- O campo de filtro aceita apenas caracteres presentes no campo de letras das palavras a serem buscadas e o caractere `*`. O mesmo não aceita filtros de tamanho maior do que a quantidade de letras de palavras a serem buscadas. Além disso, só é possível inserir filtros em que uma letra só aparece na mesma quantidade em que aparece nas letras das palavras (ex.: se a busca for com as letras `foobar`, só será possível filtros contendo no máximo 2 caracteres `o` e 1 caractere `a`).

## Nota importante sobre os dicionários
Novos dicionários podem ser adicionados na pasta `dicionarios`. Todas as palavras de um dicionário devem ser formadas apenas por caracteres de `a` à `z`, maiúsculas ou minúsculas, separadas por quebra de linha. Os dicionários não devem possuir palavras com caracteres diferentes dos especificados (Exemplos: números, letras acentuadas e afins, hífens, etc.).