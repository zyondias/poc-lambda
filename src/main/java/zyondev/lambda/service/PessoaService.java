package zyondev.lambda.service;

import zyondev.lambda.vo.Pessoa;

import com.amazonaws.regions.RegionUtils;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.google.gson.Gson;

public class PessoaService {

//	private Context context;
	private DynamoDB dynamoDB;

	public PessoaService() {
//		this.context = context;
		AmazonDynamoDBClient client= new AmazonDynamoDBClient();
		client.setRegion(RegionUtils.getRegion(Regions.US_EAST_1.getName()));
		dynamoDB = new DynamoDB(client);
	}

	public void salva(Pessoa pessoa) {
//		context.getLogger().log("inicio para salver pessoa na base");
		Table table = dynamoDB.getTable("pessoas");
		String json = new Gson().toJson(pessoa);
		table.putItem(new Item().withPrimaryKey("id", pessoa.getId()).withJSON("pessoa",
				json));
//		context.getLogger().log("pessoa salva com sucesso: " + pessoa.getApelido());
	}
	public static void main(String[] args) {
		Pessoa stef = new Pessoa();
		stef.setApelido("stef");
		stef.setNome("Stefani Araujo");
		stef.setIdade(22);
		stef.setId(12321);
		PessoaService ps = new PessoaService();
		ps.salva(stef);
	}
}
