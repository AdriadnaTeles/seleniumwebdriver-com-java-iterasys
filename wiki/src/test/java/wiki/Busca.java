package wiki;

import static org.junit.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;



@RunWith(Parameterized.class)
public class Busca {
	//Atributos
	String url;
	WebDriver driver ;
	static String pastaFoto = new SimpleDateFormat("yyyy-MM-dd hh-mm-ss").format(Calendar.getInstance().getTime());

	
	//Métodos de Apoio
	
	//Atributo da Massa de Teste
	
	
	
	// Método para tirar print (screenshot)
	public void print(String nomeFoto) throws IOException {
		File foto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(foto, new File("C:\\Users\\ROBSON\\eclipse\\CursoSeleniumWebDriverprojeto2\\wiki\\target\\" + pastaFoto + "\\" + nomeFoto +".png"));
		
		
		
	}
	
	//Método para ler um arquivo CSV - Comma Separeted Values
	
	//Atributos da Massa de TEste 
	
	String id;
	String termo;
	String resultado;
	String tipo;
	String browser;
	
	
	
	
	//Construtor para a leitura dos campos, clica com o botaão direito >Source>Generating constructor using fields

	public Busca(String id, String termo, String resultado, String tipo, String browser) {
		this.id = id;
		this.termo = termo;
		this.resultado = resultado;
		this.tipo = tipo;
		this.browser = browser;
	}
	@Parameters
	// Coleção que informa o local e o nome do arquivo da massa
	public static Collection <String[]> lerArquivo() throws IOException {
		//Chamar a coleção lerCSV e passar o caminho e o nome da massa
		return lerCSV("C:\\Users\\ROBSON\\eclipse\\CursoSeleniumWebDriverprojeto2\\wiki\\db\\massaWiki.csv");
	}
	public static Collection <String[]> lerCSV(String nomeMassa)throws IOException {
		//Realmente lê o arquivo massaWiki.csv, repete a quantidade de linhas que tem no arquivo.
				String linha;
				List<String[]> dados = new ArrayList<String[]>();
				BufferedReader arquivo = new BufferedReader(new FileReader(nomeMassa));
				while ((linha = arquivo.readLine()) !=null ) {
					String campos[] = linha.split(";");
					dados.add(campos);
				}
				arquivo.close();
				return dados;
	}
		
	
	//Método de Inicialização
	@Before
	public void iniciar() {
		url = "https://pt.wikipedia.org";
		System.setProperty("webdriver.chrome.driver", 
				"C:\\Users\\ROBSON\\eclipse\\CursoSeleniumWebDriverprojeto2\\wiki\\drivers\\chromedriver.exe");
		         driver = new ChromeDriver();
		         driver.manage().window().maximize();
		         driver.manage().timeouts().implicitlyWait(60000, TimeUnit.MILLISECONDS);
		
	}
    @After
    public void finalizar() {
    	driver.quit();
    }
    	
    	@Test
    	public void buscar() throws IOException{
    		driver.get(url);//abrir o navegador na página
    		driver.findElement(By.id("searchInput")).sendKeys(termo);
    		//tirar um print
    		print("Passo 1 - Consulta pelo Termo");
    		driver.findElement(By.id("searchInput")).sendKeys(Keys.ENTER);
    		
    		
    		assertEquals(resultado, driver.findElement(By.id("firstHeading")).getText());
    		print("Passo 2 - Valida o REsultado");		
    	
}
    	

}  

