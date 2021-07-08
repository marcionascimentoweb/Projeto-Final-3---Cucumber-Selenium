package tests;

import static org.junit.Assert.assertEquals;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import cucumber.api.java.pt.Dado;
import cucumber.api.java.pt.Ent�o;
import cucumber.api.java.pt.Quando;

public class CadastrarClientes {
	
	WebDriver driver;

	@Dado("^Acessar a p�gina de cadastro do cliente$")
	public void acessar_a_p�gina_de_cadastro_do_cliente() {
		System.setProperty("webdriver.chrome.driver", "c:\\drivers\\chromedriver.exe");
	    driver = new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.get("http://prjfinalteste-001-site1.ctempurl.com/Home/Exercicio03");
	}

	@Dado("^Informar o nome do Funcion�rio \"([^\"]*)\"$")
	public void informar_o_nome_do_Funcion�rio(String nome) {
	    driver.findElement(By.id("Nome")).sendKeys(nome);
	}

	@Dado("^Informar o rg do cliente \"([^\"]*)\"$")
	public void informar_o_rg_do_cliente(String rg) {
		driver.findElement(By.id("RG")).sendKeys(rg);
	}

	@Dado("^Informar o CPF do do cliente \"([^\"]*)\"$")
	public void informar_o_CPF_do_do_cliente(String cpf) {
		driver.findElement(By.id("Cpf")).sendKeys(cpf);
	}

	@Dado("^Informar a data de Nascimento do cliente (.*)$")
	public void informar_a_data_de_Nascimento_do_cliente(String data) {
		driver.findElement(By.id("DataNascimento")).sendKeys(data);
	}

	@Dado("^Selecione o tipo de processo seletivo (.*)$")
	public void selecione_o_tipo_de_processo_seletivo(String tipo) {
		new Select(driver.findElement(By.id("ProcessoInscricao"))).selectByVisibleText(tipo);
	}

	@Quando("^Solicitar realiza��o da inscri��o$")
	public void solicitar_realiza��o_da_inscri��o() {
	    driver.findElement(By.xpath("//*[@id=\"btnCadastro\"]")).click();
	}

	@Ent�o("^Sistema informar� a mensagem de sucesso$")
	public void sistema_informar�_a_mensagem_de_sucesso() {
		String mensagem = driver.findElement(By.xpath("//*[@id=\"mensagem\"]")).getText();
	    assertEquals(mensagem, "Processo realizado com sucesso");
	    
	  //evidencias
	    try {
	    	File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(evidencia, new File("E:\\marcio_2021\\coti_Informatica\\Teste_Software_Sergio\\projeto_Final\\tarefa3\\evidencias\\tarefa3.png"));
	    }
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
	}

	@Ent�o("^Sistema informar� que precisam preencher todos os campos$")
	public void sistema_informar�_que_precisam_preencher_todos_os_campos() {
	   
		String nomeBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[1]/div/span")).getText();
		String rgBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[2]/div/span")).getText();
		String cpfBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[3]/div/span")).getText();
		String dataBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[4]/div/span")).getText();
		String tipoBranco = driver.findElement(By.xpath("/html/body/div/div[2]/form/div/div[5]/div/span")).getText();
		
		assertEquals(nomeBranco, "Campo obrigat�rio");
		assertEquals(rgBranco, "Campo obrigat�rio");
		assertEquals(cpfBranco, "Campo obrigat�rio");
		assertEquals(dataBranco, "Campo obrigat�rio");
		assertEquals(tipoBranco, "Campo obrigat�rio");
		
		 //evidencias
	    try {
	    	File evidencia = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
	    	FileUtils.copyFile(evidencia, new File("E:\\marcio_2021\\coti_Informatica\\Teste_Software_Sergio\\projeto_Final\\tarefa3\\evidencias\\tarefa3_Dados_Branco.png"));
	    }
	    catch(Exception e) {
	    	System.out.println(e.getMessage());
	    }
		
	}


}