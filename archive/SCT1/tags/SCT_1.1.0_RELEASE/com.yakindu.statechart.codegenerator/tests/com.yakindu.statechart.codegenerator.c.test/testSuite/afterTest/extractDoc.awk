#!/bin/sh
BEGIN{
testlock=0;
FS=":";
teststringSize=0;
cnt=0;
teststring[0] = "No documentation available"
}
{
if ($1 == "*/") {
  testlock = 0;
  teststringSize=cnt;
  }

if (testlock == 1)  
  teststring[cnt++]=$0;

if (($0 ~ "^.*#TEST:") && (errline > NR)) {
  testlock = 1;
  cnt=0;
  teststring[cnt++] = $2;
  }

}
END{
  for ( i=0 ; i<teststringSize ; ++i ) {
    print teststring[i];
  }
}
