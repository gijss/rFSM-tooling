rFSM-tooling
===

Introduction
---
The goal of this project is a complete IDE for the development of [rFSM](http://people.mech.kuleuven.be/~mklotzbucher/rfsm/README.html) programs. Both a textual or a graphical interface can be used to create such projects. Projects created with the graphical editor can afterwards be seamlessly edited with the textual editor, the other way around is not yet supported.

This project is meant to be eventually used in the [Rodinia project](http://www.roboticsmodelling.eu/tooling/rodinia).

The rFSM-tooling project contains:
* A [meta-model](https://github.com/gijss/rFSM-tooling/blob/master/be.kuleuven.model.rfsm/model/rfsm.xcore) of rFSM, based on a hypergraph model
* A [grammar](https://github.com/gijss/rFSM-tooling/blob/master/be.kuleuven.dsl.rfsm/be.kuleuven.dsl.rfsm/src/be/kuleuven/dsl/Rfsm.xtext)
* A complete textual programming environment based on that Xtext grammar
* A graphical editor for the model of an rFSM program
* Lua [code generation](https://github.com/gijss/rFSM-tooling/tree/master/be.kuleuven.transform.rfsm/epsilon) based on the model of an rFSM program

This project illustrates the creation of a meta-model, DSL and proper programming tools through the use of Eclipse Modeling Framework. In particular, Xcore is used to define the meta-model, Xtext to define the grammar and to create the textual programming environment, Graphiti to graphically edit the model and Epsilon to transform the model and to generate source code for an interpreter.

Installation
---
###Installation instructions
1. Download this project's sources: `git clone https://github.com/gijss/rfsm-modeling.git`
2. Install dependencies
    1. Install Java (tested with openjdk-7-jdk)
    2. Install Lua (tested with lua5.2)
    3. Install [Eclipse](https://www.eclipse.org/downloads/) (tested with Eclipse 4.3.2)
    4. Install [Xcore](https://wiki.eclipse.org/Xcore) (tested with Xcore 1.1.2)
    5. Install [Xtext](https://www.eclipse.org/Xtext/) (tested with Xtext 2.5.3)
    6. Install [Epsilon](https://www.eclipse.org/epsilon/) (tested with Epsilon 1.1.0)
    7. Install [Graphiti](http://www.eclipse.org/graphiti/) (tested with 0.10.2)
    8. Install "OCL Examples and Editors" from the Eclipse Repository
    9. Download Rodinia sources: `git clone http://git.mech.kuleuven.be/robotics/rodinia.git` (tested with branch Graphiti from 2014-02-03)
    10. Download rFSM sources: `git clone https://github.com/kmarkus/rFSM.git` (tested with branch master from 2014-02)

###Build programming environment
3. Start Eclipse and import into workspace:
    1. All projects from rFSM-tooling repository
    2. Project _be.kuleuven.rodinia.epsilon.service_ from Rodinia repository (Graphiti branch)
4. Generate Xtext Artifacts:
    1. Select _Rfsm.xtext_ from _be.kuleuven.dsl.rfsm_ project and
    2. Right click and choose __Run As > Generate Xtext Artifacts__ from its context menu
5. Register metamodel into Epsilon:
    1. Select _rfsm.ecore_ from _be.kuleuven.model.rfsm_ project and
    2. Right click and choose __Register EPackages__ from its context menu
6. Launch Runtime Eclipse:
    1. Choose __Run As > Run Configurations...__
    2. Choose __Eclipse Application > Launch Runtime Eclipse__
    3. Click __Run__ to run with default configuration


Usage
---
For textual editor: see [tutorial](https://github.com/gijss/rFSM-tooling/blob/master/tutorial.md)

For graphical editor: not yet available


Notable differences from rFSM's internal DSL in Lua
---
The current meta-model of rFSM used by this project is based on a HyperGraph meta-model. This generalisation has certain consequences for the derived rFSM model.

###No owning state for transitions
Transitions are owned by the graph itself, not by any state. States can only contain other states and no transitions.

###No connectors
The concept of connectors differs from the semantics of a HyperGraph meta-model. For now, connectors have been left out of the meta-model and are thus not supported yet. Initial transitions can be defined by a transition from a parent to its direct child.


Current issues
---
* no connectors
* not possible to extend grammar (with activity, tasks, ...)
* not possible to add existing rFSM into new model
* no synchronisation from textual to graphical editor
* no indentation in the generated Lua code
