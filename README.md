<h1>estoqueapp por Lívia Mendes Soares</h1>
<h3>Software de gerenciamento de estoque desenvolvido em Java, SQL e CSS, com uso do framework JavaFX e do software SceneBuilder.</h3>
<p>Permite fácil controle de estoque por meio do registro de saída de produtos, assim como a adição e remoção destes.</p>
<h3>Configuração utilizada durante o desenvolvimento:</h3>
<ul>
  <li>JDK 21;</li>
  <li>JavaFX SDK 21.0.2;</li>
  <li>SceneBuilder 21.0.0;</li>
  <li>Visual Studio Code IDE</li>
</ul>
<h2>Produtos</h2>
<p>Os produtos são organizados em uma tabela que se localiza na janela principal, visando fácil consulta. Na tabela, cada produto recebe os seguintes atributos:</p>
<ul>
  <li>Código: Gerado automaticamente pela tabela no momento em que o produto é adicionado. Utilizado para facilitar o processo de registrar retiradas e remoção de produto, não exigindo que o usuário digite o nome do produto</li>
  <li>Nome: Atributo obrigatório. Normalizado em upper case durante a adição de novo produto</li>
  <li>Tamanho: Atributo não obrigatório. Normalizado em upper case durante a adição de novo produto</li>
  <li>QTD (Quantidade): Atributo obrigatório.</li>
  <li>C.Prod (Custo de Produção): Atributo não obrigatório.</li>
  <li>Varejo (Preço): Atributo obrigatório.</li>
  <li>Atacado (Preço): Atributo não obrigatório.</li>
</ul>
