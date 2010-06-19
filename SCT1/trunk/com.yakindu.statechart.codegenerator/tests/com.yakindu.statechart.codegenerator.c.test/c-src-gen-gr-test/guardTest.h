#include "guardTest_Handle.h"
#include "guardTest_Iface.h"
#include "sm_guardTest.h"

#ifdef __cplusplus
 extern "C" {
#endif

/** @brief Function to initialize the state machine handle 
 *
 * The handle is initialized completely, the interface communication is set up and the 
 * state is set to the initial state of the most global region.
 * 
 * The function did not allocate any new memory from the heap, so the size of a handle 
 * structure is of static size and does not change during initialization or operation. 
 * 
 * @param handle
 * : The handle must be a pointer to a valid memory region, great enough
 *         to hold the handle data.
 *  
*/
extern void guardTest_init(GuardTest_Handle* handle);

/** @brief Function to call one cycle of the state machine
 * 
 * The call to guardTest_runCycle() initiates one run to completion cycle process of the state machine. 
 *
 * @param handle
 * : A valid/initialized state machine handle
 *
 * Please be aware that, if there are uncondition transitions between two states or the transitions (e.g. guards)
 * are always taken, the do-while loop runs infinite!
 *
 */
extern void guardTest_runCycle(GuardTest_Handle* handle);

/** @brief Function to clean up the external triggers.
 * 
 * Function can be called explicitly, but is called whenever guardTest_runCycle() is called
 *
 * @param handle
 * : A valid/initialized state machine handle
 *   
*/
extern void guardTest_cleanUnusedTriggers(GuardTest_Handle* handle);

/** @brief Function to access the integer value of variable \em startState  for reading
 * 
 * Function gives read access to the variable \em startState , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em startState  belongs to.
 * 
 * @return
 * The actual value of variable \em startState .   
*/
extern int32 guardTest_getVar_startState(GuardTest_Handle* handle);
/** @brief Function to access the integer value of variable \em state1  for reading
 * 
 * Function gives read access to the variable \em state1 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em state1  belongs to.
 * 
 * @return
 * The actual value of variable \em state1 .   
*/
extern int32 guardTest_getVar_state1(GuardTest_Handle* handle);
/** @brief Function to access the integer value of variable \em state2  for reading
 * 
 * Function gives read access to the variable \em state2 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em state2  belongs to.
 * 
 * @return
 * The actual value of variable \em state2 .   
*/
extern int32 guardTest_getVar_state2(GuardTest_Handle* handle);
/** @brief Function to access the integer value of variable \em state3  for reading
 * 
 * Function gives read access to the variable \em state3 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em state3  belongs to.
 * 
 * @return
 * The actual value of variable \em state3 .   
*/
extern int32 guardTest_getVar_state3(GuardTest_Handle* handle);
/** @brief Function to access the integer value of variable \em out  for reading
 * 
 * Function gives read access to the variable \em out , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em out  belongs to.
 * 
 * @return
 * The actual value of variable \em out .   
*/
extern int32 guardTest_getVar_out(GuardTest_Handle* handle);
/** @brief Function to access the integer value of variable \em gValue  for reading
 * 
 * Function gives read access to the variable \em gValue , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em gValue  belongs to.
 * 
 * @return
 * The actual value of variable \em gValue .   
*/
extern int32 guardTest_getVar_gValue(GuardTest_Handle* handle);
/** @brief Function to access the integer value of variable \em value1  for reading
 * 
 * Function gives read access to the variable \em value1 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em value1  belongs to.
 * 
 * @return
 * The actual value of variable \em value1 .   
*/
extern int32 guardTest_getVar_value1(GuardTest_Handle* handle);
/** @brief Function to access the integer value of variable \em value2  for reading
 * 
 * Function gives read access to the variable \em value2 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em value2  belongs to.
 * 
 * @return
 * The actual value of variable \em value2 .   
*/
extern int32 guardTest_getVar_value2(GuardTest_Handle* handle);
/** @brief Function to access the integer value of variable \em state4  for reading
 * 
 * Function gives read access to the variable \em state4 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em state4  belongs to.
 * 
 * @return
 * The actual value of variable \em state4 .   
*/
extern int32 guardTest_getVar_state4(GuardTest_Handle* handle);
/** @brief Function to access the integer value of variable \em state5  for reading
 * 
 * Function gives read access to the variable \em state5 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em state5  belongs to.
 * 
 * @return
 * The actual value of variable \em state5 .   
*/
extern int32 guardTest_getVar_state5(GuardTest_Handle* handle);
/** @brief Function to access the integer value of variable \em state6  for reading
 * 
 * Function gives read access to the variable \em state6 , created by the state machine editor.
 * This function is only available if the variable is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, variable \em state6  belongs to.
 * 
 * @return
 * The actual value of variable \em state6 .   
*/
extern int32 guardTest_getVar_state6(GuardTest_Handle* handle);



/** @brief Function to raise trigger \em trigger1 
 * 
 * Function raises the trigger \em trigger1, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em trigger1 belongs to.
 * 
*/
extern void guardTest_raiseTrigger_trigger1(GuardTest_Handle* handle);    
/** @brief Function to raise trigger \em trigger2 
 * 
 * Function raises the trigger \em trigger2, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em trigger2 belongs to.
 * 
*/
extern void guardTest_raiseTrigger_trigger2(GuardTest_Handle* handle);    
/** @brief Function to raise trigger \em trigger3 
 * 
 * Function raises the trigger \em trigger3, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em trigger3 belongs to.
 * 
*/
extern void guardTest_raiseTrigger_trigger3(GuardTest_Handle* handle);    
/** @brief Function to raise trigger \em trigger4 
 * 
 * Function raises the trigger \em trigger4, created by the state machine editor.
 * This function is only available if the trigger is marked as input.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em trigger4 belongs to.
 * 
*/
extern void guardTest_raiseTrigger_trigger4(GuardTest_Handle* handle);    
/** @brief Function to access the trigger \em trigger5 for reading
 * 
 * Function gives read access to the trigger \em trigger5, created by the state machine editor.
 * This function is only available if the trigger is marked as output.
 *
 * @param handle
 * : A valid/initialized state machine handle, the trigger \em trigger5 belongs to.
 * 
 * @return
 * The actual status of trigger \em trigger5; true if set, false if not.   
*/
extern BOOL guardTest_getTrigger_trigger5(GuardTest_Handle* handle);


#ifdef __cplusplus
  }
#endif

