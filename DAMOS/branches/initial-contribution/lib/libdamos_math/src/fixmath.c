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

#include "damos/math.h"
#include "damos/internal/mathconstants.h"

#define DAMOS_MATH_PI INT32_C(0x3243f6a9)
#define DAMOS_MATH_TWO_PI INT32_C(0x6487ed51)
#define DAMOS_MATH_HALF_PI INT32_C(0x1921fb54)
#define DAMOS_MATH_QUARTER_PI INT32_C(0x0c90fdaa)

static const int32_t logTwoPowerNReversed32[] = {
	INT32_C(0x55f3439c), /* ln(2^31) = 21.487563 */
	INT32_C(0x532d7b3c), /* ln(2^30) = 20.794415 */
	INT32_C(0x5067b2dc), /* ln(2^29) = 20.101268 */
	INT32_C(0x4da1ea7c), /* ln(2^28) = 19.408121 */
	INT32_C(0x4adc221d), /* ln(2^27) = 18.714974 */
	INT32_C(0x481659bd), /* ln(2^26) = 18.021827 */
	INT32_C(0x4550915d), /* ln(2^25) = 17.328680 */
	INT32_C(0x428ac8fd), /* ln(2^24) = 16.635532 */
	INT32_C(0x3fc5009d), /* ln(2^23) = 15.942385 */
	INT32_C(0x3cff383d), /* ln(2^22) = 15.249238 */
	INT32_C(0x3a396fdd), /* ln(2^21) = 14.556091 */
	INT32_C(0x3773a77d), /* ln(2^20) = 13.862944 */
	INT32_C(0x34addf1e), /* ln(2^19) = 13.169796 */
	INT32_C(0x31e816be), /* ln(2^18) = 12.476649 */
	INT32_C(0x2f224e5e), /* ln(2^17) = 11.783502 */
	INT32_C(0x2c5c85fe), /* ln(2^16) = 11.090355 */
	INT32_C(0x2996bd9e), /* ln(2^15) = 10.397208 */
	INT32_C(0x26d0f53e), /* ln(2^14) = 9.704061 */
	INT32_C(0x240b2cde), /* ln(2^13) = 9.010913 */
	INT32_C(0x2145647e), /* ln(2^12) = 8.317766 */
	INT32_C(0x1e7f9c1f), /* ln(2^11) = 7.624619 */
	INT32_C(0x1bb9d3bf), /* ln(2^10) = 6.931472 */
	INT32_C(0x18f40b5f), /* ln(2^9) = 6.238325 */
	INT32_C(0x162e42ff), /* ln(2^8) = 5.545177 */
	INT32_C(0x13687a9f), /* ln(2^7) = 4.852030 */
	INT32_C(0x10a2b23f), /* ln(2^6) = 4.158883 */
	INT32_C(0x0ddce9df), /* ln(2^5) = 3.465736 */
	INT32_C(0x0b17217f), /* ln(2^4) = 2.772589 */
	INT32_C(0x08515920), /* ln(2^3) = 2.079442 */
	INT32_C(0x058b90c0), /* ln(2^2) = 1.386294 */
	INT32_C(0x02c5c860), /* ln(2^1) = 0.693147 */
	INT32_C(0x00000000)  /* ln(2^0) = 0.000000 */
};

static const int32_t logOnePlusTwoPowerMinusN32[] = {
	INT32_C(0x019f323f), /* ln(1+2^-1) = 4.054651e-01 */
	INT32_C(0x00e47fbe), /* ln(1+2^-2) = 2.231436e-01 */
	INT32_C(0x00789c1e), /* ln(1+2^-3) = 1.177830e-01 */
	INT32_C(0x003e1462), /* ln(1+2^-4) = 6.062462e-02 */
	INT32_C(0x001f829b), /* ln(1+2^-5) = 3.077166e-02 */
	INT32_C(0x000fe054), /* ln(1+2^-6) = 1.550419e-02 */
	INT32_C(0x0007f80b), /* ln(1+2^-7) = 7.782140e-03 */
	INT32_C(0x0003fe01), /* ln(1+2^-8) = 3.898640e-03 */
	INT32_C(0x0001ff80), /* ln(1+2^-9) = 1.951220e-03 */
	INT32_C(0x0000ffe0), /* ln(1+2^-10) = 9.760860e-04 */
	INT32_C(0x00007ff8), /* ln(1+2^-11) = 4.881621e-04 */
	INT32_C(0x00003ffe), /* ln(1+2^-12) = 2.441108e-04 */
	INT32_C(0x00002000), /* ln(1+2^-13) = 1.220629e-04 */
	INT32_C(0x00001000), /* ln(1+2^-14) = 6.103329e-05 */
	INT32_C(0x00000800), /* ln(1+2^-15) = 3.051711e-05 */
	INT32_C(0x00000400), /* ln(1+2^-16) = 1.525867e-05 */
	INT32_C(0x00000200), /* ln(1+2^-17) = 7.629365e-06 */
	INT32_C(0x00000100), /* ln(1+2^-18) = 3.814690e-06 */
	INT32_C(0x00000080), /* ln(1+2^-19) = 1.907347e-06 */
	INT32_C(0x00000040), /* ln(1+2^-20) = 9.536739e-07 */
	INT32_C(0x00000020), /* ln(1+2^-21) = 4.768370e-07 */
	INT32_C(0x00000010), /* ln(1+2^-22) = 2.384186e-07 */
	INT32_C(0x00000008), /* ln(1+2^-23) = 1.192093e-07 */
	INT32_C(0x00000004), /* ln(1+2^-24) = 5.960464e-08 */
	INT32_C(0x00000002), /* ln(1+2^-25) = 2.980232e-08 */
	INT32_C(0x00000001), /* ln(1+2^-26) = 1.490116e-08 */
	INT32_C(0x00000000), /* ln(1+2^-27) = 7.450581e-09 */
	INT32_C(0x00000000), /* ln(1+2^-28) = 3.725290e-09 */
	INT32_C(0x00000000), /* ln(1+2^-29) = 1.862645e-09 */
	INT32_C(0x00000000), /* ln(1+2^-30) = 9.313226e-10 */
	INT32_C(0x00000000)  /* ln(1+2^-31) = 4.656613e-10 */
};

