#Zuqhame Skosana
JAVAC=/usr/bin/javac
.SUFFIXES: .java .class

SRCDIR=src
BINDIR=bin
DOCDIR=doc


SOURCES=$(shell find $(SRCDIR) -name '*.java' -type f)
CLASSES=$(SOURCES:$(SRCDIR)/%.java=$(BINDIR)/%.class)

$(BINDIR)/%.class:$(SRCDIR)/%.java
	$(JAVAC) -d $(BINDIR)/ -cp $(SRCDIR) $<

compile: $(CLASSES)

clean:
	rm $(BINDIR)/*.class

docs:
	javadoc -d $(DOCDIR) $(SRCDIR)/*.java
