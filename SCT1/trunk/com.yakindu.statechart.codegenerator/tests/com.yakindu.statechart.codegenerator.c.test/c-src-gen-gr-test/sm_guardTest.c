
#include "definitions.h"

#include "sm_guardTest.h"


/* var() gives complete access to the variable 
   this is only used for better readablility */
#define var(x) (rhandle->global->ihandle.x)

/* send() raises a trigger. This is implemented for easier readablility */
#define send(x) (guardTest_Iface_raiseTrigger(&rhandle->global->ihandle,x))

/* Forward Declaration of internal functions */
static void local_StartState_handle(SM_GuardTest_Handle* rhandle);
static void local_State1_handle(SM_GuardTest_Handle* rhandle);
static void local_State2_handle(SM_GuardTest_Handle* rhandle);
static void local_State3_handle(SM_GuardTest_Handle* rhandle);
static void local_Initial_handle(SM_GuardTest_Handle* rhandle);
static void local_State4_handle(SM_GuardTest_Handle* rhandle);
static void local_Choice_handle(SM_GuardTest_Handle* rhandle);
static void local_State5_handle(SM_GuardTest_Handle* rhandle);
static void local_State6_handle(SM_GuardTest_Handle* rhandle);
static void local_Junction_handle(SM_GuardTest_Handle* rhandle);

static BOOL local_StartState_analyseTransitionIn(SM_GuardTest_Handle* rhandle);
static BOOL local_State1_analyseTransitionIn(SM_GuardTest_Handle* rhandle);
static BOOL local_State2_analyseTransitionIn(SM_GuardTest_Handle* rhandle);
static BOOL local_State3_analyseTransitionIn(SM_GuardTest_Handle* rhandle);
static BOOL local_Initial_analyseTransitionIn(SM_GuardTest_Handle* rhandle);
static BOOL local_State4_analyseTransitionIn(SM_GuardTest_Handle* rhandle);
static BOOL local_Choice_analyseTransitionIn(SM_GuardTest_Handle* rhandle);
static BOOL local_State5_analyseTransitionIn(SM_GuardTest_Handle* rhandle);
static BOOL local_State6_analyseTransitionIn(SM_GuardTest_Handle* rhandle);
static BOOL local_Junction_analyseTransitionIn(SM_GuardTest_Handle* rhandle);

static void local_StartState_enter(SM_GuardTest_Handle* rhandle);
static void local_State1_enter(SM_GuardTest_Handle* rhandle);
static void local_State2_enter(SM_GuardTest_Handle* rhandle);
static void local_State3_enter(SM_GuardTest_Handle* rhandle);
static void local_Initial_enter(SM_GuardTest_Handle* rhandle);
static void local_State4_enter(SM_GuardTest_Handle* rhandle);
static void local_Choice_enter(SM_GuardTest_Handle* rhandle);
static void local_State5_enter(SM_GuardTest_Handle* rhandle);
static void local_State6_enter(SM_GuardTest_Handle* rhandle);
static void local_Junction_enter(SM_GuardTest_Handle* rhandle);

static void local_StartState_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);
static void local_State1_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);
static void local_State2_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);
static void local_State3_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);
static void local_Initial_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);
static void local_State4_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);
static void local_Choice_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);
static void local_State5_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);
static void local_State6_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);
static void local_Junction_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState);

static GuardTest_StateType getLocalStateInThisRegion(GuardTest_StateType globalState);

/* End of forward declarations */

/*! The function returns the state on this hierarchy level, the state given as parameter belongs to.
    
    The state machine does only store the actual state of a state machine. The state, this actual state
    is nested in can be extracted by this function.
    
    Every region level provides this function to get the right state in this hierarchy level. 

*/
GuardTest_StateType getLocalStateInThisRegion(GuardTest_StateType globalState)
{
    GuardTest_StateType stateInThisRegion;
    
	switch (globalState) {
    
      /* look for state in this region */
      case st_guardTest_StartState: {
        stateInThisRegion = st_guardTest_StartState;
	 	break;
	  }


    
      /* look for state in this region */
      case st_guardTest_State1: {
        stateInThisRegion = st_guardTest_State1;
	 	break;
	  }


    
      /* look for state in this region */
      case st_guardTest_State2: {
        stateInThisRegion = st_guardTest_State2;
	 	break;
	  }


    
      /* look for state in this region */
      case st_guardTest_State3: {
        stateInThisRegion = st_guardTest_State3;
	 	break;
	  }


    
      /* look for state in this region */
      case st_guardTest_Initial: {
        stateInThisRegion = st_guardTest_Initial;
	 	break;
	  }


    
      /* look for state in this region */
      case st_guardTest_State4: {
        stateInThisRegion = st_guardTest_State4;
	 	break;
	  }


    
      /* look for state in this region */
      case st_guardTest_Choice: {
        stateInThisRegion = st_guardTest_Choice;
	 	break;
	  }


    
      /* look for state in this region */
      case st_guardTest_State5: {
        stateInThisRegion = st_guardTest_State5;
	 	break;
	  }


    
      /* look for state in this region */
      case st_guardTest_State6: {
        stateInThisRegion = st_guardTest_State6;
	 	break;
	  }


    
      /* look for state in this region */
      case st_guardTest_Junction: {
        stateInThisRegion = st_guardTest_Junction;
	 	break;
	  }


    
    default: {
      /* error: using the inital state - only for completeness */
      stateInThisRegion = st_guardTest_Initial;
      break;
    }
  }
  
  return(stateInThisRegion);
}

