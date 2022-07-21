<h1 align="center">Imersão Java - Alura</h1>

<h3> Descrição do projeto</h3>
Nesse projeto estamos consumindo uma API e tranformaremos os dados.</br>

-`Funcionalidade 1`: Organizar e mostrar os dados da API consumida;</br>
-`Funcionalidade 2`: Gerar Stickers para compartilhar em aplicativos de mensagem;</br>

## Aula 01
-Na primeira aula acessei os dados da API da IMDb (Top 250 Movies) e aloquei os dados dentro de uma String.</br>
-Extrai os dados que são relevantes.</br>
-Exibi e manipulei os dados para que eles aparecessem no terminal de forma organizada e estilizada.</br>

![Resultado da Aula 01](https://github.com/DharanCosta/ImersaoJava_Alura/blob/main/Assets/Captura%20de%20tela%202022-07-18%20211352.jpg?raw=true)


## Aula 02
-Comecei a trabalhar na leitura das imagens dos posters de cada filme, o objetivo é transforma-los em stickers para compartilhar via whatsapp/telegran</br>
-Consumindo os dados que vieram da API, utilizei lógica para conseguir extrair imagens no tamanho grande dos links recebidos. </br>
-Com as imagens em um tamanho grande, precisei padronizar os tamanhos. O que facilitou os próximos passos.</br>
-Assim pude adicionar o respiro transparente na parte de baixo das imagens.</br>
-Adicionei um texto que mostra a nota que o filme recebeu.</br>
-Adicionei também um segundo sticker para representar o resultado da nota recebida.</br>
-Criei uma lógica para que as notas pudessem gerar dois resultados diferentes, aprovado e reprovado.</br>
Obs. Como os dados são dos top 250 mais bem rankeados, coloquei uma nota de corte de 9.0.</br>

![Resultado da Aula 02](https://github.com/DharanCosta/ImersaoJava_Alura/blob/main/Assets/SharedScreenshot.jpg
)

-Agora com borda no texto.</br>
![Resultado da Aula 02](https://user-images.githubusercontent.com/41304141/179857515-a16a9661-2a94-4d82-a559-eccdfcba24fb.jpg)

## Aula 03
-Começei um processo de refatoração do código para facilitar o recebimento novas APIs, dessa maneira também acessei a API da Nasa que mostra as fotos do dia</br>
-Criei a classe ClienteHttp para separa a gestão das urls das APIs.</br>
-Criei o extrator de conteúdos para receber o JSON das APIs e fazer o tratamento específico para extrair os dados.</br>
![Aula03jpg](https://user-images.githubusercontent.com/41304141/180103992-73145793-5212-4323-8726-1e7facc67507.jpg)
-Criei também uma classe Record para padronizar os conteúdos.
-Adicionei um Enum para gerenciar as URLs dos APIs.</br>
![Aula03Enunjpg](https://user-images.githubusercontent.com/41304141/180104008-70686282-3d55-4f8b-b7f1-2726893e18f9.jpg)

<h2 text-align="center">Como ficaram os sticker no Whatsapp</h2>
![SharedScreenshot](https://user-images.githubusercontent.com/41304141/180104378-97ac80dd-4f3d-4356-bdcf-d9eb41d6c158.jpg)



