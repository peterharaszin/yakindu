
#include "definitions.h"

#include "sm_afterTest.h"


/* var() gives complete access to the variable 
   this is only used for better readablility */
#define var(x) (rhandle->global->ihandle.x)

/* send() raises a trigger. This is implemented for easier readablility */
#define send(x) (afterTest_Iface_raiseTrigger(&rhandle->global->ihandle,x))

/* Forward Declaration of internal functions */
static void local_State1_handle(SM_AfterTest_Handle* rhandle);
static void local_State2_handle(SM_AfterTest_Handle* rhandle);
static void local_State3_handle(SM_AfterTest_Handle* rhandle);
static void local_Initial_handle(SM_AfterTest_Handle* rhandle);
static void local_State4_handle(SM_AfterTest_Handle* rhandle);

static BOOL local_State1_analyseTransitionIn(SM_AfterTest_Handle* rhandle);
static BOOL local_State2_analyseTransitionIn(SM_AfterTest_Handle* rhandle);
static BOOL local_State3_analyseTransitionIn(SM_AfterTest_Handle* rhandle);
static BOOL local_Initial_analyseTransitionIn(SM_AfterTest_Handle* rhandle);
static BOOL local_State4_analyseTransitionIn(SM_AfterTest_Handle* rhandle);

static void local_State1_enter(SM_AfterTest_Handle* rhandle);
static void local_State2_enter(SM_AfterTest_Handle* rhandle);
static void local_State3_enter(SM_AfterTest_Handle* rhandle);
static void local_Initial_enter(SM_AfterTest_Handle* rhandle);
static void local_State4_enter(SM_AfterTest_Handle* rhandle);

static void local_State1_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState);
static void local_State2_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState);
static void local_State3_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState);
static void local_Initial_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState);
static void local_State4_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState);

static AfterTest_StateType getLocalStateInThisRegion(AfterTest_StateType globalState);

/* End of forward declarations */

/*! The function returns the state on this hierarchy level, the state given as parameter belongs to.
    
    The state machine does only store the actual state of a state machine. The state, this actual state
    is nested in can be extracted by this function.
    
    Every region level provides this function to get the right state in this hierarchy level. 

*/
AfterTest_StateType getLocalStateInThisRegion(AfterTest_StateType globalState)
{
    AfterTest_StateType stateInThisRegion;
    
	switch (globalState) {
    
      /* look for state in this region */
      case st_afterTest_State1: {
        stateInThisRegion = st_afterTest_State1;
	 	break;
	  }


    
      /* look for state in this region */
      case st_afterTest_State2: {
        stateInThisRegion = st_afterTest_State2;
	 	break;
	  }


    
      /* look for state in this region */
      case st_afterTest_State3: {
        stateInThisRegion = st_afterTest_State3;
	 	break;
	  }


    
      /* look for state in this region */
      case st_afterTest_Initial: {
        stateInThisRegion = st_afterTest_Initial;
	 	break;
	  }


    
      /* look for state in this region */
      case st_afterTest_State4: {
        stateInThisRegion = st_afterTest_State4;
	 	break;
	  }


    
    default: {
      /* error: using the inital state - only for completeness */
      stateInThisRegion = st_afterTest_Initial;
      break;
    }
  }
  
  return(stateInThisRegion);
}

BOOL sm_afterTest_runCycle(SM_AfterTest_Handle* rhandle)
{
	AfterTest_StateType oldState = rhandle->global->state;
	AfterTest_StateType localState = getLocalStateInThisRegion(rhandle->global->state);
	
	/* clean transition information */
	rhandle->global->transition = trans_AfterTest_noTransition;
	
    /* handle actual state and find transitions */
	switch (localState) {
    
      case st_afterTest_State1: {
        local_State1_handle(rhandle);
	 	break;
	  }  
    
      case st_afterTest_State2: {
        local_State2_handle(rhandle);
	 	break;
	  }  
    
      case st_afterTest_State3: {
        local_State3_handle(rhandle);
	 	break;
	  }  
    
      case st_afterTest_Initial: {
        local_Initial_handle(rhandle);
	 	break;
	  }  
    
      case st_afterTest_State4: {
        local_State4_handle(rhandle);
	 	break;
	  }  
	  
    default: {
        local_Initial_handle(rhandle);
      }
	}
	
	/* if the new state is within this region but the local state has changed,
	   then run the enter entries */
	if (((sm_afterTest_isIn(rhandle->global->state) == TRUE) && 
	    (localState != getLocalStateInThisRegion(rhandle->global->state))) ||
	    ((rhandle->global->state == localState) && (rhandle->global->transition != trans_AfterTest_noTransition))) {

	  /* run the state exit actions from this point */
      sm_afterTest_exit(rhandle, oldState);

      /* run the transition action */
	  if (rhandle->global->transition != trans_AfterTest_noTransition)
	    afterTest_callTransitionAction(rhandle->global);
	  
	  /* run the state entry actions from this point */
	  sm_afterTest_enter(rhandle);
	}
	
  return(rhandle->global->state == oldState);
}

