@echo off
rem ע��ؼ�
regsvr32 dmcj.ocx
rem �ƶ��ļ���system32
copy EnCodeQr.dll C:\WINDOWS\system32
rem copy ���ǳ��μ�.ttf C:\WINDOWS\Fonts
rem ��װ����
for /f %%a in ('dir /x /b *.ttf') do (dir %windir%\fonts\%%a>nul 2>nul||(copy %%a %windir%\fonts>nul 2>nul&rundll32.exe gdi32.dll,AddFontResourceA %windir%\fonts\%%a))
