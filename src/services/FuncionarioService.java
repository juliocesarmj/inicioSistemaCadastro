package services;

import entities.Dependente;
import entities.Funcionario;
import factories.ConnectionFactory;
import repositories.DependenteRepository;
import repositories.FuncionarioRepository;

public class FuncionarioService {
	
	//m�todo para cadastrar funcionario
	//servi�o de dom�nio - regra de neg�cio
	public void cadastrarFuncionario(Funcionario funcionario) throws Exception {
		
		if(funcionario.getDependentes() != null && funcionario.getDependentes().size() <= 3) {
			
			
			FuncionarioRepository funcionarioRepository = new FuncionarioRepository(ConnectionFactory.getConnection());
			DependenteRepository dependenteRepository = new DependenteRepository(ConnectionFactory.getConnection());
			
			//gravar um funcionario no banco
			funcionarioRepository.create(funcionario);
			
			for(Dependente dependente : funcionario.getDependentes()) {
				
				//antes de gravar cada dependente da lista, associo o dependente ao funcionario criado
				dependente.setFuncionario(funcionario);
				
				//gravar um dependente no banco. J� relacionado ao funcionario
				dependenteRepository.create(dependente);
				
			}
		} else {
			throw new Exception("Funcion�rio n�o pode ter mais de 3 dependentes!");
		}
	}
}