BOOL sm_guardTest_runCycle(SM_GuardTest_Handle* rhandle)
{
	GuardTest_StateType oldState = rhandle->global->state;
	GuardTest_StateType localState = getLocalStateInThisRegion(rhandle->global->state);
	
	/* clean transition information */
	rhandle->global->transition = trans_GuardTest_noTransition;
	
    /* handle actual state and find transitions */
	switch (localState) {
    
      case st_guardTest_StartState: {
        local_StartState_handle(rhandle);
	 	break;
	  }  
    
      case st_guardTest_State1: {
        local_State1_handle(rhandle);
	 	break;
	  }  
    
      case st_guardTest_State2: {
        local_State2_handle(rhandle);
	 	break;
	  }  
    
      case st_guardTest_State3: {
        local_State3_handle(rhandle);
	 	break;
	  }  
    
      case st_guardTest_Initial: {
        local_Initial_handle(rhandle);
	 	break;
	  }  
    
      case st_guardTest_State4: {
        local_State4_handle(rhandle);
	 	break;
	  }  
    
      case st_guardTest_Choice: {
        local_Choice_handle(rhandle);
	 	break;
	  }  
    
      case st_guardTest_State5: {
        local_State5_handle(rhandle);
	 	break;
	  }  
    
      case st_guardTest_State6: {
        local_State6_handle(rhandle);
	 	break;
	  }  
    
      case st_guardTest_Junction: {
        local_Junction_handle(rhandle);
	 	break;
	  }  
	  
    default: {
        local_Initial_handle(rhandle);
      }
	}
	
	/* if the new state is within this region but the local state has changed,
	   then run the enter entries */
	if (((sm_guardTest_isIn(rhandle->global->state) == TRUE) && 
	    (localState != getLocalStateInThisRegion(rhandle->global->state))) ||
	    ((rhandle->global->state == localState) && (rhandle->global->transition != trans_GuardTest_noTransition))) {

	  /* run the state exit actions from this point */
      sm_guardTest_exit(rhandle, oldState);

      /* run the transition action */
	  if (rhandle->global->transition != trans_GuardTest_noTransition)
	    guardTest_callTransitionAction(rhandle->global);
	  
	  /* run the state entry actions from this point */
	  sm_guardTest_enter(rhandle);
	}
	
  return(rhandle->global->state == oldState);
}

BOOL sm_guardTest_isIn(GuardTest_StateType testState)
{
	BOOL retvalue = FALSE;
	
	switch (testState) {
	
	case st_guardTest_State5: {
		retvalue = TRUE;
		break;
	}
	
	case st_guardTest_State6: {
		retvalue = TRUE;
		break;
	}
	
	case st_guardTest_Initial: {
		retvalue = TRUE;
		break;
	}
	
	case st_guardTest_State4: {
		retvalue = TRUE;
		break;
	}
	
	case st_guardTest_Junction: {
		retvalue = TRUE;
		break;
	}
	
	case st_guardTest_Choice: {
		retvalue = TRUE;
		break;
	}
	
	case st_guardTest_State1: {
		retvalue = TRUE;
		break;
	}
	
	case st_guardTest_State3: {
		retvalue = TRUE;
		break;
	}
	
	case st_guardTest_State2: {
		retvalue = TRUE;
		break;
	}
	
	case st_guardTest_StartState: {
		retvalue = TRUE;
		break;
	}
	
	default: {
	  retvalue = FALSE;
	}
	
	}
	
	return(retvalue);
}