static const int32_t logOneOverOneMinusTwoPowerMinusN32[] = {
	INT32_C(0x02c5c860), /* ln(1/(1-2^-1)) = 6.931472e-01 */
	INT32_C(0x01269621), /* ln(1/(1-2^-2)) = 2.876821e-01 */
	INT32_C(0x0088bc74), /* ln(1/(1-2^-3)) = 1.335314e-01 */
	INT32_C(0x00421663), /* ln(1/(1-2^-4)) = 6.453852e-02 */
	INT32_C(0x002082bb), /* ln(1/(1-2^-5)) = 3.174870e-02 */
	INT32_C(0x00102056), /* ln(1/(1-2^-6)) = 1.574836e-02 */
	INT32_C(0x0008080b), /* ln(1/(1-2^-7)) = 7.843177e-03 */
	INT32_C(0x00040201), /* ln(1/(1-2^-8)) = 3.913899e-03 */
	INT32_C(0x00020080), /* ln(1/(1-2^-9)) = 1.955035e-03 */
	INT32_C(0x00010020), /* ln(1/(1-2^-10)) = 9.770396e-04 */
	INT32_C(0x00008008), /* ln(1/(1-2^-11)) = 4.884005e-04 */
	INT32_C(0x00004002), /* ln(1/(1-2^-12)) = 2.441704e-04 */
	INT32_C(0x00002001), /* ln(1/(1-2^-13)) = 1.220778e-04 */
	INT32_C(0x00001000), /* ln(1/(1-2^-14)) = 6.103702e-05 */
	INT32_C(0x00000800), /* ln(1/(1-2^-15)) = 3.051804e-05 */
	INT32_C(0x00000400), /* ln(1/(1-2^-16)) = 1.525891e-05 */
	INT32_C(0x00000200), /* ln(1/(1-2^-17)) = 7.629424e-06 */
	INT32_C(0x00000100), /* ln(1/(1-2^-18)) = 3.814705e-06 */
	INT32_C(0x00000080), /* ln(1/(1-2^-19)) = 1.907350e-06 */
	INT32_C(0x00000040), /* ln(1/(1-2^-20)) = 9.536748e-07 */
	INT32_C(0x00000020), /* ln(1/(1-2^-21)) = 4.768373e-07 */
	INT32_C(0x00000010), /* ln(1/(1-2^-22)) = 2.384186e-07 */
	INT32_C(0x00000008), /* ln(1/(1-2^-23)) = 1.192093e-07 */
	INT32_C(0x00000004), /* ln(1/(1-2^-24)) = 5.960465e-08 */
	INT32_C(0x00000002), /* ln(1/(1-2^-25)) = 2.980232e-08 */
	INT32_C(0x00000001), /* ln(1/(1-2^-26)) = 1.490116e-08 */
	INT32_C(0x00000000), /* ln(1/(1-2^-27)) = 7.450581e-09 */
	INT32_C(0x00000000), /* ln(1/(1-2^-28)) = 3.725290e-09 */
	INT32_C(0x00000000), /* ln(1/(1-2^-29)) = 1.862645e-09 */
	INT32_C(0x00000000), /* ln(1/(1-2^-30)) = 9.313226e-10 */
	INT32_C(0x00000000)  /* ln(1/(1-2^-31)) = 4.656613e-10 */
};

