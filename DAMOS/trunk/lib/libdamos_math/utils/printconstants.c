/****************************************************************************
 * Copyright (c) 2008, 2011 Andreas Unger and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *    Andreas Unger - initial API and implementation
 ****************************************************************************/

#include <stdio.h>
#include <math.h>

#include "damos/math.h"
#include "damos/internal/mathconstants.h"

int main() {
	int i;

	/*
	 * 32 bit
	 */

	for (i = 31; i >= 0 ; --i) {
		double doubleValue = log(pow(2, i));
		int64_t value = (int64_t) round(doubleValue * pow(2, DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32));
		printf("INT32_C(0x%08lx), /* ln(2^%d) = %f */\n", value, i, doubleValue);
	}

	for (i = 1; i < 32 ; ++i) {
		double doubleValue = log(1.0 + pow(2, -i));
		int64_t value = (int64_t) round(doubleValue * pow(2, DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32));
		printf("INT32_C(0x%08lx), /* ln(1+2^-%d) = %e */\n", value, i, doubleValue);
	}

	for (i = 1; i < 32 ; ++i) {
		double doubleValue = log(1.0 / (1 - pow(2, -i)));
		int64_t value = (int64_t) round(doubleValue * pow(2, DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32));
		printf("INT32_C(0x%08lx), /* ln(1/(1-2^-%d)) = %e */\n", value, i, doubleValue);
	}

	/*
	 * 64 bit
	 */

	for (i = 63; i >= 0 ; --i) {
		double doubleValue = log(pow(2, i));
		int64_t value = (int64_t) round(doubleValue * pow(2, DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64));
		printf("INT64_C(0x%016lx), /* ln(2^%d) = %f */\n", value, i, doubleValue);
	}

	for (i = 1; i < 64 ; ++i) {
		double doubleValue = log(1.0 + pow(2, -i));
		int64_t value = (int64_t) round(doubleValue * pow(2, DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64));
		printf("INT64_C(0x%016lx), /* ln(1+2^-%d) = %e */\n", value, i, doubleValue);
	}

	for (i = 1; i < 64 ; ++i) {
		double doubleValue = log(1.0 / (1 - pow(2, -i)));
		int64_t value = (int64_t) round(doubleValue * pow(2, DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64));
		printf("INT64_C(0x%016lx), /* ln(1/(1-2^-%d)) = %e */\n", value, i, doubleValue);
	}

	return 0;
}