void sm_guardTest_enter(SM_GuardTest_Handle* rhandle)
{
  GuardTest_StateType localState = getLocalStateInThisRegion(rhandle->global->state);
  
  /* running through all local states in this region */
  switch (localState) {
    /* look for state in this region */
    case st_guardTest_StartState: {
      local_StartState_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_guardTest_State1: {
      local_State1_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_guardTest_State2: {
      local_State2_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_guardTest_State3: {
      local_State3_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_guardTest_Initial: {
      local_Initial_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_guardTest_State4: {
      local_State4_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_guardTest_Choice: {
      local_Choice_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_guardTest_State5: {
      local_State5_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_guardTest_State6: {
      local_State6_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_guardTest_Junction: {
      local_Junction_enter(rhandle);
	  break;
	}

    default: {
        rhandle->global->state = st_guardTest_Initial;
        local_Initial_enter(rhandle);
      }
	}
	
    return;
}

void sm_guardTest_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{
    GuardTest_StateType localState = getLocalStateInThisRegion(oldState);

    /* running through all local states in this region */
    switch (localState) {
      case st_guardTest_StartState: {
        local_StartState_exit(rhandle, oldState);
	 	break;
	  }

      case st_guardTest_State1: {
        local_State1_exit(rhandle, oldState);
	 	break;
	  }

      case st_guardTest_State2: {
        local_State2_exit(rhandle, oldState);
	 	break;
	  }

      case st_guardTest_State3: {
        local_State3_exit(rhandle, oldState);
	 	break;
	  }

      case st_guardTest_Initial: {
        local_Initial_exit(rhandle, oldState);
	 	break;
	  }

      case st_guardTest_State4: {
        local_State4_exit(rhandle, oldState);
	 	break;
	  }

      case st_guardTest_Choice: {
        local_Choice_exit(rhandle, oldState);
	 	break;
	  }

      case st_guardTest_State5: {
        local_State5_exit(rhandle, oldState);
	 	break;
	  }

      case st_guardTest_State6: {
        local_State6_exit(rhandle, oldState);
	 	break;
	  }

      case st_guardTest_Junction: {
        local_Junction_exit(rhandle, oldState);
	 	break;
	  }

	  
    default: {
        /* can't do anything here */
      }
	}

    return;
}



void local_StartState_enter(SM_GuardTest_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(startState) = 1;
    
			
}


void local_StartState_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      var(startState) = 0;
    
          
   /* remember the old state */
   
   return;
}


void local_StartState_handle(SM_GuardTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_StartState_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_StartState_analyseTransitionIn(SM_GuardTest_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "trigger2[gValue > 3]/out=2;" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger2)  ) &&  (var(gValue)>3))  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger2); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_State2;
	  rhandle->global->transition = guardTest_StartState_TO_guardTest_State2_P1;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "trigger1[gValue > 3]" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger1)  ) &&  (var(gValue)>3))  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger1); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_State2;
	  rhandle->global->transition = guardTest_StartState_TO_guardTest_State2_P2;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "trigger2[gValue == 3]/out=1;" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger2)  ) &&  (var(gValue)==3))  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger2); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_State1;
	  rhandle->global->transition = guardTest_StartState_TO_guardTest_State1_P3;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "trigger1[gValue == 3]" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger1)  ) &&  (var(gValue)==3))  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger1); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_State1;
	  rhandle->global->transition = guardTest_StartState_TO_guardTest_State1_P4;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "trigger3/out=3;" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger3) )  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger3); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_State3;
	  rhandle->global->transition = guardTest_StartState_TO_guardTest_State3_P5;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "trigger2[gValue < 3]/out=4;" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger2)  ) &&  (var(gValue)<3))  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger2); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_State3;
	  rhandle->global->transition = guardTest_StartState_TO_guardTest_State3_P6;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "[value2==10]" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (var(value2)==10))  
    {
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_Choice;
	  rhandle->global->transition = guardTest_StartState_TO_guardTest_Choice_P7;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "[value1 >10 && value2 > 2]" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (var(value1)>10&&var(value2)>2))  
    {
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_State4;
	  rhandle->global->transition = guardTest_StartState_TO_guardTest_State4_P8;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State1_enter(SM_GuardTest_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(state1) = 1;
      var(value2) = var(value2) + (1);
    
			
}


void local_State1_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      var(state1) = 0;
    
          
   /* remember the old state */
   
   return;
}


