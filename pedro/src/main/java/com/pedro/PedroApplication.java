package com.pedro;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.pedro.domain.Cidade;
import com.pedro.domain.Cliente;
import com.pedro.domain.Endereco;
import com.pedro.domain.Estado;
import com.pedro.domain.enuns.TipoCliente;
import com.pedro.domain.repositories.CidadeRepository;
import com.pedro.domain.repositories.ClienteRepository;
import com.pedro.domain.repositories.EnderecoRepository;
import com.pedro.domain.repositories.EstadoRepository;

@SpringBootApplication
public class PedroApplication implements CommandLineRunner {

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;


    public static void main(String[] args) {
        SpringApplication.run(PedroApplication.class, args);
    }
    @Override
    public void run(String... args) throws Exception {
        Estado est1 = new Estado(null, "Minas Gerais");
        Estado est2 = new Estado(null, "Espirito Santo");
        estadoRepository.saveAll(Arrays.asList(est1,est2));

        Cidade c1 = new Cidade(null, "Uberlândia", est1);
        Cidade c2 = new Cidade(null, "Espirito Santo", est2);
        cidadeRepository.saveAll(Arrays.asList(c1,c2));

        Cliente cli1 = new  Cliente(null, "Pedro Henrique", "12234578908", "pedrohfs757@gmail.com", 
                TipoCliente.PESSOAFISICA);
        Cliente cli2 = new  Cliente(null, "Anderso", "33322277790", "Andersonroberto@gmail.com",
        		TipoCliente.PESSOAFISICA);
        cli1.getTelefones().addAll(Arrays.asList("24000002345", "12124354987"));
        cli2.getTelefones().addAll(Arrays.asList("44444567789", "00000987656"));
        clienteRepository.saveAll(Arrays.asList(cli1,cli2));

        Endereco e1 = new Endereco(null, "Rua Wasinton", "666","", "Roosevelt", "387891234",cli1,c1);
        Endereco e2 = new Endereco(null, "Rua Pixinguinha", "6969","", "Jardin America", "06609874",cli2,c2);
        cli1.getEnderecos().addAll(Arrays.asList(e1));
        cli2.getEnderecos().addAll(Arrays.asList(e2));
        enderecoRepository.saveAll(Arrays.asList(e1,e2));

    }

}

