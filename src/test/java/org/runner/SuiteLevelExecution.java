package org.runner;

import org.execution.CheckYourCartPageValidation;
import org.execution.FictionPageValidation;
import org.execution.LoginPageValidation;
import org.execution.MyShoppingcartPageValidation;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({

	LoginPageValidation.class,
	FictionPageValidation.class,
	MyShoppingcartPageValidation.class,
	CheckYourCartPageValidation.class

})

public class SuiteLevelExecution {

}
