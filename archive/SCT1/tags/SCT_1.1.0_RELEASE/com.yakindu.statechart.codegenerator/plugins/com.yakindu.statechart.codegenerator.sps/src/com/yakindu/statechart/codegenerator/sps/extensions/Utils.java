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
package com.yakindu.statechart.codegenerator.sps.extensions;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.mwe.core.ConfigurationException;

import statemachine.DataElement;
import statemachine.DataTypes;
import statemachine.Event;
import statemachine.Region;
import statemachine.Node;
import statemachine.Statechart;
import statemachine.Transition;
import statemachine.Variable;

public class Utils {
	/** All transitions are counted, starting by 0 */
	private static int transID=0;
	/**
	 * return every time a higher transition number
	 * the extension is cached so this method is only called once per transition
	 * @param t	Transition 
	 * @return new number for this transition
	 */
	public static Integer transitionID(Transition t){
		return transID++;
	}
	
	/** All regions and states are counted, starting by 0 */
	private static int fbId=10;
	/**
	 * return every time a higher region number
	 * the extension is cached so this method is only called once per region (which is a node)
	 * @param r Region
	 * @return next number for this Region
	 */
	public static Integer regionID(Region r){
		return fbId++;
	}
	/**
	 * return every time a higher node number
	 * the extension is cached so this method is only called once per region (which is a node)
	 * @param n Node
	 * @return next number for this node, not continuous for states but for nodes
	 */
	public static Integer stateID(Node n){
		return fbId++;
	}
	
	/**
	 * Get next node in this region. The Order is given by region
	 * @param s predecessor from next node
	 * @return node after s in this region or null, if none exist
	 */
	public static Node nextNode(Node s){
		Region r = (Region)s.eContainer();
		EList<Node> nodes= r.getState();
		int ind = nodes.indexOf(s)+1;
		if (ind == nodes.size())
			return null;
		return nodes.get(ind);
	}

	/**
	 * Return next transition in the given list.
	 * @param s	predecessor 
	 * @param list	list of all relevant transitions
	 * @return	next transition in list or 
	 * 		null, if s was the last, 
	 * 		and the first transition if s is not contained in list
	 */
	public static Transition nextTransition(Transition s, List<Transition> list){
		int ind=list.indexOf(s)+1;
		if (list.size()==ind)
		{
			return null;
		}
		return (Transition)list.get(ind);
	}

	/**
	 * evaluate an action and translate to AWL. Implemented for boolean actions and numerics
	 * @param expr	String to be evaluated an assigned
	 * @param s		Statechart containing this model for variables 
	 * @return	AWL expression to evaluate and assign this expression
	 */
	public static String action2AWL(final String expr, final Statechart s){
		String res="";
		res+=assignExpr(expr, s);
		return res;
		/* �DEFINE evaluate(State s) FOR String-�
		�IF length==0-�
		�ELSEIF startsWith("!")-�
			�EXPAND evaluate(s) FOR subString(1,length).trim()-�
			   NOT;
		�ELSEIF startsWith("(")-�
		       U(
			�EXPAND evaluate(s) FOR subString(1,length-1).trim()-�
		�ELSEIF startsWith(")")-�
		       );
			�EXPAND evaluate(s) FOR subString(1,length).trim()-�
		�ELSE-�
		       U   DB1.�spsVarName()�;
		�ENDIF-�
		�ENDDEFINE� */
	}
	
	private static String assignExpr(final String action, final Statechart s){
		if (action==null || action.trim().length()==0){
			return "";
		} else {
			DataTypes dt = getVarType(action.split("=")[0], s);
			if (dt == DataTypes.BOOLEAN){
				final String res = assignBool(action, s);
				return res;
			} else {
				final String res = assignMath(action, s);
				return res;
			}
			
		}
	}

	private static String assignBool(String expr, Statechart s){
//* Ohne externen Workflow	
		if (expr==null || expr.trim().length()==0){
			return "";
		}
		String[] vars = expr.split("=");
		if (vars.length==1){
			if (vars[0].equalsIgnoreCase("TRUE")){
				return "       SET;\n";
			} else if (vars[0].equalsIgnoreCase("FALSE")){
				return "       CLR;\n";
			} else {
				return "       S    DB1."+vars[0].trim()+"\n";
			}
		}
		String evaluate = evaluateBool(vars[vars.length-1], s);
		for (int i=vars.length-2;i>=0;i--){
			if (getVarType(vars[i], s)!=null){
				evaluate += "       =    DB1."+vars[i]+";\n";
			} else {
				evaluate += "       =    "+vars[i]+";\n";
			}
		}
		return evaluate;
//*/
		
/* Inclusive Aufruf eines externen Workflows (scheitert an der Initialisierung des WF)
		WorkflowRunner wr = new WorkflowRunner();
        Map<String, String> prop = new HashMap<String, String>();
        final File oawFile = loadFile("sps/codegenerator/action/generator.oaw");
		final URI oawURI = URI.createFileURI(oawFile.getAbsolutePath());

		final File tmpDir = new File("tmp");
		tmpDir.mkdir();
		final File modelFile = new File(tmpDir.getAbsolutePath()+"/actionModel.dsl");
		try {
			final BufferedWriter bw = new BufferedWriter(new FileWriter(modelFile));
			bw.write(expr);
			bw.close();
			prop.put("modelFile", modelFile.getAbsolutePath());
		} catch (IOException e) {
			throw new ConfigurationException(e);
		}
		
		prop.put("targetDir", tmpDir.getAbsolutePath());
        
		//sps.codegenerator.action.MetaModelRegistration mm = new MetaModelRegistration();
		
        wr.run(oawURI.path(), new NullProgressMonitor(), prop, null);

        try {
        	StringBuffer sb = new StringBuffer();
			final BufferedReader br = new BufferedReader(new FileReader(tmpDir.getAbsolutePath()+"/actionModel.out"));
			while (br.ready()){
				sb.append(br.readLine());
			}
			return sb.toString();
		} catch (FileNotFoundException e) {
			throw new ConfigurationException("The workflow '"+prop.get("targetDir")+"' has not written the file",e);
		} catch (IOException e) {
			throw new ConfigurationException(e);
		}
//*/
    }
	
