package testng_extra;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DPpractice {

	@Test(dataProvider = "getData")
	public void fbLogin(String un, String pwd, String kuch) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.facebook.com/");

//		String un = "admin";
//		String pwd = "password";

		Actions act = new Actions(driver);
		act.sendKeys(un + Keys.TAB + pwd).build().perform();

		driver.quit();
	}

	@DataProvider
	public String[][] getData() {
		String[][] students = new String[22][3];
//									row =>3  column=>2
//									row=> number of execution
//									column => num of data => num of parameter in @test method

		students[0][0] = "naveen_veeraReddy";
		students[0][1] = "MassEntry@Kantara";

		students[1][0] = "anurag_pushpaMode";
		students[1][1] = "FlowerAlaFire123";

		students[2][0] = "shikha_JaanuFan";
		students[2][1] = "96FramesOfLove";

		students[3][0] = "sumant_bahubaliReturns";
		students[3][1] = "KatappaWhyMe7";

		students[4][0] = "jitesh_VikramVeda";
		students[4][1] = "RolexNotCheap";

		students[5][0] = "kritika_PonniyinSelvi";
		students[5][1] = "CholaQueen2025";

		students[6][0] = "chirag_AnjaanAgent";
		students[6][1] = "SuryaSwag_01";

		students[7][0] = "pravakar_RRRized";
		students[7][1] = "NatuNatu@Beam";

		students[8][0] = "ravindra_JailerStyle";
		students[8][1] = "TigerKaAppa";

		students[9][0] = "amit_KGFfied";
		students[9][1] = "RockyBhaiOp";

		students[10][0] = "ayush_ThalapathyMode";
		students[10][1] = "BeastEntry2025";

		students[11][0] = "khushi_SitaRamam";
		students[11][1] = "RamForSita@11";

		students[12][0] = "jitendra_KabaliDa";
		students[12][1] = "NeruppuDa_77";

		students[13][0] = "kamani_ArjunReddyVibe";
		students[13][1] = "RowdyClass_09";

		students[14][0] = "nishant_SinghamReturns";
		students[14][1] = "MassOfficer@DSP";

		students[15][0] = "jisha_PushpaSrivalli";
		students[15][1] = "SrivalliStep_96";

		students[16][0] = "bindu_BabyFan";
		students[16][1] = "SaiPallaviGrace";

		students[17][0] = "nidhi_KarthikDial";
		students[17][1] = "PremamLove2025";

		students[18][0] = "somi_DarlingPrabhas";
		students[18][1] = "MirchiHeat@88";

		students[19][0] = "nikhil_Robo2Point0";
		students[19][1] = "ChittiReloaded";

		students[20][0] = "vaishnavi_BomberRashmika";
		students[20][1] = "NationalCrush#1";

		students[21][0] = "devesh_OGPushparaj";
		students[21][1] = "FireLagaDenge@001";
		
		return students;
	}
}
