cd %~dp0
java -classpath ".\lib\*" org.apache.axis.wsdl.WSDL2Java -a partner.wsdl -o src

pause