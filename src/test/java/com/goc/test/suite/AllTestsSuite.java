package com.goc.test.suite;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Game Of Cards Test Suite")
@SelectPackages("com.goc.test")
public class AllTestsSuite {

}
