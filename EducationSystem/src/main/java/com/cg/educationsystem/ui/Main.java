package com.cg.educationsystem.ui;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import org.apache.log4j.Logger;

import com.cg.educationsystem.entity.Schedule;
import com.cg.educationsystem.exception.InvalidInputException;
import com.cg.educationsystem.service.ScheduleService;
import com.cg.educationsystem.service.ScheduleServiceImp;

public class Main {
	public static void main(String[] args) {
		ScheduleService service = new ScheduleServiceImp();
		Logger logger = Logger.getLogger(Main.class);
		logger.info("adding schedule/ updating/ viewing");

		Scanner sc = new Scanner(System.in);

		/* ----- Selecting Role------- */
		System.out.println("Schedule");
		System.out.println("_______________________________________________________________");
		System.out.println("Select the role: \nA. Admin \nB. Student");
		Character role = ' ';
		role = sc.next().charAt(0);
		switch (role) {
		case 'A':
			System.out.println("__________________________Admin Page__________________________");
			System.out.println("\n1.Add Schedule \n2.Update Schedule \n3.View Schedule");
			int ch = 1;
			ch = sc.nextInt();
			switch (ch) {
			case 1:
				Schedule s1 = new Schedule();
				
				logger.info("adding schedule");
				// getting trainer id and validating
				System.out.println("\nEnter Trainer ID ");
				int t_id = 0;
				do {
					try {
						t_id = sc.nextInt();
						if (t_id <= 0 || t_id > 10000) {
							throw new InvalidInputException();
						} else {
							s1.setT_id(t_id);
						}
					} catch (InvalidInputException e) {
						e.printStackTrace();
						System.err.println("Trainer ID should be greater than zero & less than 5 digits!");
					} catch (InputMismatchException e) {
						sc.next();// this is important!
						e.printStackTrace();
						System.err.println("That's not a trainer ID!");
					}
				} while (t_id <= 0 || t_id > 10000);

				// getting course id and validating
				System.out.println("Enter Course ID ");
				int c_id = 0;
				do {
					try {
						c_id = sc.nextInt();
						if (c_id <= 0 || c_id > 10000) {
							throw new InvalidInputException();
						} else {
							s1.setT_id(c_id);

						}
					} catch (InvalidInputException e) {
						e.printStackTrace();
						System.err.println("Course ID should be greater than zero & less than 5 digits!");
					} catch (InputMismatchException e) {
						sc.next();// this is important!
						e.printStackTrace();
						System.err.println("That's not a course ID!");
					}
				} while (c_id <= 0 || c_id > 10000);

				// getting course name and validating
				System.out.println("Enter Course Name");
				String c_name = "";
				do {
					try {
						sc.next();
						c_name = sc.nextLine();
						if (c_name.matches("[0-9]+") || Character.isDigit(c_name.charAt(0))) {
							throw new InvalidInputException();
						} else {
							s1.setC_name(c_name);
						}
					} catch (InvalidInputException e) {
						e.printStackTrace();
						System.err.println("Course Name cannot start with a digit OR contain only digits");
					}

				} while (c_name.matches("[0-9]+") || Character.isDigit(c_name.charAt(0)));

				// getting date and validating
				System.out.println("Enter Date and Time of course in format: yyyy-MM-dd'T'HH:mm:ss");
				String datetime1 = "";
				LocalDateTime ldt1 = null;
				do {
					try {
						datetime1 = sc.next();
						DateTimeFormatter format1 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
						ldt1 = LocalDateTime.parse(datetime1, format1);
						s1.setTime_slot(ldt1);

					} catch (DateTimeParseException e) {
						// sc.next();
						e.printStackTrace();
						System.err.println("Enter Valid Date!");

					}
				} while (ldt1 == null);

				Schedule schedule1 = service.addSchedule(s1);
				System.out.println("Schedule added...");
				logger.info("adding schedule/ updating/ viewing");
				//break;
				System.exit(0);

			case 2:
				logger.info("updating schedule");
				Schedule s2 = new Schedule();
				System.out.println("Enter the schedule id of the class to be updated ");
				int s_id = 0;
				do {
					try {
						s_id = sc.nextInt();
						if (!(s_id == 0)) {
							System.out.println(
									"Enter updated Date and Time of course in format: 'yyyy-MM-dd'T'HH:mm:ss' ");
							String datetime2 = "";
							LocalDateTime ldt2 = null;
							do {
								try {
									datetime2 = sc.next();
									DateTimeFormatter format2 = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
									ldt2 = LocalDateTime.parse(datetime2, format2);
									//Schedule schedule2 = service.updateSchedule(s_id, ldt2);
									if(service.updateSchedule(s_id, ldt2) != null) {
										System.out.println("Schedule updated...");
										logger.info("schedule updated");
										}
									
									

								} catch (DateTimeParseException e) {
									// sc.next();
									e.printStackTrace();
									System.err.println("Enter Valid Date!");

								}
							} while (ldt2 == null);
						}
					} catch (NullPointerException e) {
						e.printStackTrace();
						System.err.println("Invalid Schedule ID");
					} catch (InputMismatchException e) {
						sc.next();
						e.printStackTrace();
						System.err.println("Invalid Input");
					}
				} while (s_id == 0);

				
				//break;
				System.exit(0);

			case 3:
				logger.info("viewing schedule");
				List<Schedule> list = service.viewSchedule();
				for (Schedule s : list) {
					System.out.print("Schedule ID: " + s.getS_id() + " ");
					System.out.print("Course ID: " + s.getC_id() + " ");
					System.out.print("Course Name: " + s.getC_name() + " ");
					System.out.print("Trainer ID: " + s.getT_id() + " ");
					System.out.print("Time Slot: " + s.getTime_slot() + " ");
					System.out.println();
				}
				//break;
				logger.info("viewed schedule");
				System.exit(0);
			default:
				System.err.println("Enter a valid choice");
				
			}

		case 'B':
			System.out.println("__________________________Student Page__________________________");
			System.out.println("1. View Schedule");
			int c = 0;
			c = sc.nextInt();
			switch (c) {
			case 1:
				List<Schedule> sch = service.viewSchedule();
				for (Schedule s : sch) {
					System.out.print("Schedule ID: " + s.getS_id() + " ");
					System.out.print("Course ID: " + s.getC_id() + " ");
					System.out.print("Course Name: " + s.getC_name() + " ");
					System.out.print("Trainer ID: " + s.getT_id() + " ");
					System.out.print("Time Slot: " + s.getTime_slot() + " ");
					System.out.println();

				}
				//break;
				System.exit(0);
			default:
				System.err.println("Invalid choice");
			}
		default:
			System.err.println("Enter a valid choice");
		}
	}
}
