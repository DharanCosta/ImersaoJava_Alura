<h1 align="center">Imersão Java - Alura</h1>

<h3> Descrição do projeto </h3>
Nesse projeto estamos consumindo uma API e tranformaremos os dados.</br>

-🔨 `Funcionalidade 1`: Consumir e tratar dados de API's;</br>
-🔨 `Funcionalidade 2`: Gerar Stickers(.png) para compartilhar em aplicativos de mensagem;</br>


<h3> ✔️ Técnicas e tecnologias utilizadas </h3>
 
- ``Java 17``
- ``InteliJ IDEA``
- ``Biblioteca GSON``
- ``Paradigma de orientação a objetos``

## 📁 Repositório API-Linguagens

https://github.com/DharanCosta/API_Programing_Languages


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
-Adicionei borda no texto impresso nos stickers.</br>

![Resultado da Aula 02](https://user-images.githubusercontent.com/41304141/179857515-a16a9661-2a94-4d82-a559-eccdfcba24fb.jpg)

## Aula 03

-Começei um processo de refatoração do código para facilitar o recebimento novas APIs, dessa maneira também acessei a API da Nasa que mostra as fotos do dia</br>
-Criei a classe ClienteHttp para separa a gestão das urls das APIs.</br>
-Criei o extrator de conteúdos para receber o JSON das APIs e fazer o tratamento específico para extrair os dados.</br>

![Aula03jpg](https://user-images.githubusercontent.com/41304141/180103992-73145793-5212-4323-8726-1e7facc67507.jpg)

-Criei também uma classe Record para padronizar os conteúdos.
-Adicionei um Enum para gerenciar as URLs dos APIs.</br>

![Aula03Enunjpg](https://user-images.githubusercontent.com/41304141/180104008-70686282-3d55-4f8b-b7f1-2726893e18f9.jpg)

<h2 align="center">Exemplo dos sticker no Whatsapp</h2>

![StickerWhatsappExample2](https://user-images.githubusercontent.com/41304141/180104893-7dbd4fc8-a647-4ddb-b51e-0c9b4259e40f.jpg)

![StickerWhatsappExample](https://user-images.githubusercontent.com/41304141/180104578-0266c8c3-01cd-452d-9ce3-cfc483f05e92.jpg)

## Aula 04 

- Criei a minha própria API (https://github.com/DharanCosta/API_Programing_Languages)</br>

<h3>Detalhes sobre essa API:</h3>

-Projeto Spring utilizando o MongoDB para guardar uma lista de linguagens de programação.

-Fiz um CRUD completo desta API, incluindo um endpoint que ordena por rank de linguagens preferidas.

![CRUD](https://user-images.githubusercontent.com/41304141/180464673-204a2daa-a92d-4a31-addc-5cd3b35e11e1.jpg)

-Retorna um JSON para ser consumido no Gerador de Stickers(imagem abaixo).

![jsonAPIlinguagensjpg](https://user-images.githubusercontent.com/41304141/180462837-37cec6f0-3dc9-4d82-b204-21dc0b958d9d.jpg)

-Acrescentei no projeto o GSON parser para facilitar a extração de dados de diferentes APIs.

-Inclui no Gerador de Sticker um extartor específico para Linguagens.

<h2 align="center">Exemplo dos sticker no Whatsapp</h2>

![StickersLinguagesn](https://user-images.githubusercontent.com/41304141/180466420-d78e27cc-b354-4de5-9943-284a88e7fe69.jpg)

## Aula 05
- Testando todos os endpoints da API-Linguagens. </br>
- Preparei o projeto para deploy.</br>
- Deploy realizado com sucesso (http://api-linguagens-alura.herokuapp.com/linguagens/ranking).</br>

<h1 align="center">🌎 Onde você me encontra? 🌍</h1>

                                    
<div align="center" > 
  <a href="https://discord.gg/4j9jynF3" target="_blank"><img src="https://img.shields.io/badge/Discord-7289DA?style=for-the-badge&logo=discord&logoColor=white" target="_blank"></a> 
  <a href = "mailto:dharancosta@gmail.com"><img src="https://img.shields.io/badge/Gmail-D14836?style=for-the-badge&logo=gmail&logoColor=white" target="_blank"></a>
  <a href="www.linkedin.com/in/dharancosta" target="_blank"><img src="https://img.shields.io/badge/-LinkedIn-%230077B5?style=for-the-badge&logo=linkedin&logoColor=white" target="_blank"></a> 
</div

