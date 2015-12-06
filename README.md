#Objetivo
Esse poc tem como ideia mostar como utlizar o serviço da aws de Lambda
Mostrando como implementar e utilizar seus recursos

#SetUp
O SetUp Inicial do projeto foi criando um projeto simples do maven
e depois colocando as dependencias dentro do pom.xml do lambda 
<code>
   <dependency>
  		<groupId>com.amazonaws</groupId>
  		<artifactId>aws-lambda-java-core</artifactId>
  		<version>1.1.0</version>
  	</dependency>
</code>

em seguida colocar o plugin de build tambem é inserido dentro do pom.xml 
<code>
  <build>
  	<plugins>
  		<plugin>
  			<groupId>org.apache.maven.plugins</groupId>
  			<artifactId>maven-shade-plugin</artifactId>
  			<version>2.3</version>
  		</plugin>
  	</plugins>
  </build>
</code>

#CODIFICANDO

Com as dependencias OK você pode criar uma class implementando a interface RequestHandler<T,T>
Passando como primeiro parametro o tipo de objeto que você ira receber e no segundo o tipo de objeto da resposta.
Exemplo: https://github.com/zyondias/poc-lambda/blob/master/src/main/java/zyondev/lambda/controller/PocLambda.java


#Build & deploy

Para gerar o pacote jar, basta executar o maven utilizando "package shade:shade".
Feito isso va para console da AWS para criar uma nova lambda ou editar a já existente, faça upload do pacote jar, e nas configurações,

*Handler:* coloque o caminho da class onde você implementou a interface por exemplo "zyondev.lambda.controller.PocLambda"

*Role:* crie uma role padrão como sugerido pela aws

