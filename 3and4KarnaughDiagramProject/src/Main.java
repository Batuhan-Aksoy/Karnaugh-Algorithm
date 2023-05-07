import java.io.Console;

public class Main {

	public static void main(String[] args) {
		FileRead fileReadInstance = new FileRead();
		fileReadInstance.FileReader();
		fileReadInstance.SetParametersFromReaderFile();
		fileReadInstance.SetDiagramFromReaderFile();
		Parameters parametersInstance = new Parameters();
		Process processInstance = new Process(
				parametersInstance.getParameters(),
				parametersInstance.getDiagramParameters()
				);
		processInstance.TruthTable();
		System.out.println("doğruluk tablosu:");
		processInstance.TruthTableJoinOutputF();
		processInstance.SumMinterms();
		processInstance.MultiplicationMaxterms();
		processInstance.SumCompletementOfMinterms();
		processInstance.MultiplicationComplementOfMaxterms();
		System.out.println("fonksiyon ifadeleri:");
		System.out.println(parametersInstance.getSumMinterms());
		System.out.println(parametersInstance.getMultiplicationMaxterms());
		System.out.println(parametersInstance.getMultiplicationComplementOfMaxterms());
		System.out.println(parametersInstance.getSumCompletementOfMinterms());
	}

}
