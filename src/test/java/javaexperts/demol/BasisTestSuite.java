package javaexperts.demol;

import javaexperts.demol.dao.*;
import org.junit.experimental.categories.Categories;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Categories.class)
@Categories.ExcludeCategory(Geavanceerd.class)
@Suite.SuiteClasses({ AfleveringDaoTest.class, AntwoordDaoTest.class, KandidaatDaoTest.class, OpdrachtDaoTest.class, VraagDaoTest.class })
public class BasisTestSuite {
}
