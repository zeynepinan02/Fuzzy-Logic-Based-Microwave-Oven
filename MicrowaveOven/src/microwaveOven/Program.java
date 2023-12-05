package microwaveOven;

import java.net.URISyntaxException;
import java.util.List;
import java.util.Scanner;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;
import net.sourceforge.jFuzzyLogic.rule.Rule;


public class Program {

	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		System.out.print("Yiyecek Sıcaklığı [-18-70]°C : " );
		double sicaklik = in.nextDouble();
		System.out.print("Yiyecek Ağırlığı [0-1500]gr: ");
		double agirlik = in.nextDouble();
		System.out.print("Mikrodalga Çalışma Gücü [0-800]W: ");
		double guc = in.nextDouble();
		System.out.print("Yiyecek Türü [0-140]: ");
		double yiyecekTur = in.nextDouble();
		System.out.println("");
		
		try {
			Oven oven = new Oven();
			
			System.out.print("süre: "+oven.getSure(sicaklik,agirlik,guc,yiyecekTur)+" dakika");
			System.out.println("");
			oven.grafikleriCiz();
			
			List<Rule> kurallar= oven.getModel().getFunctionBlock("microwave").getFuzzyRuleBlock("kuralBlok1").getRules();
			
			for(var kural: kurallar) {
				 if(kural.getDegreeOfSupport()> 0) {
					 System.out.print(kural);
					 System.out.println("");
				 }
			 }
			
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}	
				
	}

}
