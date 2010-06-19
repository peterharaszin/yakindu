
#include "definitions.h"

#include "sm_historyTest_MainState.h"

/* Include all nested states/regions */
#include "sm_historyTest_MainState_State0.h"
/* Include all nested states/regions */
#include "sm_historyTest_MainState_State2.h"

/* var() gives complete access to the variable 
   this is only used for better readablility */
#define var(x) (rhandle->global->ihandle.x)

/* send() raises a trigger. This is implemented for easier readablility */
#define send(x) (historyTest_Iface_raiseTrigger(&rhandle->global->ihandle,x))

/* Forward Declaration of internal functions */
static void local_State0_handle(SM_HistoryTest_MainState_Handle* rhandle);
static void local_Initial_handle(SM_HistoryTest_MainState_Handle* rhandle);
static void local_State1_handle(SM_HistoryTest_MainState_Handle* rhandle);
static void local_State2_handle(SM_HistoryTest_MainState_Handle* rhandle);
static void local_ShallowHistory_handle(SM_HistoryTest_MainState_Handle* rhandle);
static void local_DeepHistory_handle(SM_HistoryTest_MainState_Handle* rhandle);

static BOOL local_State0_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle);
static BOOL local_Initial_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle);
static BOOL local_State1_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle);
static BOOL local_State2_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle);
static BOOL local_ShallowHistory_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle);
static BOOL local_DeepHistory_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle);

static void local_State0_enter(SM_HistoryTest_MainState_Handle* rhandle);
static void local_Initial_enter(SM_HistoryTest_MainState_Handle* rhandle);
static void local_State1_enter(SM_HistoryTest_MainState_Handle* rhandle);
static void local_State2_enter(SM_HistoryTest_MainState_Handle* rhandle);
static void local_ShallowHistory_enter(SM_HistoryTest_MainState_Handle* rhandle);
static void local_DeepHistory_enter(SM_HistoryTest_MainState_Handle* rhandle);

static void local_State0_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState);
static void local_Initial_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState);
static void local_State1_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState);
static void local_State2_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState);
static void local_ShallowHistory_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState);
static void local_DeepHistory_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState);

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
      case st_historyTest_MainState_State0: {
        stateInThisRegion = st_historyTest_MainState_State0;
	 	break;
	  }

      /* Nested states within subsequent region */
	  case st_historyTest_MainState_State0_State3_State5: {
        stateInThisRegion = st_historyTest_MainState_State0;
	    break;	  
	  }
	  
	  case st_historyTest_MainState_State0_State3: {
        stateInThisRegion = st_historyTest_MainState_State0;
	    break;	  
	  }
	  
	  case st_historyTest_MainState_State0_Initial: {
        stateInThisRegion = st_historyTest_MainState_State0;
	    break;	  
	  }
	  
	  case st_historyTest_MainState_State0_State3_Initial: {
        stateInThisRegion = st_historyTest_MainState_State0;
	    break;	  
	  }
	  
	  case st_historyTest_MainState_State0_State3_State4: {
        stateInThisRegion = st_historyTest_MainState_State0;
	    break;	  
	  }
	  

    
      /* look for state in this region */
      case st_historyTest_MainState_Initial: {
        stateInThisRegion = st_historyTest_MainState_Initial;
	 	break;
	  }


    
      /* look for state in this region */
      case st_historyTest_MainState_State1: {
        stateInThisRegion = st_historyTest_MainState_State1;
	 	break;
	  }


    
      /* look for state in this region */
      case st_historyTest_MainState_State2: {
        stateInThisRegion = st_historyTest_MainState_State2;
	 	break;
	  }

      /* Nested states within subsequent region */
	  case st_historyTest_MainState_State2_State6: {
        stateInThisRegion = st_historyTest_MainState_State2;
	    break;	  
	  }
	  
	  case st_historyTest_MainState_State2_Initial: {
        stateInThisRegion = st_historyTest_MainState_State2;
	    break;	  
	  }
	  

    
      /* look for state in this region */
      case st_historyTest_MainState_ShallowHistory: {
        stateInThisRegion = st_historyTest_MainState_ShallowHistory;
	 	break;
	  }


    
      /* look for state in this region */
      case st_historyTest_MainState_DeepHistory: {
        stateInThisRegion = st_historyTest_MainState_DeepHistory;
	 	break;
	  }


    
    default: {
      /* error: using the inital state - only for completeness */
      stateInThisRegion = st_historyTest_MainState_Initial;
      break;
    }
  }
  
  return(stateInThisRegion);
}