static const int64_t logTwoPowerNReversed64[] = {
	INT64_C(0x575627cbf9441c00), /* ln(2^63) = 43.668272 */
	INT64_C(0x55f3439c09a08000), /* ln(2^62) = 42.975125 */
	INT64_C(0x54905f6c19fce000), /* ln(2^61) = 42.281978 */
	INT64_C(0x532d7b3c2a594000), /* ln(2^60) = 41.588831 */
	INT64_C(0x51ca970c3ab5a400), /* ln(2^59) = 40.895684 */
	INT64_C(0x5067b2dc4b120400), /* ln(2^58) = 40.202536 */
	INT64_C(0x4f04ceac5b6e6400), /* ln(2^57) = 39.509389 */
	INT64_C(0x4da1ea7c6bcac400), /* ln(2^56) = 38.816242 */
	INT64_C(0x4c3f064c7c272800), /* ln(2^55) = 38.123095 */
	INT64_C(0x4adc221c8c838800), /* ln(2^54) = 37.429948 */
	INT64_C(0x49793dec9cdfe800), /* ln(2^53) = 36.736801 */
	INT64_C(0x481659bcad3c4800), /* ln(2^52) = 36.043653 */
	INT64_C(0x46b3758cbd98ac00), /* ln(2^51) = 35.350506 */
	INT64_C(0x4550915ccdf50c00), /* ln(2^50) = 34.657359 */
	INT64_C(0x43edad2cde516c00), /* ln(2^49) = 33.964212 */
	INT64_C(0x428ac8fceeadcc00), /* ln(2^48) = 33.271065 */
	INT64_C(0x4127e4ccff0a3000), /* ln(2^47) = 32.577917 */
	INT64_C(0x3fc5009d0f669000), /* ln(2^46) = 31.884770 */
	INT64_C(0x3e621c6d1fc2f000), /* ln(2^45) = 31.191623 */
	INT64_C(0x3cff383d301f5200), /* ln(2^44) = 30.498476 */
	INT64_C(0x3b9c540d407bb200), /* ln(2^43) = 29.805329 */
	INT64_C(0x3a396fdd50d81400), /* ln(2^42) = 29.112182 */
	INT64_C(0x38d68bad61347400), /* ln(2^41) = 28.419034 */
	INT64_C(0x3773a77d7190d600), /* ln(2^40) = 27.725887 */
	INT64_C(0x3610c34d81ed3800), /* ln(2^39) = 27.032740 */
	INT64_C(0x34addf1d92499800), /* ln(2^38) = 26.339593 */
	INT64_C(0x334afaeda2a5fa00), /* ln(2^37) = 25.646446 */
	INT64_C(0x31e816bdb3025a00), /* ln(2^36) = 24.953299 */
	INT64_C(0x3085328dc35ebc00), /* ln(2^35) = 24.260151 */
	INT64_C(0x2f224e5dd3bb1c00), /* ln(2^34) = 23.567004 */
	INT64_C(0x2dbf6a2de4177e00), /* ln(2^33) = 22.873857 */
	INT64_C(0x2c5c85fdf473de00), /* ln(2^32) = 22.180710 */
	INT64_C(0x2af9a1ce04d04000), /* ln(2^31) = 21.487563 */
	INT64_C(0x2996bd9e152ca000), /* ln(2^30) = 20.794415 */
	INT64_C(0x2833d96e25890200), /* ln(2^29) = 20.101268 */
	INT64_C(0x26d0f53e35e56200), /* ln(2^28) = 19.408121 */
	INT64_C(0x256e110e4641c400), /* ln(2^27) = 18.714974 */
	INT64_C(0x240b2cde569e2400), /* ln(2^26) = 18.021827 */
	INT64_C(0x22a848ae66fa8600), /* ln(2^25) = 17.328680 */
	INT64_C(0x2145647e7756e600), /* ln(2^24) = 16.635532 */
	INT64_C(0x1fe2804e87b34800), /* ln(2^23) = 15.942385 */
	INT64_C(0x1e7f9c1e980fa900), /* ln(2^22) = 15.249238 */
	INT64_C(0x1d1cb7eea86c0a00), /* ln(2^21) = 14.556091 */
	INT64_C(0x1bb9d3beb8c86b00), /* ln(2^20) = 13.862944 */
	INT64_C(0x1a56ef8ec924cc00), /* ln(2^19) = 13.169796 */
	INT64_C(0x18f40b5ed9812d00), /* ln(2^18) = 12.476649 */
	INT64_C(0x1791272ee9dd8e00), /* ln(2^17) = 11.783502 */
	INT64_C(0x162e42fefa39ef00), /* ln(2^16) = 11.090355 */
	INT64_C(0x14cb5ecf0a965000), /* ln(2^15) = 10.397208 */
	INT64_C(0x13687a9f1af2b100), /* ln(2^14) = 9.704061 */
	INT64_C(0x1205966f2b4f1200), /* ln(2^13) = 9.010913 */
	INT64_C(0x10a2b23f3bab7300), /* ln(2^12) = 8.317766 */
	INT64_C(0x0f3fce0f4c07d480), /* ln(2^11) = 7.624619 */
	INT64_C(0x0ddce9df5c643580), /* ln(2^10) = 6.931472 */
	INT64_C(0x0c7a05af6cc09680), /* ln(2^9) = 6.238325 */
	INT64_C(0x0b17217f7d1cf780), /* ln(2^8) = 5.545177 */
	INT64_C(0x09b43d4f8d795880), /* ln(2^7) = 4.852030 */
	INT64_C(0x0851591f9dd5b980), /* ln(2^6) = 4.158883 */
	INT64_C(0x06ee74efae321ac0), /* ln(2^5) = 3.465736 */
	INT64_C(0x058b90bfbe8e7bc0), /* ln(2^4) = 2.772589 */
	INT64_C(0x0428ac8fceeadcc0), /* ln(2^3) = 2.079442 */
	INT64_C(0x02c5c85fdf473de0), /* ln(2^2) = 1.386294 */
	INT64_C(0x0162e42fefa39ef0), /* ln(2^1) = 0.693147 */
	INT64_C(0x0000000000000000)  /* ln(2^0) = 0.000000 */
};

