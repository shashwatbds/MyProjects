#!/bin/sh

time=''

if [[ $# -eq 0  ]]
then
  echo "No arguments passed"
else
 echo $1
 time=$1
 echo $time
fi
 
CP=HumanFriendlyClock.jar:slf4j-api-1.7.3.jar
java -cp $CP com.lloyds.clock.HumanFriendlyClock.HumanFriendlyClockCommandLineAPI $time