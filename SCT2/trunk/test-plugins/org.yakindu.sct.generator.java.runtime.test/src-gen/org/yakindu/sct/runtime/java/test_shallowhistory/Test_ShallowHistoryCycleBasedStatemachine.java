/**
Copyright (c) 2011 committers of YAKINDU and others. 
All rights reserved. This program and the accompanying materials
are made available under the terms of the Eclipse Public License v1.0
which accompanies this distribution, and is available at
http://www.eclipse.org/legal/epl-v10.html
 
Contributors:
	committers of YAKINDU - initial API and implementation
 */
package org.yakindu.sct.runtime.java.test_shallowhistory;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import org.yakindu.sct.runtime.java.Event;
import org.yakindu.sct.runtime.java.IStatemachine;

public class Test_ShallowHistoryCycleBasedStatemachine implements IStatemachine {

	public enum State {
		State1, State2, State3, State4, State6, State7, State8, State9, State5,
	};

	private DefaultInterfaceImpl defaultInterface;

	private final State[] stateVector = new State[1];

	private int nextStateIndex;

	private final ArrayList<Event<? extends Enum<?>>> occuredEvents;

	private final Collection<Event<? extends Enum<?>>> outEvents;

	public Test_ShallowHistoryCycleBasedStatemachine() {
		occuredEvents = new ArrayList<Event<? extends Enum<?>>>();
		outEvents = new HashSet<Event<? extends Enum<?>>>();
		defaultInterface = new DefaultInterfaceImpl(this);

	}

	protected Collection<Event<? extends Enum<?>>> getOccuredEvents() {
		return occuredEvents;
	}

	protected Collection<Event<? extends Enum<?>>> getOutEvents() {
		return outEvents;
	}

	protected boolean eventOccured() {
		return !occuredEvents.isEmpty();
	}

	public void init() {

	}

	public boolean isStateActive(State state) {
		for (int i = 0; i < stateVector.length; i++) {
			if (stateVector[i] == state) {
				return true;
			}
		}
		return false;
	}

	public DefaultInterface getDefaultInterface() {
		return defaultInterface;
	}

	public void enter() {
		nextStateIndex = 0;
		stateVector[0] = State.State1;

	}

	private void reactState1() {
		if (occuredEvents.contains(defaultInterface.getEventEvent1())) {
			stateVector[0] = null;

			nextStateIndex = 0;
			stateVector[0] = State.State3;

		}
	}
	private void reactState2() {
	}
	private void reactState3() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			if (isStateActive(State.State3)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State6)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State8)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State9)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State5)) {
				stateVector[0] = null;

			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent3())) {
				stateVector[0] = null;

				nextStateIndex = 0;
				stateVector[0] = State.State6;

			}

		}
	}
	private void reactState4() {
	}
	private void reactState6() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			if (isStateActive(State.State3)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State6)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State8)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State9)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State5)) {
				stateVector[0] = null;

			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent4())) {
				if (isStateActive(State.State6)) {
					stateVector[0] = null;

				} else if (isStateActive(State.State8)) {
					stateVector[0] = null;

				} else if (isStateActive(State.State9)) {
					stateVector[0] = null;

				}

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent5())) {
					stateVector[0] = null;

					nextStateIndex = 0;
					stateVector[0] = State.State8;

				}

			}

		}
	}
	private void reactState7() {
	}
	private void reactState8() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			if (isStateActive(State.State3)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State6)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State8)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State9)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State5)) {
				stateVector[0] = null;

			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent4())) {
				if (isStateActive(State.State6)) {
					stateVector[0] = null;

				} else if (isStateActive(State.State8)) {
					stateVector[0] = null;

				} else if (isStateActive(State.State9)) {
					stateVector[0] = null;

				}

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent6())) {
					if (isStateActive(State.State8)) {
						stateVector[0] = null;

					} else if (isStateActive(State.State9)) {
						stateVector[0] = null;

					}

					nextStateIndex = 0;
					stateVector[0] = State.State6;

				} else {
					if (occuredEvents.contains(defaultInterface
							.getEventEvent7())) {
						stateVector[0] = null;

						nextStateIndex = 0;
						stateVector[0] = State.State9;

					}

				}

			}

		}
	}
	private void reactState9() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			if (isStateActive(State.State3)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State6)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State8)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State9)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State5)) {
				stateVector[0] = null;

			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {
			if (occuredEvents.contains(defaultInterface.getEventEvent4())) {
				if (isStateActive(State.State6)) {
					stateVector[0] = null;

				} else if (isStateActive(State.State8)) {
					stateVector[0] = null;

				} else if (isStateActive(State.State9)) {
					stateVector[0] = null;

				}

				nextStateIndex = 0;
				stateVector[0] = State.State5;

			} else {
				if (occuredEvents.contains(defaultInterface.getEventEvent6())) {
					if (isStateActive(State.State8)) {
						stateVector[0] = null;

					} else if (isStateActive(State.State9)) {
						stateVector[0] = null;

					}

					nextStateIndex = 0;
					stateVector[0] = State.State6;

				} else {
					if (occuredEvents.contains(defaultInterface
							.getEventEvent8())) {
						stateVector[0] = null;

						nextStateIndex = 0;
						stateVector[0] = State.State8;

					}

				}

			}

		}
	}
	private void reactState5() {
		if (occuredEvents.contains(defaultInterface.getEventEvent2())) {
			if (isStateActive(State.State3)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State6)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State8)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State9)) {
				stateVector[0] = null;

			} else if (isStateActive(State.State5)) {
				stateVector[0] = null;

			}

			nextStateIndex = 0;
			stateVector[0] = State.State1;

		} else {

		}
	}
	public void runCycle() {
		outEvents.clear();

		for (nextStateIndex = 0; nextStateIndex < stateVector.length; nextStateIndex++) {
			if (stateVector[nextStateIndex] != null) {
				switch (stateVector[nextStateIndex]) {
					case State1 :
						reactState1();
						break;
					case State2 :
						reactState2();
						break;
					case State3 :
						reactState3();
						break;
					case State4 :
						reactState4();
						break;
					case State6 :
						reactState6();
						break;
					case State7 :
						reactState7();
						break;
					case State8 :
						reactState8();
						break;
					case State9 :
						reactState9();
						break;
					case State5 :
						reactState5();
						break;
					default :
						// no state found
				}
			}
		}
		occuredEvents.clear();
	}
}
