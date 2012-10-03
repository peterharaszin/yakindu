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

package org.eclipse.damos.mscript.interpreter.util;

import org.eclipse.damos.mscript.interpreter.IOverflowMonitor;
import org.eclipse.damos.mscript.interpreter.OverflowInfo;

/**
 * @author Andreas Unger
 *
 */
public class FixMath {

	private static final int DAMOS_MATH_PI = 0x3243f6a9;
	private static final int DAMOS_MATH_TWO_PI = 0x6487ed51;
	private static final int DAMOS_MATH_HALF_PI = 0x1921fb54;
//	private static final int DAMOS_MATH_QUARTER_PI = 0x0c90fdaa;

	private static final int DAMOS_MATH_TRIG_FRACTION_LENGTH = 28;

	private static final int DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 = 26;
	private static final int DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64 = 57;

	private static final int logTwoPowerNReversed32[] = {
		0x55f3439c, /* ln(2^31) = 21.487563 */
		0x532d7b3c, /* ln(2^30) = 20.794415 */
		0x5067b2dc, /* ln(2^29) = 20.101268 */
		0x4da1ea7c, /* ln(2^28) = 19.408121 */
		0x4adc221d, /* ln(2^27) = 18.714974 */
		0x481659bd, /* ln(2^26) = 18.021827 */
		0x4550915d, /* ln(2^25) = 17.328680 */
		0x428ac8fd, /* ln(2^24) = 16.635532 */
		0x3fc5009d, /* ln(2^23) = 15.942385 */
		0x3cff383d, /* ln(2^22) = 15.249238 */
		0x3a396fdd, /* ln(2^21) = 14.556091 */
		0x3773a77d, /* ln(2^20) = 13.862944 */
		0x34addf1e, /* ln(2^19) = 13.169796 */
		0x31e816be, /* ln(2^18) = 12.476649 */
		0x2f224e5e, /* ln(2^17) = 11.783502 */
		0x2c5c85fe, /* ln(2^16) = 11.090355 */
		0x2996bd9e, /* ln(2^15) = 10.397208 */
		0x26d0f53e, /* ln(2^14) = 9.704061 */
		0x240b2cde, /* ln(2^13) = 9.010913 */
		0x2145647e, /* ln(2^12) = 8.317766 */
		0x1e7f9c1f, /* ln(2^11) = 7.624619 */
		0x1bb9d3bf, /* ln(2^10) = 6.931472 */
		0x18f40b5f, /* ln(2^9) = 6.238325 */
		0x162e42ff, /* ln(2^8) = 5.545177 */
		0x13687a9f, /* ln(2^7) = 4.852030 */
		0x10a2b23f, /* ln(2^6) = 4.158883 */
		0x0ddce9df, /* ln(2^5) = 3.465736 */
		0x0b17217f, /* ln(2^4) = 2.772589 */
		0x08515920, /* ln(2^3) = 2.079442 */
		0x058b90c0, /* ln(2^2) = 1.386294 */
		0x02c5c860, /* ln(2^1) = 0.693147 */
		0x00000000  /* ln(2^0) = 0.000000 */
	};

	private static final int logOnePlusTwoPowerMinusN32[] = {
		0x019f323f, /* ln(1+2^-1) = 4.054651e-01 */
		0x00e47fbe, /* ln(1+2^-2) = 2.231436e-01 */
		0x00789c1e, /* ln(1+2^-3) = 1.177830e-01 */
		0x003e1462, /* ln(1+2^-4) = 6.062462e-02 */
		0x001f829b, /* ln(1+2^-5) = 3.077166e-02 */
		0x000fe054, /* ln(1+2^-6) = 1.550419e-02 */
		0x0007f80b, /* ln(1+2^-7) = 7.782140e-03 */
		0x0003fe01, /* ln(1+2^-8) = 3.898640e-03 */
		0x0001ff80, /* ln(1+2^-9) = 1.951220e-03 */
		0x0000ffe0, /* ln(1+2^-10) = 9.760860e-04 */
		0x00007ff8, /* ln(1+2^-11) = 4.881621e-04 */
		0x00003ffe, /* ln(1+2^-12) = 2.441108e-04 */
		0x00002000, /* ln(1+2^-13) = 1.220629e-04 */
		0x00001000, /* ln(1+2^-14) = 6.103329e-05 */
		0x00000800, /* ln(1+2^-15) = 3.051711e-05 */
		0x00000400, /* ln(1+2^-16) = 1.525867e-05 */
		0x00000200, /* ln(1+2^-17) = 7.629365e-06 */
		0x00000100, /* ln(1+2^-18) = 3.814690e-06 */
		0x00000080, /* ln(1+2^-19) = 1.907347e-06 */
		0x00000040, /* ln(1+2^-20) = 9.536739e-07 */
		0x00000020, /* ln(1+2^-21) = 4.768370e-07 */
		0x00000010, /* ln(1+2^-22) = 2.384186e-07 */
		0x00000008, /* ln(1+2^-23) = 1.192093e-07 */
		0x00000004, /* ln(1+2^-24) = 5.960464e-08 */
		0x00000002, /* ln(1+2^-25) = 2.980232e-08 */
		0x00000001, /* ln(1+2^-26) = 1.490116e-08 */
		0x00000000, /* ln(1+2^-27) = 7.450581e-09 */
		0x00000000, /* ln(1+2^-28) = 3.725290e-09 */
		0x00000000, /* ln(1+2^-29) = 1.862645e-09 */
		0x00000000, /* ln(1+2^-30) = 9.313226e-10 */
		0x00000000  /* ln(1+2^-31) = 4.656613e-10 */
	};

