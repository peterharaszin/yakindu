# Copyright 2008 Mattias Norrby
#
# This file is part of Test Dept..
#
# Test Dept. is free software: you can redistribute it and/or modify
# it under the terms of the GNU General Public License as published by
# the Free Software Foundation, either version 3 of the License, or
# (at your option) any later version.
#
# Test Dept. is distributed in the hope that it will be useful,
# but WITHOUT ANY WARRANTY; without even the implied warranty of
# MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
# GNU General Public License for more details.
#
# You should have received a copy of the GNU General Public License
# along with Test Dept..  If not, see <http://www.gnu.org/licenses/>.

# An example project using test_dept in its cstub form

# Basic definitions for the project to be able to build
CC=gcc
LD=$(CC)

VPATH=../../c-src-gen-af-test

#You can remove these when an installation of Test Dept. is made on your system
#include test-dept.mk

# All test cases reside in TEST_SRCS
TEST_SRCS=sm_afterTest_enter_test.c
CFLAGS:=$(CFLAGS) -I. -I../ -I../../c-src-gen-af-test
# A file which declares all possible stub functions

# Dependencies for each test binary. Should be self explanatory
sm_afterTest_enter_test:	afterTest_Handle.o afterTest_Iface.o afterTest_timerIface.o sm_afterTest.o afterTest.o

check:	test_dept_run

clean:
	rm -f *.o *_test main_*.c *_stubs.* *~

# Rules for making test binaries reside here
include test-dept-rudimentary.mk


