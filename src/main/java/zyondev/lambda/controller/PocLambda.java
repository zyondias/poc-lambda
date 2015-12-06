package zyondev.lambda.controller;

import zyondev.lambda.service.PessoaService;
import zyondev.lambda.vo.Pessoa;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class PocLambda implements RequestHandler<Pessoa, String> {
	
	private PessoaService pessoaService;

	/***
	 * Implmentando metodo que será chamado pela lambda da aws
	 */
	public String handleRequest(Pessoa person, Context context) {
		// utilizando esse log do contexto ele aparece no console da aws dentro
		// do CloudWatch
		context.getLogger().log(
				"testando log chegou novo usuario: " + person.getApelido());
		
		//salvando pessoa no banco de dados
		getPessoaService(context).salva(person);
		
		return "criado com sucesso usando interface: " + person.getNome();
	}
	
	private PessoaService getPessoaService(Context context){
		if(pessoaService == null){
			context.getLogger().log("Criando uma nova instancia de Pessoa Service");
			pessoaService = new PessoaService(context);
		}else
			context.getLogger().log("NAO NECESSARIO criar instancia de Pessoa Service");
		return pessoaService;
	}

	/***
	 * Metodo deprecado, utilizado por lambda de moco que tem q escrever o nome
	 * do metodo dentro da configuracao da amazon na hora de criar a lambda
	 * fazendo implementacao da interface RequestHandler iss não é mais
	 * necessario
	 * 
	 * @param person
	 * @param context
	 * @return
	 */
	@Deprecated
	public String myHandler(Pessoa person, Context context) {
		return "criado com sucesso usando: " + person.getNome();
	}
}