static const int64_t logOnePlusTwoPowerMinusN64[] = {
	INT64_C(0x00cf991f65fcc260), /* ln(1+2^-1) = 4.054651e-01 */
	INT64_C(0x00723fdf1e6a6888), /* ln(1+2^-2) = 2.231436e-01 */
	INT64_C(0x003c4e0edc55e5cc), /* ln(1+2^-3) = 1.177830e-01 */
	INT64_C(0x001f0a30c01162a6), /* ln(1+2^-4) = 6.062462e-02 */
	INT64_C(0x000fc14d873c1980), /* ln(1+2^-5) = 3.077166e-02 */
	INT64_C(0x0007f02a2c3f00f9), /* ln(1+2^-6) = 1.550419e-02 */
	INT64_C(0x0003fc054d620cf1), /* ln(1+2^-7) = 7.782140e-03 */
	INT64_C(0x0001ff00aa2b10bc), /* ln(1+2^-8) = 3.898640e-03 */
	INT64_C(0x0000ffc0154d5887), /* ln(1+2^-9) = 1.951220e-03 */
	INT64_C(0x00007ff002aa2ac4), /* ln(1+2^-10) = 9.760860e-04 */
	INT64_C(0x00003ffc00554d56), /* ln(1+2^-11) = 4.881621e-04 */
	INT64_C(0x00001fff000aaa2b), /* ln(1+2^-12) = 2.441108e-04 */
	INT64_C(0x00000fffc001554d), /* ln(1+2^-13) = 1.220629e-04 */
	INT64_C(0x000007fff0002aaa), /* ln(1+2^-14) = 6.103329e-05 */
	INT64_C(0x000003fffc000555), /* ln(1+2^-15) = 3.051711e-05 */
	INT64_C(0x000001ffff0000ab), /* ln(1+2^-16) = 1.525867e-05 */
	INT64_C(0x000000ffffc00015), /* ln(1+2^-17) = 7.629365e-06 */
	INT64_C(0x0000007ffff00003), /* ln(1+2^-18) = 3.814690e-06 */
	INT64_C(0x0000003ffffc0000), /* ln(1+2^-19) = 1.907347e-06 */
	INT64_C(0x0000001fffff0000), /* ln(1+2^-20) = 9.536739e-07 */
	INT64_C(0x0000000fffffc000), /* ln(1+2^-21) = 4.768370e-07 */
	INT64_C(0x00000007fffff000), /* ln(1+2^-22) = 2.384186e-07 */
	INT64_C(0x00000003fffffc00), /* ln(1+2^-23) = 1.192093e-07 */
	INT64_C(0x00000001ffffff00), /* ln(1+2^-24) = 5.960464e-08 */
	INT64_C(0x00000000ffffffc0), /* ln(1+2^-25) = 2.980232e-08 */
	INT64_C(0x000000007ffffff0), /* ln(1+2^-26) = 1.490116e-08 */
	INT64_C(0x000000003ffffffc), /* ln(1+2^-27) = 7.450581e-09 */
	INT64_C(0x000000001fffffff), /* ln(1+2^-28) = 3.725290e-09 */
	INT64_C(0x0000000010000000), /* ln(1+2^-29) = 1.862645e-09 */
	INT64_C(0x0000000008000000), /* ln(1+2^-30) = 9.313226e-10 */
	INT64_C(0x0000000004000000), /* ln(1+2^-31) = 4.656613e-10 */
	INT64_C(0x0000000002000000), /* ln(1+2^-32) = 2.328306e-10 */
	INT64_C(0x0000000001000000), /* ln(1+2^-33) = 1.164153e-10 */
	INT64_C(0x0000000000800000), /* ln(1+2^-34) = 5.820766e-11 */
	INT64_C(0x0000000000400000), /* ln(1+2^-35) = 2.910383e-11 */
	INT64_C(0x0000000000200000), /* ln(1+2^-36) = 1.455192e-11 */
	INT64_C(0x0000000000100000), /* ln(1+2^-37) = 7.275958e-12 */
	INT64_C(0x0000000000080000), /* ln(1+2^-38) = 3.637979e-12 */
	INT64_C(0x0000000000040000), /* ln(1+2^-39) = 1.818989e-12 */
	INT64_C(0x0000000000020000), /* ln(1+2^-40) = 9.094947e-13 */
	INT64_C(0x0000000000010000), /* ln(1+2^-41) = 4.547474e-13 */
	INT64_C(0x0000000000008000), /* ln(1+2^-42) = 2.273737e-13 */
	INT64_C(0x0000000000004000), /* ln(1+2^-43) = 1.136868e-13 */
	INT64_C(0x0000000000002000), /* ln(1+2^-44) = 5.684342e-14 */
	INT64_C(0x0000000000001000), /* ln(1+2^-45) = 2.842171e-14 */
	INT64_C(0x0000000000000800), /* ln(1+2^-46) = 1.421085e-14 */
	INT64_C(0x0000000000000400), /* ln(1+2^-47) = 7.105427e-15 */
	INT64_C(0x0000000000000200), /* ln(1+2^-48) = 3.552714e-15 */
	INT64_C(0x0000000000000100), /* ln(1+2^-49) = 1.776357e-15 */
	INT64_C(0x0000000000000080), /* ln(1+2^-50) = 8.881784e-16 */
	INT64_C(0x0000000000000040), /* ln(1+2^-51) = 4.440892e-16 */
	INT64_C(0x0000000000000020), /* ln(1+2^-52) = 2.220446e-16 */
	INT64_C(0x0000000000000000), /* ln(1+2^-53) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1+2^-54) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1+2^-55) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1+2^-56) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1+2^-57) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1+2^-58) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1+2^-59) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1+2^-60) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1+2^-61) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1+2^-62) = 0.000000e+00 */
	INT64_C(0x0000000000000000)  /* ln(1+2^-63) = 0.000000e+00 */
};

