import java.io.*;
import java.util.*;
public class FileRead {
	ArrayList<String> ReaderFileLineList = new ArrayList<String>();
	Parameters parametersInstance = new Parameters();
	public void FileReader () {
		File file = new File("karnaugh.txt");
		if(!file.exists()) {
			System.out.println("Dosya Bulunamadı");
		}
		try {
			FileReader  fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String Line;
			while((Line = bufferedReader.readLine()) != null) {
				ReaderFileLineList.add(Line);
			}
			System.out.println("karnaugh.txt dosyası okundu.");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void SetParametersFromReaderFile() {
		int index=0;
		ArrayList<Character> ParametersArray = new ArrayList<Character>();
		for (String line : ReaderFileLineList) {
			if(line.contains("değişkenler:")) {
				index = line.lastIndexOf(":")+1;
				for(int i = index;i<line.length();i++) {
					if(line.charAt(i) != ' ' && line.charAt(i) != ',')
						ParametersArray.add(line.charAt(i));
				}
			}
		}
		
		parametersInstance.setParameters(ParametersArray);
	}
	public void SetDiagramFromReaderFile() {
		boolean flag=false;
		ArrayList<String> DiagramArray = new ArrayList<String>();
		for (String line : ReaderFileLineList) {
			if(flag==true)
			{
				DiagramArray.add(line);
			}
			if(line.contains("diyagram:")) {
				flag=true;
			}
		}
		
		parametersInstance.setDiagramParameters(DiagramArray);
		
	}
}
