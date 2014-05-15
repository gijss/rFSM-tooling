/**
 */
package be.kuleuven.model.rfsm.impl;

import be.kuleuven.model.rfsm.Event;
import be.kuleuven.model.rfsm.Function;
import be.kuleuven.model.rfsm.RfsmFactory;
import be.kuleuven.model.rfsm.RfsmGraph;
import be.kuleuven.model.rfsm.RfsmPackage;
import be.kuleuven.model.rfsm.State;
import be.kuleuven.model.rfsm.Transition;

import be.kuleuven.model.rfsm.util.RfsmValidator;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.EcorePackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class RfsmPackageImpl extends EPackageImpl implements RfsmPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass rfsmGraphEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transitionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass eventEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass functionEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see be.kuleuven.model.rfsm.RfsmPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private RfsmPackageImpl()
  {
    super(eNS_URI, RfsmFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link RfsmPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static RfsmPackage init()
  {
    if (isInited) return (RfsmPackage)EPackage.Registry.INSTANCE.getEPackage(RfsmPackage.eNS_URI);

    // Obtain or create and register package
    RfsmPackageImpl theRfsmPackage = (RfsmPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof RfsmPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new RfsmPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    EcorePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theRfsmPackage.createPackageContents();

    // Initialize created meta-data
    theRfsmPackage.initializePackageContents();

    // Register package validator
    EValidator.Registry.INSTANCE.put
      (theRfsmPackage, 
       new EValidator.Descriptor()
       {
         public EValidator getEValidator()
         {
           return RfsmValidator.INSTANCE;
         }
       });

    // Mark meta-data to indicate it can't be changed
    theRfsmPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(RfsmPackage.eNS_URI, theRfsmPackage);
    return theRfsmPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRfsmGraph()
  {
    return rfsmGraphEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRfsmGraph_Name()
  {
    return (EAttribute)rfsmGraphEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRfsmGraph_RootState()
  {
    return (EReference)rfsmGraphEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRfsmGraph_Transitions()
  {
    return (EReference)rfsmGraphEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRfsmGraph_RfmsGraphs()
  {
    return (EReference)rfsmGraphEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getState()
  {
    return stateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getState_Name()
  {
    return (EAttribute)stateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_States()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_Entry()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_Doo()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getState_Exit()
  {
    return (EReference)stateEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransition()
  {
    return transitionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransition_Name()
  {
    return (EAttribute)transitionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransition_Source()
  {
    return (EReference)transitionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransition_Target()
  {
    return (EReference)transitionEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransition_Events()
  {
    return (EReference)transitionEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransition_PriorityNumber()
  {
    return (EAttribute)transitionEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EOperation getTransition__IsAncestor__State_State()
  {
    return transitionEClass.getEOperations().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEvent()
  {
    return eventEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvent_Name()
  {
    return (EAttribute)eventEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEvent_Event()
  {
    return (EAttribute)eventEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFunction()
  {
    return functionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunction_Name()
  {
    return (EAttribute)functionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFunction_Call()
  {
    return (EAttribute)functionEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RfsmFactory getRfsmFactory()
  {
    return (RfsmFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    rfsmGraphEClass = createEClass(RFSM_GRAPH);
    createEAttribute(rfsmGraphEClass, RFSM_GRAPH__NAME);
    createEReference(rfsmGraphEClass, RFSM_GRAPH__ROOT_STATE);
    createEReference(rfsmGraphEClass, RFSM_GRAPH__TRANSITIONS);
    createEReference(rfsmGraphEClass, RFSM_GRAPH__RFMS_GRAPHS);

    stateEClass = createEClass(STATE);
    createEAttribute(stateEClass, STATE__NAME);
    createEReference(stateEClass, STATE__STATES);
    createEReference(stateEClass, STATE__ENTRY);
    createEReference(stateEClass, STATE__DOO);
    createEReference(stateEClass, STATE__EXIT);

    transitionEClass = createEClass(TRANSITION);
    createEAttribute(transitionEClass, TRANSITION__NAME);
    createEReference(transitionEClass, TRANSITION__SOURCE);
    createEReference(transitionEClass, TRANSITION__TARGET);
    createEReference(transitionEClass, TRANSITION__EVENTS);
    createEAttribute(transitionEClass, TRANSITION__PRIORITY_NUMBER);
    createEOperation(transitionEClass, TRANSITION___IS_ANCESTOR__STATE_STATE);

    eventEClass = createEClass(EVENT);
    createEAttribute(eventEClass, EVENT__NAME);
    createEAttribute(eventEClass, EVENT__EVENT);

    functionEClass = createEClass(FUNCTION);
    createEAttribute(functionEClass, FUNCTION__NAME);
    createEAttribute(functionEClass, FUNCTION__CALL);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    EcorePackage theEcorePackage = (EcorePackage)EPackage.Registry.INSTANCE.getEPackage(EcorePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(rfsmGraphEClass, RfsmGraph.class, "RfsmGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRfsmGraph_Name(), theEcorePackage.getEString(), "name", null, 0, 1, RfsmGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRfsmGraph_RootState(), this.getState(), null, "rootState", null, 0, 1, RfsmGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRfsmGraph_Transitions(), this.getTransition(), null, "transitions", null, 0, -1, RfsmGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRfsmGraph_RfmsGraphs(), this.getRfsmGraph(), null, "rfmsGraphs", null, 0, -1, RfsmGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stateEClass, State.class, "State", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getState_Name(), theEcorePackage.getEString(), "name", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_States(), this.getState(), null, "states", null, 0, -1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_Entry(), this.getFunction(), null, "entry", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_Doo(), this.getFunction(), null, "doo", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getState_Exit(), this.getFunction(), null, "exit", null, 0, 1, State.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transitionEClass, Transition.class, "Transition", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransition_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_Source(), this.getState(), null, "source", null, 0, -1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_Target(), this.getState(), null, "target", null, 0, -1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransition_Events(), this.getEvent(), null, "events", null, 0, -1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransition_PriorityNumber(), theEcorePackage.getEInt(), "priorityNumber", null, 0, 1, Transition.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    EOperation op = initEOperation(getTransition__IsAncestor__State_State(), theEcorePackage.getEBooleanObject(), "isAncestor", 0, 1, !IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getState(), "one", 0, 1, !IS_UNIQUE, IS_ORDERED);
    addEParameter(op, this.getState(), "two", 0, 1, !IS_UNIQUE, IS_ORDERED);

    initEClass(eventEClass, Event.class, "Event", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEvent_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getEvent_Event(), theEcorePackage.getEString(), "event", null, 0, 1, Event.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFunction_Name(), theEcorePackage.getEString(), "name", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getFunction_Call(), theEcorePackage.getEString(), "call", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);

    // Create annotations
    // http://www.eclipse.org/emf/2002/Ecore
    createEcoreAnnotations();
    // http://www.eclipse.org/emf/2011/Xcore
    createXcoreAnnotations();
    // http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
    createPivotAnnotations();
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createEcoreAnnotations()
  {
    String source = "http://www.eclipse.org/emf/2002/Ecore";		
    addAnnotation
      (this, 
       source, 
       new String[] 
       {
       "invocationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
       "settingDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot",
       "validationDelegates", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
       });					
    addAnnotation
      (stateEClass, 
       source, 
       new String[] 
       {
       "constraints", "onlyLeafStatesHaveDoo defineInitialConnectorWhenComposite defineMaxOneInitialConnector"
       });			
    addAnnotation
      (transitionEClass, 
       source, 
       new String[] 
       {
       "constraints", "legalBoundaryCrossing noGuardFromInitialConnector"
       });		
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2011/Xcore</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createXcoreAnnotations()
  {
    String source = "http://www.eclipse.org/emf/2011/Xcore";				
    addAnnotation
      (this, 
       source, 
       new String[] 
       {
       "Pivot", "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot"
       });						
  }

  /**
   * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected void createPivotAnnotations()
  {
    String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";							
    addAnnotation
      (stateEClass, 
       source, 
       new String[] 
       {
       "onlyLeafStatesHaveDoo", "(not self.doo.oclIsUndefined()) implies (self.states->size() = 0)",
       "defineInitialConnectorWhenComposite", "self.states->size() > 0 and Transition.allInstances()->exists(t | t.target->at(1)=self) implies Transition.allInstances()->exists(t | t.target->at(1)->oclAsType(ecore::EObject).eContainer()=self and t.source->at(1)=self) ",
       "defineMaxOneInitialConnector", "Transition.allInstances()->select(t | t.target->at(1)->oclAsType(ecore::EObject).eContainer()=self and t.source->at(1)=self)->size() <= 1"
       });			
    addAnnotation
      (transitionEClass, 
       source, 
       new String[] 
       {
       "legalBoundaryCrossing", "isAncestor(self.target->at(1)->oclAsType(ecore::EObject).eContainer()->oclAsType(State), self.source->at(1))"
       });		
    addAnnotation
      (getTransition__IsAncestor__State_State(), 
       source, 
       new String[] 
       {
       "body", "if (one = two)\n\t\t\t\t\tthen true\n\t\t\t\telse\n\t\t\t\t\tif (two->oclAsType(ecore::EObject).eContainer() = null)\n\t\t\t\t\t\tthen false\n\t\t\t\t\telse\n\t\t\t\t\t\tif (two->oclAsType(ecore::EObject).eContainer() = one)\n\t\t\t\t\t\t\tthen true\n\t\t\t\t\t\telse\n\t\t\t\t\t\t\tisAncestor(one, two->oclAsType(ecore::EObject).eContainer()->oclAsType(State))\n\t\t\t\t\t\tendif\n\t\t\t\t\tendif\n\t\t\t\tendif"
       });
  }

} //RfsmPackageImpl
