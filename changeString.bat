@echo off

@REM java 환경변수 설정
@REM set JAVA_HOME=
@REM set path=%path%;;

@REM 현재 디렉토리 설정
cd /d "%~dp0"

@REM 텍스트 파일 실행
start "" notepad.exe changeText.txt

:waitloop
@REM 사용자가 텍스트 파일을 수정하고 종료할 때까지 대기
timeout /t 1 /nobreak > nul
@REM 메모장이 종료되면 다음 작업을 수행
tasklist /fi "imagename eq notepad.exe" | find ":" > nul
if %errorlevel% == 1 (
    goto waitloop
) else (
    goto endwait
)

:endwait
@REM 사용자가 종료하면 다음 작업을 수행

@REM 종료된 텍스트 파일을 기준으로 JAR 파일 실행
java -jar quotation.jar

@REM JAR 파일이 종료된 후에 수정된 텍스트 파일을 다시 실행
start "" notepad.exe changeText.txt