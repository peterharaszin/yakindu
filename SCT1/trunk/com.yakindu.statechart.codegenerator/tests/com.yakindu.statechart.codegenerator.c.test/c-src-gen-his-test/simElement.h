
#include "definitions.h"
#include "historyTest_Iface.h"

typedef struct SimElement_T {

	struct SimElement_T* nextElement;

	uint8         used;

	uint64        atTime;

	HistoryTest_TrgType      setTrigger;
	HistoryTest_IntVarType  setVariable;

	uint32        variableValue;

} SimElement;

typedef struct ResultElement_T {

	struct ResultElement_T* nextElement;

	uint8         used;
	uint8         matched;
	uint64        atTime;

	HistoryTest_TrgType     triggerSet;
	HistoryTest_IntVarType  variableSet;

	uint32        variableValue;

} ResElement;

extern void addSimElementTrig(SimElement** elemStart, uint64 time, HistoryTest_TrgType triggerID);
extern void addSimElementVar(SimElement** elemStart, uint64 time, HistoryTest_IntVarType varID, uint32 variableValue);
extern void installChange(SimElement* elementList, HistoryTest_IfaceHandle* ihandle,  uint64 actTime);

extern void addResElementTrig(ResElement** elemStart, uint64 time, HistoryTest_TrgType triggerID);
extern void addResElementVar(ResElement** elemStart, uint64 time, HistoryTest_IntVarType varID, uint32 variableValue);
extern void compareResults(ResElement* elementList, HistoryTest_IfaceHandle* ihandle,  uint64 actTime);

extern void printStatistics(ResElement* elementList);

