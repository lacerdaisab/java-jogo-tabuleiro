package cefet.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/* classe que junta todos os teste que serao performados */
@RunWith(Suite.class)
@SuiteClasses({ ContaTest.class, JogadorTeste.class, JogoFacadeTest.class, CartasTest.class })
public class AllTests {
}
