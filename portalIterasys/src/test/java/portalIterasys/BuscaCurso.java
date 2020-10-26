package portalIterasys;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;


public class BuscaCurso {
	String url;
	WebDriver driver;
	
	@Before
	public void iniciar() {
		url = "http://www.iterasys.com.br/";
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\ROBSON\\eclipse\\CursoSeleniumWebDriverprojeto2\\portalIterasys\\drivers\\chromedriver.exe");
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		 driver.manage().window().maximize();
	}
	@After
	public void finalizar() {
		driver.quit();
		
	}
	
	@Dado("que acesso o site da Iterasys")
	public void que_acesso_o_site_da_Iterasys() throws Throwable {
		driver.get(url);
		
		System.out.println("Passo 1 - Abriu o site da Iterasys");
	    
	}

	@Quando("consulto  pelo  curso {string}")
	public void consulto_pelo_curso(String termo) throws Throwable {
		driver.findElement( By.cssSelector(".cc-compliance a")).click();
		driver.findElement(By.id("searchtext")).sendKeys(termo);
		driver.findElement(By.id("searchtext")).clear();
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(termo));
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
		System.out.println("Passo 2 - Consultou o curso");
		
	    
	}

	@Entao("exibe uma lista com curso {string}")
	public void exibe_uma_lista_com_curso(String termo) throws Throwable {
		assertEquals("Cursos › \"" + termo + "\"", driver.findElement(By.cssSelector("div h3")).getText());
		assertEquals("MATRICULE-SE  ",driver.findElement(By.cssSelector("span.comprar")).getText()); 
		System.out.println("Passo 3 - Exibiu o curso na lista");
	   
	}

	@Quando("clico em Matricule-se")
	public void clico_em_Matricule_se() throws Throwable {
		driver.findElement(By.cssSelector("span.comprar")).click();
		System.out.println("Passo 4 - Clicou em Matricule-se");
	   
	}

	@Entao("exibe o titulo {string} e o valor {string}")
	public void exibe_o_titulo_e_o_valor(String titulo, String valor)throws Throwable {
	assertEquals(titulo, driver.findElement (By.cssSelector("span.item-title")).getText());
	assertEquals(valor, driver.findElement (By.className("new-price")).getText());
	System.out.println("Passo 5 - Exibiu o título e o valor do curso");
		
	}
		
	@Entao("exibe mensagem que o  curso {string} nao foi encontrado")
	public void exibe_mensagem_que_o_curso_nao_foi_encontrado(String termo) {
		assertEquals("Cursos › \"" + termo + "\"", driver.findElement(By.cssSelector("div h3")).getText());
		assertEquals("Desculpe não encontramos o curso que procura =(   Conheça nossos Cursos", driver.findElement(By.className("alert-warning")).getText());
		assertTrue(driver.findElement(By.className("alert-warning")).getText().contains("Desculpe não encontramos o curso"));
		System.out.println("Passo 3e  - Exibiu a mensagem de curso nao encontrado");
	}
	
	
	@Quando("consulto  pelo  {string}")
	public void consulto_pelo(String curso) {
		driver.findElement( By.cssSelector(".cc-compliance a")).click();
		driver.findElement(By.id("searchtext")).sendKeys(curso);
		driver.findElement(By.id("searchtext")).clear();
		driver.findElement(By.id("searchtext")).sendKeys(Keys.chord(curso));
		driver.findElement(By.id("searchtext")).sendKeys(Keys.ENTER);
		System.out.println("Passo 2 - Consultou o curso");
	    
	}

	@Entao("exibe uma lista com {string}")
	public void exibe_uma_lista_com(String curso) throws Throwable {
		assertEquals("Cursos › \"" + curso + "\"", driver.findElement(By.cssSelector("div h3")).getText());
		assertEquals("MATRICULE-SE  ",driver.findElement(By.cssSelector("span.comprar")).getText()); 
		System.out.println("Passo 3 - Exibiu o curso na lista");
	    
	}

	@Entao("exibe o titulo {string} e o {string}") 
		public void exibe_o_titulo_e_o(String curso, String valor) throws Throwable {
			assertEquals(curso, driver.findElement (By.cssSelector("span.item-title")).getText());
			assertEquals(valor, driver.findElement (By.className("new-price")).getText());
			System.out.println("Passo 5 - Exibiu o título e o valor do curso");
	}
	
	}
	
