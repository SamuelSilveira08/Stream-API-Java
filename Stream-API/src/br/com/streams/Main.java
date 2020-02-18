package br.com.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		List<Empregado> empregados = new ArrayList<>();
		empregados.add(new Empregado(1, "João", 2000, "Produção"));
		empregados.add(new Empregado(2, "Maria", 3000, "RH"));
		empregados.add(new Empregado(3, "José", 5000, "Controladoria"));
		empregados.add(new Empregado(4, "Josefina", 7000, "CTO"));
		
		// Maneira Tradicional
		
		for(Empregado emp : empregados) {
			System.out.println("Nome: " + emp.getNome());
		}
		
		System.out.println();
		
		// Com a Stream API - Lambda
		
		Stream<Empregado> empStream = empregados.stream();
		
		empStream.forEach(emp -> System.out.println("Nome: " + emp.getNome()));
		
		System.out.println();
		
		// Com a Stream API - Method Reference - Tem que sobrescrever toString()
		
		empStream = empregados.stream();
		
		empStream.forEach(System.out::println);
		
		empStream = empregados.stream();
		
		var maiorSalario = empStream.mapToDouble(emp -> emp.getSalario()).max();
		System.out.println(maiorSalario);
	}

}
