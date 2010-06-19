
#include "definitions.h"

#include "sm_historyTest_MainState_State0_State3.h"


/* var() gives complete access to the variable 
   this is only used for better readablility */
#define var(x) (rhandle->global->ihandle.x)

/* send() raises a trigger. This is implemented for easier readablility */
#define send(x) (historyTest_Iface_raiseTrigger(&rhandle->global->ihandle,x))

/* Forward Declaration of internal functions */
static void local_State4_handle(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);
static void local_State5_handle(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);
static void local_Initial_handle(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);

static BOOL local_State4_analyseTransitionIn(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);
static BOOL local_State5_analyseTransitionIn(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);
static BOOL local_Initial_analyseTransitionIn(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);

static void local_State4_enter(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);
static void local_State5_enter(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);
static void local_Initial_enter(SM_HistoryTest_MainState_State0_State3_Handle* rhandle);

static void local_State4_exit(SM_HistoryTest_MainState_State0_State3_Handle* rhandle, HistoryTest_StateType oldState);
static void local_State5_exit(SM_HistoryTest_MainState_State0_State3_Handle* rhandle, HistoryTest_StateType oldState);
static void local_Initial_exit(SM_HistoryTest_MainState_State0_State3_Handle* rhandle, HistoryTest_StateType oldState);

static HistoryTest_StateType getLocalStateInThisRegion(HistoryTest_StateType globalState);

/* End of forward declarations */

/*! The function returns the state on this hierarchy level, the state given as parameter belongs to.
    
    The state machine does only store the actual state of a state machine. The state, this actual state
    is nested in can be extracted by this function.
    
    Every region level provides this function to get the right state in this hierarchy level. 

*/
HistoryTest_StateType getLocalStateInThisRegion(HistoryTest_StateType globalState)
{
    HistoryTest_StateType stateInThisRegion;
    
	switch (globalState) {
    
      /* look for state in this region */
      case st_historyTest_MainState_State0_State3_State4: {
        stateInThisRegion = st_historyTest_MainState_State0_State3_State4;
	 	break;
	  }


    
      /* look for state in this region */
      case st_historyTest_MainState_State0_State3_State5: {
        stateInThisRegion = st_historyTest_MainState_State0_State3_State5;
	 	break;
	  }


    
      /* look for state in this region */
      case st_historyTest_MainState_State0_State3_Initial: {
        stateInThisRegion = st_historyTest_MainState_State0_State3_Initial;
	 	break;
	  }


    
    default: {
      /* error: using the inital state - only for completeness */
      stateInThisRegion = st_historyTest_MainState_State0_State3_Initial;
      break;
    }
  }
  
  return(stateInThisRegion);
}

BOOL sm_historyTest_MainState_State0_State3_runCycle(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
	HistoryTest_StateType oldState = rhandle->global->state;
	HistoryTest_StateType localState = getLocalStateInThisRegion(rhandle->global->state);
	
	/* clean transition information */
	rhandle->global->transition = trans_HistoryTest_noTransition;
	
    /* handle actual state and find transitions */
	switch (localState) {
    
      case st_historyTest_MainState_State0_State3_State4: {
        local_State4_handle(rhandle);
	 	break;
	  }  
    
      case st_historyTest_MainState_State0_State3_State5: {
        local_State5_handle(rhandle);
	 	break;
	  }  
    
      case st_historyTest_MainState_State0_State3_Initial: {
        local_Initial_handle(rhandle);
	 	break;
	  }  
	  
    default: {
        local_Initial_handle(rhandle);
      }
	}
	
	/* if the new state is within this region but the local state has changed,
	   then run the enter entries */
	if (((sm_historyTest_MainState_State0_State3_isIn(rhandle->global->state) == TRUE) && 
	    (localState != getLocalStateInThisRegion(rhandle->global->state))) ||
	    ((rhandle->global->state == localState) && (rhandle->global->transition != trans_HistoryTest_noTransition))) {

	  /* run the state exit actions from this point */
      sm_historyTest_MainState_State0_State3_exit(rhandle, oldState);

      /* run the transition action */
	  if (rhandle->global->transition != trans_HistoryTest_noTransition)
	    historyTest_callTransitionAction(rhandle->global);
	  
	  /* run the state entry actions from this point */
	  sm_historyTest_MainState_State0_State3_enter(rhandle);
	}
	
  return(rhandle->global->state == oldState);
}

