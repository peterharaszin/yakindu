/**
 * Copyright (c) 2010 committers of YAKINDU and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Contributors:
 *     committers of YAKINDU - initial API and implementation
 */
package com.yakindu.statechart.codegenerator.sps.component;

import org.eclipse.emf.mwe.core.WorkflowContext;
import org.eclipse.emf.mwe.core.issues.Issues;
import org.eclipse.emf.mwe.core.lib.AbstractWorkflowComponent2;
import org.eclipse.emf.mwe.core.monitor.ProgressMonitor;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;
import java.util.List;
import java.util.SortedSet;
import java.util.StringTokenizer;
import java.util.TreeSet;
import java.util.Vector;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ConvertToStep7 extends AbstractWorkflowComponent2 {

    private final Log logger = LogFactory.getLog(ConvertToStep7.class);

    private String directories;

    private String step7File;

    public void setDirectories(final String directories) {
        this.directories = directories;
    }


    public void setStep7File(final String step7File) {
        this.step7File = step7File;
    }

    public String getLogMessage() {
    	return "Appending all AWL files from '"+directories+"' in descending order to '"+step7File+"'";
    }

    @Override
    protected void invokeInternal(final WorkflowContext model, final ProgressMonitor monitor, final Issues issues) {
        if (directories != null && step7File != null) {
            final StringTokenizer st = new StringTokenizer(directories, ",");
            final File outFile = new File(step7File);
            if (outFile.exists()) {
            	outFile.delete();
            }
            try {
				
            	if (outFile.createNewFile()) {
				    while (st.hasMoreElements()) {
				        final String dir = st.nextToken().trim();
				        final File f = new File(dir);
				        logger.info("Appending " + f.getAbsolutePath());
				        append(f,outFile);
				    }
				} else {
					logger.warn("creation of " + outFile.getAbsolutePath()+" failed!");
				}
			} catch (IOException e) {
				logger.warn("creation of " + outFile.getAbsolutePath()+" failed!");
			}
        }
    }

    @Override
    protected void checkConfigurationInternal(final Issues issues) {
        if (directories == null) {
            issues.addWarning("No directories specified!");
        }
        if (step7File == null) {
            issues.addWarning("No step7File specified for output!");
        }
        if (new File(step7File).isDirectory()) {
            issues.addWarning("Given step7File is a directory!");
        }
    }

    public boolean append(final File file, final File outFile) {
        if (file.isDirectory()) {
        	final SortedSet<File> ordered = new TreeSet<File>(new Comparator<File>(){
				public int compare(File f0, File f1) {
					//reverse Order for descending
					return getNumber(f1)-getNumber(f0);
				}
				private int getNumber(File f){
					String type=f.getName();
					
					if (type.startsWith("OB")){
						return parseNumber(type)*4;
					} else if(type.startsWith("DB")){
						return parseNumber(type)*4+1;
					} else if(type.startsWith("FB")){
						return parseNumber(type)*4+2;
					} else if (type.startsWith("FC")){
						return parseNumber(type)*4+3;
					} else {
						return 0;
					}
				}
				
				private final int parseNumber(String name) {
					int extPos = name.lastIndexOf('.');
					if (extPos == -1) {
						extPos = name.length()-1;
					}
					return Integer.parseInt(name.substring(2, extPos));
				}
				
        	});

        	final File[] contents = file.listFiles();
        	final List<File> dirs = new Vector<File>();
        	File containsDB1=null;
        	for (int j = 0; j < contents.length; j++) {
        		final File c = contents[j];
        		if (c.isDirectory()){
        			dirs.add(c);
        		} else {
        			if (c.getName().toUpperCase().equals("DB1.AWL")) {
        				containsDB1=c;
        			} else {
        				ordered.add(contents[j]);
        			}
        		}
            }
            for (File dir:dirs) {
                if (!append(dir, outFile)) {
                    logger.error("Couldn't append " + dir.getAbsolutePath());
                }
            }

            if (containsDB1!=null) {
                if (!append(containsDB1, outFile)) {
                    logger.error("Couldn't append " + containsDB1.getAbsolutePath());
                }
            }
            for (File awl:ordered) {
                if (!append(awl, outFile)) {
                    logger.error("Couldn't append " + awl.getAbsolutePath());
                }
            }
        } else {
        	if (!outFile.getAbsoluteFile().equals(file.getAbsoluteFile()))
        	try {
				BufferedWriter bw = new BufferedWriter(new FileWriter(outFile, true));
				BufferedReader br = new BufferedReader(new FileReader(file));
				while (br.ready()){
					bw.write(br.read());
				}
				bw.close();
				br.close();
				return true;
			} catch (IOException e) {
				return false;
			}
        	
        }

        return true;
    }
}
