# ProjetoArq_SimuladorCache

<p align="center">
	<br>
	<img src="prints/teste4.PNG"/ >
	<br>
</p>

<p id="docs-internal-guid-3d6d8a8c-7fff-f4e0-4b10-4a391ecd5deb" dir="ltr"><span>Se o desempenho do processador fosse atrelado ao desempenho da memória RAM, os PCs já teriam estagnado a um bom tempo, já que simplesmente não faria sentido desenvolver processadores mais rápidos, apenas para que eles passassem esperar mais e mais ciclos pelas leituras na memória. A solução veio com a introdução da memória cache, que serve como um reservatório temporário de dados com grande possibilidade de serem usados pelo processador, reduzindo a percentagem de vezes em que ele precisa buscar informações diretamente na memória.</span></p>
<p dir="ltr"><span>Sempre que precisa de novas informações, o processador checa primeiro as informações disponíveis no cache L1. Caso não encontre o que precisa, ele verifica em seguida o cache L2 e por último a memória. Sempre que o processador encontra o que precisa nos caches temos um "cache hit" e sempre que precisa recorrer à memória temos um "cache miss". Quanto maior a percentagem de cache hits, melhor é o desempenho.</span></p>
<br /><ol>
<li dir="ltr">
<h1 dir="ltr"><span>Desenvolvimento</span></h1>
</li>
</ol>
<p dir="ltr"><span>Para o projeto, foi definido a estrutura da seguinte forma:</span></p>
<ul>
<li dir="ltr">
<p dir="ltr"><span>O cache L1 é menor que a L2 e oferece tempos de acesso muito baixos, equivalentes a apenas 3 ciclos de clock. </span></p>
</li>
<li dir="ltr">
<p dir="ltr"><span>O cache L2 por sua vez, tem 4 vezes o tamanho da L1, mas ele em compensação trabalha com tempos de acesso mais altos, de tipicamente 14 ciclos de clock.</span></p>
</li>
<li dir="ltr">
<p dir="ltr"><span>A memória RAM tem 128 células, equivale a 4 vezes o tamanho da cache L2, mas em contrapartida, tem 240 Ciclos de clock.</span></p>
</li>
</ul>
<br />
<p dir="ltr"><span>Foi utilizado duas formas (heurísticas) para selecionar o elemento a ser retirado, LRU e FIFO.</span></p>
<p dir="ltr"><span>Podendo ser escolhido no início da execução.</span></p>
<br />
<p dir="ltr"><span>Bloco ou linha: </span><span>unidade de informação mínima que pode estar presente ou ausente na hierarquia de dois níveis. Consiste de múltiplas palavras contíguas na memória.  </span></p>
<p dir="ltr"><span>Hit:</span><span> dados encontrados em algum bloco durante a pesquisa ou escrita. </span></p>
<p dir="ltr"><span>Miss:</span><span> dados não encontrados, precisa acessar o nível inferior.  </span></p>
<p dir="ltr"><span>Total de acessos: </span><span>Total de acesso a memória Cache</span></p>
<p dir="ltr"><span>Desempenho:</span><span> Porcentagem de acertos de falhas na execução do algoritmo.</span></p>
<p dir="ltr"><span>Tempo:</span><span> Tempo de execução do algoritmo</span></p>
<span>Ciclos de Clock:</span><span> Quantidade de ciclos do processador para determinada instrução.</span>
