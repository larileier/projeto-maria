import static org.junit.Assert.fail;

import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import br.senai.sc.edu.projetomaria.service.CargaService;


// HU1 - BDD 5

class HU1CargaCanalTest {

	static CargaService service = null;

//	@BeforeAll
//	static void path() {
//		service = new CargaService();
//		ClassLoader classLoader = HU1CargaCanalTest.class.getClassLoader();
//		Path p = null;
//		try {
//			p = Paths.get(classLoader.getResource("dataset/carga-canal-fora-padrao.csv").toURI());
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			service.insertCanal(p);
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}

	@Test
	void insertCanal() {
		ClassLoader classLoader = getClass().getClassLoader();
		Path p = null;
		try {
			p = Paths.get(classLoader.getResource("dataset/carga-canal-fora-padrao.csv").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			service.insertCanal(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void insertCanal2() {
		ClassLoader classLoader = getClass().getClassLoader();
		Path p = null;
		try {
			p = Paths.get(classLoader.getResource("dataset/carga-canal-fora-padrao-certo.csv").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			service.insertCanal(p);
		} catch (SQLException e) {
		}
	}
}



// HU2 - BDD 9

class HU2CargaHistoricoTest {

	static CargaService service = null;

	@BeforeAll

	static void path() {
		service = new CargaService();
		ClassLoader classLoader = HU1CargaCanalTest.class.getClassLoader();
		Path p = null;
		try {
			p = Paths.get(classLoader.getResource("dataset/carga_historico_insert.csv").toURI());
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			service.insertCanal(p);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Path mp = null;
		try {
			mp = Paths.get(classLoader.getResource("dataset/carga/produto/insert.csv").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		service.insertProduto(mp);
	}

	@Test
	void insertLinhaBranco() {
		service = new CargaService();

		ClassLoader classLoader = getClass().getClassLoader();
		Path p = null;
		try {
			p = Paths.get(classLoader.getResource("dataset/carga_historico_insert.csv").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			service.insertCanal(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Test
	void insertLinhaBranco2() {
		service = new CargaService();

		ClassLoader classLoader = getClass().getClassLoader();
		Path p = null;
		try {
			p = Paths.get(classLoader.getResource("dataset/carga_historico_insert_certo.csv").toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			service.insertCanal(p);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}