void local_State1_handle(SM_GuardTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State1_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State1_analyseTransitionIn(SM_GuardTest_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "trigger4" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger4) )  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger4); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_StartState;
	  rhandle->global->transition = guardTest_State1_TO_guardTest_StartState_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State2_enter(SM_GuardTest_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(state2) = 1;
    
			
}


void local_State2_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      var(state2) = 0;
    
          
   /* remember the old state */
   
   return;
}


void local_State2_handle(SM_GuardTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State2_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State2_analyseTransitionIn(SM_GuardTest_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "trigger4" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger4) )  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger4); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_StartState;
	  rhandle->global->transition = guardTest_State2_TO_guardTest_StartState_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State3_enter(SM_GuardTest_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(state3) = 1;
    
			
}


void local_State3_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      var(state3) = 0;
    
          
   /* remember the old state */
   
   return;
}


void local_State3_handle(SM_GuardTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State3_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State3_analyseTransitionIn(SM_GuardTest_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "trigger4" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger4) )  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger4); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_StartState;
	  rhandle->global->transition = guardTest_State3_TO_guardTest_StartState_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_Initial_enter(SM_GuardTest_Handle* rhandle)
{
	
	/* rhandle->global->state = st_guardTest_Initial;  */ 
} 


void local_Initial_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{
} 


void local_Initial_handle(SM_GuardTest_Handle* rhandle)
{
	(void)local_Initial_analyseTransitionIn(rhandle);

    return;
}


BOOL local_Initial_analyseTransitionIn(SM_GuardTest_Handle* rhandle)
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
	  rhandle->global->state      = st_guardTest_StartState;
	  rhandle->global->transition = guardTest_Initial_TO_guardTest_StartState_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State4_enter(SM_GuardTest_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(state4) = 1;
      var(value2) = 0;
    
			
}


void local_State4_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      var(state4) = 0;
    
          
   /* remember the old state */
   
   return;
}


void local_State4_handle(SM_GuardTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State4_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State4_analyseTransitionIn(SM_GuardTest_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "trigger4" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger4) )  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger4); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_StartState;
	  rhandle->global->transition = guardTest_State4_TO_guardTest_StartState_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_Choice_enter(SM_GuardTest_Handle* rhandle)
{
	
	/* rhandle->global->state = st_guardTest_Choice;  */ 
} 


void local_Choice_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{
} 


void local_Choice_handle(SM_GuardTest_Handle* rhandle)
{
	(void)local_Choice_analyseTransitionIn(rhandle);

    return;
}


BOOL local_Choice_analyseTransitionIn(SM_GuardTest_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "[value1>100]" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (var(value1)>100))  
    {
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_State5;
	  rhandle->global->transition = guardTest_Choice_TO_guardTest_State5_P1;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "[value1<=100]" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (var(value1)<=100))  
    {
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_State6;
	  rhandle->global->transition = guardTest_Choice_TO_guardTest_State6_P2;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State5_enter(SM_GuardTest_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(state5) = 1;
    
			
}


void local_State5_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      var(state5) = 0;
    
          
   /* remember the old state */
   
   return;
}


void local_State5_handle(SM_GuardTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State5_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State5_analyseTransitionIn(SM_GuardTest_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "trigger4" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger4) )  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger4); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_Junction;
	  rhandle->global->transition = guardTest_State5_TO_guardTest_Junction_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State6_enter(SM_GuardTest_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(state6) = 1;
    
			
}


void local_State6_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      var(state6) = 0;
    
          
   /* remember the old state */
   
   return;
}


void local_State6_handle(SM_GuardTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State6_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State6_analyseTransitionIn(SM_GuardTest_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "trigger4" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  guardTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger4) )  
    {
      guardTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger4); 
          
      /* return new status */
	  rhandle->global->state      = st_guardTest_Junction;
	  rhandle->global->transition = guardTest_State6_TO_guardTest_Junction_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_Junction_enter(SM_GuardTest_Handle* rhandle)
{
	
	/* rhandle->global->state = st_guardTest_Junction;  */ 
} 


void local_Junction_exit(SM_GuardTest_Handle* rhandle, GuardTest_StateType oldState)
{
} 


void local_Junction_handle(SM_GuardTest_Handle* rhandle)
{
	(void)local_Junction_analyseTransitionIn(rhandle);

    return;
}


BOOL local_Junction_analyseTransitionIn(SM_GuardTest_Handle* rhandle)
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
	  rhandle->global->state      = st_guardTest_StartState;
	  rhandle->global->transition = guardTest_Junction_TO_guardTest_StartState_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



