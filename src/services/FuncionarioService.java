package services;

import entities.Dependente;
import entities.Funcionario;
import factories.ConnectionFactory;
import repositories.DependenteRepository;
import repositories.FuncionarioRepository;

public class FuncionarioService {
	
	//método para cadastrar funcionario
	//serviço de domínio - regra de negício
	public void cadastrarFuncionario(Funcionario funcionario) throws Exception {
		
		if(funcionario.getDependentes() != null && funcionario.getDependentes().size() <= 3) {
			
			
			FuncionarioRepository funcionarioRepository = new FuncionarioRepository(ConnectionFactory.getConnection());
			DependenteRepository dependenteRepository = new DependenteRepository(ConnectionFactory.getConnection());
			
			//gravar um funcionario no banco
			funcionarioRepository.create(funcionario);
			
			for(Dependente dependente : funcionario.getDependentes()) {
				
				//antes de gravar cada dependente da lista, associo o dependente ao funcionario criado
				dependente.setFuncionario(funcionario);
				
				//gravar um dependente no banco. Já relacionado ao funcionario
				dependenteRepository.create(dependente);
				
			}
		} else {
			throw new Exception("Funcionário não pode ter mais de 3 dependentes!");
		}
	}
}
