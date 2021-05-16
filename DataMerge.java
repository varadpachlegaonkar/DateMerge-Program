package Assignment;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

class DateRange {
	Date startDate;
	Date endDate;

	public DateRange(Date startDate, Date endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public String toString() {
		return "StarttDate: " + startDate + " EndDate: " + endDate;
	}
}

public class DataMerge {

	public ArrayList<DateRange> mergeDates(ArrayList<DateRange> DateRange) {
		long mill = 1000 * 60 * 60 * 24;

		for (int i = 0; i < DateRange.size(); i++) {

			for (int j = i + 1; j < DateRange.size(); j++) {
				Date d = (DateRange.get(i).endDate);
				Date d1 = (DateRange.get(j).startDate);

				long n = d.getTime() + mill;
				Date res = new Date(n);

				if (res.equals(DateRange.get(j).startDate)) {
					System.out.println(DateRange.get(i).startDate + "  " + DateRange.get(i).endDate);
					System.out.println(DateRange.get(i).endDate + "  " + DateRange.get(j).endDate);
				} else if (d.compareTo(d1) > 0) {
					System.out.println(DateRange.get(i).startDate + "  " + DateRange.get(j).endDate);
				}
			}
		}
		return DateRange;
	}

	public static void main(String[] args) throws ParseException {

		ArrayList<DateRange> al = new ArrayList<>();

		String sDate1 = "01/01/2014";
		String sDate2 = "30/01/2014";

		String sDate3 = "15/01/2014";
		String sDate4 = "15/02/2014";

		String sDate5 = "10/03/2014";
		String sDate6 = "15/04/2014";

		String sDate7 = "16/04/2014";
		String sDate8 = "15/05/2014";

		Date date1 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate1);
		Date date2 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate2);

		Date date3 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate3);
		Date date4 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate4);

		Date date5 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate5);
		Date date6 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate6);

		Date date7 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate7);
		Date date8 = new SimpleDateFormat("dd/MM/yyyy").parse(sDate8);

		al.add(new DateRange(date1, date2));
		al.add(new DateRange(date3, date4));
		al.add(new DateRange(date5, date6));
		al.add(new DateRange(date7, date8));

		System.out.println("Input is: ");
		Iterator<DateRange> itr = al.iterator();

		while (itr.hasNext()) {
			System.out.println(itr.next());
		}

		DataMerge obj = new DataMerge();

		System.out.println();
		System.out.println("OutPut is: ");
		obj.mergeDates(al);

	}

}