	public static String evaluateBool(String expr, Statechart s){
		if (expr==null){
			return "";
		}
		expr=expr.trim();
		if (expr.length()==0){
			return "";
		}
		if (expr.startsWith("!")){
			return evaluateBool(expr.substring(1), s)+"       NOT;\n";
		}
		if (expr.startsWith("(")){
			final int closingAt = getClosingBrace(expr)-1;
			if (closingAt < 0) {
				throw new ConfigurationException("more opening than closing braces in '"+ expr+"'.");
			}
			String res = evaluateBool(expr.substring(1,closingAt), s);
			final String tail = expr.substring(closingAt+1).trim();
			if (tail.startsWith("|")) {
				return "       O(   ;\n"+res+"       )   ;\n"+evaluateBool(tail, s);
			} else {
				return "       U(   ;\n"+res+"       )   ;\n"+evaluateBool(tail, s);				
			}
		}
		String[] split = expr.split("[|]");
		if (split.length>1){
			String res = "";
			for (String part:split){
				res+="       O(   ;\n"+evaluateBool(part, s)+"       );\n";
			}
			return res;
		} //if split.length==1
		split = split[0].split("[&]");
		if (split.length>1){
			String res = "";
			for (String part:split){
				res+="       U(   ;\n"+evaluateBool(part, s)+"       );\n";
			}
			return res;
		}
		if (getVarType(split[0], s)==null){
			if (split[0].equals("1") || split[0].equalsIgnoreCase("TRUE")){
				return "       SET;\n";
			}
			if (split[0].equals("0") || split[0].equalsIgnoreCase("FALSE")){
				return "       CLR;\n";
			}
			return "       U    "+split[0].trim()+";\n";
		}
		return "       U    DB1."+split[0].trim()+";\n";
	}
	
	private static int getClosingBrace(String expr){
		if (expr.startsWith("(")){
			return getClosingBrace(expr, 1, 1);
		}
		return 0;
	}
	
	/**
	 * 
	 * @param open String with hole expression starting with "("
	 * @param start first Index, where ")" is searched
	 * @param countOpen how many braces are open
	 * @return Position after all ")" are closed again or -1 if not found
	 */
	private static int getClosingBrace(final String open, int start, int countOpen){
		final int indOpen = open.indexOf('(', start);
		final int indClose = open.indexOf(')', start);
		if (countOpen==0) return start;
		if (indClose == -1){
			return -1;
		}
		if (indOpen == -1 && indClose >=0){
				return getClosingBrace(open, indClose+1, countOpen-1);
		}
		if (indOpen < indClose){
			return getClosingBrace(open, indOpen+1, countOpen+1);
		} else {
			return getClosingBrace(open, indClose+1, countOpen-1);
		}
	}

