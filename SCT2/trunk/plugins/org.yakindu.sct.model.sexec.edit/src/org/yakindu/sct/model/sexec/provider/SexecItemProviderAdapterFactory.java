/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package org.yakindu.sct.model.sexec.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.yakindu.sct.model.sexec.util.SexecAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class SexecItemProviderAdapterFactory extends SexecAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public SexecItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.ExecutionFlow} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionFlowItemProvider executionFlowItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.ExecutionFlow}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExecutionFlowAdapter() {
		if (executionFlowItemProvider == null) {
			executionFlowItemProvider = new ExecutionFlowItemProvider(this);
		}

		return executionFlowItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.ExecutionState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionStateItemProvider executionStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.ExecutionState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExecutionStateAdapter() {
		if (executionStateItemProvider == null) {
			executionStateItemProvider = new ExecutionStateItemProvider(this);
		}

		return executionStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.Reaction} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReactionItemProvider reactionItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.Reaction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReactionAdapter() {
		if (reactionItemProvider == null) {
			reactionItemProvider = new ReactionItemProvider(this);
		}

		return reactionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.NamedElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NamedElementItemProvider namedElementItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.NamedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createNamedElementAdapter() {
		if (namedElementItemProvider == null) {
			namedElementItemProvider = new NamedElementItemProvider(this);
		}

		return namedElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.MappedElement} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected MappedElementItemProvider mappedElementItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.MappedElement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createMappedElementAdapter() {
		if (mappedElementItemProvider == null) {
			mappedElementItemProvider = new MappedElementItemProvider(this);
		}

		return mappedElementItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.Check} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CheckItemProvider checkItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.Check}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCheckAdapter() {
		if (checkItemProvider == null) {
			checkItemProvider = new CheckItemProvider(this);
		}

		return checkItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.Sequence} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SequenceItemProvider sequenceItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.Sequence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createSequenceAdapter() {
		if (sequenceItemProvider == null) {
			sequenceItemProvider = new SequenceItemProvider(this);
		}

		return sequenceItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.If} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IfItemProvider ifItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.If}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createIfAdapter() {
		if (ifItemProvider == null) {
			ifItemProvider = new IfItemProvider(this);
		}

		return ifItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.Execution} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExecutionItemProvider executionItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.Execution}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExecutionAdapter() {
		if (executionItemProvider == null) {
			executionItemProvider = new ExecutionItemProvider(this);
		}

		return executionItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.EnterState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EnterStateItemProvider enterStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.EnterState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createEnterStateAdapter() {
		if (enterStateItemProvider == null) {
			enterStateItemProvider = new EnterStateItemProvider(this);
		}

		return enterStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.ExitState} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ExitStateItemProvider exitStateItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.ExitState}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createExitStateAdapter() {
		if (exitStateItemProvider == null) {
			exitStateItemProvider = new ExitStateItemProvider(this);
		}

		return exitStateItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.Call} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CallItemProvider callItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.Call}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCallAdapter() {
		if (callItemProvider == null) {
			callItemProvider = new CallItemProvider(this);
		}

		return callItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.ScheduleTimeEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScheduleTimeEventItemProvider scheduleTimeEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.ScheduleTimeEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScheduleTimeEventAdapter() {
		if (scheduleTimeEventItemProvider == null) {
			scheduleTimeEventItemProvider = new ScheduleTimeEventItemProvider(this);
		}

		return scheduleTimeEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.UnscheduleTimeEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected UnscheduleTimeEventItemProvider unscheduleTimeEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.UnscheduleTimeEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createUnscheduleTimeEventAdapter() {
		if (unscheduleTimeEventItemProvider == null) {
			unscheduleTimeEventItemProvider = new UnscheduleTimeEventItemProvider(this);
		}

		return unscheduleTimeEventItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.StateSwitch} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateSwitchItemProvider stateSwitchItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.StateSwitch}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStateSwitchAdapter() {
		if (stateSwitchItemProvider == null) {
			stateSwitchItemProvider = new StateSwitchItemProvider(this);
		}

		return stateSwitchItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.StateCase} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateCaseItemProvider stateCaseItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.StateCase}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStateCaseAdapter() {
		if (stateCaseItemProvider == null) {
			stateCaseItemProvider = new StateCaseItemProvider(this);
		}

		return stateCaseItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.ReactionFired} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ReactionFiredItemProvider reactionFiredItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.ReactionFired}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createReactionFiredAdapter() {
		if (reactionFiredItemProvider == null) {
			reactionFiredItemProvider = new ReactionFiredItemProvider(this);
		}

		return reactionFiredItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.CheckRef} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CheckRefItemProvider checkRefItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.CheckRef}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createCheckRefAdapter() {
		if (checkRefItemProvider == null) {
			checkRefItemProvider = new CheckRefItemProvider(this);
		}

		return checkRefItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.StateVector} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected StateVectorItemProvider stateVectorItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.StateVector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createStateVectorAdapter() {
		if (stateVectorItemProvider == null) {
			stateVectorItemProvider = new StateVectorItemProvider(this);
		}

		return stateVectorItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.yakindu.sct.model.sexec.TimeEvent} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected TimeEventItemProvider timeEventItemProvider;

	/**
	 * This creates an adapter for a {@link org.yakindu.sct.model.sexec.TimeEvent}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createTimeEventAdapter() {
		if (timeEventItemProvider == null) {
			timeEventItemProvider = new TimeEventItemProvider(this);
		}

		return timeEventItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (namedElementItemProvider != null) namedElementItemProvider.dispose();
		if (mappedElementItemProvider != null) mappedElementItemProvider.dispose();
		if (executionFlowItemProvider != null) executionFlowItemProvider.dispose();
		if (executionStateItemProvider != null) executionStateItemProvider.dispose();
		if (reactionItemProvider != null) reactionItemProvider.dispose();
		if (stateVectorItemProvider != null) stateVectorItemProvider.dispose();
		if (timeEventItemProvider != null) timeEventItemProvider.dispose();
		if (sequenceItemProvider != null) sequenceItemProvider.dispose();
		if (checkItemProvider != null) checkItemProvider.dispose();
		if (checkRefItemProvider != null) checkRefItemProvider.dispose();
		if (ifItemProvider != null) ifItemProvider.dispose();
		if (executionItemProvider != null) executionItemProvider.dispose();
		if (enterStateItemProvider != null) enterStateItemProvider.dispose();
		if (exitStateItemProvider != null) exitStateItemProvider.dispose();
		if (callItemProvider != null) callItemProvider.dispose();
		if (scheduleTimeEventItemProvider != null) scheduleTimeEventItemProvider.dispose();
		if (unscheduleTimeEventItemProvider != null) unscheduleTimeEventItemProvider.dispose();
		if (stateSwitchItemProvider != null) stateSwitchItemProvider.dispose();
		if (stateCaseItemProvider != null) stateCaseItemProvider.dispose();
		if (reactionFiredItemProvider != null) reactionFiredItemProvider.dispose();
	}

}
