This document explains the JDK, JRE, JVM, java, javac and bytecode by following the process of writing and executing java code.

Java is a programming language use to create computer applications. One of its biggest advantages is that is platform independent, meaning you can write the code once and run it on any OS without changing the code.

A java program is written in a file with the .java extension. This file is called the source file and the code inside it is called source code.

To compile the source code we use this command:
javac filename.java

The javac is the java compiler. It converts the source code into a .class file, which contains the java bytecode. Bytecode is not machine code but it is an intermediate code which can only be execute by JVM(Java virtual machine). 

The javac compiler is part of the Java Development Kit(JDK). The JDK is the complete toolkit for java development and includes Java Runtime environment(JRE), compiler, debugger, documentations and other utilities needed to develop java applications.

The JVM is responsible for executing the bytecode. To run a compiled java program, we use this command:

java classname

The java command starts the JVM, which loads the required .class files into memory and executes the bytecode.

The JVM is the part of JRE which contains the JVM and java standard libraries providing all the things needed to run a java program. If you want to only run java program and not develop them, then installing only JRE is enough.

Java platform independence comes from bytecode. Since the compiler produces the same bytecode regardless of the underlying OS, any computer with a compatible JVM can execute the same .class file without recompiling the source code.
