import java.util.*;
public  class Parameters {

	public static ArrayList<Character> Parameters = new ArrayList<Character>();
	public static ArrayList<String> DiagramParameters = new ArrayList<String>();
	public static ArrayList<String> TruthTable = new ArrayList<String>();
	public static ArrayList<Character> OutputF = new ArrayList<Character>();
	public static String SumMinterms;
	public static String MultiplicationMaxterms;
	public static String SumCompletementOfMinterms;
	public static String MultiplicationComplementOfMaxterms;
	
	public void setParameters (ArrayList<Character> ParametersArray) {
		Parameters = ParametersArray;
	}
	
	public ArrayList<Character> getParameters () {
		return Parameters;	
	}
	
	public void setDiagramParameters (ArrayList<String> DiagramParametersArray) {
		DiagramParameters = DiagramParametersArray;
	}
	
	public ArrayList<String> getDiagramParameters () {
		return DiagramParameters;	
	}
	
	public void setTruthTable (ArrayList<String> TruthTableArray) {
		TruthTable = TruthTableArray;
	}
	
	public ArrayList<String> getTruthTable () {
		return TruthTable;
	}
	
	public void setOutputF (ArrayList<Character> OutputFArray) {
		OutputF = OutputFArray;
	}
	
	public ArrayList<Character> getOutputF () {
		return OutputF;
	}
	
	public void setSumMinterms (String SumMintermsParameter) {
		SumMinterms = SumMintermsParameter;
	}
	
	public String getSumMinterms () {
		return SumMinterms;
	}
	
	public void setMultiplicationMaxterms (String MultiplicationMaxtermsParameter) {
		MultiplicationMaxterms = MultiplicationMaxtermsParameter;
	}
	
	public String getMultiplicationMaxterms () {
		return MultiplicationMaxterms;
	}
	
	public void setSumCompletementOfMinterms (String SumCompletementOfMintermsParameter) {
		SumCompletementOfMinterms = SumCompletementOfMintermsParameter;
	}
	
	public String getSumCompletementOfMinterms () {
		return SumCompletementOfMinterms;
	}
	
	public void setMultiplicationComplementOfMaxterms (String MultiplicationComplementOfMaxtermsParameter) {
		MultiplicationComplementOfMaxterms = MultiplicationComplementOfMaxtermsParameter;
	}
	
	public String getMultiplicationComplementOfMaxterms () {
		return MultiplicationComplementOfMaxterms;
	}
}