	private static final int logOneOverOneMinusTwoPowerMinusN32[] = {
		0x02c5c860, /* ln(1/(1-2^-1)) = 6.931472e-01 */
		0x01269621, /* ln(1/(1-2^-2)) = 2.876821e-01 */
		0x0088bc74, /* ln(1/(1-2^-3)) = 1.335314e-01 */
		0x00421663, /* ln(1/(1-2^-4)) = 6.453852e-02 */
		0x002082bb, /* ln(1/(1-2^-5)) = 3.174870e-02 */
		0x00102056, /* ln(1/(1-2^-6)) = 1.574836e-02 */
		0x0008080b, /* ln(1/(1-2^-7)) = 7.843177e-03 */
		0x00040201, /* ln(1/(1-2^-8)) = 3.913899e-03 */
		0x00020080, /* ln(1/(1-2^-9)) = 1.955035e-03 */
		0x00010020, /* ln(1/(1-2^-10)) = 9.770396e-04 */
		0x00008008, /* ln(1/(1-2^-11)) = 4.884005e-04 */
		0x00004002, /* ln(1/(1-2^-12)) = 2.441704e-04 */
		0x00002001, /* ln(1/(1-2^-13)) = 1.220778e-04 */
		0x00001000, /* ln(1/(1-2^-14)) = 6.103702e-05 */
		0x00000800, /* ln(1/(1-2^-15)) = 3.051804e-05 */
		0x00000400, /* ln(1/(1-2^-16)) = 1.525891e-05 */
		0x00000200, /* ln(1/(1-2^-17)) = 7.629424e-06 */
		0x00000100, /* ln(1/(1-2^-18)) = 3.814705e-06 */
		0x00000080, /* ln(1/(1-2^-19)) = 1.907350e-06 */
		0x00000040, /* ln(1/(1-2^-20)) = 9.536748e-07 */
		0x00000020, /* ln(1/(1-2^-21)) = 4.768373e-07 */
		0x00000010, /* ln(1/(1-2^-22)) = 2.384186e-07 */
		0x00000008, /* ln(1/(1-2^-23)) = 1.192093e-07 */
		0x00000004, /* ln(1/(1-2^-24)) = 5.960465e-08 */
		0x00000002, /* ln(1/(1-2^-25)) = 2.980232e-08 */
		0x00000001, /* ln(1/(1-2^-26)) = 1.490116e-08 */
		0x00000000, /* ln(1/(1-2^-27)) = 7.450581e-09 */
		0x00000000, /* ln(1/(1-2^-28)) = 3.725290e-09 */
		0x00000000, /* ln(1/(1-2^-29)) = 1.862645e-09 */
		0x00000000, /* ln(1/(1-2^-30)) = 9.313226e-10 */
		0x00000000  /* ln(1/(1-2^-31)) = 4.656613e-10 */
	};

