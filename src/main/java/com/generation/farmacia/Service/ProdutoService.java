package com.generation.farmacia.Service;

import com.generation.farmacia.Models.Produto;
import com.generation.farmacia.Repository.ProdutoRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto findById(Long id) {
        Optional<Produto> produto = produtoRepository.findById(id);
        return produto.orElseThrow(() -> new EntityNotFoundException(
                "Produto não encontrado! Id: " + id));
    }

    public List<Produto> findAll() {
        return produtoRepository.findAll();
    }

    @Transactional
    public Produto create(@Valid Produto produto) {
        return produtoRepository.save(produto);
    }

    @Transactional
    public Produto update(@Valid Produto updatedProduto) {
        Produto produto = findById(updatedProduto.getId());

        updatedProduto.setId(produto.getId());
        produto.setNome(updatedProduto.getNome());
        produto.setPreco(updatedProduto.getPreco());
        produto.setDescricao(updatedProduto.getDescricao());
        produto.setDistribuidor(updatedProduto.getDistribuidor());
        produto.setCategoria(updatedProduto.getCategoria());

        return produtoRepository.save(produto);
    }

    public void delete(Long id) {
        produtoRepository.findById(id);
        try {
            produtoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Não é possível realizar a exclusão!");
        }
    }

    public List<Produto> findAllByDistribuidor(Produto distribuidor) {
        if (distribuidor == null || distribuidor.getDistribuidor() == null) {
            return Collections.emptyList();
        }

        String nomeDistribuidor = distribuidor.getDistribuidor().toLowerCase();
        return produtoRepository.findAllByDistribuidorContainingIgnoreCase(nomeDistribuidor);
    }

    public List<Produto> findAllByCategoria(String categoria) {
        //Lógica feita para praticar e não utilizar métodos prontos da JPA
        List<Produto> produtos = findAll();
        List<Produto> produtosCategoria = new LinkedList<>();
        for (Produto produto : produtos) {
            if (produto.getCategoria().getNome().equalsIgnoreCase(categoria)) {
                produtosCategoria.add(produto);
            }
        }

        return produtosCategoria;
    }
}