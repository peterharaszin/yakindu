
#include "afterTest_Iface.h"

#ifdef __cplusplus
 extern "C" {
#endif

/** @brief callback function to be filled with platform specific code by the implementer
 *  
 Prototyp only, function must be filled systemdependent by implementer 
   These two (virtual) functions are called inside the state machine and implement the timer service */
extern void afterTest_timerIface_installTimer(void* ihandle, uint32 trigger, uint64 time_ms);
extern void afterTest_timerIface_resetTimer(void* ihandle, uint32 trigger);

/* Interface funktion is called by the timer service to inform the state machine of a time-trigger event */
extern void afterTest_timerIface_raiseTimer(void* ihandle, uint32 trigger);

#ifdef __cplusplus
 }
#endif

