package com.goc.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

/**
 * Test Suite to run all the test cases available for Game of Cards at one go.
 * 
 * @author denniskbijo
 *
 */
@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Game Of Cards Test Suite")
@SelectPackages("com.goc.test.game")
public class AllTestsSuite {

}
