//package com.jurdox;
//
//import org.apache.log4j.Logger;
//
//public class Test {
//
//	final static Logger logger = Logger.getLogger(Test.class);
//
//	@Before
//	public void setUp() {
//		logger.info("Before every test !");
//	}
//
//	@After
//	public void tearDown() {
//		logger.info("After every test !");
//	}
//
//	@BeforeClass
//	public static void setupOnce() {
//		logger.info("Before class !");
//	}
//
//	@AfterClass
//	public static void shutDown() {
//		logger.info("After class !");
//	}
//
//	@Test
//	public void testExample() {
//		logger.info("starting test !");
//		logger.info("this is empty test !");
//	}
//
//}
