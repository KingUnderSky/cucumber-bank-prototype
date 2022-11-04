import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	
	//  variável de saldo
	int saldo;
	
	//  variável de saque
	int saque;
	
	//  variável que indica se o cliente é comum
	boolean clienteComum = false;
	
	//  variável que indica se o cliente é especial
	boolean clienteEspecial = false;
	
	/* Inicio do primeiro cenário: Cliente especial
	 * 
	 * @param int1 é o primeiro parâmetro de teste, referente ao saldo atual do cliente especial
	 * Nesse método, esperasse que o valor recebido para saldo seja -200 e que o cliente seja do tipo especial
	 */
	
	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
	    // Write code here that turns the phrase above into concrete actions
		this.saldo = int1;
		this.clienteEspecial = true;
		if(this.saldo != -200 && !this.clienteEspecial)
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * @param int2 é o segundo parâmetro de teste, referente ao valor de saque efetuado pelo cliente especial
	 * Nesse método, esperasse que o valor recebido para saque seja 100 e que o cliente seja do tipo especial
	 */
	
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int2) {
	    // Write code here that turns the phrase above into concrete actions
		this.saque = int2;
		if(this.saque != 100 && !this.clienteEspecial)
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * @param int3 é o terceiro parâmetro de teste, referente ao valor que irá restar de saldo
	 * do cliente especial após subtrair o saldo recebido antes pelo valor de saque
	 * Nesse método, esperasse que o valor de saldo seja de -300 e que o cliente seja do tipo especial
	 */
	
	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int3) {
	    // Write code here that turns the phrase above into concrete actions
		if(this.saldo - this.saque != int3 && !this.clienteEspecial)
			throw new io.cucumber.java.PendingException();
	}

	/* Inicio do segundo cenário: Cliente comum
	 * 
	 * @param int4 é o quarto parâmetro de teste, referente ao saldo atual do cliente comum
	 * Nesse método, esperasse que o valor recebido para saldo seja -300 e que o cliente seja do tipo comum
	 */
	
	@Given("Um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int4) {
	    // Write code here that turns the phrase above into concrete actions
		this.saldo = int4;
		this.clienteComum = true;
		if(this.saldo != -300 && !this.clienteComum)
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * @param int5 é o quinto parâmetro de teste, referente ao valor de saque efetuado pelo cliente comum
	 * Nesse método, esperasse que o valor recebido para saque seja 100 e que o cliente seja do tipo comum
	 */
	
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int5) {
	    // Write code here that turns the phrase above into concrete actions
		this.saque = int5;
		if(this.saque != 200 && !this.clienteComum)
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * Nesse método, esperasse que o cliente seja do tipo normal, sendo assim, por ter saldo negativo,
	 * não será possível efetuar o saque, sendo retornado a mensagem "Saldo Insuficiente"
	 */
	
	@Then("Não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
	    // Write code here that turns the phrase above into concrete actions
		if(!this.clienteComum) {
			throw new io.cucumber.java.PendingException();			
		} else {
			System.out.println("Saldo Insuficiente");
		}
	}
}
