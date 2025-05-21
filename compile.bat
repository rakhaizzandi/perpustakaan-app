@echo off
echo Compiling Java files...
javac -cp "lib/*" -d . src/*.java
echo Done!
pause 