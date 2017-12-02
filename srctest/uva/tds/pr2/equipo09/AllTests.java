package uva.tds.pr2.equipo09;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * @author ginquin
 * @author davidgo
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ CoordenadaTDDTest.class, LineaFixtureTDDTest.class, LineaTDDTest.class,
		RedAutobusesFixtureRedConTresLineasDosConCorrespondenciaTDDTest.class,
		RedAutobusesFixtureRedConTresLineasDosConTransbordoDirectoTDDTest.class, RedAutobusesFixtureTDDTest.class,
		RedAutobusesTDDTest.class })
public class AllTests {

}
