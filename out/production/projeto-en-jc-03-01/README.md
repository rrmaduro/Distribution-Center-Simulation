# Programação Orientada por Objetos

Centro de Distribuição - Segunda fase

**Época normal**

# 1.  Introdução

O objetivo deste projeto é o desenvolvimento de uma simulação do funcionamento de um centro de distribuição de produtos utilizando a linguagem Java e a Programação Orientada por Objetos (POO).

Neste centro de distribuição, os produtos são recebidos num local especifico do armazém, são embalados e depois são transportados para os locais onde ficam armazenados. O transporte é efetuado por veículos guiados automaticamente (Automated Guided Vehicle - AGV). A distribuição dos produtos para os locais de venda segue um processo idêntico onde os produtos armazenados são retirados dos locais de armazenamento e levados para um local de recolha dentro armazém.

O projeto será desenvolvido em duas fases. A primeira fase consistiu na modelação e implementação de um conjunto de classes que permitam representar a lógica da aplicação e que permitam a sua utilização em modo **consola**. A segunda fase será dedicada a completar as funcionalidades definidas na primeira fase e à criação da **interface gráfica** com o utilizador. 

Tenha particular atenção ao uso do paradigma de POO na modelação das classes, i.e., ao correto uso dos conceitos de encapsulamento, herança, classes abstratas, polimorfismo, interfaces, maximização da coesão (responsabilidade única), minimização do acoplamento, desenho orientado por responsabilidades, etc. Uma modelação bem pensada facilitará todo o processo de desenvolvimento e manutenção.

**O presente documento refere-se apenas à segunda-fase do projeto.**

# 2.  Objetivos

Na segunda fase do projeto o objetivo passa por completar as funcionalidades e desenvolver a interface gráfica, em **JavaFx**, que permita ao utilizador interagir com o sistema concebido na primeira fase. 

A interface gráfica **deve incluir** **apenas**  os requisitos indicados no ponto 3. Contudo deverá ser reaproveitado o código necessário da primeira fase.

# 3.  Funcionalidades e requisitos de implementação

## 3.1. Completar as funcionalidades definidas na primeira fase

Nesta segunda fase será necessário completar as funcionalidades que ficaram como opcionais na primeira fase, nomeadamente:

- Implementar os vários tipos de sensores com as características definidas na primeira fase.
- Implementar o movimento **pré-definido** para os vários veículos. Neste caso, deve ser definido uma sequência de pontos que cada veículo deve seguir para o transporte da carga entre os vários locais. Não é necessário o cálculo dinâmico da trajetória dos veículos.

## 3.2. Interface gráfica

Deverá ser implementada uma interface gráfica, em JavaFX, **que permita visualizar o centro de distribuição com todos os elementos que o compõem**. Na simulação é necessária a visualização do movimento dos veículos. Um possibilidade será aproveitar o tipo de movimentação apresentado no exemplo da companhia de táxis para reproduzir esta movimentação no projeto.

Também será necessário a visualização do número de produtos armazenados e o peso total dos produtos armazenados (com atualização dinâmica destes valores).

## 3.3. Requisitos da Implementação

Para a implementação da aplicação deverão obrigatoriamente ser utilizadas:

3.2.1. Coleções observáveis

3.2.2. Propriedades (*Properties*), sempre que seja pertinente

3.2.3. Eventos para executar as alterações no ecrã

3.2.4. Efeitos ou animações (por exemplo na “apresentação de gráficos”)

## 3.3. Funcionamento da aplicação e novos requisitos funcionais

3.3.1. A visualização dos passos da simulação deixa de utilizar a consola, passando a ter uma interface gráfica.

3.3.2. Deverá ser possível distinguir e identificar os diferentes locais e elementos do armazém, em particular:

3.3.2.1.       **Paredes do armazém** – As paredes do armazém devem ser identificadas por uma linha de posições na vertical e na horizontal.

3.3.2.2.       **Locais de entrega e recolha de produtos** Os locais de entrega e recolha de produtos devem estar assinalados. Neste caso, correspondem a uma interrupção das paredes do armazém nessas posições. Pode optar por usar cores diferentes para as posições ocupados por estes pontos. 

3.3.2.3.       **Prateleiras** As prateleiras devem ser facilmente identificadas e devem mostrar em cada momento o número de produtos que contêm. A zona de carregamento dos produtos em frente às prateleiras também deve estar assinalada. Por exemplo, com uma cor diferente. O armazém deverá ter pelo menos duas prateleiras de dimensão mínima de dois blocos. 

3.3.2.4.       **Veículos** Deve ser possível distinguir entre os diferentes tipos de veículos. Para cada veículo, deve ser perceptível se transporta carga ou se está vazio. 

# 4.  Fases de desenvolvimento e entrega

O projeto está dividido em 2 fases, com a cotação distribuída da seguinte forma:

·     Fase I – 70% da avaliação final

·     Fase II – 30% da avaliação final

Conforme referido na ficha da disciplina, poderá alternativamente entregar o projeto numa só data, na época de recurso (sem possibilidade de incorporar componente de avaliação contínua), contemplando as duas fases do projeto.