BOOL sm_historyTest_MainState_State0_State3_isIn(HistoryTest_StateType testState)
{
	BOOL retvalue = FALSE;
	
	switch (testState) {
	
	case st_historyTest_MainState_State0_State3_State5: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_State0_State3_Initial: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_State0_State3_State4: {
		retvalue = TRUE;
		break;
	}
	
	default: {
	  retvalue = FALSE;
	}
	
	}
	
	return(retvalue);
}

void sm_historyTest_MainState_State0_State3_enter(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
  HistoryTest_StateType localState = getLocalStateInThisRegion(rhandle->global->state);
  
  /* running through all local states in this region */
  switch (localState) {
    /* look for state in this region */
    case st_historyTest_MainState_State0_State3_State4: {
      local_State4_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_historyTest_MainState_State0_State3_State5: {
      local_State5_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_historyTest_MainState_State0_State3_Initial: {
      local_Initial_enter(rhandle);
	  break;
	}

    default: {
        rhandle->global->state = st_historyTest_MainState_State0_State3_Initial;
        local_Initial_enter(rhandle);
      }
	}
	
    return;
}

void sm_historyTest_MainState_State0_State3_exit(SM_HistoryTest_MainState_State0_State3_Handle* rhandle, HistoryTest_StateType oldState)
{
    HistoryTest_StateType localState = getLocalStateInThisRegion(oldState);

    /* running through all local states in this region */
    switch (localState) {
      case st_historyTest_MainState_State0_State3_State4: {
        local_State4_exit(rhandle, oldState);
	 	break;
	  }

      case st_historyTest_MainState_State0_State3_State5: {
        local_State5_exit(rhandle, oldState);
	 	break;
	  }

      case st_historyTest_MainState_State0_State3_Initial: {
        local_Initial_exit(rhandle, oldState);
	 	break;
	  }

	  
    default: {
        /* can't do anything here */
      }
	}

    return;
}



void local_State4_enter(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(inState4) = 1;
    
			
}


void local_State4_exit(SM_HistoryTest_MainState_State0_State3_Handle* rhandle, HistoryTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      var(inState4) = 0;
    
          
   /* remember the old state */
   
   return;
}


void local_State4_handle(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State4_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State4_analyseTransitionIn(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "event3" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  historyTest_Iface_isTriggerRaised(&rhandle->global->ihandle,event3) )  
    {
      historyTest_Iface_resetTrigger(&rhandle->global->ihandle,event3); 
          
      /* return new status */
	  rhandle->global->state      = st_historyTest_MainState_State2_State6;
	  rhandle->global->transition = historyTest_MainState_State0_State3_State4_TO_historyTest_MainState_State2_State6_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State5_enter(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(inState5) = 1;
    
			
}


void local_State5_exit(SM_HistoryTest_MainState_State0_State3_Handle* rhandle, HistoryTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      var(inState5) = 0;
    
          
   /* remember the old state */
   
   return;
}


void local_State5_handle(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State5_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State5_analyseTransitionIn(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "event2" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  historyTest_Iface_isTriggerRaised(&rhandle->global->ihandle,event2) )  
    {
      historyTest_Iface_resetTrigger(&rhandle->global->ihandle,event2); 
          
      /* return new status */
	  rhandle->global->state      = st_historyTest_MainState_State0_State3_State4;
	  rhandle->global->transition = historyTest_MainState_State0_State3_State5_TO_historyTest_MainState_State0_State3_State4_P1;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "event4/selfTrans+=2;" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  historyTest_Iface_isTriggerRaised(&rhandle->global->ihandle,event4) )  
    {
      historyTest_Iface_resetTrigger(&rhandle->global->ihandle,event4); 
          
      /* return new status */
	  rhandle->global->state      = st_historyTest_MainState_State0_State3_State5;
	  rhandle->global->transition = historyTest_MainState_State0_State3_State5_TO_historyTest_MainState_State0_State3_State5_P2;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_Initial_enter(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
	
	/* rhandle->global->state = st_historyTest_MainState_State0_State3_Initial;  */ 
} 


void local_Initial_exit(SM_HistoryTest_MainState_State0_State3_Handle* rhandle, HistoryTest_StateType oldState)
{
} 


void local_Initial_handle(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
	(void)local_Initial_analyseTransitionIn(rhandle);

    return;
}


BOOL local_Initial_analyseTransitionIn(SM_HistoryTest_MainState_State0_State3_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (1 == 1) )  
    {
          
      /* return new status */
	  rhandle->global->state      = st_historyTest_MainState_State0_State3_State4;
	  rhandle->global->transition = historyTest_MainState_State0_State3_Initial_TO_historyTest_MainState_State0_State3_State4_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



