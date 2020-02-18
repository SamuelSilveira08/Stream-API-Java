package br.com.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Empregado> empregados = new ArrayList<>();
		empregados.add(new Empregado(1, "João", 2000, "Produção"));
		empregados.add(new Empregado(2, "Maria", 3000, "RH"));
		empregados.add(new Empregado(3, "José", 5000, "Controladoria"));
		empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));

		// Maneira Tradicional

//		for(Empregado emp : empregados) {
//			System.out.println("Nome: " + emp.getNome());
//		}
//		
//		System.out.println();

		// Com a Stream API - Lambda

//		Stream<Empregado> empStream = empregados.stream();
//		
//		empStream.forEach(emp -> System.out.println("Nome: " + emp.getNome()));
//		
//		System.out.println();

		// Com a Stream API - Method Reference - Tem que sobrescrever toString()

//		empStream = empregados.stream();
//		
//		empStream.forEach(System.out::println);
//		
//		empStream = empregados.stream();
//		
//		var maiorSalario = empStream.mapToDouble(emp -> emp.getSalario()).max();
//		System.out.println(maiorSalario);

		// ***************************************************************************************
		// //

		System.out.println("Funcionários que começam com J: ");

		Stream<Empregado> empStream = empregados.stream();

		Stream<Empregado> empregadosComecamComJ = empStream.filter(emp -> emp.getNome().startsWith("J"));

		List<Empregado> empregadosComJ = empregadosComecamComJ.collect(Collectors.toList());

		empregadosComJ.stream().forEach(emp -> System.out.println(emp));

		double salarySum = empregadosComJ.stream().mapToDouble(emp -> emp.getSalario()).sum();

		System.out.println("Soma dos salários dos funcionários com J: R$ " + salarySum);
		
		OptionalDouble minimumSalary = empregadosComJ.stream().mapToDouble(emp -> emp.getSalario()).min();
		
		System.out.println("Menor salários dos funcionários com J: R$ " + minimumSalary);

	}

}