# 5.  Implementação e codificação

O programa deve ser desenvolvido utilizando a linguagem Java, colocando em prática os conceitos fundamentais do paradigma de Programação Orientada por Objetos.

Em relação às regras de codificação, siga as convenções adotadas normalmente para a linguagem Java:

·     A notação *camelCase* para o nome das variáveis locais e identificadores de atributos e métodos;

·     A notação *PascalCase* para os nomes das classes e interfaces;

·     Utilização de maiúsculas para os nomes das constantes e dos valores enumerados;

·     Não utilize o símbolo ‘_’ nos identificadores (exceto nas constantes), nem abreviaturas.

É necessário que o projeto cumpra o que é pedido no seu enunciado, sendo deixado ao critério do programador qualquer pormenor de implementação que não seja referido, o qual deverá ser devidamente documentado.

# 6.  Constituição de grupos

Cada projeto deverá ser elaborado em grupos de dois alunos, podendo eventualmente ser elaborado individualmente. Não serão permitidos, em nenhum caso, grupos com mais do que dois alunos.

Os grupos dos alunos já se encontram determinados através da metodologia de *pair programming* que está a ser utilizada nos laboratórios.

# 7.  Entrega do projeto

O projeto será entregue em duas fases:

·     Uma primeira fase (**até às 08:00:00 do dia 30 de maio de 2023**) com a implementação da lógica da aplicação (descrita no presente documento);

·     A segunda fase (**até às 22:00:00 do dia 1 de julho de 2023**) com a parte gráfica.

O projeto deverá ser entregue até à data limite especificada **por via exclusivamente eletrónica utilizando os grupos criados no Github**. 

**Não serão aceites quaisquer projetos entregues fora do prazo!**

Todos os materiais do projeto devem ser devidamente identificados com nome, número e endereço de correio eletrónico dos alunos.

Os materiais do projeto deverão incluir:

·     Um Manual Técnico onde conste uma breve descrição do programa, incluindo a explicação das classes/interfaces implementadas, principais atributos e métodos e suas relações.

·     A documentação do programa em **JavaDoc** (não converta o documento gerado automaticamente em HTML para DOC!).

·     O código fonte do programa na forma de projeto em BlueJ, *NetBeans* ou *IntelliJ*, com um *main* de testes a funcionar e com todas as funcionalidades implementadas. 

·     Todos os ficheiros que compõem o projeto deverão estar guardados num único ficheiro compactado em formato ZIP cujo nome deverá ter a seguinte nomenclatura: *<curso>_<numAluno1>_<numAluno2>*.zip.

# 8.  Regras e Critérios de Avaliação do Projeto

## 8.1. Regras de Avaliação

A avaliação do projeto está sujeita às seguintes regras:

·     Caso o aluno falte ao momento de supervisão, terá essa componente avaliada com zero valores.

·     **Não serão aceites quaisquer projetos entregues fora do prazo!**

·     A classificação do programa terá em conta a qualidade da programação (fatores de qualidade do software), a estrutura do código criado segundo os princípios da Programação Orientada por Objetos, tendo em conta conceitos como a coesão de classes e métodos, o grau de acoplamento entre classes e o desenho de classes orientado pela responsabilidade, e a utilização/conhecimento da linguagem Java.

·     Serão premiadas a facilidade de utilização, a apresentação, a imaginação e a criatividade.

·     O projeto terá uma componente de avaliação oral obrigatória com classificação individual dos elementos do grupo.

·     Os alunos que não comparecerem à discussão serão classificados com zero na fase respetiva. Nesta discussão será apurada a capacidade do aluno de produzir o código apresentado. Nos casos em que essa capacidade não for demonstrada, a nota atribuída será zero.

·     A avaliação oral é realizada pelo respetivo professor de laboratório e irá ser feita uma marcação prévia para cada grupo de trabalho.

·     Todos os projetos serão submetidos a um sistema automático de deteção de cópias. Os projetos que forem identificados como possíveis cópias, e verificando-se serem realmente cópias, serão anulados.

·     As avaliações da segunda fase do projeto serão realizadas na última semana de junho de 2023.

## 8.2. Critérios de Avaliação

A segunda fase do projeto será avaliada segundo os seguintes critérios:

| **Funcionalidades**                          | **45%** |
| -------------------------------------------- | ------- |
| **Implementação**                            | **35%** |
| Estrutura de classes                         | 20%     |
| Conhecimento e boa utilização  da linguagem  | 5%      |
| Bom estilo (nomes, comentários,  indentação) | 5%      |
| Definição de testes unitários                | 5%      |
| **Documentação** | **10%** |
| JavaDOC          | 5%      |
| Manual técnico   | 5%      |
| **Avaliação  qualitativa** | **10%** |


# 9.  Resumo das Datas Importantes

## 9.1. Entrega da 2ª fase

A entrega da 2ª fase do projeto será até **às 22:00:00 do dia 1 de julho de 2023**.

## 9.2. Avaliações da 2ª fase

As avaliações da segunda fase do projeto serão realizadas, se possível, entre os dias **03 e 04 de julho de 2023**.