BOOL sm_historyTest_MainState_runCycle(SM_HistoryTest_MainState_Handle* rhandle)
{
	HistoryTest_StateType oldState = rhandle->global->state;
	HistoryTest_StateType localState = getLocalStateInThisRegion(rhandle->global->state);
	
	/* clean transition information */
	rhandle->global->transition = trans_HistoryTest_noTransition;
	
    /* handle actual state and find transitions */
	switch (localState) {
    
      case st_historyTest_MainState_State0: {
        local_State0_handle(rhandle);
	 	break;
	  }  
    
      case st_historyTest_MainState_Initial: {
        local_Initial_handle(rhandle);
	 	break;
	  }  
    
      case st_historyTest_MainState_State1: {
        local_State1_handle(rhandle);
	 	break;
	  }  
    
      case st_historyTest_MainState_State2: {
        local_State2_handle(rhandle);
	 	break;
	  }  
    
      case st_historyTest_MainState_ShallowHistory: {
        local_ShallowHistory_handle(rhandle);
	 	break;
	  }  
    
      case st_historyTest_MainState_DeepHistory: {
        local_DeepHistory_handle(rhandle);
	 	break;
	  }  
	  
    default: {
        local_Initial_handle(rhandle);
      }
	}
	
	/* if the new state is within this region but the local state has changed,
	   then run the enter entries */
	if (((sm_historyTest_MainState_isIn(rhandle->global->state) == TRUE) && 
	    (localState != getLocalStateInThisRegion(rhandle->global->state))) ||
	    ((rhandle->global->state == localState) && (rhandle->global->transition != trans_HistoryTest_noTransition))) {

	  /* run the state exit actions from this point */
      sm_historyTest_MainState_exit(rhandle, oldState);

      /* run the transition action */
	  if (rhandle->global->transition != trans_HistoryTest_noTransition)
	    historyTest_callTransitionAction(rhandle->global);
	  
	  /* run the state entry actions from this point */
	  sm_historyTest_MainState_enter(rhandle);
	}
	
  return(rhandle->global->state == oldState);
}