	private static final long logTwoPowerNReversed64[] = {
		0x575627cbf9441c00L, /* ln(2^63) = 43.668272 */
		0x55f3439c09a08000L, /* ln(2^62) = 42.975125 */
		0x54905f6c19fce000L, /* ln(2^61) = 42.281978 */
		0x532d7b3c2a594000L, /* ln(2^60) = 41.588831 */
		0x51ca970c3ab5a400L, /* ln(2^59) = 40.895684 */
		0x5067b2dc4b120400L, /* ln(2^58) = 40.202536 */
		0x4f04ceac5b6e6400L, /* ln(2^57) = 39.509389 */
		0x4da1ea7c6bcac400L, /* ln(2^56) = 38.816242 */
		0x4c3f064c7c272800L, /* ln(2^55) = 38.123095 */
		0x4adc221c8c838800L, /* ln(2^54) = 37.429948 */
		0x49793dec9cdfe800L, /* ln(2^53) = 36.736801 */
		0x481659bcad3c4800L, /* ln(2^52) = 36.043653 */
		0x46b3758cbd98ac00L, /* ln(2^51) = 35.350506 */
		0x4550915ccdf50c00L, /* ln(2^50) = 34.657359 */
		0x43edad2cde516c00L, /* ln(2^49) = 33.964212 */
		0x428ac8fceeadcc00L, /* ln(2^48) = 33.271065 */
		0x4127e4ccff0a3000L, /* ln(2^47) = 32.577917 */
		0x3fc5009d0f669000L, /* ln(2^46) = 31.884770 */
		0x3e621c6d1fc2f000L, /* ln(2^45) = 31.191623 */
		0x3cff383d301f5200L, /* ln(2^44) = 30.498476 */
		0x3b9c540d407bb200L, /* ln(2^43) = 29.805329 */
		0x3a396fdd50d81400L, /* ln(2^42) = 29.112182 */
		0x38d68bad61347400L, /* ln(2^41) = 28.419034 */
		0x3773a77d7190d600L, /* ln(2^40) = 27.725887 */
		0x3610c34d81ed3800L, /* ln(2^39) = 27.032740 */
		0x34addf1d92499800L, /* ln(2^38) = 26.339593 */
		0x334afaeda2a5fa00L, /* ln(2^37) = 25.646446 */
		0x31e816bdb3025a00L, /* ln(2^36) = 24.953299 */
		0x3085328dc35ebc00L, /* ln(2^35) = 24.260151 */
		0x2f224e5dd3bb1c00L, /* ln(2^34) = 23.567004 */
		0x2dbf6a2de4177e00L, /* ln(2^33) = 22.873857 */
		0x2c5c85fdf473de00L, /* ln(2^32) = 22.180710 */
		0x2af9a1ce04d04000L, /* ln(2^31) = 21.487563 */
		0x2996bd9e152ca000L, /* ln(2^30) = 20.794415 */
		0x2833d96e25890200L, /* ln(2^29) = 20.101268 */
		0x26d0f53e35e56200L, /* ln(2^28) = 19.408121 */
		0x256e110e4641c400L, /* ln(2^27) = 18.714974 */
		0x240b2cde569e2400L, /* ln(2^26) = 18.021827 */
		0x22a848ae66fa8600L, /* ln(2^25) = 17.328680 */
		0x2145647e7756e600L, /* ln(2^24) = 16.635532 */
		0x1fe2804e87b34800L, /* ln(2^23) = 15.942385 */
		0x1e7f9c1e980fa900L, /* ln(2^22) = 15.249238 */
		0x1d1cb7eea86c0a00L, /* ln(2^21) = 14.556091 */
		0x1bb9d3beb8c86b00L, /* ln(2^20) = 13.862944 */
		0x1a56ef8ec924cc00L, /* ln(2^19) = 13.169796 */
		0x18f40b5ed9812d00L, /* ln(2^18) = 12.476649 */
		0x1791272ee9dd8e00L, /* ln(2^17) = 11.783502 */
		0x162e42fefa39ef00L, /* ln(2^16) = 11.090355 */
		0x14cb5ecf0a965000L, /* ln(2^15) = 10.397208 */
		0x13687a9f1af2b100L, /* ln(2^14) = 9.704061 */
		0x1205966f2b4f1200L, /* ln(2^13) = 9.010913 */
		0x10a2b23f3bab7300L, /* ln(2^12) = 8.317766 */
		0x0f3fce0f4c07d480L, /* ln(2^11) = 7.624619 */
		0x0ddce9df5c643580L, /* ln(2^10) = 6.931472 */
		0x0c7a05af6cc09680L, /* ln(2^9) = 6.238325 */
		0x0b17217f7d1cf780L, /* ln(2^8) = 5.545177 */
		0x09b43d4f8d795880L, /* ln(2^7) = 4.852030 */
		0x0851591f9dd5b980L, /* ln(2^6) = 4.158883 */
		0x06ee74efae321ac0L, /* ln(2^5) = 3.465736 */
		0x058b90bfbe8e7bc0L, /* ln(2^4) = 2.772589 */
		0x0428ac8fceeadcc0L, /* ln(2^3) = 2.079442 */
		0x02c5c85fdf473de0L, /* ln(2^2) = 1.386294 */
		0x0162e42fefa39ef0L, /* ln(2^1) = 0.693147 */
		0x0000000000000000L  /* ln(2^0) = 0.000000 */
	};

