package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.NivelTrabalho;

public class Trabalhador {
	
	private String nome;
	private NivelTrabalho nivel;
	private Double salarioBase;
	
	private Departamento departamento;
	private List<ContratoPorHora> contratos = new ArrayList<>();
	
	public Trabalhador() {
	}

	public Trabalhador(String nome, NivelTrabalho nivel, Double salarioBase, Departamento departamento) {
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

	public NivelTrabalho getNivel() {
		return nivel;
	}

	public void setNivel(NivelTrabalho nivel) {
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

	public List<ContratoPorHora> getContratos() {
		return contratos;
	}
	
	public void addContrato(ContratoPorHora contrato) {
		contratos.add(contrato);
	}
	
	public void removeContrato(ContratoPorHora contrato) {
		contratos.remove(contrato);
	}
	
	public double renda(int ano, int mes) {
		double soma = salarioBase;
		Calendar cal = Calendar.getInstance();
		for(ContratoPorHora c: contratos) {
			cal.setTime(c.getData());
			int c_ano = cal.get(Calendar.YEAR);
			int c_mes = 1 + cal.get(Calendar.MONTH);
			if(c_ano == ano && c_mes == mes) {
				soma += c.valorTotal();
			}
		}
		return soma;
	}

}
