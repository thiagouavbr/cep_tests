import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;



public class RestAssuredAPI_T1 {

	@Test
	public void test1() {

		Response response = RestAssured.get("https://viacep.com.br/ws/91060900/json/");
		System.out.println(response.jsonPath().getString("cep"));
		System.out.println("Logradouro: "+response.jsonPath().getString("logradouro"));
		System.out.println(response.jsonPath().getString("complemento"));
		System.out.println(response.jsonPath().getString("bairro"));
		System.out.println(response.jsonPath().getString("localidade"));
		System.out.println(response.jsonPath().getString("uf"));
		System.out.println(response.jsonPath().getString("ibge"));


	}


	@Test
	public void test2() {

		given().get("https://viacep.com.br/ws/910600900/json/").then().statusCode(400);
	}

	@Test
	public void test3() {

		given().get("https://viacep.com.br/ws/910600888888900/json/").then().statusCode(400);
	}

	@Test
	public void test4() {

		given().get("https://viacep.com.br/ws/RS/Gravatai/Barroso/json/").then().statusCode(200).body("[0].cep", equalTo("94085-170"));
		given().get("https://viacep.com.br/ws/RS/Gravatai/Barroso/json/").then().statusCode(200).body("[1].cep", equalTo("94175-000"));

	}

}