	private static final long logOnePlusTwoPowerMinusN64[] = {
		0x00cf991f65fcc260L, /* ln(1+2^-1) = 4.054651e-01 */
		0x00723fdf1e6a6888L, /* ln(1+2^-2) = 2.231436e-01 */
		0x003c4e0edc55e5ccL, /* ln(1+2^-3) = 1.177830e-01 */
		0x001f0a30c01162a6L, /* ln(1+2^-4) = 6.062462e-02 */
		0x000fc14d873c1980L, /* ln(1+2^-5) = 3.077166e-02 */
		0x0007f02a2c3f00f9L, /* ln(1+2^-6) = 1.550419e-02 */
		0x0003fc054d620cf1L, /* ln(1+2^-7) = 7.782140e-03 */
		0x0001ff00aa2b10bcL, /* ln(1+2^-8) = 3.898640e-03 */
		0x0000ffc0154d5887L, /* ln(1+2^-9) = 1.951220e-03 */
		0x00007ff002aa2ac4L, /* ln(1+2^-10) = 9.760860e-04 */
		0x00003ffc00554d56L, /* ln(1+2^-11) = 4.881621e-04 */
		0x00001fff000aaa2bL, /* ln(1+2^-12) = 2.441108e-04 */
		0x00000fffc001554dL, /* ln(1+2^-13) = 1.220629e-04 */
		0x000007fff0002aaaL, /* ln(1+2^-14) = 6.103329e-05 */
		0x000003fffc000555L, /* ln(1+2^-15) = 3.051711e-05 */
		0x000001ffff0000abL, /* ln(1+2^-16) = 1.525867e-05 */
		0x000000ffffc00015L, /* ln(1+2^-17) = 7.629365e-06 */
		0x0000007ffff00003L, /* ln(1+2^-18) = 3.814690e-06 */
		0x0000003ffffc0000L, /* ln(1+2^-19) = 1.907347e-06 */
		0x0000001fffff0000L, /* ln(1+2^-20) = 9.536739e-07 */
		0x0000000fffffc000L, /* ln(1+2^-21) = 4.768370e-07 */
		0x00000007fffff000L, /* ln(1+2^-22) = 2.384186e-07 */
		0x00000003fffffc00L, /* ln(1+2^-23) = 1.192093e-07 */
		0x00000001ffffff00L, /* ln(1+2^-24) = 5.960464e-08 */
		0x00000000ffffffc0L, /* ln(1+2^-25) = 2.980232e-08 */
		0x000000007ffffff0L, /* ln(1+2^-26) = 1.490116e-08 */
		0x000000003ffffffcL, /* ln(1+2^-27) = 7.450581e-09 */
		0x000000001fffffffL, /* ln(1+2^-28) = 3.725290e-09 */
		0x0000000010000000L, /* ln(1+2^-29) = 1.862645e-09 */
		0x0000000008000000L, /* ln(1+2^-30) = 9.313226e-10 */
		0x0000000004000000L, /* ln(1+2^-31) = 4.656613e-10 */
		0x0000000002000000L, /* ln(1+2^-32) = 2.328306e-10 */
		0x0000000001000000L, /* ln(1+2^-33) = 1.164153e-10 */
		0x0000000000800000L, /* ln(1+2^-34) = 5.820766e-11 */
		0x0000000000400000L, /* ln(1+2^-35) = 2.910383e-11 */
		0x0000000000200000L, /* ln(1+2^-36) = 1.455192e-11 */
		0x0000000000100000L, /* ln(1+2^-37) = 7.275958e-12 */
		0x0000000000080000L, /* ln(1+2^-38) = 3.637979e-12 */
		0x0000000000040000L, /* ln(1+2^-39) = 1.818989e-12 */
		0x0000000000020000L, /* ln(1+2^-40) = 9.094947e-13 */
		0x0000000000010000L, /* ln(1+2^-41) = 4.547474e-13 */
		0x0000000000008000L, /* ln(1+2^-42) = 2.273737e-13 */
		0x0000000000004000L, /* ln(1+2^-43) = 1.136868e-13 */
		0x0000000000002000L, /* ln(1+2^-44) = 5.684342e-14 */
		0x0000000000001000L, /* ln(1+2^-45) = 2.842171e-14 */
		0x0000000000000800L, /* ln(1+2^-46) = 1.421085e-14 */
		0x0000000000000400L, /* ln(1+2^-47) = 7.105427e-15 */
		0x0000000000000200L, /* ln(1+2^-48) = 3.552714e-15 */
		0x0000000000000100L, /* ln(1+2^-49) = 1.776357e-15 */
		0x0000000000000080L, /* ln(1+2^-50) = 8.881784e-16 */
		0x0000000000000040L, /* ln(1+2^-51) = 4.440892e-16 */
		0x0000000000000020L, /* ln(1+2^-52) = 2.220446e-16 */
		0x0000000000000000L, /* ln(1+2^-53) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1+2^-54) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1+2^-55) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1+2^-56) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1+2^-57) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1+2^-58) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1+2^-59) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1+2^-60) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1+2^-61) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1+2^-62) = 0.000000e+00 */
		0x0000000000000000L  /* ln(1+2^-63) = 0.000000e+00 */
	};

