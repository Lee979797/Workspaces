@echo off
rem 注册控件
regsvr32 dmcj.ocx
rem 移动文件到system32
copy EnCodeQr.dll C:\WINDOWS\system32
rem copy 汉仪长宋简.ttf C:\WINDOWS\Fonts
rem 安装字体
for /f %%a in ('dir /x /b *.ttf') do (dir %windir%\fonts\%%a>nul 2>nul||(copy %%a %windir%\fonts>nul 2>nul&rundll32.exe gdi32.dll,AddFontResourceA %windir%\fonts\%%a))
