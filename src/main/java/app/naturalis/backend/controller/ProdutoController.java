package app.naturalis.backend.controller;

import app.naturalis.backend.event.RecursoEvent;
import app.naturalis.backend.model.Produto;
import app.naturalis.backend.repository.ProdutoRepository;
import app.naturalis.backend.repository.filter.ProdutoFilter;
import app.naturalis.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProdutoController {
    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ProdutoService produtoService;

    @Autowired
    private ApplicationEventPublisher pubEvent;

    @GetMapping
    public Page<Produto> getAll(
            ProdutoFilter produtoFilter,
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "10") int size,
            @RequestParam(defaultValue = "false") boolean sort){
        Pageable paging = PageRequest.of(page, size);
        Page<Produto> pageOrder = this.produtoRepository.filtrarPaging(produtoFilter, paging,sort);
        return pageOrder;
    }

    @PostMapping("/create")
    public ResponseEntity<Produto> create(@Valid @RequestBody Produto produto, HttpServletResponse response){
        Produto nvProduto = this.produtoService.newProduct(produto);

        pubEvent.publishEvent(new RecursoEvent(this, response, nvProduto.getId()));

        return ResponseEntity.status(HttpStatus.CREATED).body(nvProduto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable("id") int id){
        Optional<Produto> produto = this.produtoService.getById(id);

        return produto.isPresent() ? ResponseEntity.ok(produto) : ResponseEntity.notFound().build();
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Produto> editById(@PathVariable("id") int id, @Valid @RequestBody Produto produto){
        var prod = this.produtoService.editById(id, produto);

        return ResponseEntity.ok(prod);
    }

    @DeleteMapping("/{id}")
    public void removeProdById(@PathVariable("id") int id){
        this.produtoService.removeProductById(id);
    }
}
