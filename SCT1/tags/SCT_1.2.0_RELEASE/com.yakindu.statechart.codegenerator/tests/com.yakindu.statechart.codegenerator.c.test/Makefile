# Name: Makefile
# Author: Joern Seger
# Copyright: 2009 Itemis AG, Joern Seger
# License: GPL

COMPILE = gcc -Wall -O0 -g -I../c-src-gen-his-test -I../environment -ansi -pedantic
COMPILEPP = g++ -Wall -O0 -g -I../c-src-gen-his-test 
MV = mv

all: hisTest grTest afTest runHisTest runGrTest runAfTest

hisTest:
	$(MAKE) -f Makefile.hisTest -C testSuite
	@$(MV) testSuite/testSuite-hisTest .  

grTest:
	$(MAKE) -f Makefile.grTest -C testSuite
	@$(MV) testSuite/testSuite-grTest .  
	
afTest:
	$(MAKE) -f Makefile.afTest -C testSuite
	@$(MV) testSuite/testSuite-afTest .  

clean: hisTestclean grTestclean afTestclean

hisTestclean: 
	$(MAKE) -f Makefile.hisTest -C testSuite clean

grTestclean:
	$(MAKE) -f Makefile.grTest -C testSuite clean
	
afTestclean:
	$(MAKE) -f Makefile.afTest -C testSuite clean

runHisTest:
	@echo
	@echo RUNNING TESTSUITE: HISTORY AND TRANSITION TEST
	@echo
	./testSuite-hisTest 2>&1 | tee hisTest.log
	
runAfTest:
	@echo
	@echo RUNNING TESTSUITE: AFTER-STATEMENT TEST
	@echo
	./testSuite-afTest 2>&1 | tee afTest.log

runGrTest:
	@echo
	@echo RUNNING TESTSUITE: GUARD-STATEMENT TEST
	@echo
	./testSuite-grTest 2>&1 | tee grTest.log

    