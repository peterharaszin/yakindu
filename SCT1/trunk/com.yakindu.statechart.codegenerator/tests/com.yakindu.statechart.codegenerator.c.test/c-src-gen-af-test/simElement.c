
#include <stdlib.h>
#include <string.h>
#include <stdio.h>

#include "simElement.h"

static const char* trgName[] = {
  "trigger1"  ,
  "trigger2"  ,
  "key1"  ,
  "key2"  ,
  "outputEvent1"  ,
  "outputEvent2"  };

static const char* varName[] = {
  "waitTime"  ,
  "st"  };



void addSimElementTrig(SimElement** elemStart, uint64 time, AfterTest_TrgType triggerID)
{
	SimElement* actElem = *elemStart;
	SimElement* newElem = malloc(sizeof(SimElement));

	bzero(newElem, sizeof(SimElement));

    newElem->atTime = time;
    newElem->setTrigger = triggerID;
    newElem->setVariable = VarInt_AfterTest_MAX;

    if (actElem == NULL) {
    	*elemStart = newElem;
    	return;
    }

	while (actElem->nextElement != NULL) {
		actElem = actElem->nextElement;
	}

    actElem->nextElement = newElem;
}

void addSimElementVar(SimElement** elemStart, uint64 time, AfterTest_IntVarType varID, uint32 variableValue)
{
	SimElement* actElem = *elemStart;
	SimElement* newElem = malloc(sizeof(SimElement));

	bzero(newElem, sizeof(SimElement));

	newElem->atTime = time;
	newElem->setVariable = varID;
	newElem->variableValue = variableValue;
	newElem->setTrigger = trigger_AfterTest_MAX;

    if (actElem == NULL) {
    	*elemStart = newElem;
    	return;
    }

	while (actElem->nextElement != NULL) {
		actElem = actElem->nextElement;
	}

    actElem->nextElement = newElem;
}

void installChange(SimElement* elementList, AfterTest_IfaceHandle* ihandle,  uint64 actTime)
{
	SimElement* actElem;

	for(actElem = elementList; actElem != 0; actElem = actElem->nextElement) {
		if ((actElem->used == 0) && (actTime >= actElem->atTime)) {

			if (actElem->setTrigger != trigger_AfterTest_MAX) {
				afterTest_Iface_raiseTrigger(ihandle, actElem->setTrigger);
			} else {
				afterTest_Iface_setVariable(ihandle, actElem->setVariable, actElem->variableValue);
			}

			actElem->used = 1;
		}
	}
}

void addResElementTrig(ResElement** elemStart, uint64 time, AfterTest_TrgType triggerID)
{
	ResElement* actElem = *elemStart;
	ResElement* newElem = malloc(sizeof(ResElement));

	bzero(newElem, sizeof(ResElement));

    newElem->atTime = time;
    newElem->triggerSet = triggerID;
    newElem->variableSet = VarInt_AfterTest_MAX;

    if (actElem == NULL) {
    	*elemStart = newElem;
    	return;
    }

	while (actElem->nextElement != NULL) {
		actElem = actElem->nextElement;
	}

    actElem->nextElement = newElem;
}

void addResElementVar(ResElement** elemStart, uint64 time, AfterTest_IntVarType varID, uint32 variableValue)
{
	ResElement* actElem = *elemStart;
	ResElement* newElem = malloc(sizeof(ResElement));

	bzero(newElem, sizeof(ResElement));

	newElem->atTime = time;
	newElem->variableSet = varID;
	newElem->variableValue = variableValue;
	newElem->triggerSet = trigger_AfterTest_MAX;

    if (actElem == NULL) {
    	*elemStart = newElem;
    	return;
    }

	while (actElem->nextElement != NULL) {
		actElem = actElem->nextElement;
	}

    actElem->nextElement = newElem;
}

void compareResults(ResElement* elementList, AfterTest_IfaceHandle* ihandle,  uint64 actTime)
{
	ResElement* actElem;

	for(actElem = elementList; actElem != 0; actElem = actElem->nextElement) {
		if ((actElem->used == 0) && (actTime >= actElem->atTime)) {

			if (actElem->triggerSet != trigger_AfterTest_MAX) {
				if (!afterTest_Iface_isTriggerRaised(ihandle, actElem->triggerSet)) {
					printf("ERROR  : Trigger with ID <%s> was NOT raised at time %d\n",trgName[actElem->triggerSet], (uint32)actElem->atTime);
				}
				else {
					actElem->matched = 1;
					printf("CORRECT: Trigger with ID <%s> was raised at time %d\n",trgName[actElem->triggerSet], (uint32)actElem->atTime);
				}
			} else {
				if (afterTest_Iface_getVariable(ihandle, actElem->variableSet) != actElem->variableValue) {
					printf("ERROR  : Variable with ID <%s> -> %d was NOT equal to value <%d> at time %d\n",varName[actElem->variableSet], afterTest_Iface_getVariable(ihandle, actElem->variableSet), actElem->variableValue, (uint32)actElem->atTime);
				}
				else {
					actElem->matched = 1;
					printf("CORRECT: Variable with ID <%s> -> %d was equal to value <%d> at time %d\n",varName[actElem->variableSet], afterTest_Iface_getVariable(ihandle, actElem->variableSet), actElem->variableValue, (uint32)actElem->atTime);
				}
			}

			actElem->used = 1;
		}
	}
}

void printStatistics(ResElement* elementList)
{
	ResElement* actElem;
	uint32 stat_all = 0, stat_used = 0, stat_matched = 0;

	for(actElem = elementList; actElem != 0; actElem = actElem->nextElement) {
		stat_all++;
		if (actElem->used)
			stat_used++;
		if (actElem->matched)
			stat_matched++;
	}

	printf("\nOverall Rules: %d\n",stat_all);
	printf("Rules used   : %d\n",stat_used);
	printf("Rules matched: %d\n\n",stat_matched);

}
