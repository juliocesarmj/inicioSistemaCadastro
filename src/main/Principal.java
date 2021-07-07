package main;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

import entities.Dependente;
import entities.Funcionario;
import entities.Setor;
import services.FuncionarioService;

public class Principal {

	public static void main(String[] args) {
		
		try {
			
			Funcionario funcionario = new Funcionario();
			funcionario.setSetor(new Setor());
			funcionario.setDependentes(new ArrayList<Dependente>());
			
			funcionario.setNome("Julio");
			funcionario.setCpf("123.123.123-55");
			funcionario.setMatricula("1455856");
			funcionario.getSetor().setIdSetor(1);
			
			Dependente dependente1 = new Dependente();
			dependente1.setNome("Ana paula");
			dependente1.setDataNascimento(new GregorianCalendar(2015, Calendar.JANUARY, 10).getTime());
			
			Dependente dependente2 = new Dependente();
			dependente2.setNome("Ana luiza");
			dependente2.setDataNascimento(new GregorianCalendar(1994, Calendar.SEPTEMBER, 16).getTime());
			
			Dependente dependente3 = new Dependente();
			dependente3.setNome("Pedro Rogerio");
			dependente3.setDataNascimento(new GregorianCalendar(2018, Calendar.DECEMBER, 20).getTime());
			
			funcionario.getDependentes().add(dependente1);
			funcionario.getDependentes().add(dependente2);
			funcionario.getDependentes().add(dependente3);
			
			FuncionarioService service = new FuncionarioService();
			service.cadastrarFuncionario(funcionario);
			System.out.println("Funcionário cadastrado com sucesso!");
			
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

	}

}
