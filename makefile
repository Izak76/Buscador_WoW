JAR_NAME=buscadorWoW
SRC_PATH=buscadorWoW
APP_NAME=App

ifeq ($(OS),Windows_NT)
	CLEAN=clean-windows
else
	CLEAN=clean-linux
endif


all: create-jar $(CLEAN)

create-jar:
	javac -d build -encoding utf-8 $(SRC_PATH)/$(APP_NAME).java
	cd build && \
	jar -c -e $(SRC_PATH)/$(APP_NAME) -f ../$(JAR_NAME).jar *

clean-windows:
	del /S /Q build > NUL
	rmdir /S /Q build

clean-linux:
	rm -r -d build