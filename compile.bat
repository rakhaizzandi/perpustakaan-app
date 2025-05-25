@echo off
echo Compiling Java files...

:: Buat direktori bin jika belum ada
if not exist bin mkdir bin

:: Hapus semua file .class yang ada di src
del /Q src\*.class

:: Compile dengan output ke direktori bin
javac -d bin -cp ".;lib/*" src/*.java

echo Compilation complete!
pause 