import java.util.*;

public class Process {
	ArrayList<Character> _Parameters = new ArrayList<Character>();
	ArrayList<String> _DiagramParameters = new ArrayList<String>();
	ArrayList<String> TruthTableArray = new ArrayList<String>();
	ArrayList<Character> OutputFArray = new ArrayList<Character>();
	Parameters parameterInstance = new Parameters();
	public Process(ArrayList<Character> Parameters, ArrayList<String> DiagramParameters) {
		_Parameters = Parameters;
		_DiagramParameters = DiagramParameters;
		
	}
	
	public void TruthTable () {
		
		int parametersLength = 0;
		int lineIndex=0;
		String trimDiagramLine;
		for (char character : _Parameters) {
			parametersLength+=1;
		}
		
		for(int i = 0; i<Math.pow(2,parametersLength);i++)
		{
			OutputFArray.add('0');
		}
		
		for (String diagramLine : _DiagramParameters) {
			lineIndex += 1;
			trimDiagramLine = diagramLine.replaceAll(" ","");
			for(int i = 0;i<trimDiagramLine.length();i++) {
				TruthTableArray.add(CalculeteTruthTableLine(trimDiagramLine.charAt(i),i,lineIndex,parametersLength));
			}
			
		}
		FixedFormatTruthTable(parametersLength);
		parameterInstance.setTruthTable(TruthTableArray);
		parameterInstance.setOutputF(OutputFArray);

	}

	public String CalculeteTruthTableLine(char CharacterOfLine,int NumberOfLine,int LineIndex,int KarnaughLength) {
		int numberOfLineForOutput = 0;
		if(KarnaughLength == 3) {
			if(NumberOfLine == 3)
				numberOfLineForOutput = NumberOfLine-1;
			else if(NumberOfLine == 2)
				numberOfLineForOutput = NumberOfLine+1;
			else
				numberOfLineForOutput = NumberOfLine;
			
			if(LineIndex == 1) {
				if(CharacterOfLine == '1')
					OutputFArray.set(numberOfLineForOutput, '1');
				return Integer.toBinaryString(NumberOfLine);
			}
			else {
				if(CharacterOfLine == '1')
					OutputFArray.set(numberOfLineForOutput+4, '1');
				return Integer.toBinaryString(NumberOfLine+4);
			}
		}
		else if (KarnaughLength == 4) {
			if(NumberOfLine == 3)
				numberOfLineForOutput = NumberOfLine-1;
			else if(NumberOfLine == 2)
				numberOfLineForOutput = NumberOfLine+1;
			else
				numberOfLineForOutput = NumberOfLine;
			
			if(LineIndex == 1) {
				if(CharacterOfLine == '1')
					OutputFArray.set(numberOfLineForOutput, '1');
				return Integer.toBinaryString(NumberOfLine);
			}
			else if (LineIndex == 2) {
				if(CharacterOfLine == '1')
					OutputFArray.set(numberOfLineForOutput+4, '1');
				return Integer.toBinaryString(NumberOfLine+4);
			}
			else if (LineIndex == 3) {
				if(CharacterOfLine == '1')
					OutputFArray.set(numberOfLineForOutput+12, '1');
				return Integer.toBinaryString(NumberOfLine+8);
			}
			else {
				if(CharacterOfLine == '1')
					OutputFArray.set(numberOfLineForOutput+8, '1');
				return Integer.toBinaryString(NumberOfLine+12);
			}
		}
		return null;
	}
	
	public void TruthTableJoinOutputF() {
		for (Character parameter : _Parameters) {
			System.out.print(parameter +" ");
		}
		System.out.print("F");
		System.out.println();
		int lineIndex=0;
		for (String  truthTableLine : TruthTableArray) {
			for(int i = 0; i<truthTableLine.length();i++)
			{
				System.out.print(truthTableLine.charAt(i) + " ");
			}
			System.out.print(OutputFArray.get(lineIndex));
			lineIndex+=1;
			System.out.println();
		}
	}
	
	public void FixedFormatTruthTable(int KarnaughLength) {
		int index = 0;
		for (String line : TruthTableArray) {
			for(int i = line.length();i<KarnaughLength;i++) {
				line = "0"+line;
			}
			TruthTableArray.set(index, line);
			index+=1;
		}
	}
	