static const int64_t logOneOverOneMinusTwoPowerMinusN64[] = {
	INT64_C(0x0162e42fefa39ef0), /* ln(1/(1-2^-1)) = 6.931472e-01 */
	INT64_C(0x00934b1089a6dc88), /* ln(1/(1-2^-2)) = 2.876821e-01 */
	INT64_C(0x00445e3a089f91e8), /* ln(1/(1-2^-3)) = 1.335314e-01 */
	INT64_C(0x00210b316b3c740c), /* ln(1/(1-2^-4)) = 6.453852e-02 */
	INT64_C(0x0010415d89e74440), /* ln(1/(1-2^-5)) = 3.174870e-02 */
	INT64_C(0x0008102b2c49ac1c), /* ln(1/(1-2^-6)) = 1.574836e-02 */
	INT64_C(0x000404055d62379a), /* ln(1/(1-2^-7)) = 7.843177e-03 */
	INT64_C(0x00020100ab2b1165), /* ln(1/(1-2^-8)) = 3.913899e-03 */
	INT64_C(0x00010040155d5882), /* ln(1/(1-2^-9)) = 1.955035e-03 */
	INT64_C(0x0000801002ab2ac4), /* ln(1/(1-2^-10)) = 9.770396e-04 */
	INT64_C(0x0000400400555d52), /* ln(1/(1-2^-11)) = 4.884005e-04 */
	INT64_C(0x00002001000aab2b), /* ln(1/(1-2^-12)) = 2.441704e-04 */
	INT64_C(0x000010004001555d), /* ln(1/(1-2^-13)) = 1.220778e-04 */
	INT64_C(0x0000080010002aa9), /* ln(1/(1-2^-14)) = 6.103702e-05 */
	INT64_C(0x0000040004000555), /* ln(1/(1-2^-15)) = 3.051804e-05 */
	INT64_C(0x00000200010000ab), /* ln(1/(1-2^-16)) = 1.525891e-05 */
	INT64_C(0x0000010000400015), /* ln(1/(1-2^-17)) = 7.629424e-06 */
	INT64_C(0x00000080000ffffb), /* ln(1/(1-2^-18)) = 3.814705e-06 */
	INT64_C(0x000000400003ffff), /* ln(1/(1-2^-19)) = 1.907350e-06 */
	INT64_C(0x0000002000010000), /* ln(1/(1-2^-20)) = 9.536748e-07 */
	INT64_C(0x0000001000004000), /* ln(1/(1-2^-21)) = 4.768373e-07 */
	INT64_C(0x0000000800001000), /* ln(1/(1-2^-22)) = 2.384186e-07 */
	INT64_C(0x0000000400000400), /* ln(1/(1-2^-23)) = 1.192093e-07 */
	INT64_C(0x0000000200000100), /* ln(1/(1-2^-24)) = 5.960465e-08 */
	INT64_C(0x0000000100000040), /* ln(1/(1-2^-25)) = 2.980232e-08 */
	INT64_C(0x0000000080000010), /* ln(1/(1-2^-26)) = 1.490116e-08 */
	INT64_C(0x000000003ffffffc), /* ln(1/(1-2^-27)) = 7.450581e-09 */
	INT64_C(0x000000001fffffff), /* ln(1/(1-2^-28)) = 3.725290e-09 */
	INT64_C(0x0000000010000000), /* ln(1/(1-2^-29)) = 1.862645e-09 */
	INT64_C(0x0000000008000000), /* ln(1/(1-2^-30)) = 9.313226e-10 */
	INT64_C(0x0000000004000000), /* ln(1/(1-2^-31)) = 4.656613e-10 */
	INT64_C(0x0000000002000000), /* ln(1/(1-2^-32)) = 2.328306e-10 */
	INT64_C(0x0000000001000000), /* ln(1/(1-2^-33)) = 1.164153e-10 */
	INT64_C(0x0000000000800000), /* ln(1/(1-2^-34)) = 5.820766e-11 */
	INT64_C(0x0000000000400000), /* ln(1/(1-2^-35)) = 2.910383e-11 */
	INT64_C(0x0000000000200000), /* ln(1/(1-2^-36)) = 1.455192e-11 */
	INT64_C(0x0000000000100000), /* ln(1/(1-2^-37)) = 7.275958e-12 */
	INT64_C(0x0000000000080000), /* ln(1/(1-2^-38)) = 3.637979e-12 */
	INT64_C(0x0000000000040000), /* ln(1/(1-2^-39)) = 1.818989e-12 */
	INT64_C(0x0000000000020000), /* ln(1/(1-2^-40)) = 9.094947e-13 */
	INT64_C(0x0000000000010000), /* ln(1/(1-2^-41)) = 4.547474e-13 */
	INT64_C(0x0000000000008000), /* ln(1/(1-2^-42)) = 2.273737e-13 */
	INT64_C(0x0000000000004000), /* ln(1/(1-2^-43)) = 1.136868e-13 */
	INT64_C(0x0000000000002000), /* ln(1/(1-2^-44)) = 5.684342e-14 */
	INT64_C(0x0000000000001000), /* ln(1/(1-2^-45)) = 2.842171e-14 */
	INT64_C(0x0000000000000800), /* ln(1/(1-2^-46)) = 1.421085e-14 */
	INT64_C(0x0000000000000400), /* ln(1/(1-2^-47)) = 7.105427e-15 */
	INT64_C(0x0000000000000200), /* ln(1/(1-2^-48)) = 3.552714e-15 */
	INT64_C(0x0000000000000100), /* ln(1/(1-2^-49)) = 1.776357e-15 */
	INT64_C(0x0000000000000080), /* ln(1/(1-2^-50)) = 8.881784e-16 */
	INT64_C(0x0000000000000040), /* ln(1/(1-2^-51)) = 4.440892e-16 */
	INT64_C(0x0000000000000020), /* ln(1/(1-2^-52)) = 2.220446e-16 */
	INT64_C(0x0000000000000020), /* ln(1/(1-2^-53)) = 2.220446e-16 */
	INT64_C(0x0000000000000000), /* ln(1/(1-2^-54)) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1/(1-2^-55)) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1/(1-2^-56)) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1/(1-2^-57)) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1/(1-2^-58)) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1/(1-2^-59)) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1/(1-2^-60)) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1/(1-2^-61)) = 0.000000e+00 */
	INT64_C(0x0000000000000000), /* ln(1/(1-2^-62)) = 0.000000e+00 */
	INT64_C(0x0000000000000000)  /* ln(1/(1-2^-63)) = 0.000000e+00 */
};

