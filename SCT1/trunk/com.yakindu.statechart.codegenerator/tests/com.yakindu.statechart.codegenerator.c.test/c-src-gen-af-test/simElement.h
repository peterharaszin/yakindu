
#include "definitions.h"
#include "afterTest_Iface.h"

typedef struct SimElement_T {

	struct SimElement_T* nextElement;

	uint8         used;

	uint64        atTime;

	AfterTest_TrgType      setTrigger;
	AfterTest_IntVarType  setVariable;

	uint32        variableValue;

} SimElement;

typedef struct ResultElement_T {

	struct ResultElement_T* nextElement;

	uint8         used;
	uint8         matched;
	uint64        atTime;

	AfterTest_TrgType     triggerSet;
	AfterTest_IntVarType  variableSet;

	uint32        variableValue;

} ResElement;

extern void addSimElementTrig(SimElement** elemStart, uint64 time, AfterTest_TrgType triggerID);
extern void addSimElementVar(SimElement** elemStart, uint64 time, AfterTest_IntVarType varID, uint32 variableValue);
extern void installChange(SimElement* elementList, AfterTest_IfaceHandle* ihandle,  uint64 actTime);

extern void addResElementTrig(ResElement** elemStart, uint64 time, AfterTest_TrgType triggerID);
extern void addResElementVar(ResElement** elemStart, uint64 time, AfterTest_IntVarType varID, uint32 variableValue);
extern void compareResults(ResElement* elementList, AfterTest_IfaceHandle* ihandle,  uint64 actTime);

extern void printStatistics(ResElement* elementList);

