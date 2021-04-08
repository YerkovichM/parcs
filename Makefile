all: run

out/Master.jar: out/parcs.jar src/Master.java
	@javac -cp out/parcs.jar src/Master.java
	@jar cf out/Master.jar -C src Master.class

out/DFS.jar: out/parcs.jar src/DFS.java
	@javac -cp out/parcs.jar src/DFS.java
	@jar cf out/DFS.jar -C src DFS.class

build: out/Master.jar out/DFS.jar

run: out/Master.jar out/DFS.jar
	@cd out && java -cp 'parcs.jar:Master.jar' Master
