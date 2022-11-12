import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

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
	boolean clienteEspecial;
	
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
	@Given("^Um cliente especial com saldo atual de -(\\d+) reais$")
	public void um_cliente_especial_com_saldo_atual_de_reais(int int1) throws Throwable {
		setSaldo(int1 * -1);
		setClienteEspecial(true);
		if(this.clienteEspecial != true)
			throw new PendingException();
	}

	/*
	 * @param int2 é o segundo parâmetro de teste, referente ao valor de saque efetuado pelo cliente especial
	 * Nesse método, esperasse que o valor recebido seja um inteiro
	 */	
	@When("^for solicitado um saque no valor de (\\d+) reais$")
	public void for_solicitado_um_saque_no_valor_de_reais(int int2) throws Throwable {
		setSaque(int2);
	}

	/*
	 * @param int3 é o terceiro parâmetro de teste, referente ao valor que irá restar de saldo
	 * do cliente especial após subtrair o saldo recebido antes pelo valor de saque
	 * Nesse método, esperasse que o valor de saldo seja subtraido do saque e que o resultado seja igual ao
	 * int3, e que o int3 seja um número inteiro
	 */
	@Then("^deve efetuar o saque e atualizar o saldo da conta para -(\\d+) reais$")
	public void deve_efetuar_o_saque_e_atualizar_o_saldo_da_conta_para_reais(int int3) throws Throwable {
		setSaldo(getSaldo() - getSaque());
		if(getSaldo() != (int3 * -1))
			throw new PendingException();
	}

	/* 
	 * Inicio do segundo cenário: Cliente comum
	 * 
	 * @param int4 é o quarto parâmetro de teste, referente ao saldo atual do cliente comum
	 * Nesse método, esperasse que o valor seja um inteiro e que o cliente seja do tipo comum
	 */
	@Given("^Um cliente comum com saldo atual de (\\d+) reais$")
	public void um_cliente_comum_com_saldo_atual_de_reais(int int4) throws Throwable {
		setSaldo(int4);
		setClienteEspecial(false);
		if(isClienteEspecial())
			throw new PendingException();
	}

	/*
	 * @param int5 é o quinto parâmetro de teste, referente ao valor de saque efetuado pelo cliente comum
	 * Nesse método, esperasse que o valor recebido seja um inteiro
	 */
	@When("^solicitar um saque de (\\d+) reais$")
	public void solicitar_um_saque_de_reais(int int5) throws Throwable {
		setSaque(int5);
	}

	/*
	 * Nesse método, esperasse que o cliente seja do tipo normal, se o saldo for menor que
	 * o valor de saque, deve ser retornado uma mensagem de "Saldo Insuficiente".
	 */
	@Then("^Não deve efetuar o saque e deve retornar a mensagem Saldo Insuficiente$")
	public void não_deve_efetuar_o_saque_e_deve_retornar_a_mensagem_Saldo_Insuficiente() throws Throwable {
		if(getSaldo() < 0)
			throw new PendingException();
		if(getSaque() > getSaldo())
			System.out.println("Saldo Insuficiente");
	}
}
