package cefet.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


/**
 * 
 * class that gathers all tests to be performed
 * @author joana
 */
@RunWith(Suite.class)
@SuiteClasses({ ContaTest.class, JogadorTeste.class, JogoFacadeTest.class, CartasTest.class })
public class AllTests {

}
