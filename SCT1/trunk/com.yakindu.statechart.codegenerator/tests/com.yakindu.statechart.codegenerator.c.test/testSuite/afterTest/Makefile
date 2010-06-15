#
# Makefile to create an run all test cases for this project
# 

MKFILE_LIST:=$(wildcard *.mk)

all:
	@for mkFile in $(MKFILE_LIST); \
	do \
	  echo ;\
	  echo "****************************************";\
	  echo ;\
	  echo  Running Makefile $$mkFile; \
	  echo ;\
	  echo  options: $$MAKEFLAGS; \
	  echo ;\
	  echo "****************************************";\
	  $(MAKE) -f $$mkFile; \
	done
#	test_dept $(MKFILE_LIST:%.mk=%_test)

check:
	./test_dept $(MKFILE_LIST:%.mk=%_test) | awk -f analyseError.awk 2>&1 > c_test.xml


clean:
	@rm -f *.o $(MKFILE_LIST:%.mk=%_test) *~ c_test.xml