BOOL sm_afterTest_isIn(AfterTest_StateType testState)
{
	BOOL retvalue = FALSE;
	
	switch (testState) {
	
	case st_afterTest_Initial: {
		retvalue = TRUE;
		break;
	}
	
	case st_afterTest_State1: {
		retvalue = TRUE;
		break;
	}
	
	case st_afterTest_State3: {
		retvalue = TRUE;
		break;
	}
	
	case st_afterTest_State4: {
		retvalue = TRUE;
		break;
	}
	
	case st_afterTest_State2: {
		retvalue = TRUE;
		break;
	}
	
	default: {
	  retvalue = FALSE;
	}
	
	}
	
	return(retvalue);
}

void sm_afterTest_enter(SM_AfterTest_Handle* rhandle)
{
  AfterTest_StateType localState = getLocalStateInThisRegion(rhandle->global->state);
  
  /* running through all local states in this region */
  switch (localState) {
    /* look for state in this region */
    case st_afterTest_State1: {
      local_State1_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_afterTest_State2: {
      local_State2_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_afterTest_State3: {
      local_State3_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_afterTest_Initial: {
      local_Initial_enter(rhandle);
	  break;
	}

    /* look for state in this region */
    case st_afterTest_State4: {
      local_State4_enter(rhandle);
	  break;
	}

    default: {
        rhandle->global->state = st_afterTest_Initial;
        local_Initial_enter(rhandle);
      }
	}
	
    return;
}

void sm_afterTest_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState)
{
    AfterTest_StateType localState = getLocalStateInThisRegion(oldState);

    /* running through all local states in this region */
    switch (localState) {
      case st_afterTest_State1: {
        local_State1_exit(rhandle, oldState);
	 	break;
	  }

      case st_afterTest_State2: {
        local_State2_exit(rhandle, oldState);
	 	break;
	  }

      case st_afterTest_State3: {
        local_State3_exit(rhandle, oldState);
	 	break;
	  }

      case st_afterTest_Initial: {
        local_Initial_exit(rhandle, oldState);
	 	break;
	  }

      case st_afterTest_State4: {
        local_State4_exit(rhandle, oldState);
	 	break;
	  }

	  
    default: {
        /* can't do anything here */
      }
	}

    return;
}



void local_State1_enter(SM_AfterTest_Handle* rhandle)
{
	afterTest_timerIface_installTimer((void*) &rhandle->global->ihandle, (uint32) timer_afterTest_State1_TO_afterTest_State2_P1, var(waitTime)); 
    /* "Enter" action in this state */
      var(st) = 1;
    
			
}


void local_State1_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState)
{
	afterTest_timerIface_resetTimer((void*) &rhandle->global->ihandle, (uint32)timer_afterTest_State1_TO_afterTest_State2_P1); 

   /* no "Exit" action specified */
          
   /* remember the old state */
   
   return;
}


void local_State1_handle(SM_AfterTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State1_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State1_analyseTransitionIn(SM_AfterTest_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "after(waitTime)" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  afterTest_Iface_isTriggerRaised(&rhandle->global->ihandle,timer_afterTest_State1_TO_afterTest_State2_P1) )  
    {
      afterTest_Iface_resetTrigger(&rhandle->global->ihandle,timer_afterTest_State1_TO_afterTest_State2_P1); 
          
      /* return new status */
	  rhandle->global->state      = st_afterTest_State2;
	  rhandle->global->transition = afterTest_State1_TO_afterTest_State2_P1;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "key2[waitTime > 200]" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (  afterTest_Iface_isTriggerRaised(&rhandle->global->ihandle,key2)  ) &&  (var(waitTime)>200))  
    {
      afterTest_Iface_resetTrigger(&rhandle->global->ihandle,key2); 
          
      /* return new status */
	  rhandle->global->state      = st_afterTest_State4;
	  rhandle->global->transition = afterTest_State1_TO_afterTest_State4_P2;
	
	  isTriggerSet = TRUE;
    }
  }
  
  /* test for transition "key1[waitTime < 2000]" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  (  afterTest_Iface_isTriggerRaised(&rhandle->global->ihandle,key1)  ) &&  (var(waitTime)<2000))  
    {
      afterTest_Iface_resetTrigger(&rhandle->global->ihandle,key1); 
          
      /* return new status */
	  rhandle->global->state      = st_afterTest_State3;
	  rhandle->global->transition = afterTest_State1_TO_afterTest_State3_P3;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State2_enter(SM_AfterTest_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(st) = 2;
    
			
}


void local_State2_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState)
{

   /* no "Exit" action specified */
          
   /* remember the old state */
   
   return;
}


