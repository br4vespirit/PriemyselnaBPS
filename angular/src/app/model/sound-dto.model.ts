import {Sound} from "./sound.model";

export class SoundDto {
  value: number;
  year: number;
  month: string;
  day: number;
  hour: number;
  minute: number;
  second: number;

  constructor(value: number, year: number, month: string, day: number, hour: number, minute: number, second: number) {
    this.value = value;
    this.year = year;
    this.month = month;
    this.day = day;
    this.hour = hour;
    this.minute = minute;
    this.second = second;
  }

  static parse(sound: Sound[]): SoundDto[] {
    let result: SoundDto[] = [];
    for (let i = 0; i < sound.length; i++) {
      let date: Date = new Date(sound[i].dateReceived);
      result.push(new SoundDto(
        sound[i].value,
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
