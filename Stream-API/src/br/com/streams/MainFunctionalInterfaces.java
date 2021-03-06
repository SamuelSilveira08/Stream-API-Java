package br.com.streams;

import java.util.Random;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MainFunctionalInterfaces {

	public static void main(String[] args) {

		// Entra um par�metro e n�o retorna nada
		Consumer<Empregado> consumer = emp -> {
			System.out.println(emp.getNome() + ", R$ " + emp.getSalario());
		};
		
		consumer.accept(new Empregado(10, "Samuel", 3000, "TI"));
		
		// Entra um par�metros e retorna algo
		
		Function<Empregado, Double> function = emp -> emp.getSalario() * 10;
		
		double salaryTenTimes = function.apply(new Empregado (10, "Samuel", 3000, "TI"));
		
		System.out.println(salaryTenTimes);
		
		// Entram dois par�metros e retorna algo do mesmo tipo
		
		BinaryOperator<Empregado> binaryOperator = (emp1, emp2) -> new Empregado(5, emp1.getNome() + emp2.getNome(),
				emp1.getSalario() + emp2.getSalario(), "Jun��o");
		
		System.out.println(binaryOperator.apply(new Empregado(10, "Samuel", 3000, "TI"), new Empregado(15, "Samuel", 3000, "TI")));
		
		// Entra um par�metro e retorna um booleano
		
		Predicate<Empregado> predicate = emp -> emp.getNome().endsWith("el");
		
		predicate.test(new Empregado(10, "Samuel", 3000, "TI"));
		
		System.out.println("Termina com \"el\"");
		
		// N�o tem par�metro e sempre retorna algo
		
		Supplier<Empregado> supplier = () -> new Empregado(new Random().nextInt(), "Samuel", 3000, "TI");
		
		Empregado emp = supplier.get();
		
		System.out.println(emp + " ID: " + emp.getId());
		
	}

}