	private static final long logOneOverOneMinusTwoPowerMinusN64[] = {
		0x0162e42fefa39ef0L, /* ln(1/(1-2^-1)) = 6.931472e-01 */
		0x00934b1089a6dc88L, /* ln(1/(1-2^-2)) = 2.876821e-01 */
		0x00445e3a089f91e8L, /* ln(1/(1-2^-3)) = 1.335314e-01 */
		0x00210b316b3c740cL, /* ln(1/(1-2^-4)) = 6.453852e-02 */
		0x0010415d89e74440L, /* ln(1/(1-2^-5)) = 3.174870e-02 */
		0x0008102b2c49ac1cL, /* ln(1/(1-2^-6)) = 1.574836e-02 */
		0x000404055d62379aL, /* ln(1/(1-2^-7)) = 7.843177e-03 */
		0x00020100ab2b1165L, /* ln(1/(1-2^-8)) = 3.913899e-03 */
		0x00010040155d5882L, /* ln(1/(1-2^-9)) = 1.955035e-03 */
		0x0000801002ab2ac4L, /* ln(1/(1-2^-10)) = 9.770396e-04 */
		0x0000400400555d52L, /* ln(1/(1-2^-11)) = 4.884005e-04 */
		0x00002001000aab2bL, /* ln(1/(1-2^-12)) = 2.441704e-04 */
		0x000010004001555dL, /* ln(1/(1-2^-13)) = 1.220778e-04 */
		0x0000080010002aa9L, /* ln(1/(1-2^-14)) = 6.103702e-05 */
		0x0000040004000555L, /* ln(1/(1-2^-15)) = 3.051804e-05 */
		0x00000200010000abL, /* ln(1/(1-2^-16)) = 1.525891e-05 */
		0x0000010000400015L, /* ln(1/(1-2^-17)) = 7.629424e-06 */
		0x00000080000ffffbL, /* ln(1/(1-2^-18)) = 3.814705e-06 */
		0x000000400003ffffL, /* ln(1/(1-2^-19)) = 1.907350e-06 */
		0x0000002000010000L, /* ln(1/(1-2^-20)) = 9.536748e-07 */
		0x0000001000004000L, /* ln(1/(1-2^-21)) = 4.768373e-07 */
		0x0000000800001000L, /* ln(1/(1-2^-22)) = 2.384186e-07 */
		0x0000000400000400L, /* ln(1/(1-2^-23)) = 1.192093e-07 */
		0x0000000200000100L, /* ln(1/(1-2^-24)) = 5.960465e-08 */
		0x0000000100000040L, /* ln(1/(1-2^-25)) = 2.980232e-08 */
		0x0000000080000010L, /* ln(1/(1-2^-26)) = 1.490116e-08 */
		0x000000003ffffffcL, /* ln(1/(1-2^-27)) = 7.450581e-09 */
		0x000000001fffffffL, /* ln(1/(1-2^-28)) = 3.725290e-09 */
		0x0000000010000000L, /* ln(1/(1-2^-29)) = 1.862645e-09 */
		0x0000000008000000L, /* ln(1/(1-2^-30)) = 9.313226e-10 */
		0x0000000004000000L, /* ln(1/(1-2^-31)) = 4.656613e-10 */
		0x0000000002000000L, /* ln(1/(1-2^-32)) = 2.328306e-10 */
		0x0000000001000000L, /* ln(1/(1-2^-33)) = 1.164153e-10 */
		0x0000000000800000L, /* ln(1/(1-2^-34)) = 5.820766e-11 */
		0x0000000000400000L, /* ln(1/(1-2^-35)) = 2.910383e-11 */
		0x0000000000200000L, /* ln(1/(1-2^-36)) = 1.455192e-11 */
		0x0000000000100000L, /* ln(1/(1-2^-37)) = 7.275958e-12 */
		0x0000000000080000L, /* ln(1/(1-2^-38)) = 3.637979e-12 */
		0x0000000000040000L, /* ln(1/(1-2^-39)) = 1.818989e-12 */
		0x0000000000020000L, /* ln(1/(1-2^-40)) = 9.094947e-13 */
		0x0000000000010000L, /* ln(1/(1-2^-41)) = 4.547474e-13 */
		0x0000000000008000L, /* ln(1/(1-2^-42)) = 2.273737e-13 */
		0x0000000000004000L, /* ln(1/(1-2^-43)) = 1.136868e-13 */
		0x0000000000002000L, /* ln(1/(1-2^-44)) = 5.684342e-14 */
		0x0000000000001000L, /* ln(1/(1-2^-45)) = 2.842171e-14 */
		0x0000000000000800L, /* ln(1/(1-2^-46)) = 1.421085e-14 */
		0x0000000000000400L, /* ln(1/(1-2^-47)) = 7.105427e-15 */
		0x0000000000000200L, /* ln(1/(1-2^-48)) = 3.552714e-15 */
		0x0000000000000100L, /* ln(1/(1-2^-49)) = 1.776357e-15 */
		0x0000000000000080L, /* ln(1/(1-2^-50)) = 8.881784e-16 */
		0x0000000000000040L, /* ln(1/(1-2^-51)) = 4.440892e-16 */
		0x0000000000000020L, /* ln(1/(1-2^-52)) = 2.220446e-16 */
		0x0000000000000020L, /* ln(1/(1-2^-53)) = 2.220446e-16 */
		0x0000000000000000L, /* ln(1/(1-2^-54)) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1/(1-2^-55)) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1/(1-2^-56)) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1/(1-2^-57)) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1/(1-2^-58)) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1/(1-2^-59)) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1/(1-2^-60)) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1/(1-2^-61)) = 0.000000e+00 */
		0x0000000000000000L, /* ln(1/(1-2^-62)) = 0.000000e+00 */
		0x0000000000000000L  /* ln(1/(1-2^-63)) = 0.000000e+00 */
	};

	private static final int arctanTwoPowerMinusN[] = {
		0x11b6e193, /* atan(2^1) = 1.107149e+00 */
		0x0c90fdaa, /* atan(2^0) = 7.853982e-01 */
		0x076b19c1, /* atan(2^-1) = 4.636476e-01 */
		0x03eb6ebf, /* atan(2^-2) = 2.449787e-01 */
		0x01fd5baa, /* atan(2^-3) = 1.243550e-01 */
		0x00ffaade, /* atan(2^-4) = 6.241881e-02 */
		0x007ff557, /* atan(2^-5) = 3.123983e-02 */
		0x003ffeab, /* atan(2^-6) = 1.562373e-02 */
		0x001fffd5, /* atan(2^-7) = 7.812341e-03 */
		0x000ffffb, /* atan(2^-8) = 3.906230e-03 */
		0x0007ffff, /* atan(2^-9) = 1.953123e-03 */
		0x00040000, /* atan(2^-10) = 9.765622e-04 */
		0x00020000, /* atan(2^-11) = 4.882812e-04 */
		0x00010000, /* atan(2^-12) = 2.441406e-04 */
		0x00008000, /* atan(2^-13) = 1.220703e-04 */
		0x00004000, /* atan(2^-14) = 6.103516e-05 */
		0x00002000, /* atan(2^-15) = 3.051758e-05 */
		0x00001000, /* atan(2^-16) = 1.525879e-05 */
		0x00000800, /* atan(2^-17) = 7.629395e-06 */
		0x00000400, /* atan(2^-18) = 3.814697e-06 */
		0x00000200, /* atan(2^-19) = 1.907349e-06 */
		0x00000100, /* atan(2^-20) = 9.536743e-07 */
		0x00000080, /* atan(2^-21) = 4.768372e-07 */
		0x00000040, /* atan(2^-22) = 2.384186e-07 */
		0x00000020, /* atan(2^-23) = 1.192093e-07 */
		0x00000010, /* atan(2^-24) = 5.960464e-08 */
		0x00000008, /* atan(2^-25) = 2.980232e-08 */
		0x00000004, /* atan(2^-26) = 1.490116e-08 */
		0x00000002, /* atan(2^-27) = 7.450581e-09 */
		0x00000001, /* atan(2^-28) = 3.725290e-09 */
		0x00000001, /* atan(2^-29) = 1.862645e-09 */
		0x00000000  /* atan(2^-30) = 9.313226e-10 */
};

