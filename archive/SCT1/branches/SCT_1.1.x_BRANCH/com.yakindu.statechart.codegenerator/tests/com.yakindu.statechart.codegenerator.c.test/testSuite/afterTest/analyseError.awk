BEGIN{
  startErr=0;
  FS=":";
  print "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>"
}
/^Failures:/ {
  split($0,a," ");
  failures=a[2];
  runs=a[4];

  "date +%FT%T" | getline date; 
  "hostname -f" | getline host;

  print "<testsuite errors=\"" failures "\" failures=\"0\" hostname=\"" host "\" name=\"com.yakindu.statechart.codegenerator.c.test\" tests=\"" runs "\" time=\"0.0\" timestamp=\"" date "\">"

}
{
  if ($0 ~ "^\-\-\-") {
    print "  </testcase>"
    startErr=0;
}

  if (startErr == 1) {
    split($0,a," ");
    type = substr(a[1],1,length(a[1])-1);
    print "    <error type=\"" type "\">";
    failureStr = substr($0,length(a[1])+2,length($0)-length(a[1]));
    gsub("&", "&amp;", failureStr);
    print failureStr; 
    print ""
    print "Testspecification: "
    system("awk -f extractDoc.awk -v errline="$2" "$1);
    print "    </error>";
  }

  if ($0 ~ "^\+\+\+ ") {
    gsub(", ", " ");
    gsub(":", "");
    split($0,a," ");
    gsub("./","",a[2]);
    print "  <testcase classname=\"" a[2] "\" name=\"" a[3] "\" time=\"0.0\">"

    ln = $0;
    startErr=1;
  }

  lastline =$0;
}


END{
  print "  <system-out><![CDATA[]]></system-out>"
  print "  <system-err><![CDATA[]]></system-err>"
  print "</testsuite>"
}

