package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.stream.Collectors;

import entities.Funcionario;
import service.SumService;

public class Main {
	
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		String path = "in.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))){
			
			List<Funcionario> list = new ArrayList<>();
			String line = br.readLine();
			
			while(line != null) {
				String[] coluna = line.split(",");
				list.add(new Funcionario(coluna[0], coluna[1], Double.parseDouble(coluna[2])));
				line = br.readLine();
			}
			
			System.out.println("Salario: ");
			double salary = sc.nextDouble();
			
			//predicate para orderna os email em ordem alfabetica
			Comparator<String> comp = (s1, s2) -> s1.toUpperCase().compareTo(s2.toUpperCase());
			
			List<String> emails = list.stream()
					.filter(f -> f.getSalary() >= salary)
					.map(f -> f.getEmail())
					.sorted(comp)
					.collect(Collectors.toList());
			
			emails.forEach(System.out::println);
			
			
			double sum = list.stream()
					.filter(f -> f.getName().charAt(0) == 'M')
					.map(f -> f.getSalary())
					.reduce(0.0, (x, y) -> x + y);
			
			System.out.println("A soma de todos os funcionarios começão com a letra 'M' :" + sum);
					
			
		}catch(IOException e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
