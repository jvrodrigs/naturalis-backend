package app.naturalis.backend.service;

import app.naturalis.backend.model.Produto;
import app.naturalis.backend.repository.ProdutoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public Produto newProduct(Produto produto){
        return this.produtoRepository.save(produto);
    }

    public Optional<Produto> getById(int id){
        Optional<Produto> produtoById = Optional.ofNullable(this.produtoRepository.findById(id)
                .orElseThrow( () -> new EmptyResultDataAccessException(1)));
        return produtoById;
    }

    public Produto editById(int id, Produto produto){
        Optional<Produto> produtoSave = Optional.ofNullable(this.produtoRepository.findById(id)
                .orElseThrow( () -> new EmptyResultDataAccessException(1)));
        BeanUtils.copyProperties(produto, produtoSave.get(), "id");
        return this.produtoRepository.save(produtoSave.get());
    }

    public void removeProductById(int id){
        this.produtoRepository.deleteById(id);
    }
}
