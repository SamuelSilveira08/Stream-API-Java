package br.com.streams;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;

public class MainFunctionalInterfaces {

	public static void main(String[] args) {

		// Entra um parâmetro e não retorna nada
		Consumer<Empregado> consumer = emp -> {
			System.out.println(emp.getNome() + ", R$ " + emp.getSalario());
		};
		
		consumer.accept(new Empregado(10, "Samuel", 3000, "TI"));
		
		// Entram dois parâmetros e retorna algo
		
		Function<Empregado, Double> function = emp -> emp.getSalario() * 10;
		
		double salaryTenTimes = function.apply(new Empregado (10, "Samuel", 3000, "TI"));
		
		System.out.println(salaryTenTimes);
		
		// 
		
		BinaryOperator<Empregado> binaryOperator = (emp1, emp2) -> new Empregado(5, emp1.getNome() + emp2.getNome(),
				emp1.getSalario() + emp2.getSalario(), "Junção");
		
		System.out.println(binaryOperator.apply(new Empregado(10, "Samuel", 3000, "TI"), new Empregado(15, "Samuel", 3000, "TI")));
	}

}
