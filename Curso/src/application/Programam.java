package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.ContratoPorHora;
import entities.Departamento;
import entities.Trabalhador;
import entities.enums.NivelTrabalho;

public class Programam {

	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner teclado = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Entre com o nome do departamento: ");
		String nomeDepartamento = teclado.nextLine();
		System.out.println("Entre com os dados do trabalhador: ");
		System.out.print("Nome: ");
		String nomeTrabalhador = teclado.nextLine();
		System.out.print("Entre com o nível do trabalhador: ");
		String nivelTrabalho = teclado.nextLine();
		System.out.print("Entre com o salário base: ");
		double salarioBase = teclado.nextDouble();
		Trabalhador trabalhador = new Trabalhador(nomeTrabalhador, NivelTrabalho.valueOf(nivelTrabalho), salarioBase, new Departamento(nomeDepartamento));
		
		System.out.print("Quantos contratos possui o trabalhador? ");
		int n = teclado.nextInt();
		
		for(int i = 1; i <= n; i++) {
			System.out.println("Entre com os dados do contrato #" + i);
			System.out.print("Entre com a data do contrato (DD/MM/YYYY)");
			Date dataContrato = sdf.parse(teclado.next());
			System.out.print("Digite o valor por hora: ");
			double valorPorHora = teclado.nextDouble();
			System.out.print("Duração (horas)");
			int horas = teclado.nextInt();
			ContratoPorHora contrato = new ContratoPorHora(dataContrato, valorPorHora, horas);
			trabalhador.addContrato(contrato);
		}
		
		System.out.println();
		System.out.print("Entre com o mês e ano para calcular a renda:(MM/YYYY) ");
		String mesEAno = teclado.next();
		int mes = Integer.parseInt(mesEAno.substring(0,2));
		int ano = Integer.parseInt(mesEAno.substring(3));
		System.out.println("Nome: " + trabalhador.getNome());
		System.out.println("Departamento: " + trabalhador.getDepartamento().getNome());
		System.out.println("Renda em " + mesEAno + ": " + String.format("%.2f",trabalhador.renda(ano,mes)));
		teclado.close();
	}

}
