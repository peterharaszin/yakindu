#!/bin/bash

TEX_FILE="compendium"
TEX_DIR="compendium"


function copy() {
for dir in ${GRAPHICS_PATH} ; do
  if [ -f ${dir}/${file}.png ]
  then
    orig=${dir}/${file}.png
    copyImage=html/img${i}.png
    convert ${orig} -geometry 800x800 ${copyImage}
    origSize=$(stat -s  ${orig} | sed -e 's:^.*st_size=\([0123456789]*\).*$:\1:g')
    copySize=$(stat -s  ${copyImage} | sed -e 's:^.*st_size=\([0123456789]*\).*$:\1:g')
    if [[ ${copySize} -gt ${origSize} ]]
    then
      cp ${orig} ${copyImage}
    fi 
  fi
done
}

function compile() {
LATEX_OPT="-split 3 -navigation -top_navigation -bottom_navigation -dir=html -mkdir -html_version 4.0,unicode"

imageFiles=$(find .. -iname "*.png")
for i in ${imageFiles} ; do
  target=$(dirname $i)/$(basename $i .png).ps
  if [[ ! -f $target ]] ; then
    echo TARGET not exist: convert $i to $target
    convert $i $target
  fi
done

#latex2html -dir=html -mkdir −nonavigation −noaddress −noreuse ${TEX_FILE}.tex 
latex2html $LATEX_OPT ${TEX_FILE}.tex
cp html/images.tex html/images.save
latex2html $LATEX_OPT -noimages ${TEX_FILE}.tex 
latex2html -images_only -dir=html -mkdir ${TEX_FILE}.tex 
rm html/images.tex
mv html/images.save html/images.tex

i=1
#blocks=$(grep -e "^\\{\\\\newpage\\\\clearpage$" -A4 html/images.tex )
#includes=echo $blocks | sed -e "s:^{\\\\newpage\\\\clearpage\\n.*\\n\\\\includegraphics.*{\\(.*\\)}$:\1:g"
#includes=echo $blocks | sed -e "s:^{\\\\newpage\\\\clearpage\\n.*\\n\\\\includegraphics.*{\\(.*\\)}%\\n.*\\n.*$:\1:g"
#echo $includes
GRAPHICS_PATH=$(grep -e "^\\(\\\\\graphicspath\\)" html/images.tex)
GRAPHICS_PATH=$(echo ${GRAPHICS_PATH} | sed -e "s:\\\\graphicspath{{::g"\
	-e "s:}{: :g" -e "s:}::g")
for line in $(grep -e "^\\(\\\\includegraphics\\|\\\\lthtmlinlinemathA\\)" html/images.tex) ; do
  if (echo $line | grep "^\\\\includegraphics") ; then
    file=$(echo $line | sed -e "s:^\\\\includegraphics.*{\\(.*\\)}%$:\1:g")
    echo Copy file: $file to html/img${i}.png
    rm html/img${i}.png
    copy 
	#${file}.png html/img${i}.png
  else
    echo Found formulae $line
  fi
  i=$(expr $i + 1)
done

echo Graphics path is: ${GRAPHICS_PATH}

rm html/*.old

}

function buildToc() {
echo '<?xml version="1.0" encoding="utf-8" standalone="no"?>
<toc label="Yakindu">
	<topic label="Overview" href="html/index.html"/>' > toc.xml

cat ${TEX_FILE}.toc | \
sed -e s:"\\\\contentsline {subsection}{\\\\numberline {[0123456789\.]*}\([^}]*\)}{\([0123456789]*\)}.*$":\
"<topic label=\"\1\" href=\"html/node\$NODEFILE.html\"/>":g | \
sed -e s:"\\\\contentsline {section}{\\\\numberline {[0123456789\.]*}\([^}]*\)}{\([0123456789]*\)}.*$":\
"</topic><topic label=\"\1\" href=\"html/node\$NODEFILE.html\">":g
 >> toc.xml

echo '</topic>
</toc>' >> toc.xml
}

function parseHTML {
echo '<?xml version="1.0" encoding="utf-8" standalone="no"?>
<toc label="Yakindu">
	<topic label="Overview" href="html/index.html">' > toc.xml

grep 'HREF="node' html/index.html |\
sed -e s:'HREF="\([^#"]*\)">\(.*\)</A>':\
'</topic><topic label="\2" href="html/\1">':g \
-e s:'HREF="\([^\"]*\)">\(.*\)</A>':\
"<topic label=\"\2\" href=\"html/\1\"/>":g \
>> toc.xml
  
echo '</topic>
</toc>' >> toc.xml
}

function clean () {
  for i in dvi ps log out aux ; do
    rm html/*.${i}
  done
}

pushd ${TEX_DIR}
compile
#buildToc
parseHTML
clean
popd
