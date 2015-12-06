package zyondev.lambda;

import zyondev.lambda.vo.Pessoa;

import com.amazonaws.services.lambda.runtime.Context;

public class PocLambda {

	public String myHandler(Pessoa person, Context context) {
		return "criado com sucesso: " + person.getNome();
	}
}