static const int32_t arctanTwoPowerMinusN[] = {
		INT32_C(0x11b6e193), /* atan(2^1) = 1.107149e+00 */
		INT32_C(0x0c90fdaa), /* atan(2^0) = 7.853982e-01 */
		INT32_C(0x076b19c1), /* atan(2^-1) = 4.636476e-01 */
		INT32_C(0x03eb6ebf), /* atan(2^-2) = 2.449787e-01 */
		INT32_C(0x01fd5baa), /* atan(2^-3) = 1.243550e-01 */
		INT32_C(0x00ffaade), /* atan(2^-4) = 6.241881e-02 */
		INT32_C(0x007ff557), /* atan(2^-5) = 3.123983e-02 */
		INT32_C(0x003ffeab), /* atan(2^-6) = 1.562373e-02 */
		INT32_C(0x001fffd5), /* atan(2^-7) = 7.812341e-03 */
		INT32_C(0x000ffffb), /* atan(2^-8) = 3.906230e-03 */
		INT32_C(0x0007ffff), /* atan(2^-9) = 1.953123e-03 */
		INT32_C(0x00040000), /* atan(2^-10) = 9.765622e-04 */
		INT32_C(0x00020000), /* atan(2^-11) = 4.882812e-04 */
		INT32_C(0x00010000), /* atan(2^-12) = 2.441406e-04 */
		INT32_C(0x00008000), /* atan(2^-13) = 1.220703e-04 */
		INT32_C(0x00004000), /* atan(2^-14) = 6.103516e-05 */
		INT32_C(0x00002000), /* atan(2^-15) = 3.051758e-05 */
		INT32_C(0x00001000), /* atan(2^-16) = 1.525879e-05 */
		INT32_C(0x00000800), /* atan(2^-17) = 7.629395e-06 */
		INT32_C(0x00000400), /* atan(2^-18) = 3.814697e-06 */
		INT32_C(0x00000200), /* atan(2^-19) = 1.907349e-06 */
		INT32_C(0x00000100), /* atan(2^-20) = 9.536743e-07 */
		INT32_C(0x00000080), /* atan(2^-21) = 4.768372e-07 */
		INT32_C(0x00000040), /* atan(2^-22) = 2.384186e-07 */
		INT32_C(0x00000020), /* atan(2^-23) = 1.192093e-07 */
		INT32_C(0x00000010), /* atan(2^-24) = 5.960464e-08 */
		INT32_C(0x00000008), /* atan(2^-25) = 2.980232e-08 */
		INT32_C(0x00000004), /* atan(2^-26) = 1.490116e-08 */
		INT32_C(0x00000002), /* atan(2^-27) = 7.450581e-09 */
		INT32_C(0x00000001), /* atan(2^-28) = 3.725290e-09 */
		INT32_C(0x00000001), /* atan(2^-29) = 1.862645e-09 */
		INT32_C(0x00000000), /* atan(2^-30) = 9.313226e-10 */
};

static int32_t rightShift32(int32_t x, int shift) {
	return shift < 0 ? x << -shift : x >> shift;
}

static int64_t rightShift64(int64_t x, int shift) {
	return shift < 0 ? x << -shift : x >> shift;
}

int32_t DamosMath_mulfix32(int32_t a, int32_t b, int fractionLength) {
	const uint32_t mask = (INT32_C(1) << fractionLength) - 1;

	int32_t hi0 = a >> fractionLength;
	int32_t hi1 = b >> fractionLength;
	uint32_t lo0 = a & mask;
	uint32_t lo1 = b & mask;

	int32_t resultHi = hi0 * hi1;
	int32_t result = hi0 * lo1 + hi1 * lo0;
	uint32_t resultLo = lo0 * lo1;

	result += (resultHi & mask) << fractionLength;
	result += resultLo >> fractionLength;

	return result;
}

int32_t DamosMath_expfix32(int32_t x, int fractionLength) {
	const int32_t one = INT32_C(1) << fractionLength;
	const int tableShift = DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 - fractionLength;

	if (x >= (logTwoPowerNReversed32[fractionLength] >> tableShift)) {
		return INT32_C(0x7fffffff);
	}
	if (x < -(logTwoPowerNReversed32[31 - fractionLength] >> tableShift)) {
		return INT32_C(0);
	}
	if (x == 0) {
		return one;
	}

	{
		const int maxPower = 31 - fractionLength;
		const int negativeFractionLength = -fractionLength;

		int32_t result = one;
		int32_t temp = x << tableShift;

		if (x > 0) {
			int power = maxPower;
			int32_t const* logEntry = logTwoPowerNReversed32 + fractionLength;

			while (temp != 0 && power > negativeFractionLength) {
				while (power == 0 || temp < *logEntry) {
					if (power == 0) {
						logEntry = logOnePlusTwoPowerMinusN32;
					} else {
						++logEntry;
					}
					--power;
				}
				temp -= *logEntry;
				if (power < 0) {
					result += result >> -power;
				} else {
					result <<= power;
				}
			}
		} else {
			int power = fractionLength;
			int32_t const* logEntry = logTwoPowerNReversed32 + maxPower - power + fractionLength;

			while (temp != 0 && power > negativeFractionLength) {
				while (power == 0 || temp > -(*logEntry)) {
					if (power == 0) {
						logEntry = logOneOverOneMinusTwoPowerMinusN32;
					} else {
						++logEntry;
					}
					--power;
				}
				temp += *logEntry;
				if (power < 0) {
					result -= result >> -power;
				} else {
					result >>= power;
				}
			}
		}

		return result;
	}
}

int64_t DamosMath_expfix64(int64_t x, int fractionLength) {
	const int64_t one = INT64_C(1) << fractionLength;
	const int tableShift = DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64 - fractionLength;

	if (x >= (logTwoPowerNReversed64[fractionLength] >> tableShift)) {
		return INT64_C(0x7fffffffffffffff);
	}
	if (x < -(logTwoPowerNReversed64[63 - fractionLength] >> tableShift)) {
		return INT64_C(0);
	}
	if (x == 0) {
		return one;
	}

	{
		const int maxPower = 63 - fractionLength;
		const int negativeFractionLength = -fractionLength;

		int64_t result = one;
		int64_t temp = x << tableShift;

		if (x > 0) {
			int power = maxPower;
			int64_t const* logEntry = logTwoPowerNReversed64 + fractionLength;

			while (temp != 0 && power > negativeFractionLength) {
				while (power == 0 || temp < *logEntry) {
					if (power == 0) {
						logEntry = logOnePlusTwoPowerMinusN64;
					} else {
						++logEntry;
					}
					--power;
				}
				temp -= *logEntry;
				if (power < 0) {
					result += result >> -power;
				} else {
					result <<= power;
				}
			}
		} else {
			int power = fractionLength;
			int64_t const* logEntry = logTwoPowerNReversed64 + maxPower - power + fractionLength;

			while (temp != 0 && power > negativeFractionLength) {
				while (power == 0 || temp > -(*logEntry)) {
					if (power == 0) {
						logEntry = logOneOverOneMinusTwoPowerMinusN64;
					} else {
						++logEntry;
					}
					--power;
				}
				temp += *logEntry;
				if (power < 0) {
					result -= result >> -power;
				} else {
					result >>= power;
				}
			}
		}

		return result;
	}
}

