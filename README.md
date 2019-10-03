# Jogo 2048
![2048gif](https://user-images.githubusercontent.com/53903774/66094013-c53d5000-e568-11e9-8ae5-01c613244a4b.gif)
Reprodução do jogo disponível neste [link](https://rachacuca.com.br/raciocinio/2048/).
## Glossario
* [Informacoes Gerais](#informacoes-gerais)
* [Tecnologias](#tecnologias)
* [Setup](#setup)

## Informacoes Gerais
2048 é jogado em um tabuleiro de 4×4, com peças numéricas que deslizam suavemente quando o jogador as move. Cada vez, um novo aparece aleatoriamente em um local vazio na placa com um valor de 2 ou 4. Os blocos deslizam o mais longe possível na direção escolhida até que eles sejam interrompidos por qualquer outro bloco ou a borda do tabuleiro. Se duas peças do mesmo número colidem durante a movimentação, elas irão se fundir em um bloco com o valor total das duas peças que colidiram. A peça resultante não pode se fundir com outra peça novamente na mesma jogada. O jogo acaba quando o jogador consegue juntar dois blocos e criar um com o valor de 2048.
	
## Tecnologia Usada
O projeto foi criado com:
* [Apache NetBeans 11.1](https://netbeans.org/)
	
## Setup
Para utilizar o programa, basta instalar o [GitBash](https://git-scm.com/downloads) e inserir os seguintes comandos:

```
$ cd ../lorem
$ npm install
$ npm start
```

