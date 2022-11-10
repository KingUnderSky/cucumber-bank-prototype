import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Conta {
	
	/*
	 * Declaração da variável que irá receber o saldo do
	 * cliente nos cenários
	 */
	int saldo;
	
	/*
	 * Declaração da variável que irá receber o saque efetuado
	 * pelo cliente nos cenários
	 */
	int saque;

	/*
	 * Declaração da variável que irá indicar se o cliente é
	 * do tipo especial
	 */
	boolean clienteEspecial = false;
	
	public int getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getSaque() {
		return saque;
	}

	public void setSaque(int saque) {
		this.saque = saque;
	}

	public boolean isClienteEspecial() {
		return clienteEspecial;
	}

	public void setClienteEspecial(boolean clienteEspecial) {
		this.clienteEspecial = clienteEspecial;
	}

	
	/* 
	 * Inicio do primeiro cenário: Cliente especial
	 * 
	 * @param int1 é o primeiro parâmetro de teste, referente ao saldo atual do cliente especial
	 * Nesse método, esperasse que o cliente seja do tipo especial e que o saldo seja um inteiro
	 */
	@Given("Um cliente especial com saldo atual de {int} reais")
	public void um_cliente_especial_com_saldo_atual_de_reais(Integer int1) {
		this.saldo = int1;
		if(this.clienteEspecial != true || !(int1 instanceof Integer))
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * @param int2 é o segundo parâmetro de teste, referente ao valor de saque efetuado pelo cliente especial
	 * Nesse método, esperasse que o valor recebido seja um inteiro
	 */	
	@When("for solicitado um saque no valor de {int} reais")
	public void for_solicitado_um_saque_no_valor_de_reais(Integer int2) {
		this.saque = int2;
		if(!(int2 instanceof Integer))
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * @param int3 é o terceiro parâmetro de teste, referente ao valor que irá restar de saldo
	 * do cliente especial após subtrair o saldo recebido antes pelo valor de saque
	 * Nesse método, esperasse que o valor de saldo seja subtraido do saque e que o resultado seja igual ao
	 * int3, e que o int3 seja um número inteiro
	 */
	@Then("deve efetuar o saque e atualizar o saldo da conta para {int} reais")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(Integer int3) {
		if(int3 instanceof Integer)
		{
			setSaldo(getSaldo() - getSaque());
			if(getSaldo() != int3)
				throw new io.cucumber.java.PendingException();
		} else
			throw new io.cucumber.java.PendingException();
	}

	/* 
	 * Inicio do segundo cenário: Cliente comum
	 * 
	 * @param int4 é o quarto parâmetro de teste, referente ao saldo atual do cliente comum
	 * Nesse método, esperasse que o valor seja um inteiro e que o cliente seja do tipo comum
	 */
	@Given("Um cliente comum com saldo atual de {int} reais")
	public void um_cliente_comum_com_saldo_atual_de_reais(Integer int4) {
		this.saldo = int4;
		if(this.clienteEspecial == true || !(int4 instanceof Integer))
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * @param int5 é o quinto parâmetro de teste, referente ao valor de saque efetuado pelo cliente comum
	 * Nesse método, esperasse que o valor recebido seja um inteiro
	 */
	@When("solicitar um saque de {int} reais")
	public void solicitar_um_saque_de_reais(Integer int5) {
		this.saque = int5;
		if(!(int5 instanceof Integer))
			throw new io.cucumber.java.PendingException();
	}

	/*
	 * Nesse método, esperasse que o cliente seja do tipo normal, se o saldo for menor que
	 * o valor de saque, deve ser retornado uma mensagem de "Saldo Insuficiente".
	 */
	
	@Then("Não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_saldo_insuficiente() {
		if(!(getSaldo() > 0) && (getSaque() < getSaldo()))
			throw new io.cucumber.java.PendingException();
		if(getSaque() >= getSaldo())
			System.out.println("Saldo Insuficiente");
	}
}
