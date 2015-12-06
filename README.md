#Objetivo
Esse poc tem como ideia mostar como utlizar o serviço da aws de Lambda
Mostrando como implementar e utilizar seus recursos

#SetUp
O SetUp Inicial do projeto foi criando um projeto simples do maven
e depois colocando as dependencias dentro do pom.xml do lambda 
<pre>
   &lt;dependency&gt;
  		&lt;groupId&gt;com.amazonaws&lt;/groupId&gt;
  		&lt;artifactId&gt;aws-lambda-java-core&lt;/artifactId&gt;
  		&lt;version&gt;1.1.0&lt;/version&gt;
  	&lt;/dependency&gt;
</pre>

em seguida colocar o plugin de build tambem é inserido dentro do pom.xml 
<pre>
  &lt;build&gt;
  	&lt;plugins&gt;
  		&lt;plugin&gt;
  			&lt;groupId&gt;org.apache.maven.plugins&lt;/groupId&gt;
  			&lt;artifactId&gt;maven-shade-plugin&lt;/artifactId&gt;
  			&lt;version&gt;2.3&lt;/version&gt;
  		&lt;/plugin&gt;
  	&lt;/plugins&gt;
  &lt;/build&gt;
</pre>

#CODIFICANDO

Com as dependencias OK você pode criar uma class implementando a interface RequestHandler<T,T>
Passando como primeiro parametro o tipo de objeto que você ira receber e no segundo o tipo de objeto da resposta.
Exemplo: https://github.com/zyondias/poc-lambda/blob/master/src/main/java/zyondev/lambda/controller/PocLambda.java


#Build & deploy

Para gerar o pacote jar, basta executar o maven utilizando "package shade:shade".
Feito isso va para console da AWS para criar uma nova lambda ou editar a já existente, faça upload do pacote jar, e nas configurações,

*Handler:* coloque o caminho da class onde você implementou a interface por exemplo "zyondev.lambda.controller.PocLambda"

*Role:* crie uma role padrão como sugerido pela aws


#Referencias
http://docs.aws.amazon.com/lambda/latest/dg/java-handler-using-predefined-interfaces.html
http://docs.aws.amazon.com/lambda/latest/dg/java-create-jar-pkg-maven-and-eclipse.html

