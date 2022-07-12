In which paradigm of Java 8 falls-
	1) Fails in object oriented programming
	2) Functional programming language 
		- Lambda Calculus
		- Functional Interface - pure function, output only dependent on input parameters passed
									and not on the state of the object. This is achieved using 
									lambda expressions.
	3) Procedural programming language:
		
	4) Logic programming language.
	
What is MetaSpace? How does it differ from PermGen?
	PermGen - Metadata information of classes was stored in PerGen before java 8. Permgen is fixed in size
	and can not be dynamically resized. It was contiguous Java Heap Memory.
	MetaSpace - Java 8 stores the metadata of classes in native memory called Metaspace. It is not a contiguous 
	Heap memory and hence can be grown dynamically which helps to overcome the size constraints. This improves Garbage collection.
	
	
Can a functional interface extend/inherit another interface?
	A functional interface can not extend another interface because it may cause the functional interface 
		to have more than one abstract method.

Default Method: Why is it needed?
	A Method in body of interface with predefined functionality.
	They are introduced to have backward compatibility in case JDK modifies any interface. 
	In case  new abstract methods are added to the interface, all classes implementing the 
	interface will break and will have to implement the new method.
	With default method there will be no impact on the interface implementing classes. 
	Default methods can be overridden if needed in implementation. 
	Also, it does not qualify as synchronized or final. 