	public static int expfix32(int x, int fractionLength, IOverflowMonitor overflowMonitor) {
		final int one = 1 << fractionLength;
		final int tableShift = DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 - fractionLength;

		if (x >= (logTwoPowerNReversed32[fractionLength] >> tableShift)) {
			overflowMonitor.handleOverflow(new OverflowInfo());
			return 0x7fffffff;
		}
		if (x < -(logTwoPowerNReversed32[31 - fractionLength] >> tableShift)) {
			return 0;
		}
		if (x == 0) {
			return one;
		}

		{
			final int maxPower = 31 - fractionLength;
			final int negativeFractionLength = -fractionLength;

			int result = one;
			int temp = x << tableShift;

			if (x > 0) {
				int power = maxPower;
				int[] logEntry = logTwoPowerNReversed32;
				int index = fractionLength;

				while (temp != 0 && power > negativeFractionLength) {
					while (power == 0 || temp < logEntry[index]) {
						if (power == 0) {
							logEntry = logOnePlusTwoPowerMinusN32;
							index = 0;
						} else {
							++index;
						}
						--power;
					}
					temp -= logEntry[index];
					if (power < 0) {
						result += result >> -power;
					} else {
						result <<= power;
					}
				}
			} else {
				int power = fractionLength;
				int[] logEntry = logTwoPowerNReversed32;
				int index = maxPower - power + fractionLength;

				while (temp != 0 && power > negativeFractionLength) {
					while (power == 0 || temp > -logEntry[index]) {
						if (power == 0) {
							logEntry = logOneOverOneMinusTwoPowerMinusN32;
							index = 0;
						} else {
							++index;
						}
						--power;
					}
					temp += logEntry[index];
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

	public static long expfix64(long x, int fractionLength, IOverflowMonitor overflowMonitor) {
		final long one = 1L << fractionLength;
		final int tableShift = DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64 - fractionLength;

		if (x >= (logTwoPowerNReversed64[fractionLength] >> tableShift)) {
			overflowMonitor.handleOverflow(new OverflowInfo());
			return 0x7fffffffffffffffL;
		}
		if (x < -(logTwoPowerNReversed64[63 - fractionLength] >> tableShift)) {
			return 0L;
		}
		if (x == 0) {
			return one;
		}

		{
			final int maxPower = 63 - fractionLength;
			final int negativeFractionLength = -fractionLength;

			long result = one;
			long temp = x << tableShift;

			if (x > 0) {
				int power = maxPower;
				long[] logEntry = logTwoPowerNReversed64;
				int index = fractionLength;

				while (temp != 0 && power > negativeFractionLength) {
					while (power == 0 || temp < logEntry[index]) {
						if (power == 0) {
							logEntry = logOnePlusTwoPowerMinusN64;
							index = 0;
						} else {
							++index;
						}
						--power;
					}
					temp -= logEntry[index];
					if (power < 0) {
						result += result >> -power;
					} else {
						result <<= power;
					}
				}
			} else {
				int power = fractionLength;
				long[] logEntry = logTwoPowerNReversed64;
				int index = maxPower - power + fractionLength;

				while (temp != 0 && power > negativeFractionLength) {
					while (power == 0 || temp > -logEntry[index]) {
						if (power == 0) {
							logEntry = logOneOverOneMinusTwoPowerMinusN64;
							index = 0;
						} else {
							++index;
						}
						--power;
					}
					temp += logEntry[index];
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

	private static int lnfix32base(int x, int fractionLength, IOverflowMonitor overflowMonitor) {
		final int one = 1 << fractionLength;

		if (x <= 0) {
			overflowMonitor.handleOverflow(new OverflowInfo());
			return -0x7fffffff;
		}
	    if (x == one) {
			return 0;
		}

	    {
			final /* unsigned */ int scalePosition = 0x80000000;
			final int maxPower = 31 - fractionLength;

			int result;

			int leftShift = 0;
			/* unsigned */ int rightShift = 1;

			/* unsigned */ int temp = x;
			/* unsigned */ int shiftedTemp;

			while (isLessThanUnsigned(temp, scalePosition)) {
				++leftShift;
				temp <<= 1;
			}

			result = leftShift < maxPower ? logTwoPowerNReversed32[leftShift + fractionLength] : -logTwoPowerNReversed32[2 * maxPower - leftShift + fractionLength];
			shiftedTemp = temp >>> 1;

			while (temp != 0 && isLessThanUnsigned(rightShift, fractionLength)) {
				while (isLessThanUnsigned(rightShift, fractionLength) && isLessThanUnsigned(temp, shiftedTemp + scalePosition)) {
					shiftedTemp >>>= 1;
					++rightShift;
				}

				temp -= shiftedTemp;
				shiftedTemp = temp >>> rightShift;
				result += logOneOverOneMinusTwoPowerMinusN32[rightShift - 1];
			}

			return result;
	    }
	}
	
	private static long lnfix64base(long x, int fractionLength, IOverflowMonitor overflowMonitor) {
		final long one = 1L << fractionLength;

		if (x <= 0) {
			overflowMonitor.handleOverflow(new OverflowInfo());
			return -0x7fffffffffffffffL;
		}
	    if (x == one) {
			return 0L;
		}

	    {
			final /* unsigned */ long scalePosition = 0x8000000000000000L;
			final int maxPower = 63 - fractionLength;

			long result;

			int leftShift = 0;
			/* unsigned */ int rightShift = 1;

			/* unsigned */ long temp = x;
			/* unsigned */ long shiftedTemp;

			while (isLessThanUnsigned(temp, scalePosition)) {
				++leftShift;
				temp <<= 1;
			}

			result = leftShift < maxPower ? logTwoPowerNReversed64[leftShift + fractionLength] : -logTwoPowerNReversed64[2 * maxPower - leftShift + fractionLength];
			shiftedTemp = temp >>> 1;

			while (temp != 0 && isLessThanUnsigned(rightShift, fractionLength)) {
				while (isLessThanUnsigned(rightShift, fractionLength) && isLessThanUnsigned(temp, shiftedTemp + scalePosition)) {
					shiftedTemp >>>= 1;
					++rightShift;
				}

				temp -= shiftedTemp;
				shiftedTemp = temp >>> rightShift;
				result += logOneOverOneMinusTwoPowerMinusN64[rightShift - 1];
			}

			return result;
	    }
	}

	public static int lnfix32(int x, int fractionLength, IOverflowMonitor overflowMonitor) {
		int result = lnfix32base(x, fractionLength, overflowMonitor);
		int shift = DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 - fractionLength;
		return shift >= 0 ? result >> shift : result << -shift;
	}

	public static long lnfix64(long x, int fractionLength, IOverflowMonitor overflowMonitor) {
		long result = lnfix64base(x, fractionLength, overflowMonitor);
		int shift = DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64 - fractionLength;
		return shift >= 0 ? result >> shift : result << -shift;
	}

	public static int lgfix32(int x, int fractionLength, IOverflowMonitor overflowMonitor) {
		int lnResult = lnfix32base(x, fractionLength, overflowMonitor) >> (DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 - 16);
		int result = mulfix32(lnResult, 0x6f2e, 16, overflowMonitor);
		int shift = 16 - fractionLength;
		return shift >= 0 ? result >> shift : result << -shift;
	}

	public static long lgfix64(long x, int fractionLength, IOverflowMonitor overflowMonitor) {
		long lnResult = lnfix64base(x, fractionLength, overflowMonitor) >> (DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64 - 28);
		long result = mulfix64(lnResult, 0x06f2dec5L, 28, overflowMonitor);
		int shift = 28 - fractionLength;
		return shift >= 0 ? result >> shift : result << -shift;
	}

	public static int lbfix32(int x, int fractionLength, IOverflowMonitor overflowMonitor) {
		int lnResult = lnfix32base(x, fractionLength, overflowMonitor) >> (DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_32 - 16);
		int result = mulfix32(lnResult, 0x17154, 16, overflowMonitor);
		int shift = 16 - fractionLength;
		return shift >= 0 ? result >> shift : result << -shift;
	}

	public static long lbfix64(long x, int fractionLength, IOverflowMonitor overflowMonitor) {
		long lnResult = lnfix64base(x, fractionLength, overflowMonitor) >> (DAMOS_MATH_LOG_TABLE_FRACTION_LENGTH_64 - 26);
		long result = mulfix64(lnResult, 0x05c551d9L, 26, overflowMonitor);
		int shift = 26 - fractionLength;
		return shift >= 0 ? result >> shift : result << -shift;
	}

	public static int powfix32(int base, int exponent, int fractionLength, IOverflowMonitor overflowMonitor) {
		return expfix32(mulfix32(exponent, lnfix32(base, fractionLength, overflowMonitor), fractionLength, overflowMonitor), fractionLength, overflowMonitor);
	}

	public static long powfix64(long base, long exponent, int fractionLength, IOverflowMonitor overflowMonitor) {
		return expfix64(mulfix64(exponent, lnfix64(base, fractionLength, overflowMonitor), fractionLength, overflowMonitor), fractionLength, overflowMonitor);
	}
	
	private static int mulfix32(int a, int b, int fractionLength, IOverflowMonitor overflowMonitor) {
		final int mask = (1 << fractionLength) - 1;

		int hi0 = a >> fractionLength;
		int hi1 = b >> fractionLength;
		/* unsigned */ int lo0 = a & mask;
		/* unsigned */ int lo1 = b & mask;

		int resultHi = hi0 * hi1;
		int result = hi0 * lo1 + hi1 * lo0;
		/* unsigned */ int resultLo = lo0 * lo1;

		result += (resultHi & mask) << fractionLength;
		result += resultLo >>> fractionLength;
		
		if (((a ^ result) & (b ^ result)) < 0) {
			overflowMonitor.handleOverflow(new OverflowInfo());
		}
		
        return result;
	}

//	private static int mulfix3264(int a, int b, int fractionLength, IOverflowMonitor overflowMonitor) {
//		if (a < Integer.MAX_VALUE / b) {
//			overflowMonitor.handleOverflow(new OverflowInfo());
//		}
//		
//        return (int) ((long) a * (long) b >> fractionLength);
//	}

	private static long mulfix64(long a, long b, int fractionLength, IOverflowMonitor overflowMonitor) {
		long result = a * b >> fractionLength;
		if (((a ^ result) & (b ^ result)) < 0) {
			overflowMonitor.handleOverflow(new OverflowInfo());
		}
		return result;
	}

	public static boolean isLessThanUnsigned(int n1, int n2) {
		boolean comp = n1 < n2;
		if (n1 < 0 != n2 < 0) {
			comp = !comp;
		}
		return comp;
	}
	
	public static boolean isLessThanUnsigned(long n1, long n2) {
		boolean comp = n1 < n2;
		if (n1 < 0 != n2 < 0) {
			comp = !comp;
		}
		return comp;
	}

	private static int rightShift32(int x, int shift) {
		return shift < 0 ? x << -shift : x >> shift;
	}

	private static long rightShift64(long x, int shift) {
		return shift < 0 ? x << -shift : x >> shift;
	}

	private static int scaleCordicResult32(int x) {
		final int scaleFactor = 0x22C2DD1C; /* 0.271572 * 2^31*/
		return (int) ((long) x * scaleFactor >> 31);
	}

	private static void performCordicRotation32(int[] px, int[] py, int theta) {
		int x = px[0], y = py[0];
		int arctanIndex = 0;
		int i;
		for (i = -1; i <= DAMOS_MATH_TRIG_FRACTION_LENGTH; ++i) {
			final int yShift = rightShift32(y, i);
			final int xShift = rightShift32(x, i);

			if (theta < 0) {
				x += yShift;
				y -= xShift;
				theta += arctanTwoPowerMinusN[arctanIndex++];
			} else {
				x -= yShift;
				y += xShift;
				theta -= arctanTwoPowerMinusN[arctanIndex++];
			}
		}
		px[0] = scaleCordicResult32(x);
		py[0] = scaleCordicResult32(y);
	}

	private static void sincos32(int theta, int[] s, int[] c) {
		int x = theta;

		if (x < 0) {
			x += DAMOS_MATH_TWO_PI;
		}

		boolean negateCos = false;
		boolean negateSin = false;

		if (x > DAMOS_MATH_PI) {
			x = DAMOS_MATH_TWO_PI - x;
			negateSin = true;
		}
		if (x > DAMOS_MATH_HALF_PI) {
			x = DAMOS_MATH_PI - x;
			negateCos = true;
		}
		int[] xCos = { 1 << DAMOS_MATH_TRIG_FRACTION_LENGTH };
		int[] xSin = { 0 };

		performCordicRotation32(xCos, xSin, x);

		if (s != null) {
			s[0] = negateSin ? -xSin[0] : xSin[0];
		}
		if (c != null) {
			c[0] = negateCos ? -xCos[0] : xCos[0];
		}
	}

	private static int reduceTheta32(int theta, int fractionLength) {
		final int mask = 1 << DAMOS_MATH_TRIG_FRACTION_LENGTH;
		int n;
		for (n = fractionLength; n < DAMOS_MATH_TRIG_FRACTION_LENGTH && (theta & mask) == 0; ++n) {
			theta <<= 1;
		}
		int shiftedPi = rightShift32(DAMOS_MATH_TWO_PI, DAMOS_MATH_TRIG_FRACTION_LENGTH - n);
		if (theta < shiftedPi || theta > shiftedPi) {
			theta %= shiftedPi;
		}
		return rightShift32(theta, n - DAMOS_MATH_TRIG_FRACTION_LENGTH);
	}

	private static long reduceTheta64(long theta, int fractionLength) {
		long shiftedPi = rightShift64(DAMOS_MATH_TWO_PI, DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
		if (theta < shiftedPi || theta > shiftedPi) {
			theta %= shiftedPi;
		}
		return rightShift64(theta, fractionLength - DAMOS_MATH_TRIG_FRACTION_LENGTH);
	}

	public static int sinfix32(int x, int fractionLength, IOverflowMonitor overflowMonitor) {
		int[] result = { 0 };
		sincos32(reduceTheta32(x, fractionLength), result, null);
		return rightShift32(result[0], DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
	}

	public static long sinfix64(long x, int fractionLength, IOverflowMonitor overflowMonitor) {
		int[] result = { 0 };
		sincos32((int) reduceTheta64(x, fractionLength), result, null);
		return rightShift64(result[0], DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
	}

	public static int cosfix32(int x, int fractionLength, IOverflowMonitor overflowMonitor) {
		int[] result = { 0 };
		sincos32(reduceTheta32(x, fractionLength), null, result);
		return rightShift32(result[0], DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
	}

	public static long cosfix64(long x, int fractionLength, IOverflowMonitor overflowMonitor) {
		int[] result = { 0 };
		sincos32((int) reduceTheta64(x, fractionLength), null, result);
		return rightShift64(result[0], DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
	}

	public static int tanfix32(int x, int fractionLength, IOverflowMonitor overflowMonitor) {
		int[] s = { 0 };
		int[] c = { 0 };
		sincos32(reduceTheta32(x, fractionLength), s, c);
		if (c[0] == 0) {
			overflowMonitor.handleOverflow(new OverflowInfo());
			return 0x7fffffff;
		}
		long result = ((long) s[0] << DAMOS_MATH_TRIG_FRACTION_LENGTH) / c[0];
		if (result > 0x7fffffff) {
			overflowMonitor.handleOverflow(new OverflowInfo());
			return 0x7fffffff;
		}
		return rightShift32((int) result, DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
	}

	public static long tanfix64(long x, int fractionLength, IOverflowMonitor overflowMonitor) {
		int[] s = { 0 };
		int[] c = { 0 };
		sincos32((int) reduceTheta64(x, fractionLength), s, c);
		if (c[0] == 0) {
			overflowMonitor.handleOverflow(new OverflowInfo());
			return 0x7fffffffffffffffL;
		}
		return rightShift64(((long) s[0] << DAMOS_MATH_TRIG_FRACTION_LENGTH) / c[0], DAMOS_MATH_TRIG_FRACTION_LENGTH - fractionLength);
	}

}
