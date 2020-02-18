package br.com.streams;

import java.util.function.Consumer;

public class MainFunctionalInterfaces {

	public static void main(String[] args) {

		// Entra um parâmetro e não retorna nada
		Consumer<Empregado> consumer = emp -> {
			System.out.println(emp.getNome() + ", R$ " + emp.getSalario());
		};

		consumer.accept(new Empregado(10, "Samuel", 3000, "TI"));
	}

}
