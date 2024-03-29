#include "Operations.h"

class InternalCallBack : public Operations::InternalSCI_OCB {

	public:

		void internalOperation1();

		sc_boolean internalOperation2(sc_integer param1);
};

class Interface1CallBack : public Operations::SCI_Interface1_OCB {
	public:

		void interfaceOperation1();

		sc_boolean interfaceOperation2(sc_integer param1);
};

class DefaultCallBack : public Operations::DefaultSCI_OCB {

	public:

		void unnamedInterfaceOperation1();

		sc_boolean unnamedInterfaceOperation2(sc_integer param1);
};

