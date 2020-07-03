package entidades;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entidades.enums.NivelDoCargo;

public class Trabalhador {

	private String nome;
	private NivelDoCargo nivel;
	private Double salarioBase;
	private Departamento departamento; // A classe trabalhador tem apenas um departamento.
	private List<ContratoPorHora> contratos = new ArrayList<>();
	// A classe trabalhador tem vários contratos, então precisa criar uma lista.

	public Trabalhador() {

	}

	public Trabalhador(String nome, NivelDoCargo nivel, Double salarioBase, Departamento departamento) {
		// Construtor criado sem o List.
		this.nome = nome;
		this.nivel = nivel;
		this.salarioBase = salarioBase;
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public NivelDoCargo getNivel() {
		return nivel;
	}

	public void setNivel(NivelDoCargo nivel) {
		this.nivel = nivel;
	}

	public Double getSalarioBase() {
		return salarioBase;
	}

	public void setSalarioBase(Double salarioBase) {
		this.salarioBase = salarioBase;
	}

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public List<ContratoPorHora> getContartos() {
		return contratos; // A lista não pode ser alterada, a não ser pelos métodos de adicionar ou
							// remover os contratos.
							// O método setContratos não pode existir para assegurar que não seja gerada uma
							// nova lista.
	}

	public void adicionarContrato(ContratoPorHora contrato) {
		contratos.add(contrato); // Fazer a associação de um trabalhador e um contrato.
	}

	public void removerContrato(ContratoPorHora contrato) {
		contratos.remove(contrato); // Desfazer a associação de um trabalhador e um contrato.
	}

	public double rendimento(int ano, int mes) { // Para poder pegar os contratos do mês e ano em questão.
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance(); // Instanciando o calendário.
		for (ContratoPorHora c : contratos) { // Para cada contrato "c" na lista contratos, faça:
			cal.setTime(c.getData()); // Agora as datas estão setadas dentro do calendario, através do método
										// getData().
			int c_ano = cal.get(Calendar.YEAR); // Pegando o ano em questão
			int c_mes = 1 + cal.get(Calendar.MONTH); // Pegando mês em questão.
			if (ano == c_ano && mes == c_mes) {// Estrutura de decisão para saber se ano e mes estão setados.
				soma += c.valorTotal();//Somando todos os valores dos contratos daquele mês e ano.
			}
		}
		return soma;
	}
}
