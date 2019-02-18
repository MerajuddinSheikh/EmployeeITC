package employee;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.StringTokenizer;

public class LoginDetails {
	/**
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	/**
	 * @param args
	 * @throws Exception
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {

		ArrayList<String> words = new ArrayList<String>();
		
		int countNight = 0;
		int countAbsence = 0;
		int countOverNight = 0;
		int dayShift =0;
		int night1200=0;
		int allowancemissed=0;
		// String setNightTimeStart="09/01/19 21:30:00";
		// String setNightTimeEnd="09/01/19 22:59:45";
		// String setnightTimeBeyond="09/01/19 23:00:00";
		

		try {
			FileReader fr = new FileReader("C:\\Users\\32680\\Desktop\\employee.csv");
			//FileReader fr = new FileReader("C:\\Users\\32680\\Desktop\\file1.csv"); 
			//FileReader fr = new FileReader("D:\\Test-Cases\\UnitTest\\inputfileUnitTest\\Test-8.txt");
			 //FileReader fr = new FileReader("C:\\Users\\32680\\Documents\\chandan.csv");
			BufferedReader br = new BufferedReader(fr);
			String Lines = br.readLine();
			 //String lines= " ";
			while ((Lines = br.readLine()) != null) {
				 //lines = Lines;
				words.add(Lines);

			//lines=br.readLine();

			}
			fr.close();
			br.close();
			//int noOfRecord = words.size() - 1;
			 //System.out.println("size of the records:" + words.size());
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String name = " ";
		int count = 0;
		int empID = 0;
		String empName = "";
		String empDepartment = " ";
		String empDate = " ";
		String empWorkedHours = " ";
		String empSetHours = " ";
		String nullValue = "";
		String empLoginTime = " ";
		String empLogoutTime = " ";
		String empComfirmHour = " ";
		// int nightHour=21;
		// int nightMinut=30;
		// int nightEnd=23;
		// SimpleDateFormat format = new SimpleDateFormat("dd/MM/yy HH:mm:ss");
		// DateFormat df = new SimpleDateFormat("HH:mm");
		// Date setTime = df.parse(empSetHours);
		for (String wk : words) {

			StringTokenizer sz = new StringTokenizer(wk, ",");

			// System.out.println(sz.countTokens());

			count = 1;
			while (sz.hasMoreElements()) {

				String token1 = sz.nextToken();

				// System.out.println(token1);
				switch (count) {
				case 1: {
					empID = Integer.parseInt(token1);
					break;
				}
				case 2: {
					name = token1;
					break;
				}
				case 3: {
					empDepartment = token1;
					break;
				}

				case 4: {
					empDate = token1;
					break;
				}
				case 5: {
					empWorkedHours = token1;
					break;
				}
				case 6: {
					empSetHours = token1;
					break;
				}

				case 7: {
					nullValue = token1;
					break;
				}

				case 8: {
					empLoginTime = token1; // first token is rollno
					break;
				}
				case 9: {
					empLogoutTime = token1;
					break;
				}
				case 10: {
					empComfirmHour = token1;
					break;
				}

				}

				count++;
			} // while loop ends here

			SimpleDateFormat sdf = new SimpleDateFormat("dd/mm/yy HH:mm:ss");
			DateFormat stf = new SimpleDateFormat("HH:mm");
			String nightTimeStart = "21:30";
			String nightTimeEnd = "22:59";
			String overNight = "23:00";
			Date set800 = null;
			Date empExit = null;
			Date empLogin=null;
			Date empWork = null;
			Date empNight2130 = null;
			Date empNight2259 = null;
			Date empNight2300= null;
			
			// Date d3 = null;
			
			if (empSetHours.equals("0:00")){
				
			//	System.out.println("employee is absent/holiday");
				countAbsence++;}
			
			
			
			
			else 
			{
				try {
					
					empLogin=sdf.parse(empLoginTime);
					empExit = sdf.parse(empLogoutTime);
					empWork = stf.parse(empWorkedHours);
					set800 = stf.parse(empSetHours);
					empNight2130 = stf.parse(nightTimeStart);
					empNight2259 = stf.parse(nightTimeEnd);
					empNight2300 = stf.parse(overNight);
					
	
					// empIn = sdf.parse(empLoginTime);
					// d3 = sdf.parse(setTime);
	
				} catch (ParseException e) {
					e.printStackTrace();
				}
			
			// Get msec from each, and subtract.
			// long diff = empExit.getTime() - empIn.getTime();
			/* long empSetTime=set.getTime()/(60 * 60 * 1000); */
			// long empWorkTime=empWork.getTime()/(60 * 60 * 1000) %24;
			// long diffSeconds = diff / 1000 % 60;
			// long diffMinutes = diff / (60 * 1000) % 60;
			// long diffHours = empWorkTime/ (60 * 60 * 1000) %24;

