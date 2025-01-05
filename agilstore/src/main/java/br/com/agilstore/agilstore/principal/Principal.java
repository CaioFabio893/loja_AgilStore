package br.com.agilstore.agilstore.principal;

import br.com.agilstore.agilstore.model.Produto;
import br.com.agilstore.agilstore.model.TipoCategoria;
import br.com.agilstore.agilstore.repository.ProdutoRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Principal {

    private final ProdutoRepository repositorio;

    private Scanner leitura = new Scanner(System.in);

    public Principal(ProdutoRepository repositorio) {
        this.repositorio = repositorio;
    }

    public void exibeMenu() {
        var opcao = -1;

        while (opcao!= 9) {
            var menu = """
                    *** Screen Sound Músicas ***                    
                                        
                    1- Cadastrar produto
                    2- Listar produtos
                    3- Atualizar produto
                    4- Excluir produto
                    5- Pesquisar por produto
                                    
                    9 - Sair
                    """;

            System.out.println(menu);
            opcao = leitura.nextInt();
            leitura.nextLine();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    atualizarProduto();
                    break;
                case 4:
                    excluirProduto();
                    break;
                case 5:
                    buscarPorProduto();
                    break;
                case 9:
                    System.out.println("Encerrando a aplicação!");
                    break;
                default:
                    System.out.println("Opção inválida!");
            }
        }
    }



    private void cadastrarProduto() {
        var cadastrarNovo = "S";

        while (cadastrarNovo.equalsIgnoreCase("s")){
            System.out.println("Informe o nome do produto: ");
            var nome = leitura.nextLine();
            System.out.println("Informe a categoria: (computadores, audio, video, fotografia, eletrodomestico, jogos, acesssorios.)");
            var tipo = leitura.nextLine();
            System.out.println("Informe o valor do produto:");
            var preco = leitura.nextDouble();
            System.out.println("Informe a quantidade de unidades no estoque.");
            var quantidadeEmEstoque = leitura.nextInt();

            TipoCategoria tipoCategoria = TipoCategoria.valueOf(tipo.toUpperCase());
            Produto produto = new Produto(nome, tipoCategoria, preco, quantidadeEmEstoque);

            repositorio.save(produto);

            System.out.println("Cadastrar novo produto? (S/N)");
            cadastrarNovo = leitura.nextLine();
        }

    }

    private void listarProdutos() {
        List<Produto> produtos = repositorio.findAll();
        produtos.forEach(System.out::println);
    }

    private void atualizarProduto() {
        System.out.println("Informe o nome do produto que deseja editar: ");
        var nome = leitura.nextLine();

        Optional<Produto> produto = repositorio.findByNomeContainingIgnoreCase(nome);
        if (produto.isPresent()) {
            Produto produtoEncontrado = produto.get();
            System.out.println("Produto encontrado: " + produtoEncontrado);

            System.out.println("Deseja editar o nome do produto? (S/N)");
            var opcaoNome = leitura.nextLine();
            if (opcaoNome.equalsIgnoreCase("S")) {
                System.out.println("Informe o novo nome do produto: ");
                var novoNome = leitura.nextLine();
                produtoEncontrado.setNome(novoNome);
            }

            System.out.println("Deseja editar a categoria do produto? (S/N)");
            var opcaoTipo = leitura.nextLine();
            if (opcaoTipo.equalsIgnoreCase("S")) {
                System.out.println("Informe a nova categoria do produto: \n(computadores, audio, video, fotografia, eletrodomestico, jogos, acesssorios.) ");
                var novoTipo = leitura.nextLine();
                try {
                    TipoCategoria tipoCategoria = TipoCategoria.valueOf(novoTipo.toUpperCase());
                    produtoEncontrado.setTipo(tipoCategoria);
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo inválido! Edição do tipo cancelada.");
                }
            }

            System.out.println("Deseja editar o valor do produto? (S/N)");
            var opcaoValor = leitura.nextLine();
            if (opcaoValor.equalsIgnoreCase("S")) {
                System.out.println("Informe o novo valor do produto: ");
                var novoValor = leitura.nextDouble();
                produtoEncontrado.setPreco((novoValor));
            }

            System.out.println("Deseja editar a quantidade em estoque do produto? (S/N)");
            var opcaoQuantidade = leitura.nextLine();
            if (opcaoQuantidade.equalsIgnoreCase("S")) {
                System.out.println("Informe a nova quantidade em estoque do produto: ");
                var novaQuantidade = leitura.nextInt();
                produtoEncontrado.setQuantidadeEmEstoque((novaQuantidade));
            }

            repositorio.save(produtoEncontrado);
            System.out.println("Produto atualizado com sucesso!");
        } else {
            System.out.println("Produto não encontrado!");
        }
    }


    private void excluirProduto() {
        System.out.println("Informe o nome do produto que deseja excluir: ");
        var nome = leitura.nextLine();

        Optional<Produto> produto = repositorio.findByNomeContainingIgnoreCase(nome);
        if (produto.isPresent()) {
            Produto produtoEncontrado = produto.get();
            System.out.println("Produto encontrado: " + produtoEncontrado);

            System.out.println("Deseja realmente excluir este produto? (S/N)");
            var opcao = leitura.nextLine();
            if (opcao.equalsIgnoreCase("S")) {
                repositorio.delete(produtoEncontrado);
                System.out.println("Produto excluído com sucesso!");
            } else {
                System.out.println("Exclusão cancelada.");
            }
        } else {
            System.out.println("Produto não encontrado!");
        }
    }

    private void buscarPorProduto() {
        System.out.println("Digite o nome do produto: ");
        var nome = leitura.nextLine();
        Optional<Produto> produto = repositorio.findByNomeContainingIgnoreCase(nome);
        if (produto.isPresent()) {
            System.out.println(produto.get());
        } else {
            System.out.println("Não temos esse produto no estoque!");
        }
    }



}