package aplicacao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entidades.ContratoPorHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.NivelDoCargo;

/*Ler os dados de um trabalhador com N contratos (N fornecido pelo usu�rio). Depois, solicitar
do usu�rio um m�s e mostrar qual foi o sal�rio do funcion�rio nesse m�s, conforme exemplo
(pr�xima p�gina).
  */

public class Programa {

	public static void main(String[] args) throws ParseException { // O m�todo main pode gerar esse tipo de
																	// exce��o.
		// TODO Auto-generated method stub
		Scanner ent = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Informe o departamento: ");
		String nomeDepartamento = ent.nextLine();
		System.out.println("Informe os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = ent.nextLine();
		System.out.print("N�vel do Cargo: ");
		String nivelDoCargo = ent.nextLine();
		System.out.print("Sal�rio Base: ");
		double salarioBase = ent.nextDouble();

		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelDoCargo.valueOf(nivelDoCargo), salarioBase,
				new Departamento(nomeDepartamento));

		System.out.print("Quantos contratos para esse trabalhador? ");
		int n = ent.nextInt();

		for (int i = 1; i <= n; i++) { // Para ler os dados dos contratos.
			System.out.println("Contrato #" + i + " data: ");
			System.out.print("Data (DD/MM/YYYY): ");
			Date dataDoContrato = sdf.parse(ent.next());
			System.out.print("Valor por hora: ");
			double valorPorHora = ent.nextDouble();
			System.out.print("Dura��o (horas): ");
			int horas = ent.nextInt(); // Esse for vai se repetir at� instaciar todos os contratos e
										// associ�-los ao trabalhador.
			ContratoPorHora contrato = new ContratoPorHora(dataDoContrato, valorPorHora, horas);
			trabalhador.adicionarContrato(contrato); // Associando o contrato com o trabalhador.
		}

		System.out.print("\nInforme o m�s e o ano para calcular o sal�rio (MM/YYYY): ");
		String mesEAno = ent.next();
		int mes = Integer.parseInt(mesEAno.substring(0, 2));//Recortando a string MM/YYYY, apenas a parte do m�s, e transformando-a em inteiro.
		int ano = Integer.parseInt(mesEAno.substring(3));//Recortando a string MM/YYYY, apenas a parte do ano, e transformando-a em inteiro.
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Rendimento: " + mesEAno + ": " + String.format("%.2f", trabalhador.rendimento(ano, mes)));
		
		ent.close();
	}

}
