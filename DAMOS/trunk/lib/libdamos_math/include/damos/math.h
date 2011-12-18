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

#ifndef DAMOS_MATH_H_
#define DAMOS_MATH_H_

#include <stdint.h>

#ifdef __cplusplus
extern "C" {
#endif

int32_t DamosMath_mulfix32(int32_t a, int32_t b, int fractionLength);

int32_t DamosMath_expfix32(int32_t x, int fractionLength);
int64_t DamosMath_expfix64(int64_t x, int fractionLength);

int32_t DamosMath_lnfix32(int32_t x, int fractionLength);
int64_t DamosMath_lnfix64(int64_t x, int fractionLength);
int32_t DamosMath_lgfix32(int32_t x, int fractionLength);
int32_t DamosMath_lgfix3264(int32_t x, int fractionLength);
int64_t DamosMath_lgfix64(int64_t x, int fractionLength);
int32_t DamosMath_lbfix32(int32_t x, int fractionLength);
int32_t DamosMath_lbfix3264(int32_t x, int fractionLength);
int64_t DamosMath_lbfix64(int64_t x, int fractionLength);

int32_t DamosMath_powfix32(int32_t base, int32_t exponent, int fractionLength);
int32_t DamosMath_powfix3264(int32_t base, int32_t exponent, int fractionLength);
int64_t DamosMath_powfix64(int64_t base, int64_t exponent, int fractionLength);

int32_t DamosMath_sinfix32(int32_t x, int fractionLength);
int64_t DamosMath_sinfix64(int64_t x, int fractionLength);
int32_t DamosMath_cosfix32(int32_t x, int fractionLength);
int64_t DamosMath_cosfix64(int64_t x, int fractionLength);
int32_t DamosMath_tanfix32(int32_t x, int fractionLength);
int64_t DamosMath_tanfix64(int64_t x, int fractionLength);

#ifdef __cplusplus
}
#endif

#endif /* DAMOS_MATH_H_ */