			// System.out.println(stf.format(set));
			// if(empWorkTime >= empSetTime){
			// if(set.getTime() >= empWork.getTime()){

			/*
			 * System.out.println("set hours are " +set.getHours());
			 * System.out.println("emp exit hour" + empExit.getHours());
			 * System.out.println("emp exit minute" + empExit.getMinutes());
			 * System.out.println("emp nightTimeStart hour" +
			 * empNightWork.getHours());
			 * System.out.println("emp nightTime minutes " +
			 * empExit.getMinutes()); System.out.println("emp overNight hour " +
			 * empNightEnd.getHours());
			 */

			// System.out.println("worked hours are" + empWork.getHours());

				/*if (empWork.getHours() >= set800.getHours()){
					//System.out.println("employee worked more than 8 hours in day shift ");
					//dayShift++;*/
				//System.out.println("worked hours are" + empExit.getTime());
				//System.out.println("worked hours are" + empNight2130.getTime());
				
				if (empWork.getTime() >= set800.getTime()){
					//System.out.println("employee is worked in day shift ");
				
				
					if (empExit.getHours()  >= empNight2130.getHours() && empExit.getHours() <= empNight2259.getHours()) {
						//System.out.println("employee continued the shift and worked > 21:30 or < 22:59 and Exit Time is "
										//+ empExit.getHours() + " "
										//+ empExit.getMinutes());
						countNight++;
					}
					}
				
				else {
					//WorkLess8hr++
					//System.out.println("employee not shortlisted for allowance");
					allowancemissed++;
			  	}
		
				
				
				
						if (empExit.getHours() >= empNight2300.getHours()) {
						  		//System.out.println("employee worked overnight and exit time is " +empExit.getHours()+ " " + empExit.getMinutes());
						  		countOverNight++;
						  		}
					 		
			if(empExit.getDate() > empLogin.getDate()){
						  		
						  		//System.out.println("employee worked overnight above 23:00 and exit time is " +empExit.getHours()+ " " + empExit.getMinutes());
						  		countOverNight++;
						  				
			}
							  		
						  		
		}

					
		}
						  		
			
					
				
				
				
				
					
				
				
		
		
			// end of 00:00
				
			
		//traversing array list
		System.out.println("size of the records:" + words.size());	
		//System.out.println("ID | Name | Total Absence | allownace missed | total dayshift | NightShift | OverNightShift |250 allowance days |  350 allowance days | Total allowance ");
		//System.out.println("ID | Name | NightShift | OverNightShift |worked Hours | loginTime | logoutTime | TotalHours | Total Allowance");
		//System.out.println(empID + "|" + name + "|" + countNight + "|" + countOverNight + "|" + empWorkedHours + "|" + empLoginTime + "|" + empLogoutTime + "|" + empComfirmHour+ "|" + (countNight*250 + countOverNight*350));
		//(empID + "|" + name + "|" + countAbsence + "|" + allowancemissed+ "|" + dayShift + "|" + countNight + "|" + countOverNight + "|" +	(countNight*250)+" | " + (countOverNight*350)+ "|" + (countNight*250+countOverNight*350));
		//System.out.println("No. of days worked overnight past 23:00 is " + countOverNight + " and allowance is INR " + countOverNight*350);
		System.out.println("Details of PS ID "+ empID + ", " + name);
		System.out.println("No. of days exit past 23:00 is " + countOverNight + " and allowance is INR " + countOverNight*350);
        System.out.println("No. of days exit between 21:30 and 22:59 is " + countNight + " and allowance is INR " + countNight * 250);
	}


	}//main method
	 // class 

			/*
			 * if(empExit.getHours()>= set.getHours()){
			 * 
			 * 
			 * }
			 

		//}

		/*
		 * System.out.println("Time in seconds: " + diffSeconds + " seconds.");
		 * System.out.println("Time in minutes: " + diffMinutes + " minutes.");
		 * System.out.println("Time in hours: " + diffHours + " hours.");
		 */
		//System.out.println("ID | Name | NightShift | OverNightShift| Total Allowance | TotalDayShift ");
		//System.out.println(empID + "|" + name + "|" + countNight + "|" + countOverNight + "|" +	(countNight*250 + countOverNight*350)+ "|" + dayShift);
	 

		// System.out.println(" emp id :" + rollno );
		/*
		 * System.out.println("employee department " + empDepartment);
		 * System.out.println(" date of work :" + empDate );
		 * System.out.println("total hour worked " + empWorkedHours);
		 * System.out.println(" set company hour :" + empSetHours );
		 * System.out.println("employee log in time " + empLoginTime);
		 * System.out.println(" employee log out time :" + empLogoutTime );
		 * System.out.println("total hourr worked :" + empComfirmHour );
		 */
		// System.out.println(countif);

		// System.out.println(countelse);

	//} // for loop ends here

//}