BOOL sm_historyTest_MainState_isIn(HistoryTest_StateType testState)
{
	BOOL retvalue = FALSE;
	
	switch (testState) {
	
	case st_historyTest_MainState_State0_State3_State5: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_State1: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_State2: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_State0_State3: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_State0_Initial: {
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
	
	case st_historyTest_MainState_Initial: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_State2_State6: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_State0: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_DeepHistory: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_ShallowHistory: {
		retvalue = TRUE;
		break;
	}
	
	case st_historyTest_MainState_State2_Initial: {
		retvalue = TRUE;
		break;
	}
	
	default: {
	  retvalue = FALSE;
	}
	
	}
	
	return(retvalue);
}

void sm_historyTest_MainState_enter(SM_HistoryTest_MainState_Handle* rhandle)
{
  HistoryTest_StateType localState = getLocalStateInThisRegion(rhandle->global->state);
  
  /* running through all local states in this region */
  switch (localState) {
    /* look for state in this region */
    case st_historyTest_MainState_State0: {
      local_State0_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_historyTest_MainState_Initial: {
      local_Initial_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_historyTest_MainState_State1: {
      local_State1_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_historyTest_MainState_State2: {
      local_State2_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_historyTest_MainState_ShallowHistory: {
      local_ShallowHistory_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_historyTest_MainState_DeepHistory: {
      local_DeepHistory_enter(rhandle);
	  break;
	}

    default: {
        rhandle->global->state = st_historyTest_MainState_Initial;
        local_Initial_enter(rhandle);
      }
	}
	
    return;
}

void sm_historyTest_MainState_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState)
{
    HistoryTest_StateType localState = getLocalStateInThisRegion(oldState);

    /* running through all local states in this region */
    switch (localState) {
      case st_historyTest_MainState_State0: {
        local_State0_exit(rhandle, oldState);
	 	break;
	  }

      case st_historyTest_MainState_Initial: {
        local_Initial_exit(rhandle, oldState);
	 	break;
	  }

      case st_historyTest_MainState_State1: {
        local_State1_exit(rhandle, oldState);
	 	break;
	  }

      case st_historyTest_MainState_State2: {
        local_State2_exit(rhandle, oldState);
	 	break;
	  }

      case st_historyTest_MainState_ShallowHistory: {
        local_ShallowHistory_exit(rhandle, oldState);
	 	break;
	  }

      case st_historyTest_MainState_DeepHistory: {
        local_DeepHistory_exit(rhandle, oldState);
	 	break;
	  }

	  
    default: {
        /* can't do anything here */
      }
	}

    return;
}



void local_State0_enter(SM_HistoryTest_MainState_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(inState0) = 1;
    
			
    /* enter the subsequent region states */
	sm_historyTest_MainState_State0_enter(&rhandle->historyTest_MainState_State0_Handle);
}


void local_State0_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState)
{

   /* Exit all subregions */
   sm_historyTest_MainState_State0_exit(&rhandle->historyTest_MainState_State0_Handle, oldState);
   /* if this state should be left, start the exit action */
	
      var(inState0) = 0;
    
          
   /* remember the old state */
   rhandle->deepHistory    = oldState;
   rhandle->shallowHistory = st_historyTest_MainState_State0;
   
   return;
}


void local_State0_handle(SM_HistoryTest_MainState_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State0_analyseTransitionIn(rhandle);
	
	if (activeTransition == FALSE) {
	
	    /* No "Do" action specified */

	   /* Calling the region cycle */

        sm_historyTest_MainState_State0_runCycle(&rhandle->historyTest_MainState_State0_Handle);
        
        /* if the new state is not within this states region, exit this state */
	    
	}	
  return;
}


BOOL local_State0_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "event6" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  historyTest_Iface_isTriggerRaised(&rhandle->global->ihandle,event6) )  
    {
      historyTest_Iface_resetTrigger(&rhandle->global->ihandle,event6); 
          
      /* return new status */
	  rhandle->global->state      = st_historyTest_MainState_State1;
	  rhandle->global->transition = historyTest_MainState_State0_TO_historyTest_MainState_State1_P1;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "event7/selfTrans+=1;" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  historyTest_Iface_isTriggerRaised(&rhandle->global->ihandle,event7) )  
    {
      historyTest_Iface_resetTrigger(&rhandle->global->ihandle,event7); 
          
      /* return new status */
	  rhandle->global->state      = st_historyTest_MainState_State0;
	  rhandle->global->transition = historyTest_MainState_State0_TO_historyTest_MainState_State0_P2;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_Initial_enter(SM_HistoryTest_MainState_Handle* rhandle)
{
	
	/* rhandle->global->state = st_historyTest_MainState_Initial;  */ 
} 


void local_Initial_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState)
{
} 


void local_Initial_handle(SM_HistoryTest_MainState_Handle* rhandle)
{
	(void)local_Initial_analyseTransitionIn(rhandle);

    return;
}


BOOL local_Initial_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle)
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
	  rhandle->global->state      = st_historyTest_MainState_State1;
	  rhandle->global->transition = historyTest_MainState_Initial_TO_historyTest_MainState_State1_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State1_enter(SM_HistoryTest_MainState_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(inState1) = 1;
    
			
}


void local_State1_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      var(inState1) = 0;
    
          
   /* remember the old state */
   rhandle->deepHistory    = oldState;
   rhandle->shallowHistory = st_historyTest_MainState_State1;
   
   return;
}


void local_State1_handle(SM_HistoryTest_MainState_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State1_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State1_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "event1" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  historyTest_Iface_isTriggerRaised(&rhandle->global->ihandle,event1) )  
    {
      historyTest_Iface_resetTrigger(&rhandle->global->ihandle,event1); 
          
      /* return new status */
	  rhandle->global->state      = st_historyTest_MainState_State0_State3_State5;
	  rhandle->global->transition = historyTest_MainState_State1_TO_historyTest_MainState_State0_State3_State5_P1;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "event5" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  historyTest_Iface_isTriggerRaised(&rhandle->global->ihandle,event5) )  
    {
      historyTest_Iface_resetTrigger(&rhandle->global->ihandle,event5); 
          
      /* return new status */
	  rhandle->global->state      = st_historyTest_MainState_State0;
	  rhandle->global->transition = historyTest_MainState_State1_TO_historyTest_MainState_State0_P3;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State2_enter(SM_HistoryTest_MainState_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(inState2) = 1;
    
			
    /* enter the subsequent region states */
	sm_historyTest_MainState_State2_enter(&rhandle->historyTest_MainState_State2_Handle);
}


void local_State2_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState)
{

   /* Exit all subregions */
   sm_historyTest_MainState_State2_exit(&rhandle->historyTest_MainState_State2_Handle, oldState);
   /* if this state should be left, start the exit action */
	
      var(inState2) = 0;
    
          
   /* remember the old state */
   rhandle->deepHistory    = oldState;
   rhandle->shallowHistory = st_historyTest_MainState_State2;
   
   return;
}


void local_State2_handle(SM_HistoryTest_MainState_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State2_analyseTransitionIn(rhandle);
	
	if (activeTransition == FALSE) {
	
	    /* No "Do" action specified */

	   /* Calling the region cycle */

        sm_historyTest_MainState_State2_runCycle(&rhandle->historyTest_MainState_State2_Handle);
        
        /* if the new state is not within this states region, exit this state */
	    
	}	
  return;
}


BOOL local_State2_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "event4" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  historyTest_Iface_isTriggerRaised(&rhandle->global->ihandle,event4) )  
    {
      historyTest_Iface_resetTrigger(&rhandle->global->ihandle,event4); 
          
      /* return new status */
	  rhandle->global->state      = st_historyTest_MainState_State1;
	  rhandle->global->transition = historyTest_MainState_State2_TO_historyTest_MainState_State1_P2;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_ShallowHistory_enter(SM_HistoryTest_MainState_Handle* rhandle)
{
	
	/* rhandle->global->state = st_historyTest_MainState_ShallowHistory;  */ 
} 


void local_ShallowHistory_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState)
{
} 


void local_ShallowHistory_handle(SM_HistoryTest_MainState_Handle* rhandle)
{
	(void)local_ShallowHistory_analyseTransitionIn(rhandle);

    return;
}


BOOL local_ShallowHistory_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */

  /* use the shallow history information */
  rhandle->global->state = rhandle->shallowHistory;
  isTriggerSet = TRUE;


  return(isTriggerSet);
}



void local_DeepHistory_enter(SM_HistoryTest_MainState_Handle* rhandle)
{
	
	/* rhandle->global->state = st_historyTest_MainState_DeepHistory;  */ 
} 


void local_DeepHistory_exit(SM_HistoryTest_MainState_Handle* rhandle, HistoryTest_StateType oldState)
{
} 


void local_DeepHistory_handle(SM_HistoryTest_MainState_Handle* rhandle)
{
	(void)local_DeepHistory_analyseTransitionIn(rhandle);

    return;
}


BOOL local_DeepHistory_analyseTransitionIn(SM_HistoryTest_MainState_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */


  /* use the deep history information */
  rhandle->global->state = rhandle->deepHistory;
  isTriggerSet = TRUE; 

  return(isTriggerSet);
}



