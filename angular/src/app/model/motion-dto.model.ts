import {Motion} from "./motion.model";

export class MotionDto {
  year: number;
  month: string;
  day: number;
  hour: number;
  minute: number;
  second: number;

  constructor(year: number, month: string, day: number, hour: number, minute: number, second: number) {
    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  static parse(motion: Motion[]): MotionDto[] {
    let result: MotionDto[] = [];
    for (let i = 0; i < motion.length; i++) {
      let date: Date = new Date(motion[i].dateReceived);
      result.push(new MotionDto(
        date.getFullYear(),
        this.getMonthString(date.getMonth()),
        date.getDate(),
        date.getHours(),
        date.getMinutes(),
        date.getSeconds(),
      ))
    }
    return result;
  }

  private static getMonthString(num: number): string {
    switch (num) {
      case 0: return "January";
      case 1: return "February";
      case 2: return "March";
      case 3: return "April";
      case 4: return "May";
      case 5: return "June";
      case 6: return "July";
      case 7: return "August";
      case 8: return "September";
      case 9: return "October";
      case 10: return "November";
      case 11: return "December";
      default: return "";
    }
  }
}
