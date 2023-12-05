package microwaveOven;

import java.io.File;
import java.net.URISyntaxException;

import net.sourceforge.jFuzzyLogic.FIS;
import net.sourceforge.jFuzzyLogic.plot.JFuzzyChart;

public class Oven {
	private final FIS fis;
	
	public Oven() throws URISyntaxException 
	{
		
		File file = new File(getClass().getResource("microwave.fcl").toURI());
		fis=FIS.load(file.getPath(),true);
	}
	
	public double getSure(double sicaklik, double agirlik, double guc, double yiyecekTur) {
		fis.setVariable("sicaklik", sicaklik);
		fis.setVariable("agirlik", agirlik);
		fis.setVariable("guc", guc);
		fis.setVariable("yiyecekTur", yiyecekTur);
		fis.evaluate();
		return fis.getVariable("pismeSuresi").getValue();
	}
	
	public FIS getModel() 
	{
		return fis;
	}
	
	public void grafikleriCiz() {
		JFuzzyChart.get().chart(fis);
		JFuzzyChart.get().chart(fis.getVariable("pismeSuresi").getDefuzzifier(),"pismeSuresi",true);
	}
}
