# Name: Makefile
# Author: Joern Seger
# Copyright: 2009 Itemis AG, Joern Seger
# License: GPL

include c-src-gen/make.include
include environment/make.include
#include graphicLib/make.include

DEVICE     = atmega128
CLOCK      = 7456000
#For Windows (For MacOSX change PORT to /dev/tty.PL2303-* )
PORT       = COM4
PROGRAMMER = -c stk500v2 -P $(PORT) -F
OBJECTS    = main.o trafficlightWaiting_timerIface.o $(ENV_OBJ) $(GRAPHIC_OBJ) $(patsubst %.o, c-src-gen/%.o, $(SM_TRAFFICLIGHTWAITING_OBJ))
LIBS       = 
#graphicLib/glcd-Display3000-211.obj

FUSES      = -U hfuse:w:0xd9:m -U lfuse:w:0x24:m
# ATMega8 fuse bits (fuse bits for other devices are different!):
# Example for 8 MHz internal oscillator
# Fuse high byte:
# 0xd9 = 1 1 0 1   1 0 0 1 <-- BOOTRST (boot reset vector at 0x0000)
#        ^ ^ ^ ^   ^ ^ ^------ BOOTSZ0
#        | | | |   | +-------- BOOTSZ1
#        | | | |   +---------- EESAVE (set to 0 to preserve EEPROM over chip erase)
#        | | | +-------------- CKOPT (clock option, depends on oscillator type)
#        | | +---------------- SPIEN (if set to 1, serial programming is disabled)
#        | +------------------ WDTON (if set to 0, watchdog is always on)
#        +-------------------- RSTDISBL (if set to 0, RESET pin is disabled)
# Fuse low byte:
# 0x24 = 0 0 1 0   0 1 0 0
#        ^ ^ \ /   \--+--/
#        | |  |       +------- CKSEL 3..0 (8M internal RC)
#        | |  +--------------- SUT 1..0 (slowly rising power)
#        | +------------------ BODEN (if 0, brown-out detector is enabled)
#        +-------------------- BODLEVEL (if 0: 4V, if 1: 2.7V)

# Example for 12 MHz external crystal:
# Fuse high byte:
# 0xc9 = 1 1 0 0   1 0 0 1 <-- BOOTRST (boot reset vector at 0x0000)
#        ^ ^ ^ ^   ^ ^ ^------ BOOTSZ0
#        | | | |   | +-------- BOOTSZ1
#        | | | |   +---------- EESAVE (set to 0 to preserve EEPROM over chip erase)
#        | | | +-------------- CKOPT (clock option, depends on oscillator type)
#        | | +---------------- SPIEN (if set to 1, serial programming is disabled)
#        | +------------------ WDTON (if set to 0, watchdog is always on)
#        +-------------------- RSTDISBL (if set to 0, RESET pin is disabled)
# Fuse low byte:
# 0x9f = 1 0 0 1   1 1 1 1
#        ^ ^ \ /   \--+--/
#        | |  |       +------- CKSEL 3..0 (external >8M crystal)
#        | |  +--------------- SUT 1..0 (crystal osc, BOD enabled)
#        | +------------------ BODEN (if 0, brown-out detector is enabled)
#        +-------------------- BODLEVEL (if 0: 4V, if 1: 2.7V)


# Tune the lines below only if you know what you are doing:

AVRDUDE = avrdude $(PROGRAMMER) -p $(DEVICE)
COMPILE = avr-gcc -Wall -Os -DF_CPU=$(CLOCK) -mmcu=$(DEVICE) -I. -I./graphicLib -I./environment -I./c-src-gen -ansi -pedantic
COMPILEPP = avr-g++ -Wall -Os -DF_CPU=$(CLOCK) -mmcu=$(DEVICE) -I. -I./graphicLib -I./environment -I./c-src-gen -I/usr/local/AVRMacPack-20081213/avr-4/include
# -DWITH_DP3000_GL
# symbolic targets:
all:	main.hex

.cpp.o:
	$(COMPILEPP) -c $< -o $@

.c.o:
	$(COMPILE) -c $< -o $@

.S.o:
	$(COMPILE) -x assembler-with-cpp -c $< -o $@

.c.s:
	$(COMPILE) -S $< -o $@

flash:	all
	$(AVRDUDE) -U flash:w:main.hex:i

#fuse:
#	$(AVRDUDE) $(FUSES)

# Xcode uses the Makefile targets "", "clean" and "install"
#install: flash fuse

# if you use a bootloader, change the command below appropriately:
#load: all
#	bootloadHID main.hex

clean:
	rm -f main.hex main.elf $(OBJECTS)

# file targets:
main.elf: $(OBJECTS)
	$(COMPILE) -o main.elf $(OBJECTS) $(LIBS)

main.hex: main.elf
	rm -f main.hex
	avr-objcopy -j .text -j .data -O ihex main.elf main.hex
# If you have an EEPROM section, you must also create a hex file for the
# EEPROM and add it to the "flash" target.

# Targets for code debugging and analysis:
disasm:	main.elf
	avr-objdump -d main.elf

cpp:
	$(COMPILE) -E main.c
