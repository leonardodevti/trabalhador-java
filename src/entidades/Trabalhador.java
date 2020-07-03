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
	// A classe trabalhador tem v�rios contratos, ent�o precisa criar uma lista.

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
		return contratos; // A lista n�o pode ser alterada, a n�o ser pelos m�todos de adicionar ou
							// remover os contratos.
							// O m�todo setContratos n�o pode existir para assegurar que n�o seja gerada uma
							// nova lista.
	}

	public void adicionarContrato(ContratoPorHora contrato) {
		contratos.add(contrato); // Fazer a associa��o de um trabalhador e um contrato.
	}

	public void removerContrato(ContratoPorHora contrato) {
		contratos.remove(contrato); // Desfazer a associa��o de um trabalhador e um contrato.
	}

	public double rendimento(int ano, int mes) { // Para poder pegar os contratos do m�s e ano em quest�o.
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance(); // Instanciando o calend�rio.
		for (ContratoPorHora c : contratos) { // Para cada contrato "c" na lista contratos, fa�a:
			cal.setTime(c.getData()); // Agora as datas est�o setadas dentro do calendario, atrav�s do m�todo
										// getData().
			int c_ano = cal.get(Calendar.YEAR); // Pegando o ano em quest�o
			int c_mes = 1 + cal.get(Calendar.MONTH); // Pegando m�s em quest�o.
			if (ano == c_ano && mes == c_mes) {// Estrutura de decis�o para saber se ano e mes est�o setados.
				soma += c.valorTotal();//Somando todos os valores dos contratos daquele m�s e ano.
			}
		}
		return soma;
	}
}