static int32_t lnfix32base(int32_t x, int fractionLength) {
	const int32_t one = INT32_C(1) << fractionLength;

	if (x <= 0) {
		return -INT32_C(0x7fffffff);
	}
    if (x == one) {
		return INT32_C(0);
	}

    {
		const uint32_t scalePosition = INT32_C(0x80000000);
		const int maxPower = 31 - fractionLength;

		int32_t result;

		int leftShift = 0;
		unsigned int rightShift = 1;

		uint32_t temp = x;
		uint32_t shiftedTemp;

		while (temp < scalePosition) {
			++leftShift;
			temp <<= 1;
		}

		result = leftShift < maxPower ? logTwoPowerNReversed32[leftShift + fractionLength] : -logTwoPowerNReversed32[2 * maxPower - leftShift + fractionLength];
		shiftedTemp = temp >> 1;

		while (temp != 0 && rightShift < fractionLength) {
			while (rightShift < fractionLength && temp < shiftedTemp + scalePosition) {
				shiftedTemp >>= 1;
				++rightShift;
			}

			temp -= shiftedTemp;
			shiftedTemp = temp >> rightShift;
			result += logOneOverOneMinusTwoPowerMinusN32[rightShift - 1];
		}

		return result;
    }
}

static int64_t lnfix64base(int64_t x, int fractionLength) {
	const int64_t one = INT64_C(1) << fractionLength;

	if (x <= 0) {
		return -INT64_C(0x7fffffffffffffff);
	}
    if (x == one) {
		return INT64_C(0);
	}

    {
		const uint64_t scalePosition = INT64_C(0x8000000000000000);
		const int maxPower = 63 - fractionLength;

		int64_t result;

		int leftShift = 0;
		unsigned int rightShift = 1;

		uint64_t temp = x;
		uint64_t shiftedTemp;

		while (temp < scalePosition) {
			++leftShift;
			temp <<= 1;
		}

		result = leftShift < maxPower ? logTwoPowerNReversed64[leftShift + fractionLength] : -logTwoPowerNReversed64[2 * maxPower - leftShift + fractionLength];
		shiftedTemp = temp >> 1;

		while (temp != 0 && rightShift < fractionLength) {
			while (rightShift < fractionLength && temp < shiftedTemp + scalePosition) {
				shiftedTemp >>= 1;
				++rightShift;
			}

			temp -= shiftedTemp;
			shiftedTemp = temp >> rightShift;
			result += logOneOverOneMinusTwoPowerMinusN64[rightShift - 1];
		}

		return result;
    }
}

int32_t DamosMath_lnfix32(int32_t x, int fractionLength) {
	int32_t result = lnfix32base(x, fractionLength);
	int shift = DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 - fractionLength;
	return shift >= 0 ? result >> shift : result << -shift;
}

int64_t DamosMath_lnfix64(int64_t x, int fractionLength) {
	int64_t result = lnfix64base(x, fractionLength);
	int shift = DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64 - fractionLength;
	return shift >= 0 ? result >> shift : result << -shift;
}

int32_t DamosMath_lgfix32(int32_t x, int fractionLength) {
	int32_t lnResult = lnfix32base(x, fractionLength) >> (DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 - 16);
	int32_t result = DamosMath_mulfix32(lnResult, INT32_C(0x6f2e), 16);
	int shift = 16 - fractionLength;
	return shift >= 0 ? result >> shift : result << -shift;
}

int32_t DamosMath_lgfix3264(int32_t x, int fractionLength) {
	int32_t lnResult = lnfix32base(x, fractionLength) >> (DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 - 16);
	int64_t result = (int64_t) lnResult * INT64_C(0x6f2e);
	int shift = 32 - fractionLength;
	return (int32_t) (shift >= 0 ? result >> shift : result << -shift);
}

int64_t DamosMath_lgfix64(int64_t x, int fractionLength) {
	int64_t lnResult = lnfix64base(x, fractionLength) >> (DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64 - 28);
	int64_t result = lnResult * INT64_C(0x06f2dec5);
	int shift = 56 - fractionLength;
	return shift >= 0 ? result >> shift : result << -shift;
}

int32_t DamosMath_lbfix32(int32_t x, int fractionLength) {
	int32_t lnResult = lnfix32base(x, fractionLength) >> (DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 - 16);
	int32_t result = DamosMath_mulfix32(lnResult, INT32_C(0x17154), 16);
	int shift = 16 - fractionLength;
	return shift >= 0 ? result >> shift : result << -shift;
}

int32_t DamosMath_lbfix3264(int32_t x, int fractionLength) {
	int32_t lnResult = lnfix32base(x, fractionLength) >> (DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 - 16);
	int64_t result = (int64_t) lnResult * INT64_C(0x17154);
	int shift = 32 - fractionLength;
	return (int32_t) (shift >= 0 ? result >> shift : result << -shift);
}