void local_State2_handle(SM_AfterTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State2_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State2_analyseTransitionIn(SM_AfterTest_Handle* rhandle)
{
  BOOL isTriggerSet = FALSE;
  
  /* Run through all transitions in order of their priority */
  
  /* test for transition "trigger1,trigger2" */
  if (isTriggerSet == FALSE)
  {
    /* run through the triggers */    
	if (  afterTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger1) || afterTest_Iface_isTriggerRaised(&rhandle->global->ihandle,trigger2) )  
    {
      afterTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger1); 
      afterTest_Iface_resetTrigger(&rhandle->global->ihandle,trigger2); 
          
      /* return new status */
	  rhandle->global->state      = st_afterTest_State1;
	  rhandle->global->transition = afterTest_State2_TO_afterTest_State1_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State3_enter(SM_AfterTest_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(waitTime) = var(waitTime) + (100);
    
			
}


void local_State3_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      send(outputEvent1);
    
          
   /* remember the old state */
   
   return;
}


void local_State3_handle(SM_AfterTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State3_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State3_analyseTransitionIn(SM_AfterTest_Handle* rhandle)
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
	  rhandle->global->state      = st_afterTest_State1;
	  rhandle->global->transition = afterTest_State3_TO_afterTest_State1_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_Initial_enter(SM_AfterTest_Handle* rhandle)
{
	
	/* rhandle->global->state = st_afterTest_Initial;  */ 
} 


void local_Initial_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState)
{
} 


void local_Initial_handle(SM_AfterTest_Handle* rhandle)
{
	(void)local_Initial_analyseTransitionIn(rhandle);

    return;
}


BOOL local_Initial_analyseTransitionIn(SM_AfterTest_Handle* rhandle)
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
	  rhandle->global->state      = st_afterTest_State1;
	  rhandle->global->transition = afterTest_Initial_TO_afterTest_State1_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



void local_State4_enter(SM_AfterTest_Handle* rhandle)
{
    /* "Enter" action in this state */
      var(waitTime) = var(waitTime) - (100);
    
			
}


void local_State4_exit(SM_AfterTest_Handle* rhandle, AfterTest_StateType oldState)
{

   /* if this state should be left, start the exit action */
	
      send(outputEvent2);
    
          
   /* remember the old state */
   
   return;
}


void local_State4_handle(SM_AfterTest_Handle* rhandle)
{
	BOOL      activeTransition;

	activeTransition = local_State4_analyseTransitionIn(rhandle);
	
  return;
}


BOOL local_State4_analyseTransitionIn(SM_AfterTest_Handle* rhandle)
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
	  rhandle->global->state      = st_afterTest_State1;
	  rhandle->global->transition = afterTest_State4_TO_afterTest_State1_P1;
	
	  isTriggerSet = TRUE;
    }
  }



  return(isTriggerSet);
}



