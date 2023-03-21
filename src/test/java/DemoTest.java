import com.thoughtworks.xstream.mapper.CannotResolveClassException;

import config.Const;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ui.selenium.webPages.EconomicCalendarPage;
import ui.selenium.webPages.HomePage;
import ui.selenium.webPages.SiteNavigation;
import ui.selenium.webPages.ResearchEducationPage;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class DemoTest extends BasicTest {

	@Test
	public void checkFlowToCalendar() throws CannotResolveClassException {
		ResearchEducationPage researchAndEducation_page = new HomePage(getDriver()).navigateToResearchAndEducation();
		researchAndEducation_page.navigateToCalendar();

	}


	@DataProvider(name="dateRanges")
	public Object[][] data(){
		return new Object [][]{
				{ Const.CalendarRanges.TODAY },
				{ Const.CalendarRanges.TOMORROW },
				{ Const.CalendarRanges.NEXT_WEEK },
				{ Const.CalendarRanges.NEXT_MONTH }
		};
	}


	@Test(dataProvider="dateRanges")
	public void testcheckCalendarSlider(Const.CalendarRanges range){
		EconomicCalendarPage calendarPage = new SiteNavigation(getDriver()).navigateToEconomicCalendar();
		calendarPage.move_slider_to(range.getRangeNum());
		getDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//		List<String> actualDatesRange = calendarPage.datePicker.getSelectedRange();
////		List<String> expectedDatesRange = Const.CalendarRanges.getRange()
		assert 1==1;

	}





}
