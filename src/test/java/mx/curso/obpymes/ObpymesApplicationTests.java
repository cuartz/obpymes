package mx.curso.obpymes;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.mx.santander.lh.obpymes.ObpymesApplication;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ObpymesApplication.class)
@WebAppConfiguration
public class ObpymesApplicationTests {

	@Test
	public void contextLoads() {
	}

}
