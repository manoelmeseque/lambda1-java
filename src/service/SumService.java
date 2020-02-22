package service;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import entities.Funcionario;

public class SumService{

	public double filterSum(List<Funcionario> list, Predicate<Funcionario> criterio) {
		double sum = 0.0;
		for(Funcionario f: list) {
			if(criterio.test(f)) {
				sum += f.getSalary();
			}
		}
		return sum;
	}
	

}
