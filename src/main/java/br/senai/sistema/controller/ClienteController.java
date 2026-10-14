package br.senai.sistema.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.senai.sistema.model.Cliente;
import br.senai.sistema.service.ClienteService;
import jakarta.validation.Valid;

/**
 * Controller de Cliente: recebe as requisições do navegador para /clientes.
 */
@Controller
@RequestMapping("/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }

    /** GET /clientes -> mostra a lista. */
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteService.listarTodos());
        return "clientes/lista";
    }

    /** GET /clientes/novo -> abre o formulário vazio. */
    @GetMapping("/novo")
    public String novo(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "clientes/form";
    }

    /**
     * POST /clientes/salvar -> recebe o formulário (cadastro ou edição).
     * @Valid confere as regras da entidade; os erros ficam em "resultado".
     */
    @PostMapping("/salvar")
    public String salvar(@Valid @ModelAttribute("cliente") Cliente cliente, BindingResult resultado,
                         RedirectAttributes atributos) {
        if (resultado.hasErrors()) {
            return "clientes/form";   // volta para o formulário mostrando os erros
        }
        clienteService.salvar(cliente);
        atributos.addFlashAttribute("mensagem", "Cliente salvo com sucesso.");
        return "redirect:/clientes";
    }
}