	public void SumMinterms() {
		int lineIndex = 0;
		boolean flag=false;
		String minterms="";
		for (String line : TruthTableArray) {
			for(int i=0;i<line.length();i++)
			{
				if(OutputFArray.get(lineIndex) == '1')
				{
					flag=true;
					if(line.charAt(i)=='1') 
						minterms+=_Parameters.get(i);
					else
						minterms+=_Parameters.get(i)+"'";
				}
			}
			if(flag==true)
				minterms+=" + ";
			lineIndex+=1;
			flag=false;
		}

		if(minterms.charAt(minterms.length()-2) == '+')
			minterms = minterms.substring(0,minterms.length()-3);
		
		parameterInstance.setSumMinterms(minterms);
		
	}
	
	public void MultiplicationMaxterms() {
		int lineIndex = 0;
		boolean flag=false;
		String maxterms="";
		for (String line : TruthTableArray) {
			for(int i=0;i<line.length();i++)
			{
				if(OutputFArray.get(lineIndex) == '0')
				{
					flag=true;
					if(i==0)
						maxterms+="(";
					if(line.charAt(i)=='0') {
						if(i==line.length()-1)
							maxterms+=_Parameters.get(i);
						else
							maxterms+=_Parameters.get(i)+" + ";
					}	
					else {
						if(i==line.length()-1)
							maxterms+=_Parameters.get(i)+"'";
						else
							maxterms+=_Parameters.get(i)+"' + ";
					}
						
					if(i==line.length()-1)
						maxterms+=")";
				}
			}
			if(flag == true)
				maxterms+=".";
			lineIndex+=1;
			flag=false;
		}
		
		if(maxterms.charAt(maxterms.length()-1) == '.')
			maxterms = maxterms.substring(0,maxterms.length()-1);
		
		parameterInstance.setMultiplicationMaxterms(maxterms);
	}
	
	public void SumCompletementOfMinterms() {
		int lineIndex = 0;
		boolean flag=false;
		String sumCompletementOfMinterms="";
		for (String line : TruthTableArray) {
			for(int i=0;i<line.length();i++)
			{
				if(OutputFArray.get(lineIndex) == '1')
				{
					flag=true;
					if(i==0)
						sumCompletementOfMinterms+="(";
					if(line.charAt(i)=='0') {
						if(i==line.length()-1)
							sumCompletementOfMinterms+=_Parameters.get(i);
						else
							sumCompletementOfMinterms+=_Parameters.get(i)+" + ";
					}	
					else {
						if(i==line.length()-1)
							sumCompletementOfMinterms+=_Parameters.get(i)+"'";
						else
							sumCompletementOfMinterms+=_Parameters.get(i)+"' + ";
					}
						
					if(i==line.length()-1)
						sumCompletementOfMinterms+=")";
				}
			}
			if(flag == true)
				sumCompletementOfMinterms+=".";
			lineIndex+=1;
			flag=false;
		}
		
		if(sumCompletementOfMinterms.charAt(sumCompletementOfMinterms.length()-1) == '.')
			sumCompletementOfMinterms = sumCompletementOfMinterms.substring(0,sumCompletementOfMinterms.length()-1);
		
		parameterInstance.setSumCompletementOfMinterms(sumCompletementOfMinterms);
	}
	
	public void MultiplicationComplementOfMaxterms() {
		int lineIndex = 0;
		boolean flag=false;
		String multiplicationComplementOfMaxterms="";
		for (String line : TruthTableArray) {
			for(int i=0;i<line.length();i++)
			{
				if(OutputFArray.get(lineIndex) == '0')
				{
					flag=true;
					if(line.charAt(i)=='1') 
						multiplicationComplementOfMaxterms+=_Parameters.get(i);
					else
						multiplicationComplementOfMaxterms+=_Parameters.get(i)+"'";
				}
			}
			if(flag==true)
				multiplicationComplementOfMaxterms+=" + ";
			lineIndex+=1;
			flag=false;
		}

		if(multiplicationComplementOfMaxterms.charAt(multiplicationComplementOfMaxterms.length()-2) == '+')
			multiplicationComplementOfMaxterms = multiplicationComplementOfMaxterms.substring(0,multiplicationComplementOfMaxterms.length()-3);
		
		parameterInstance.setMultiplicationComplementOfMaxterms(multiplicationComplementOfMaxterms);
	}
}
