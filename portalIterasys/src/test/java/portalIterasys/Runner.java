package portalIterasys;

import java.io.File;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import com.cucumber.listener.Reporter;

@RunWith (Cucumber.class)
@CucumberOptions(
		dryRun = false,
		monochrome = true,
		features = { "src/test/resources/" }, // caminho para o .feature
		glue =     { "/" }, // caminho para o .java
		plugin =   { "pretty", 
				     "html:target/relatorio1",
				     "json:target/relatorio1.json",
				     "com.cucumber.listener.ExtentCucumberFormatter:target/relatorio2/dashboard.html"}
		
		
		)


public class Runner {
	@AfterClass
	public static void writeExtentReport() {
		Reporter.loadXMLConfig(new File ("config/report.xml"));
	}

}