int64_t DamosMath_lbfix64(int64_t x, int fractionLength) {
	int64_t result = (lnfix64base(x, fractionLength) >> (DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64 - 26)) * INT64_C(0x05c551d9);
	int shift = 52 - fractionLength;
	return shift >= 0 ? result >> shift : result << -shift;
}

int32_t DamosMath_powfix32(int32_t base, int32_t exponent, int fractionLength) {
	int32_t lnResult = DamosMath_lnfix32(base, fractionLength);
	return DamosMath_expfix32(DamosMath_mulfix32(exponent, lnResult, fractionLength), fractionLength);
}

int32_t DamosMath_powfix3264(int32_t base, int32_t exponent, int fractionLength) {
	int32_t lnResult = DamosMath_lnfix32(base, fractionLength);
	return DamosMath_expfix32((int32_t) ((int64_t) exponent * (int64_t) lnResult >> fractionLength), fractionLength);
}

int64_t DamosMath_powfix64(int64_t base, int64_t exponent, int fractionLength) {
	return DamosMath_expfix64(exponent * DamosMath_lnfix64(base, fractionLength) >> fractionLength, fractionLength);
}

static int32_t scaleCordicResult32(int32_t x) {
	const int32_t scaleFactor = 0x22C2DD1C; /* 0.271572 * 2^31*/
	return (int32_t) ((int64_t) x * scaleFactor >> 31);
}

static void performCordicRotation32(int32_t *px, int32_t *py, int32_t theta) {
	int32_t x = *px, y = *py;
	const int32_t *arctan = arctanTwoPowerMinusN;
	int i;
	for (i = -1; i <= DAMOS_MATH_TRIG_FRACTION_LENGTH; ++i) {
		const int32_t yShift = rightShift32(y, i);
		const int32_t xShift = rightShift32(x, i);

		if (theta < 0) {
			x += yShift;
			y -= xShift;
			theta += *arctan++;
		} else {
			x -= yShift;
			y += xShift;
			theta -= *arctan++;
		}
	}
	*px = scaleCordicResult32(x);
	*py = scaleCordicResult32(y);
}

static void sincos32(int32_t theta, int32_t *s, int32_t *c) {
	int x = theta;

	if (x < 0) {
		x += DAMOS_MATH_TWO_PI;
	}

	/* bool */
	int negateCos = 0;
	/* bool */
	int negateSin = 0;

	if (x > DAMOS_MATH_PI) {
		x = DAMOS_MATH_TWO_PI - x;
		negateSin = 1;
	}
	if (x > DAMOS_MATH_HALF_PI) {
		x = DAMOS_MATH_PI - x;
		negateCos = 1;
	}
	int32_t xCos = 1 << DAMOS_MATH_TRIG_FRACTION_LENGTH;
	int32_t xSin = 0;

	performCordicRotation32(&xCos, &xSin, x);

	if (s) {
		*s = negateSin ? -xSin : xSin;
	}
	if (c) {
		*c = negateCos ? -xCos : xCos;
	}
}

static int32_t reduceTheta32(int32_t theta, int fractionLength) {
	const int32_t mask = INT32_C(1) << DAMOS_MATH_TRIG_FRACTION_LENGTH;
	int n;
	for (n = fractionLength; n < DAMOS_MATH_TRIG_FRACTION_LENGTH && (theta & mask) == 0; ++n) {
		theta <<= 1;
	}
	int32_t shiftedPi = rightShift32(DAMOS_MATH_TWO_PI, DAMOS_MATH_TRIG_FRACTION_LENGTH - n);
	if (theta < shiftedPi || theta > shiftedPi) {
		theta %= shiftedPi;
	}
	return rightShift32(theta, n - DAMOS_MATH_TRIG_FRACTION_LENGTH);
}

static int64_t reduceTheta64(int64_t theta, int fractionLength) {
	int64_t shiftedPi = rightShift64(DAMOS_MATH_TWO_PI, DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
	if (theta < shiftedPi || theta > shiftedPi) {
		theta %= shiftedPi;
	}
	return rightShift64(theta, fractionLength - DAMOS_MATH_TRIG_FRACTION_LENGTH);
}

int32_t DamosMath_sinfix32(int32_t x, int fractionLength) {
	int32_t result;
	sincos32(reduceTheta32(x, fractionLength), &result, 0);
	return rightShift32(result, DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
}

int64_t DamosMath_sinfix64(int64_t x, int fractionLength) {
	int32_t result;
	sincos32(reduceTheta64(x, fractionLength), &result, 0);
	return rightShift64(result, DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
}

int32_t DamosMath_cosfix32(int32_t x, int fractionLength) {
	int32_t result;
	sincos32(reduceTheta32(x, fractionLength), 0, &result);
	return rightShift32(result, DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
}

int64_t DamosMath_cosfix64(int64_t x, int fractionLength) {
	int32_t result;
	sincos32(reduceTheta64(x, fractionLength), 0, &result);
	return rightShift64(result, DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
}

int32_t DamosMath_tanfix32(int32_t x, int fractionLength) {
	int32_t s;
	int32_t c;
	sincos32(reduceTheta32(x, fractionLength), &s, &c);
	if (c == 0) {
		return INT32_C(0x7fffffff);
	}
	int64_t result = ((int64_t) s << DAMOS_MATH_TRIG_FRACTION_LENGTH) / c;
	if (result > INT32_C(0x7fffffff)) {
		return INT32_C(0x7fffffff);
	}
	return rightShift32(result, DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
}

int64_t DamosMath_tanfix64(int64_t x, int fractionLength) {
	int32_t s;
	int32_t c;
	sincos32(reduceTheta64(x, fractionLength), &s, &c);
	if (c == 0) {
		return INT64_C(0x7fffffffffffffff);
	}
	return rightShift64(((int64_t) s << DAMOS_MATH_TRIG_FRACTION_LENGTH) / c, DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
}