	private static String assignMath(String expr, Statechart s){
		String[] vars = expr.split("=");
		if (vars.length<1) {
			throw new ConfigurationException("Action '"+expr+"' mustn't be a function call and have to be a numeric allocation");
		}
		StringBuffer sb = new StringBuffer();
		for (int i=vars.length-2;i>=0;i--){
			sb.append("   L    "); sb.append(vars[i+1]); sb.append(";\n");
			sb.append("   T    "); sb.append(vars[i]); sb.append(";\n");
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param var
	 * @param s
	 * @return DataType of variable or null if no variable with specified name exist
	 */
	private static DataTypes getVarType(String var, Statechart s){
		for (DataElement de: s.getDataElement()){
			if (de instanceof Variable)
			{
				final String dName = ((Variable)de).getName();
				if (dName.equalsIgnoreCase(var.trim())){
					return ((Variable)de).getDataType();
				}
			} else if (de instanceof Event){
				final String dName = ((Event)de).getName();
				if (dName.equalsIgnoreCase(var.trim())){
					return DataTypes.BOOLEAN;
				}
			}
		}
		return null;
	}
	
	
	// Copied from common expression parser (outdated and should be removed
	
	public static String addEventExpr(final java.util.List<String> events, final String expression){
		String eventPart = expression.split("\\[")[0];
		String rest = expression.split("\\[")[1];
		for (String e:events){
			eventPart=eventPart.concat(e+", ");
		}
		return eventPart+"["+rest;
	}
	
	public static List<String> getExpressionVariables(String expression) {
		if(expression==null) return new ArrayList<String>(0);
		List<String> vars = new ArrayList<String>();
		expression = expression.replace("!","");
		//String[] conds = expression.replace("||", "&&").split("&&");
		StringTokenizer tokens = new StringTokenizer(expression, "&|=>!<");

		while (tokens.hasMoreTokens()){
			String token = tokens.nextToken().trim();
			if(!token.matches("[\\d]"))
				vars.add(token);
		}
		return vars;
	}
	
	public static List<String> getSendedEvents(String sendExpression){
		String sentEventExpression = sendExpression.replace("send(", "")
		.replace(")", "");
		List<String> sentEvents = new ArrayList<String>();
		String[] sendExpressionArr = sentEventExpression.split(",");
		for (int i = 0; i < sendExpressionArr.length; i++) {
			sentEvents.add(sendExpressionArr[i].trim());
		}
		return sentEvents;
	}

	public static List<String> getInternalActionStatments(
			String internalExpression) {
		List<String> internalActions = new ArrayList<String>();
		String[] internalActionsArray = internalExpression.split(";");
		for (int i = 0; i < internalActionsArray.length; i++) {
			internalActions.add(internalActionsArray[i]);
		}
		return internalActions;
	}
	
	public static String getAssignmentCode(String context, String statement){
		String[] variableValue = statement.replace(" ","").split("=");	
		return context+".set"+toFirstUpper(variableValue[0])+"("+variableValue[1]+");";

	}

	
	public static Integer getDelayTimeFromAction(final String action) {
		if (action == null || "".equals(action))
			return null;
		
		String value;
		int begin, end;
		
		begin = action.indexOf("after(");
		end   = action.indexOf(")");
		
		if (begin == -1 || end == -1)
			return null;

		value = action.substring(begin + 6, end);

		String delay = value.replaceAll("[^\\d]", "");
		try {
			int result = Integer.parseInt(delay);
			int mult = 1;
			if (value.indexOf("ms") > 0)
				mult = 1;
			else if (value.indexOf("s") > 0)
				mult = 1000;
			return (int) (result * mult);
	
		} catch (Throwable e) {
			e.printStackTrace();
			return 0;
		}
	
	}

	public static String getGuard(final String expression) {
	
		if (expression == null || "".equals(expression))
			return null;
	
		String guard = "";
	
		int begin, end = 0;
		begin = expression.indexOf("[");
		end = expression.indexOf("]");
		if (begin == -1 || end == -1)
			return null;
	
		guard = expression.substring(begin + 1, end);
		guard = replaceAll(guard);
		return guard;
	}
	


	private static String toFirstUpper(String expression){
		String firstChar = expression.substring(0,1);
		expression = expression.substring(1);
		return firstChar.toUpperCase()+expression;
	}
	
	public static List<String> getActions(final String expression) {
	
		if (expression == null || "".equals(expression))
			return null;
	
		List<String> toReturn = new ArrayList<String>(0);
	
		int slash = expression.indexOf("/");
		if (slash == -1)
			return null;
	
		StringTokenizer tokenizer = new StringTokenizer(expression
				.substring(slash + 1), ";,");
		while (tokenizer.hasMoreTokens()) {
			String next = tokenizer.nextToken().trim();
			next = replaceAll(next);
			if (next.length() > 0)
				toReturn.add(next);
		}
		return toReturn;
	}

	public static List<String> getTrigger(final String expression) {
	
		if (expression == null || "".equals(expression))
			return null;
	
		List<String> toReturn = new ArrayList<String>(0);
	
		int endIndex = expression.indexOf("[");
		if (endIndex == -1)
			endIndex = expression.indexOf("/");
		if (endIndex == -1)
			endIndex = expression.length();
	
		StringTokenizer tokenizer = new StringTokenizer(expression.substring(0,
				endIndex), ",;");
		while (tokenizer.hasMoreTokens()) {
			String next = tokenizer.nextToken().trim();
			next = replaceAll(next);
			if ((next.length() > 0) && !(next.toLowerCase().startsWith("after(")))
				toReturn.add(next);
		}
		if (toReturn.size() == 0)
			return null;
		return toReturn;
	
	}

	public static List<String> getSignalsOnly(final String expr){
		List<String> triggers = getTrigger(expr);
		if(triggers==null) return null;
		List<String> signals = new ArrayList<String>();

		for (String trigger : triggers) {
			if(!trigger.startsWith("send")) signals.add(trigger);
		}
		return signals;
	}
	
	private static String replaceAll(final String str) {
		String toReturn = str;
		toReturn = toReturn.replaceAll(";", "");
		toReturn = toReturn.replaceAll("true", "1");
		toReturn = toReturn.replaceAll("false", "0");
		return toReturn;
	}
}

