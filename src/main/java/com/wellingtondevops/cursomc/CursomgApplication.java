package com.wellingtondevops.cursomc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.wellingtondevops.cursomc.domain.Categoria;
import com.wellingtondevops.cursomc.domain.Cidade;
import com.wellingtondevops.cursomc.domain.Cliente;
import com.wellingtondevops.cursomc.domain.Endereco;
import com.wellingtondevops.cursomc.domain.Estado;
import com.wellingtondevops.cursomc.domain.Produto;
import com.wellingtondevops.cursomc.domain.enums.TipoCliente;
import com.wellingtondevops.cursomc.repositories.CategoriaRepository;
import com.wellingtondevops.cursomc.repositories.CidadeRepository;
import com.wellingtondevops.cursomc.repositories.ClienteRepository;
import com.wellingtondevops.cursomc.repositories.EnderecoRepository;
import com.wellingtondevops.cursomc.repositories.EstadoRepository;
import com.wellingtondevops.cursomc.repositories.ProdutoRepository;



@SpringBootApplication
public class CursomgApplication implements CommandLineRunner{
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;
	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(CursomgApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Categoria cat1 = new Categoria(null, "Informática");
		Categoria cat2 = new Categoria(null, "Escritório");
		
		Produto p1 = new Produto(null,"Computador", 2000.00);
		Produto p2 = new Produto(null,"Impressora", 800.00);
		Produto p3 = new Produto(null,"Mouse", 80.00);
		
		cat1.getProdutos().addAll(Arrays.asList(p1,p2,p3));
		cat1.getProdutos().addAll(Arrays.asList(p2));
		
		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1));
		
	
		
		categoriaRepository.save(Arrays.asList(cat1,cat2));
		produtoRepository.save(Arrays.asList(p1,p2,p3));
		

		Estado est1 = new Estado(null,"Minas Gerias");
		Estado est2 = new Estado(null,"São Paulo");
		
		Cidade c1 = new Cidade(null, "Uberlandia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);
		
		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));
		
		estadoRepository.save(Arrays.asList(est1, est2));
		cidadeRepository.save(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Marila Silva", "maria@gmail.com", "36378912377", TipoCliente.PESSOAFISICA);
				
		cli1.getTelefones().addAll(Arrays.asList("27363323","93838393"));
		
		Endereco e1 = new Endereco(null, "Rua Flores", "300", "apt 303", "Jardim", "38220834", cli1, c1);	

		Endereco e2 = new Endereco(null, "Avenida Matos", "105", "Sala 800", "Centro", "38777012", cli1, c2);
		
		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		
		clienteRepository.save(Arrays.asList(cli1));
		enderecoRepository.save(Arrays.asList(e1,e2));
		
		
		
		

		
	}
}
