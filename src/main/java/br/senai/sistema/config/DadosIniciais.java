package br.senai.sistema.config;

import java.time.LocalDate;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import br.senai.sistema.model.Cliente;
import br.senai.sistema.model.OrdemServico;
import br.senai.sistema.model.Perfil;
import br.senai.sistema.model.Usuario;
import br.senai.sistema.repository.ClienteRepository;
import br.senai.sistema.repository.OrdemServicoRepository;
import br.senai.sistema.repository.UsuarioRepository;

/**
 * Carga inicial de dados: executa uma vez sempre que a aplicação sobe.
 * Só insere os dados se a tabela ainda estiver vazia (por isso não duplica).
 */
@Component
public class DadosIniciais implements CommandLineRunner {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;
    private final ClienteRepository clienteRepository;
    private final OrdemServicoRepository ordemServicoRepository;

    public DadosIniciais(UsuarioRepository usuarioRepository, PasswordEncoder passwordEncoder,
                         ClienteRepository clienteRepository, OrdemServicoRepository ordemServicoRepository) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
        this.clienteRepository = clienteRepository;
        this.ordemServicoRepository = ordemServicoRepository;
    }

    @Override
    public void run(String... args) {
        if (usuarioRepository.count() == 0) {
            usuarioRepository.save(new Usuario("Administrador", "admin",
                    passwordEncoder.encode("admin123"), Perfil.ADMIN));
            usuarioRepository.save(new Usuario("Operador", "operador",
                    passwordEncoder.encode("operador123"), Perfil.OPERADOR));
        }

        if (clienteRepository.count() == 0) {
            Cliente cliente1 = new Cliente("Marina Costa", "123.456.789-12", "(43) 99999-1001", "marina@email.com", "Rua Dom João VI, 56", "Londrina", LocalDate.of(2026, 8, 12));
            Cliente cliente2 = new Cliente("Oficina Silva Ltda.", "456.789.123-45", "(43) 3333-2002", "contato@oficinasilva.com", "Rua Vasco da Gama, 128", "Cambé", LocalDate.of(2026, 9, 3));
            Cliente cliente3 = new Cliente("Pedro Henrique Alves", "789.123.456-78", "(43) 98888-3003", "pedro@email.com", "Avenida JK, 1387", "Ibiporã", LocalDate.of(2026, 10, 1));
            clienteRepository.save(cliente1);
            clienteRepository.save(cliente2);
            clienteRepository.save(cliente3);
        }
        
            if (ordemServicoRepository.count() == 0) {
            // OS 1 e OS 2 corrigidas sem os nomes dos parâmetros
            OrdemServico os1 = new OrdemServico("Notebook", "Dell", "Não liga", "cooler obstruído", 450.00, "Em Andamento", LocalDate.of(2026, 10, 11));
            OrdemServico os2 = new OrdemServico("Notebook", "Dell", "Não liga", "cooler obstruído", 450.00, "Em Andamento", LocalDate.of(2026, 10, 11));
            OrdemServico os3 = new OrdemServico("Smartphone", "Samsung", "Tela quebrada", "Troca de frontal", 380.00, "Em Andamento", LocalDate.of(2026, 10, 11));
            ordemServicoRepository.save(os1);
            ordemServicoRepository.save(os2);
            ordemServicoRepository.save(os3);
        }

    }
}